(function($) {
	
	$(function() {
		
		$.ajax({
            url: 'user/info.html',
            method: 'GET',
            contentType: 'application/json',
            success: function(data) {
            	data = JSON.parse(data);
            	$('.hidden-xs').text(data.accountId);
            },
            error: function(data) {
            	alert('网络出现问题，请稍后重试');
            }
        });	
		
		$('#btnUserInfo').on('click', function() {
			$.ajax({
	            url: 'user/info.html',
	            method: 'GET',
	            contentType: 'application/json',
	            success: function(data) {
	            	alert(data);
	            },
	            error: function(data) {
	            	alert('网络出现问题，请稍后重试');
	            }
	        });
		});
		
		$('#btnSignOut').on('click', function() {
			window.location.href = 'signout.html';
		});
		
		$('#logo').on('click', function() {
			$('.mainContent').load('main/dashboard.html');
		});
		
	});
	
})(jQuery);