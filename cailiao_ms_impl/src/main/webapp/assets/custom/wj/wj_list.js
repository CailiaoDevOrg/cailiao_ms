(function($, $$){
    
    $(function() {

        $('#gobackToWJTPage').on('click', function() {
            $(".mainContent").load('wjt/list.html');
        });
        
        $('#refreshList').on('click', function() {
            alert('刷新成功');
            var wjtId = $('#wjtId').val();
            $('.mainContent').load('wj/list/' + wjtId + '.html');
        });
        
        $('#wjSearch').on('click', function() {
        	var wjtId = $('#wjtId').val();
        	$('.mainContent').load('wj/search/' + wjtId + '.html');
        });

        loadTable();

        function loadTable() {
            var wjtId = $('#wjtId').val();
            $('#wjTable').DataTable({
                ordering: false,
                searching: false,
                lengthChange: false,
                language: {  
                    'emptyTable': '没有数据',  
                    'loadingRecords': '加载中...',  
                    'processing': '查询中...',   
                    'lengthMenu': '每页 _MENU_ 件',  
                    'zeroRecords': '没有数据',  
                    'paginate': {  
                        'first':      '第一页',  
                        'last':       '最后一页',  
                        'next':       '上一页',  
                        'previous':   '下一页'  
                    },  
                    'info': '第 _PAGE_ 页 / 总 _PAGES_ 页',  
                    'infoEmpty': '没有数据',  
                },
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
                            if (data == 2) {
                                return '待审核';
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

    });
})(jQuery, timeFormat);