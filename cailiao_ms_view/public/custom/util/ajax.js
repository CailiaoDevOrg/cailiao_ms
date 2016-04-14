ajax = (function() {
    
    function post(url, data, successFunc, errorFunc, isForm) {
        var isForm = arguments[4] ? arguments[4] : true;
        $.ajax({
            url: url,
            method: 'POST',
            data: data,
            contentType: isForm ? 'application/x-www-form-urlencoded' : 'application/json',
            success: successFunc,
            error: errorFunc
        });
    }
    
    return {
        post: post
    }    
    
})(jQuery);