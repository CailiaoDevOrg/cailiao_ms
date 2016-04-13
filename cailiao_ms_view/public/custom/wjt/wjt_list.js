(function($){
    
    $(function() {
        
        (function() {
            $("#createNewTemplateBtn").on('click', function() {
                $(".mainContent").load('/wjt/create.html');
            });
            
            $('#example').DataTable({
                ajax: {
                    url: '/custom/wjt/list_data.json',
                    dataSrc: 'list'
                },
                columns: [
                    { data: 'name' },
                    { data: 'desc' },
                    { data: 'beginTime' },
                    { data: 'endTime' },
                    { data: 'status' }
                ]
            });
            
        })();
        
    });
})(jQuery);