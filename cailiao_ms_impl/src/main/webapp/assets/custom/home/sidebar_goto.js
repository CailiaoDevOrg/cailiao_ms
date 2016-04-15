(function($) {
    $(function() {
       $('.sidemenu').bind('click', function() {
           var goto_url = $(this).data("navigate");
           $(".mainContent").load(goto_url);
       }); 
    });
})(jQuery);