(function($, $$){
    
    $(function() {
        
        (function() {

            $('#gobackToWJTPage').on('click', function() {
                $(".mainContent").load('wjt/list.html');
            });

            loadTable();

            function loadTable() {
                var wjtId = $('#wjtId').val();
                $('#wjTable').DataTable({
                    ordering: false,
                    searching: false,
                    lengthChange: false,
                    ajax: {
                        url: 'wj/getList/' + wjtId + '.html',
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
                                return '<button class="btn btn-primary btn-xs btn-check btn-flat" data-id="' + data + '">审核</button>';
                            }
                        },
                        {
                            targets: 2,
                            data: 'modifyTime',
                            render: function(data, type, full) {
                                return $$.formatTime(data);
                            }
                        },
                        {
                            targets: 3,
                            data: 'status',
                            render: function(data, type, full) {
                                if (data == 1) {
                                    return '编辑中';
                                } else if (data == 2) {
                                    return '已提交';
                                } else if (data == 3) {
                                    return '已审核通过'
                                } else {
                                    return '状态错误，请联系管理员'
                                }
                            }
                        }
                    ]
                });
            }

            $('#wjTable tbody').on('click', 'button.btn-check', function() {
                var id = $(this).data('id');
                window.open('online/wj/check/' + id + '.html');
            });

        })();
        
    });
})(jQuery, timeFormat);