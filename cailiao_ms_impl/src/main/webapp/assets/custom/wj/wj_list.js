(function($, $$){
    
    $(function() {
        
        (function() {

            $('#gobackToWJTPage').on('click', function() {
                $(".mainContent").load('/wjt/list.html');
            });

            loadTable();

            function loadTable() {
                var wjtId = $('#wjtId').val();
                $('#wjTable').DataTable({
                    ordering: false,
                    searching: false,
                    lengthChange: false,
                    ajax: {
                        url: '/wj/getList/' + wjtId + '.html',
                        dataSrc: 'body.questionnaireContentList'
                    },
                    columns: [
                        { data: 'id' },
                        { data: 'accountId' },
                        { data: 'modifyTime' },
                        { data: 'status' },
                        { title: '操作' }
                    ],
                    columnDefs: [
                        {
                            targets: -1,
                            data: 'id',
                            render: function(data, type, full) {
                                return '<button class="btn btn-primary btn-xs btn-check" data-id="' + data + '">审核</button>';
                            }
                        },
                        {
                            targets: 2,
                            data: 'modifyTime',
                            render: function(data, type, full) {
                                return $$.formatTime(data);
                            }
                        }
                    ]
                });
            }

            $('#wjTable tbody').on('click', 'button.btn-check', function() {
                var id = $(this).data('id');
                window.open('/online/wj/check/' + id + '.html');
            });

        })();
        
    });
})(jQuery, timeFormat);