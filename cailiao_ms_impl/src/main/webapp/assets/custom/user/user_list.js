(function($, $$){
    
    $(function() {
        
        (function() {
            $("#createUserBtn").on('click', function() {
                $(".mainContent").load('user/create.html');
            });
            
            $('#usersTable').DataTable({
                ordering: false,
                searching: false,
                lengthChange: false,
                ajax: {
                    url: 'user/getList.html',
                    dataSrc: 'body.userList'
                },
                columns: [
                    { data: 'accountId' },
                    { data: 'description' },
                    { data: 'factoryId' },
                    { data: 'email' },
                    { data: 'status' },
                    { title: '操作' }
                ],
                columnDefs: [
                    {
                        targets: -1,
                        data: {accountId: 'accountId', status: 'status'},
                        render: function(data, type, full) {
                        	var str = '<button class="btn btn-primary btn-xs btn-modify btn-flat" data-id="' + data.accountId + '">修改</button>\
                                       <button class="btn btn-danger btn-xs btn-delete btn-flat" data-id="' + data.accountId + '">删除</button>';
                        	if (data.status == 1) {
                        		return '<button class="btn btn-danger btn-xs btn-freeze btn-flat" data-id="' + data.accountId + '">冻结</button> ' + str;
                        	} else if (data.status == 2) {
                        		return '<button class="btn btn-success btn-xs btn-active btn-flat" data-id="' + data.accountId + '">激活</button> ' + str;
                        	} else {
                        		return '用户状态异常，请联系管理员';
                        	}
                        }
                    },
                    {
                        targets: 4,
                        data: 'status',
                        render: function(data, type, full) {
                        	if (data == 1) {
                        		return '已激活';
                        	} else if (data == 2) {
                        		return '未激活';
                        	} else {
                        		return '状态错误，请联系系统管理员';
                        	}
                        }
                    }
                ]
            });
            
            $('#usersTable tbody').on('click', 'button.btn-delete', function() {
                var accountId = $(this).data('id');
                var $this = $(this);
                $this.attr('disabled', true);
                if (confirm('您确定要删除吗?')) {
                	$.ajax({
                        url: 'user/delete/' + accountId + '.html',
                        method: 'DELETE',
                        success: function(data) {
                        	data = JSON.parse(data);
                        	if (data.retCode == 200) {
                                alert('删除成功');
                                $('.mainContent').load('user/list.html');
                        	} else {
                        		alert('系统忙，请稍后重试');
                        		$this.removeAttr('disabled');
                        	}
                        },
                        error: function(data) {
                        	alert('网络出现问题，请稍后重试');
                        	$this.removeAttr('disabled');
                        }
                    });
                } else {
                	$this.removeAttr('disabled');
                }
            });
            
            $('#usersTable tbody').on('click', 'button.btn-active', function() {
            	var $this = $(this);
                $this.attr('disabled', true);
                var accountId = $(this).data('id');
                var data = {
                	'accountId': accountId,
                	'status': 1
                }
                $.ajax({
                    url: 'user/updateStatus.html',
                    method: 'PUT',
                    data: JSON.stringify(data),
                    contentType: 'application/json',
                    success: function(data) {
                    	data = JSON.parse(data);
                    	if (data.retCode == 200) {
                            alert('激活成功');
                            $('.mainContent').load('user/list.html');
                    	} else {
                    		alert('系统忙，请稍后重试');
                    		$this.removeAttr('disabled');
                    	}
                    },
                    error: function(data) {
                    	alert('网络出现问题，请稍后重试');
                    	$this.removeAttr('disabled');
                    }
                });
            });
            
            $('#usersTable tbody').on('click', 'button.btn-freeze', function() {
            	var $this = $(this);
                $this.attr('disabled', true);
                var accountId = $(this).data('id');
                var data = {
                	'accountId': accountId,
                	'status': 2
                }
                $.ajax({
                    url: 'user/updateStatus.html',
                    method: 'PUT',
                    data: JSON.stringify(data),
                    contentType: 'application/json',
                    success: function(data) {
                    	data = JSON.parse(data);
                    	if (data.retCode == 200) {
                            alert('冻结成功');
                            $('.mainContent').load('user/list.html');
                    	} else {
                    		alert('系统忙，请稍后重试');
                    		$this.removeAttr('disabled');
                    	}
                    },
                    error: function(data) {
                    	alert('网络出现问题，请稍后重试');
                    	$this.removeAttr('disabled');
                    }
                });
            });

            $('#usersTable tbody').on('click', 'button.btn-modify', function() {
                var accountId = $(this).data('id');
                $('.mainContent').load('user/edit/' + accountId + '.html');
            });

        })();
        
    });
})(jQuery, timeFormat);