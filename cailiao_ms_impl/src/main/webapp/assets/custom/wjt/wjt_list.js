(function($){
    
    $(function() {
        
        (function() {
            $("#createNewTemplateBtn").on('click', function() {
                $(".mainContent").load('/wjt/create.html');
            });
            
            $('#wjTemplateTable').DataTable({
                ordering: false,
                searching: false,
                lengthChange: false,
                ajax: {
                    url: '/wjt/getWJTList/1.html',
                    dataSrc: 'body.page.list'
                },
                columns: [
                    { data: 'name' },
                    { data: 'description' },
                    { data: 'beginTime' },
                    { data: 'endTime' },
                    { data: 'status' },
                    { title: 'ops' }
                ],
                columnDefs: [
                    {
                        targets: -1,
                        data: 'id',
                        render: function(data, type, full) {
                            return '<button class="btn btn-primary btn-xs btn-edit" data-id="' + data + '">编辑</button>\
                                         <button class="btn btn-primary btn-xs btn-delete" data-id="' + data + '">删除</button>';
                        }
                    }
                ]
            });
            
            $('#wjTemplateTable tbody').on('click', 'button.btn-edit', function() {
                var id = $(this).data('id');
                alert(id);
            });
            
            $('#wjTemplateTable tbody').on('click', 'button.btn-delete', function() {
                var id = $(this).data('id');
                alert(id);
            });
            
        })();
        
    });
})(jQuery);