(function($, $$){
    
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
                    { title: '操作' }
                ],
                columnDefs: [
                    {
                        targets: -1,
                        data: 'id',
                        render: function(data, type, full) {
                            return '<button class="btn btn-primary btn-xs btn-edit" data-id="' + data + '">编辑</button>\
                                    <button class="btn btn-danger btn-xs btn-delete" data-id="' + data + '">删除</button>\
                                    <button class="btn btn-primary btn-xs btn-publish" data-id="' + data + '">发布</button>';
                        }
                    },
                    {
                        targets: 2,
                        data: 'beginTime',
                        render: function(data, type, full) {
                            return $$.formatTime(data);
                        }
                    },
                    {
                        targets: 3,
                        data: 'endTime',
                        render: function(data, type, full) {
                            return $$.formatTime(data);
                        }
                    }
                ]
            });
            
            $('#wjTemplateTable tbody').on('click', 'button.btn-edit', function() {
                var id = $(this).data('id');
                $('.mainContent').load('/wjt/getWJT/' + id + '.html');
            });
            
            $('#wjTemplateTable tbody').on('click', 'button.btn-delete', function() {
                var id = $(this).data('id');
                $.ajax({
                    url: '/wjt/deleteWJT/' + id + '.html',
                    method: 'DELETE',
                    success: function(data) {
                    	data = JSON.parse(data);
                    	if (data.retCode == 200) {
                            alert('删除成功');
                            $('.mainContent').load('/wjt/list.html');
                    	} else {
                    		alert('系统忙，请稍后重试');
                    	}
                    },
                    error: function(data) {
                    	alert('网络出现问题，请稍后重试');
                    }
                });
            });
            
            $('#wjTemplateTable tbody').on('click', 'button.btn-publish', function() {
            	var id = $(this).data('id');
            	$.ajax({
                    url: '/wjt/publishWJT/' + id + '.html',
                    method: 'PUT',
                    success: function(data) {
                    	data = JSON.parse(data);
                    	if (data.retCode == 200) {
                    		alert('发布成功');
                            $('.mainContent').load('/wjt/list.html');
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