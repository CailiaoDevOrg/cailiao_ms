(function($) {
    
    $(function() {

        loadData();

        function loadData() {
            $.ajax({
                url: 'user/info.html',
                method: 'GET',
                success: function(data) {
                    data = JSON.parse(data);
                    _renderData(data);
                },
                error: function(data) {
                    alert('网络出现问题，请稍后重试');
                }
            });
        }

        function _renderData(data) {
            $('#accountId').val(data.accountId);
            $('#description').val(data.description);
            $('#email').val(data.email);
            $('#status').val(data.status);
            $('#factoryId').val(data.factoryId);
        }
        
    });
    
})(jQuery);