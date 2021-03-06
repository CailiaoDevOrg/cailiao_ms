(function($, $$){
    
    $(function() {
    	
        
        (function() {
            $("#createNewTemplateBtn").on('click', function() {
                $(".mainContent").load('wjt/create.html');
            });
            
            $('#test').on('click',function(){
            	$.ajax({
            		url: 'wjt/getWJTList/1.html',
            		method: 'GET',
            		success:function(data){
            			console.log(data);
            		}
            	});
            });
            
            $('#wjTemplateTable').DataTable({
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
                    url: 'wjt/getWJTList/1.html',
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
                        data: {id: 'id', status: 'status'},
                        render: function(data, type, full) {
                            if (data.status == 1) {
                                return '<button class="btn btn-primary btn-xs btn-edit btn-flat" data-id="' + data.id + '">编辑</button>\
                                       <button class="btn btn-danger btn-xs btn-delete btn-flat" data-id="' + data.id + '">删除</button>\
                                       <button class="btn btn-primary btn-xs btn-publish btn-flat" data-id="' + data.id + '">发布</button>';
                            } else if (data.status == 2) {
                                return '<button class="btn btn-primary btn-xs btn-show btn-flat" data-id="' + data.id + '">查看问卷</button>\
                                       <button class="btn btn-danger btn-xs btn-delete btn-flat" data-id="' + data.id + '">删除</button>';
                            } else {
                                return '该项异常,请联系管理员';
                            }
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
                    },
                    {
                        targets: 4,
                        data: 'status',
                        render: function(data, type, full) {
                            if (data == 1) {
                                return '编辑中';
                            } else if (data == 2) {
                                return '已发布';
                            } else {
                                return '未知状态,请联系管理员';
                            }
                        }
                    }
                ]
            });

            $('#wjTemplateTable tbody').on('click', 'button.btn-show', function() {
                var id = $(this).data('id');
                $('.mainContent').load('wj/list/' + id + '.html');
            });

            $('#wjTemplateTable tbody').on('click', 'button.btn-edit', function() {
                var id = $(this).data('id');
                $('.mainContent').load('wjt/getWJT/' + id + '.html');
            });
            
            $('#wjTemplateTable tbody').on('click', 'button.btn-delete', function() {
                var id = $(this).data('id');
                var $this = $(this);
            	$this.attr('disabled', true);
                if(confirm('你确定要删除吗？')) {
                    $.ajax({
                        url: 'wjt/deleteWJT/' + id + '.html',
                        method: 'DELETE',
                        success: function(data) {
                            data = JSON.parse(data);
                            if (data.retCode == 200) {
                                alert('删除成功');
                                $('.mainContent').load('wjt/list.html');
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
            
            $('#wjTemplateTable tbody').on('click', 'button.btn-publish', function() {
            	var id = $(this).data('id');
            	var $this = $(this);
            	$this.attr('disabled', true);
            	$.ajax({
                    url: 'wjt/publishWJT/' + id + '.html',
                    method: 'PUT',
                    success: function(data) {
                    	data = JSON.parse(data);
                    	if (data.retCode == 200) {
                    		alert('发布成功');
                            $('.mainContent').load('wjt/list.html');
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
            
        })();
        
    });
})(jQuery, timeFormat);