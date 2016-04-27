(function($) {
    
    $(function() {

    	$('#refreshACL').on('click', function() {
    		$this = $(this);
    		$this.attr('disabled', true);
    		$.ajax({
                url: 'sysparam/refreshACL.html',
                method: 'GET',
                success: function(data) {
                    data = JSON.parse(data);
                    if (data.retCode == 200) {
                        alert('刷新ACL成功');
                    } else {
                        alert('系统忙，请稍后重试');
                        $this.removeAttr('disabled');
                    }
                },
                error: function(data) {
                    alert('网络出现问题，请稍后重试');
                    $this.removeAttr('disabled');
                }
            });
    	});
    	

    	$('#signOutAll').on('click', function() {
    		$this = $(this);
    		$this.attr('disabled', true);
    		$.ajax({
                url: 'sysparam/signOutAll.html',
                method: 'GET',
                success: function(data) {
                    data = JSON.parse(data);
                    if (data.retCode == 200) {
                        alert('所有用户退出登录成功');
                    } else {
                        alert('系统忙，请稍后重试');
                        $this.removeAttr('disabled');
                    }
                },
                error: function(data) {
                    alert('网络出现问题，请稍后重试');
                    $this.removeAttr('disabled');
                }
            });
    	});

    });

})(jQuery);