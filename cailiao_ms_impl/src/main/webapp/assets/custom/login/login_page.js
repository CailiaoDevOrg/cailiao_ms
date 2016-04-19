(function($, CryptoJS) {

    $(function() {
    	
    	function validateUserID(autofocus, flag) {
            if($('#inputUserId').val().trim() == '') {
                $(".bg-danger, .username-tooltip").removeClass("hidden");
                if(autofocus === true && flag) $("#inputUserId").focus();
                return false;
            } else {
                $(".username-tooltip").addClass("hidden");
                if(!$(".bg-danger > p:not(.hidden)").length) {
                    $(".bg-danger").addClass("hidden");
                }
                return true;
            }
        }

        function validatePassword(autofocus, flag) {
            if($('#inputPassword').val().trim() == '') {
                $(".bg-danger, .password-tooltip").removeClass("hidden");
                if(autofocus === true && flag) $("#inputPassword").focus();
                return false;
            } else {
                $(".password-tooltip").addClass("hidden");
                if(!$(".bg-danger > p:not(.hidden)").length) {
                    $(".bg-danger").addClass("hidden");
                }
                return true;
            }
        }

        function validateInput() {
            var flag = true;
            if(!validateUserID(true, flag)) {
                flag = false;
            }
            if(!validatePassword(true, flag)) {
                flag = false;
            }
            return flag;
        }

        $(".captcha-wrapper > a").on("click", function() {
            loadCheckCode();
            $(this).closest(".captcha-wrapper").find("input").focus().select();
            return false;
        });

        function loadCheckCode() {
            var $img = $("#checkcodeImg"), url = $img.attr("src");
            if(url.indexOf("_t=") > -1) {
                url = url.replace(/_t=\d+/, "_t=" + (new Date()).getTime());
            } else {
                url += (url.indexOf("?") > -1 ? "&" : "?") + "_t=" + (new Date()).getTime();
            }
            $img.attr("src", url);
        }

        loadCheckCode();

        /*login*/
        $('.form-signin').on('submit', function() {
            if (!validateInput()) {
                return false;
            }
            var id = $('#inputUserId').val(),
                password = $('#inputPassword').val(),
                checkcode = $('#captcha').val();
            var data = {
            	accountId : id,
                password : CryptoJS.MD5(password).toString()
            };
            data = JSON.stringify(data);
            $.ajax({
                type:"POST",
                contentType:"application/json",
                url:"/doLogin.html?checkcode=" + checkcode,
                data: data,
                success : function(data) {
                	data = JSON.parse(data);
                    if (data.retCode == 200 && data.body.canLogin == true) {
                    	window.location.href = '/main/home.html';
                    } else {
                    	if (data.retCode == 207) {
                    		alert("验证码输入错误");
                    	} else {
                    		alert("用户名或密码错误");
                    	}
                    	loadCheckCode();
                    }
                },
                error: function(data) {
                    alert("用户名或密码错误");
                    loadCheckCode();
                }
            });
            return false;
        });

        /*validate*/
        $('#inputUserId').on('blur', validateUserID).on('change', validateUserID).focus();
        $('#inputPassword').on('blur', validatePassword).on('change', validatePassword);
    });
})(jQuery, CryptoJS);