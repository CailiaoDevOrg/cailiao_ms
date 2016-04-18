(function($, $$){
    
    $(function() {
        
        (function() {
            $("#createNewsBtn").on('click', function() {
                $(".mainContent").load('/news/create.html');
            });
            
            $('#newsTable').DataTable({
                ordering: false,
                searching: false,
                lengthChange: false,
                ajax: {
                    url: '/news/getNewsList.html',
                    dataSrc: 'body.newsList'
                },
                columns: [
                    { data: 'title' },
                    { data: 'level' },
                    { data: 'beginTime' },
                    { data: 'endTime' },
                    { data: 'publishedTime' },
                    { data: 'status' },
                    { title: 'ops' }
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
                            return '<button class="btn btn-primary btn-xs btn-detail" data-id="' + data.id + '">查看</button>\
                                    <button class="btn btn-primary btn-xs ' + style + '" data-id="' + data.id + '">' + text + '</button>\
                                    <button class="btn btn-primary btn-xs btn-delete" data-id="' + data.id + '">删除</button>';
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
                ]
            });
            
            $('#newsTable tbody').on('click', 'button.btn-delete', function() {
                var id = $(this).data('id');
                $.ajax({
                    url: '/news/delete/' + id + '.html',
                    method: 'DELETE',
                    success: function(data) {
                    	data = JSON.parse(data);
                    	if (data.retCode == 200) {
                            alert('删除成功');
                            $('.mainContent').load('/news/list.html');
                    	} else {
                    		alert('系统忙，请稍后重试');
                    	}
                    },
                    error: function(data) {
                    	alert('网络出现问题，请稍后重试');
                    }
                });
            });

            $('#newsTable tbody').on('click', 'button.btn-detail', function() {
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

            $('#newsTable tbody').on('click', 'button.btn-pause', function() {
                var id = $(this).data('id');
                $.ajax({
                    url: '/news/pause/' + id + '/2.html',
                    method: 'PUT',
                    success: function(data) {
                        data = JSON.parse(data);
                        if (data.retCode == 200) {
                            alert("暂停成功");
                            $('.mainContent').load('/news/list.html');
                        } else {
                            alert('系统忙，请稍后重试');
                        }
                    },
                    error: function(data) {
                        alert('网络出现问题，请稍后重试');
                    }
                });
            });

            $('#newsTable tbody').on('click', 'button.btn-publish', function() {
                var id = $(this).data('id');
                $.ajax({
                    url: '/news/pause/' + id + '/1.html',
                    method: 'PUT',
                    success: function(data) {
                        data = JSON.parse(data);
                        if (data.retCode == 200) {
                            alert("发布成功");
                            $('.mainContent').load('/news/list.html');
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