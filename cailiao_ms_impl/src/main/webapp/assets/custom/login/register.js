(function($, CryptoJS) {
    $(function() {

    	$('#register').on('click', function() {
    		$.ajax({
                type:"POST",
                contentType:"application/json",
                url:"doRegister.html",
                data: JSON.stringify(getRegisterData()),
                success : function(data) {
                	data = JSON.parse(data);
                    if (data.retCode == 200) {
                    	alert('注册成功，等待管理员激活');
                    	window.location.href = '/login.html';
                    } else {
                    	alert('系统忙，请稍后重试');
                    }
                },
                error: function(data) {
                	alert(data)
                    alert('网络出现问题，请稍后重试');
                }
            });
    	});

    	function getRegisterData() {
    		return {
    			'accountId': $('#accountId').val(),
    			'email': $('#email').val(),
    			'factoryId': $('#factoryId').val(),
    			'password': CryptoJS.MD5($('#password').val()).toString(),
    			'description': $('#description').val()
    		}
    	}

    	function validate() {
    		if ($('#accountId').val() == '') {
    			alert('用户名不能为空');
    			return false;
    		} else if ($('#email').val() == '') {
    			alert('邮箱不能为空');
    			return false;
    		} else if ($('#factoryId').val() == '') {
    			alert('选择的水泥厂不能为空');
    			return false;
    		} else if ($('#password').val() == '') {
    			alert('密码输入错误');
    			return false;
    		} else if ($('#password').val() != $('#repassword').val()) {
    			alert('密码输入不一致');
    			return false;
    		}
    	    return true;
    	}

    });
})(jQuery, CryptoJS);