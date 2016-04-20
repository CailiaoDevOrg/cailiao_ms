(function($, $$){
    
    $(function() {
        
        (function() {
            $("#createUserBtn").on('click', function() {
                $(".mainContent").load('/user/create.html');
            });
            
            $('#usersTable').DataTable({
                ordering: false,
                searching: false,
                lengthChange: false,
                ajax: {
                    url: '/user/getList.html',
                    dataSrc: 'body.userList'
                },
                columns: [
                    { data: 'accountId' },
                    { data: 'description' },
                    { data: 'factoryId' },
                    { data: 'email' },
                    { data: 'role' },
                    { data: 'status' },
                    { title: '操作' }
                ],
                columnDefs: [
                    {
                        targets: -1,
                        data: 'accountId',
                        render: function(data, type, full) {
                            return '<button class="btn btn-primary btn-xs btn-modify" data-id="' + data + '">修改</button>\
                                    <button class="btn btn-primary btn-xs btn-delete" data-id="' + data + '">删除</button>';
                        }
                    },
                    {
                        targets: 4,
                        data: 'role',
                        render: function(data, type, full) {
                            return '测试水泥厂';
                        }
                    }
                ]
            });
            
            $('#usersTable tbody').on('click', 'button.btn-delete', function() {
                var accountId = $(this).data('id');
                $.ajax({
                    url: '/user/delete/' + accountId + '.html',
                    method: 'DELETE',
                    success: function(data) {
                    	data = JSON.parse(data);
                    	if (data.retCode == 200) {
                            alert('删除成功');
                            $('.mainContent')s.load('/user/list.html');
                    	} else {
                    		alert('系统忙，请稍后重试');
                    	}
                    },
                    error: function(data) {
                    	alert('网络出现问题，请稍后重试');
                    }
                });
            });

            $('#usersTable tbody').on('click', 'button.btn-modify', function() {
                var id = $(this).data('id');
                $.ajax({
                    url: '/news/detail/' + id + '.html',
                    method: 'GET',
                    success: function(data) {
                        data = JSON.parse(data);
                        if (data.retCode == 200) {
                            // 添加UI
                            alert(JSON.stringify(data.body));
                        } else {
                            alert('系统忙，请稍后重试');
                        }
                    },
                    error: function(data) {
                        alert('网络出现问题，请稍后重试');
                    }
                });
            });

        })();
        
    });
})(jQuery, timeFormat);