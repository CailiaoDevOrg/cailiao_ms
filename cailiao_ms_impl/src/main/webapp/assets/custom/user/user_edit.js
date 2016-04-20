(function($, CryptoJS) {
    
    $(function() {

        (function() {
            
            $('#submit').on('click', function() {
                if (true) {//补充参数校验 _validIsNotNull(objArr)
                    var data = {
                		accountId: $('#accountId').val(),
                        description: $('#description').val(),
                        email: $('#email').val(),
                        status: $('#status').val(),
                        factoryId: $('#factoryId').val()
                    };
                    $.ajax({
                        url: '/user/update.html',
                        method: 'PUT',
                        data: JSON.stringify(data),
                        contentType: 'application/json',
                        success: function(data) {
                        	data = JSON.parse(data);
                        	if (data.retCode == 200) {
                                alert('更新成功');
                                $('.mainContent').load('/user/list.html');
                        	} else {
                        		alert('系统忙，请稍后重试');
                        	}
                        },
                        error: function(data) {
                        	alert('网络出现问题，请稍后重试');
                        }
                    });
                } else {
                    alert('please check input param');
                }
            });
            
            $('#showUserList').on('click', function() {
                 $(".mainContent").load('/user/list.html');
            });
        })();
        
    });
    
})(jQuery, CryptoJS);