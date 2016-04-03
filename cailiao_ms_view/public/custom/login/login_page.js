(function($) {

    $(function() {
        function LoginPage() {
            this.loginBth = $('#loginBtn');
        }

        LoginPage.prototype.init = function() {
            this.loginBth.on('click', loginBtnOnClick);
        }

        var loginPage = new LoginPage();
        loginPage.init();

        function loginBtnOnClick() {
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