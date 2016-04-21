(function($) {

	$(function() {

		$('#showRoleList').on('click', function() {
			$('.mainContent').load('/role/list.html');
		});

		loadData();

		function loadData() {
			var id = $('#roleId').val();
			$.ajax({
	            url: '/role/getRoleEditData/' + id + '.html',
	            method: 'GET',
	            success: function(data) {
	            	alert(data);
	            	data = JSON.parse(data);
	            	if (data.retCode == 200) {
	                    
	            	} else {
	            		alert('系统忙，请稍后重试');
	            	}
	            },
	            error: function(data) {
	            	alert('网络出现问题，请稍后重试');
	            }
            });
		}
		
	});

})(jQuery);