(function($){
    
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
                        data: 'id',
                        render: function(data, type, full) {
                            return '<button class="btn btn-primary btn-xs btn-detail" data-id="' + data + '">查看</button>\
                                    <button class="btn btn-primary btn-xs btn-pause" data-id="' + data + '">暂停</button>\
                                    <button class="btn btn-primary btn-xs btn-delete" data-id="' + data + '">删除</button>';
                        }
                    }
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
            
        })();
        
    });
})(jQuery);