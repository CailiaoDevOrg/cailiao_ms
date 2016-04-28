(function($, $$) {

	$(function() {

		loadTable();

		function loadTable() {
			var wjtId = $('#wjtId').val();
			$('#wjTable').DataTable({
	            ordering: false,
	            searching: false,
	            lengthChange: false,
	            ajax: {
	                url: 'online/wj/getHistoryList/' + wjtId + '.html',
	                dataSrc: 'body.questionnaireContentList'
	            },
	            columns: [
	                { data: 'id' },
	                { data: 'modifyTime' },
	                { data: 'status' },
	                { title: '操作' }
	            ],
	            columnDefs: [
	                {
	                    targets: -1,
	                    data: {id: 'id', status: 'status'},
	                    render: function(data, type, full) {
	                    	if (data.status == 1) {
	                    		return '<button class="btn btn-primary btn-xs btn-edit btn-flat" data-id="' + data.id + '">编辑</button>';
	                    	} else {
                                return '感谢提交';
	                    	}
	                    }
	                },
	                {
                        targets: 1,
                        data: 'modifyTime',
                        render: function(data, type, full) {
                            return $$.formatTime(data);
                        }
                    },
                    {
                        targets: 2,
                        data: 'status',
                        render: function(data, type, full) {
                            if (data == 1) {
                            	return '编辑中';
                            } else if (data == 2) {
                            	return '已提交';
                            } else if (data == 3) {
                                return '已审核通过';
                            } else {
                            	return '错误的状态，请联系系统管理员';
                            }
                        }
                    }
	            ]
	        });
		}

		$('#wjTable tbody').on('click', 'button.btn-edit', function() {
            var id = $(this).data('id');
            window.location.href = 'online/wj/edit/' + id + '.html';
        });
		
	});

})(jQuery, timeFormat);