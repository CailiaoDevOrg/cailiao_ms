(function($) {
    
    $(function() {

    	$('#refreshACL').on('click', function() {
    		$.ajax({
                url: '/sysparam/refreshACL.html',
                method: 'GET',
                success: function(data) {
                    data = JSON.parse(data);
                    if (data.retCode == 200) {
                        alert('刷新ACL成功');
                    } else {
                        alert('系统忙，请稍后重试');
                    }
                },
                error: function(data) {
                    alert('网络出现问题，请稍后重试');
                }
            });
    	});

    });

})(jQuery);