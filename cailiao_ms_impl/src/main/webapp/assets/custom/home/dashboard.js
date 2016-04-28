(function($, g) {
	
	$(function() {
		
		$('#wjtTile').on('click', function() {
		    g.navigateTo('wjt/list.html');
		});
		
		$('#userManageTile').on('click', function() {
			g.navigateTo('user/list.html');
		});
		
	});
	
})(jQuery, gotoTool);