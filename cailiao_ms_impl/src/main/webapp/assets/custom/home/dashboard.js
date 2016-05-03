(function($, g) {
	
	$(function() {
		
		$('#wjtTile').on('click', function() {
		    g.navigateTo('wjt/list.html');
		});
		
		$('#userManageTile').on('click', function() {
			g.navigateTo('user/list.html');
		});
		
		$('#privilegeTile').on('click', function() {
			g.navigateTo('privilege/list.html');
		});
		
		$('#sysmsTile').on('click', function() {
			g.navigateTo('sysparam/ini.html');
		});
		
	});
	
})(jQuery, gotoTool);