(function($) {

    $(function() {

    	$('#createRoleBtn').on('click', function() {
    		$('.mainContent').load('/role/create.html');
    	});

        $('#roleTable').DataTable({
            ordering: false,
            searching: false,
            lengthChange: false,
            ajax: {
                url: '/role/getList.html',
                dataSrc: 'body.roleList'
            },
            columns: [
                { data: 'name' },
                { data: 'description' },
                { title: '操作' }
            ],
            columnDefs: [
                {
                    targets: -1,
                    data: 'id',
                    render: function(data, type, full) {
                        return '<button class="btn btn-primary btn-xs btn-delete" data-id="' + data + '">删除</button>';
                    }
                }
            ]
        });

        $('#roleTable tbody').on('click', 'button.btn-delete', function() {
            var id = $(this).data('id');
            $.ajax({
                url: '/role/delete/' + id + '.html',
                method: 'DELETE',
                success: function(data) {
                	data = JSON.parse(data);
                	if (data.retCode == 200) {
                        alert('删除成功');
                        $('.mainContent').load('/role/list.html');
                	} else {
                		alert('系统忙，请稍后重试');
                	}
                },
                error: function(data) {
                	alert('网络出现问题，请稍后重试');
                }
            });
        });

    });

})(jQuery);