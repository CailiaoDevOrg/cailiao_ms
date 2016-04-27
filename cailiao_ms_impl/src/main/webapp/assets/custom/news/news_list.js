(function($, $$){
    
    $(function() {
        
        (function() {
            $("#createNewsBtn").on('click', function() {
                $(".mainContent").load('news/create.html');
            });
            
            $('#newsTable').DataTable({
                ordering: false,
                searching: false,
                lengthChange: false,
                ajax: {
                    url: 'news/getNewsList.html',
                    dataSrc: 'body.newsList'
                },
                columns: [
                    { data: 'title' },
                    { data: 'level' },
                    { data: 'beginTime' },
                    { data: 'endTime' },
                    { data: 'publishedTime' },
                    { data: 'status' },
                    { title: '操作' }
                ],
                columnDefs: [
                    {
                        targets: -1,
                        data: {id:'id', status: 'status'},
                        render: function(data, type, full) {
                            var style, text;
                            if (data.status == 1) {
                                style = 'btn-pause';
                                text = '暂停';
                            } else {
                                style = 'btn-publish';
                                text = '发布';
                            }
                            return '<button class="btn btn-primary btn-xs btn-detail btn-flat" data-id="' + data.id + '">查看</button>\
                                    <button class="btn btn-primary btn-xs btn-flat ' + style + '" data-id="' + data.id + '">' + text + '</button>\
                                    <button class="btn btn-danger btn-xs btn-delete btn-flat" data-id="' + data.id + '">删除</button>';
                        }
                    },
                    {
                        targets: 1,
                        data: 'level',
                        render: function(data, type, full) {
                        	if (data == 1) {
                        		return '普通';
                        	} else if (data == 2) {
                        		return '临时';
                        	} else if (data == 3) {
                        		return '重要';
                        	} else {
                        		return '新闻等级异常，请联系管理员';
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
                        data: 'publishedTime',
                        render: function(data, type, full) {
                            return $$.formatTime(data);
                        }
                    },
                    {
                        targets: 5,
                        data: 'status',
                        render: function(data, type, full) {
                            if (data == 1) {
                                return '显示中'; 
                            } else if (data == 2) {
                                return '暂停显示'; 
                            } else {
                                return '新闻状态异常，请联系系统管理员';
                            }
                        }
                    }
                ]
            });
            
            $('#newsTable tbody').on('click', 'button.btn-delete', function() {
                var id = $(this).data('id');
                var $this = $(this);
                $this.attr('disabled', true);
                if (confirm('确认删除?')) {
                	$.ajax({
                        url: 'news/delete/' + id + '.html',
                        method: 'DELETE',
                        success: function(data) {
                        	data = JSON.parse(data);
                        	if (data.retCode == 200) {
                                alert('删除成功');
                                $('.mainContent').load('news/list.html');
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

            $('#newsTable tbody').on('click', 'button.btn-detail', function() {
                var id = $(this).data('id');
                $.ajax({
                    url: 'news/detail/' + id + '.html',
                    method: 'GET',
                    success: function(data) {
                        data = JSON.parse(data);
                        if (data.retCode == 200) {
                            $('#modalTitle').val(data.body.news.title);
                            $('#modalContent').val(data.body.news.content);
                            $('#modalPublishedTime').val($$.formatTime(data.body.news.publishedTime));
                            $('#modalBeginTime').val($$.formatTime(data.body.news.beginTime));
                            $('#modalEndTime').val($$.formatTime(data.body.news.endTime));
                            $('#modalUrl').val(data.body.news.url);
                            $('#detailModal').modal();
                        } else {
                            alert('系统忙，请稍后重试');
                        }
                    },
                    error: function(data) {
                        alert('网络出现问题，请稍后重试');
                    }
                });
            });

            $('#newsTable tbody').on('click', 'button.btn-pause', function() {
                var id = $(this).data('id');
                var $this = $(this);
                $this.attr('disabled', true);
                $.ajax({
                    url: 'news/pause/' + id + '/2.html',
                    method: 'PUT',
                    success: function(data) {
                        data = JSON.parse(data);
                        if (data.retCode == 200) {
                            alert("暂停成功");
                            $('.mainContent').load('news/list.html');
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

            $('#newsTable tbody').on('click', 'button.btn-publish', function() {
                var id = $(this).data('id');
                var $this = $(this);
                $this.attr('disabled', true);
                $.ajax({
                    url: 'news/pause/' + id + '/1.html',
                    method: 'PUT',
                    success: function(data) {
                        data = JSON.parse(data);
                        if (data.retCode == 200) {
                            alert("发布成功");
                            $('.mainContent').load('news/list.html');
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