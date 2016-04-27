var gotoTool = (function ($) {

    "use strict";

    var currentState, ProgressBar, ProgressBarAPI, progressBar = null;

    function bind(fn, me){
        return function(){
            return fn.apply(me, arguments);
        };
    }

    function load(container, url, params, callback) {
        if(!url || url.charAt(0) == "#" || url.substr(0, 11).toLowerCase() == "javascript:") return false;

        var selector, response, type,
            self = $(container),
            off = url.indexOf(" ");

        if(off > -1) {
            selector = $.trim(url.slice(off, url.length));
            url = url.slice(0, off);
        }

        // If it's a function
        if($.isFunction(params)) {
            // We assume that it's the callback
            callback = params;
            params = undefined;

            // Otherwise, build a param string
        } else if(params && typeof params === "object") {
            type = "POST";
        }

        if(!self.length) return;

        $.ajax({
            url: url,
            type: type, // if "type" variable is undefined, then "GET" method will be used
            dataType: "html",
            data: params,
            global: false,
            xhrFields: {
                onprogress: function(event) {
                    if(!progressBar) return;
                    var percent;
                    percent = event.lengthComputable ? event.loaded / event.total * 100 : progressBar.value + (100 - progressBar.value) / 10;
                    return progressBar.advanceTo(percent);
                }
            },
            beforeSend: function(jqXHR, settings) {
                jqXHR.setRequestHeader('X-XHR-Referer', currentState.url);
                if (progressBar) {
                    progressBar.start();
                }
            }
        }).done(function(responseText) {
            // Save response for use in complete callback
            response = arguments;

            self.html(selector ?
                // If a selector was specified, locate the right elements in a dummy div
                // Exclude scripts to avoid IE 'Permission Denied' errors
                $("<div>").append( $.parseHTML( responseText ) ).find( selector ) :

                // Otherwise use the full result
                responseText );
        }).complete( callback && function(jqXHR, status) {
            self.each( callback, response || [ jqXHR.responseText, status, jqXHR ] );
        }).then(function() {
            progressBar && progressBar.done();
        }).fail(function() {
            progressBar && progressBar.done();
            self.html('<div class="container-fluid main"><p class="bg-danger main"><i class="glyphicon glyphicon-alert"></i> 加载失败 请稍候再试</p></div>');
        });
    }

    function navigateTo(url, title) {
        load(".mainContent", url);
        if(title) document.title = title;
        var state = {
            url: url,
            title: title
        };
        url = "#!" + url;
        if(window.history.pushState) {
            window.history.pushState(state, title, url);
        } else {
            window.location.href = url;
        }
    }
    window.navigateTo = function() {
        navigateTo.apply(this, arguments);
    };

    function onHistoryChange(e) {
        var state = e.state;
        if(state && state.url) {
            navigateTo(state.url, state.title);
        }
    }

    function rememberCurrentUrlAndState() {
        window.history.replaceState({
            url: document.location.href,
            title: document.title
        }, '', document.location.href);
        return currentState = window.history.state;
    }

    rememberCurrentUrlAndState();
    window.addEventListener('popstate', onHistoryChange, false);
    window.addEventListener('hashchange', rememberCurrentUrlAndState, false);

    ProgressBar = (function() {
        var className, originalOpacity;

        className = 'page-progress-bar';

        originalOpacity = 0.99;

        ProgressBar.enable = function() {
            return progressBar != null ? progressBar : progressBar = new ProgressBar('html');
        };

        ProgressBar.disable = function() {
            if (progressBar != null) {
                progressBar.uninstall();
            }
            return progressBar = null;
        };

        function ProgressBar(elementSelector) {
            this.elementSelector = elementSelector;
            this._trickle = bind(this._trickle, this);
            this._reset = bind(this._reset, this);
            this.value = 0;
            this.content = '';
            this.speed = 300;
            this.opacity = originalOpacity;
            this.install();
        }

        ProgressBar.prototype.install = function() {
            this.element = document.querySelector(this.elementSelector);
            this.element.classList.add(className);
            this.styleElement = document.createElement('style');
            document.head.appendChild(this.styleElement);
            return this._updateStyle();
        };

        ProgressBar.prototype.uninstall = function() {
            this.element.classList.remove(className);
            return document.head.removeChild(this.styleElement);
        };

        ProgressBar.prototype.start = function() {
            if (this.value > 0) {
                this._reset();
                this._reflow();
            }
            return this.advanceTo(5);
        };

        ProgressBar.prototype.advanceTo = function(value) {
            var ref;
            if ((value > (ref = this.value) && ref <= 100)) {
                this.value = value;
                this._updateStyle();
                if (this.value === 100) {
                    return this._stopTrickle();
                } else if (this.value > 0) {
                    return this._startTrickle();
                }
            }
        };

        ProgressBar.prototype.done = function() {
            if (this.value > 0) {
                this.advanceTo(100);
                return this._finish();
            }
        };

        ProgressBar.prototype._finish = function() {
            this.fadeTimer = setTimeout((function(_this) {
                return function() {
                    _this.opacity = 0;
                    return _this._updateStyle();
                };
            })(this), this.speed / 2);
            return this.resetTimer = setTimeout(this._reset, this.speed);
        };

        ProgressBar.prototype._reflow = function() {
            return this.element.offsetHeight;
        };

        ProgressBar.prototype._reset = function() {
            this._stopTimers();
            this.value = 0;
            this.opacity = originalOpacity;
            return this._withSpeed(0, (function(_this) {
                return function() {
                    return _this._updateStyle(true);
                };
            })(this));
        };

        ProgressBar.prototype._stopTimers = function() {
            this._stopTrickle();
            clearTimeout(this.fadeTimer);
            return clearTimeout(this.resetTimer);
        };

        ProgressBar.prototype._startTrickle = function() {
            if (this.trickleTimer) {
                return;
            }
            return this.trickleTimer = setTimeout(this._trickle, this.speed);
        };

        ProgressBar.prototype._stopTrickle = function() {
            clearTimeout(this.trickleTimer);
            return delete this.trickleTimer;
        };

        ProgressBar.prototype._trickle = function() {
            this.advanceTo(this.value + Math.random() / 2);
            return this.trickleTimer = setTimeout(this._trickle, this.speed);
        };

        ProgressBar.prototype._withSpeed = function(speed, fn) {
            var originalSpeed, result;
            originalSpeed = this.speed;
            this.speed = speed;
            result = fn();
            this.speed = originalSpeed;
            return result;
        };

        ProgressBar.prototype._updateStyle = function(forceRepaint) {
            if (forceRepaint == null) {
                forceRepaint = false;
            }
            if (forceRepaint) {
                this._changeContentToForceRepaint();
            }
            return this.styleElement.textContent = this._createCSSRule();
        };

        ProgressBar.prototype._changeContentToForceRepaint = function() {
            return this.content = this.content === '' ? ' ' : '';
        };

        ProgressBar.prototype._createCSSRule = function() {
            return this.elementSelector + "." + className + "::before {\n  content: '" + this.content + "';\n  position: fixed;\n  top: 0;\n  left: 0;\n  z-index: 2000;\n  background-color: #0076ff;\n  height: 3px;\n  opacity: " + this.opacity + ";\n  width: " + this.value + "%;\n  transition: width " + this.speed + "ms ease-out, opacity " + (this.speed / 2) + "ms ease-in;\n  transform: translate3d(0,0,0);\n}";
        };

        return ProgressBar;

    })();

    ProgressBarAPI = {
        enable: ProgressBar.enable,
        disable: ProgressBar.disable,
        start: function() {
            return ProgressBar.enable().start();
        },
        advanceTo: function(value) {
            return progressBar != null ? progressBar.advanceTo(value) : undefined;
        },
        done: function() {
            return progressBar != null ? progressBar.done() : undefined;
        }
    };

    ProgressBar.enable();

    return {
        load : navigateTo,
        navigate : navigateTo,
        navigateTo : navigateTo,
        ProgressBar: ProgressBarAPI
    };

})(jQuery);
