(function($) {

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
            var $img = $(this).find("img"), url = $img.attr("src");
            if(url.indexOf("_t=") > -1) {
                url = url.replace(/_t=\d+/, "_t=" + (new Date()).getTime());
            } else {
                url += (url.indexOf("?") > -1 ? "&" : "?") + "_t=" + (new Date()).getTime();
            }
            $img.attr("src", url);
            $(this).closest(".captcha-wrapper").find("input").focus().select();
            return false;
        });

        /*login*/
        $('.form-signin').on('submit', function() {
        	window.location.href = '/home.html';
            if (!validateInput()) {
                return false;
            }
            var id = $('#inputUserId').val(),
                    password = $('#inputPassword').val();
            var data = {
                id : id,
                password : password
            };
            data = JSON.stringify(data);
            $.ajax({
                type:"POST",
                contentType:"application/json",
                dataType:"json",
                url:"/login.html",
                data: data,
                success : function(data) {
                    if (data.SUCCESS == true) {
                        window.location.href = 'index.jsp';
                    } else {
                        alert("wrong userId or password");
                    }
                }
            });
            return false;
        });

        /*validate*/
        $('#inputUserId').on('blur', validateUserID).on('change', validateUserID).focus();
        $('#inputPassword').on('blur', validatePassword).on('change', validatePassword);
    });
})(jQuery);