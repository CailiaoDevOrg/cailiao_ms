(function($) {

	$(function() {

		$('#showRoleList').on('click', function() {
			$('.mainContent').load('role/list.html');
		});

		loadData();

		function loadData() {
			var id = $('#roleId').val();
			$.ajax({
	            url: 'role/getRoleEditData/' + id + '.html',
	            method: 'GET',
	            success: function(data) {
	            	data = JSON.parse(data);
	            	if (data.retCode == 200) {
	                    _renderData(data);
	            	} else {
	            		alert('系统忙，请稍后重试');
	            	}
	            },
	            error: function(data) {
	            	alert('网络出现问题，请稍后重试');
	            }
            });
		}

		function _renderData(data) {

			var role = data.body.roleEditData.role;
			$('#name').val(role.name);
			$('#description').val(role.description);
			
			var privilegeChecked = role.privilegeIds;
        	var $div = $('#privilegeList').empty();
        	var list = data.body.roleEditData.privilegeList;
        	var $table = $('<table class="table table-responsive"></table>');
        	
        	var count = 0;
        	for (var i = 0, len = list.length; i < len; i+=3) {
        		var $tr = $('<tr></tr>');
        		while (count < 3) {
        			if (i + count < len) {
        				$checkbox = '<td><input type="checkbox" value="' + list[i + count].id + '" name="privilege">' + list[i + count].description + '[' + list[i + count].method + ']</td>';
        				if ($.inArray(list[i + count].id, privilegeChecked) > -1) {
        					$checkbox = '<td><input type="checkbox" value="' + list[i + count].id + '" name="privilege" checked>' + list[i + count].description + '[' + list[i + count].method + ']</td>';
        				}
        			} else {
                        $checkbox = '<td>&nbsp;</td>';
        			}
        			$tr.append($checkbox);
        			count++;
        		}

        		count = 0;
        		$table.append($tr);
        	}
        	$div.append($table);
        }

        $('#submit').on('click', function() {
        	$this = $(this);
        	$this.attr('disabled', true);
        	$.ajax({
                url: 'role/update.html',
                method: 'PUT',
                data: JSON.stringify(getFormData()),
                contentType: 'application/json',
                success: function(data) {
                	data = JSON.parse(data);
                	if (data.retCode == 200) {
                        alert('更新成功');
                        $('.mainContent').load('/role/list.html');
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

        function getFormData() {
        	var id = $('#roleId').val();
        	var name = $('#name').val();
        	var description = $('#description').val();
        	var privilegeList = [];
        	$('input[name=privilege]:checked').each(function() {
				privilegeList.push($(this).val());
			});
			var data = {
				id: id,
				name: name,
				description: description,
				privilegeIds: privilegeList
			}
			return data;
        }
		
	});

})(jQuery);