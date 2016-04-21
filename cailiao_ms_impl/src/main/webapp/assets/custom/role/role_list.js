(function($) {

    $(function() {

    	$('#createRoleBtn').on('click', function() {
    		$('.mainContent').load('/role/create.html');
    	});

    	var roleTable = $('#roleTable').DataTable({
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

    });

})(jQuery);