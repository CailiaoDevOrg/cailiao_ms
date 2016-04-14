(function($){
    
    $(function() {
        
        (function() {
            $("#createNewTemplateBtn").on('click', function() {
                $(".mainContent").load('/wjt/create.html');
            });
            
            $('#example').DataTable({
                ordering: false,
                ajax: {
                    url: '/custom/wjt/list_data.json',
                    dataSrc: 'list'
                },
                columns: [
                    { data: 'name' },
                    { data: 'desc' },
                    { data: 'beginTime' },
                    { data: 'endTime' },
                    { data: 'status' },
                    { title : 'ops' }
                ],
                columnDefs: [
                    {
                        targets: -1,
                        data: 'id',
                        render: function(data, type, full) {
                            return '<button class="btn btn-primary btn-xs btn-modify" data-id="' + data + '">修改</button>\
                                         <button class="btn btn-primary btn-xs btn-delete" data-id="' + data + '">删除</button>';
                        }
                    }
                ]
            });

        })();
        
    });
})(jQuery);