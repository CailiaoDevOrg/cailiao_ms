var ajax = (function($) {
    function get(url, func) {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            dataType: "json",
            url: url,
            success: function(data) {
                func(data);
            }
        });
    }
    
    return {
        get: get
    }
})(jQuery);
