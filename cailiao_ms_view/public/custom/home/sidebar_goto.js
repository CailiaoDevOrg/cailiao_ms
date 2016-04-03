(function($) {
    $(function() {
       $('.sidebar_href').bind('click', function() {
           var goto_url = $(this).data("navigate");
           $(".mainContent").load(goto_url);
       }); 
    });
})(jQuery);