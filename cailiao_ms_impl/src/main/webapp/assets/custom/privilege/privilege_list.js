(function($) {

	$(function(){

	    $("#createPrivilegeBtn").on('click', function() {
            $(".mainContent").load('/privilege/create.html');
        });

        $('#privilegeTable').DataTable({
            ordering: false,
            searching: false,
            lengthChange: false,
            ajax: {
                url: '/privilege/getList.html',
                dataSrc: 'body.privilegeList'
            },
            columns: [
                { data: 'url' },
                { data: 'method' },
                { data: 'description' },
                { title: '操作' }
            ],
            columnDefs: [
                {
                    targets: -1,
                    data: 'id',
                    render: function(data, type, full) {
                        return '<button class="btn btn-danger btn-xs btn-delete" data-id="' + data + '">删除</button>';
                    }
                }
            ]
        });

        $('#privilegeTable tbody').on('click', 'button.btn-delete', function() {
            var id = $(this).data('id');
            $.ajax({
                url: '/privilege/delete/' + id + '.html',
                method: 'DELETE',
                success: function(data) {
                	data = JSON.parse(data);
                	if (data.retCode == 200) {
                        alert('删除成功');
                        $('.mainContent').load('/privilege/list.html');
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