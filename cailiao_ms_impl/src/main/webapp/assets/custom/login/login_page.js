(function($) {

    $(function() {
        function LoginPage() {
            this.loginBth = $('#loginBtn');
        }

        LoginPage.prototype.init = function() {
            this.loginBth.on('click', __loginBtnOnClick);
            document.onkeydown = __onKeyDown;
        }

        var loginPage = new LoginPage();
        loginPage.init();

        function __onKeyDown(e) {
            var ev = document.all ? window.event : e;
            if (ev.keyCode == 13) {
                __loginBtnOnClick();
            }
        }

        function __loginBtnOnClick() {
            var userName = $('#userName').val();
            var password = $('#password').val();
            if (userName === undefined || userName.trim() === '') {
                alert('用户名不能为空');
                return;
            }
            if (password === undefined || password.trim() === '') {
                alert('密码不能为空');
                return;
            }

            var data = {
                userName: userName,
                password: password
            };

            $.ajax({
                type: "POST",
                contentType: "application/json",
                dataType: "json",
                url: "/login_check.html",
                data: JSON.stringify(data),
                success: function(data) {
                    if (data == true) {
                        window.location.href = '/home.html';
                    } else {
                        $('#password').select();
                        alert('用户名或密码错误');
                    }
                }
            });
        }
    });
})(jQuery);