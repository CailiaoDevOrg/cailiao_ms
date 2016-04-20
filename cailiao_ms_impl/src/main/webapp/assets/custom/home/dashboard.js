(function($) {
	
	$(function() {
		
		$('#wjtTile').on('click', function() {
		    $('.mainContent').load('/wjt/list.html');	
		});
		
		$('#userManageTile').on('click', function() {
			$('.mainContent').load('/user/list.html');
		});
		
	});
	
})(jQuery);