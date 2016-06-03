(function($, $$) {

	$(function() {

		loadTable();

		function loadTable() {
			var wjtId = $('#wjtId').val();
			$('#wjTable').DataTable({
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
	                    	if (data.status == 1 || data.status == 4) {
	                    		return '<button class="btn btn-primary btn-xs btn-edit btn-flat" data-id="' + data.id + '">编辑</button>';
	                    	} else {
	                    		return '<button class="btn btn-primary btn-xs btn-scan btn-flat" data-id="' + data.id + '">查看</button>';
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
                            } else if(data == 4){
                            	return '审核未通过';
                            }else {
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
		
		$('#wjTable tbody').on('click', 'button.btn-scan', function() {
            var id = $(this).data('id');
            window.location.href = 'online/wj/scan/' + id + '.html';
        });
	});

})(jQuery, timeFormat);