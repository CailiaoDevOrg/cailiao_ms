(function($, g) {
    $(function() {
       $('.sidemenu').bind('click', function() {
           var goto_url = $(this).data("navigate");
           // $(".mainContent").load(goto_url);
           g.navigateTo(goto_url);
       }); 
    });
})(jQuery, gotoTool);