(function($){

	$(function() {

		$.ajax({
            url: 'privilege/getList.html',
            method: 'GET',
            success: function(data) {
            	data = JSON.parse(data);
            	if (data.retCode == 200) {
                    createCheckbox(data);
            	} else {
            		alert('系统忙，请稍后重试');
            	}
            },
            error: function(data) {
            	alert('网络出现问题，请稍后重试');
            }
        });

        function createCheckbox(data) {
        	var $div = $('#privilegeList').empty();
        	var list = data.body.privilegeList;
        	var $table = $('<table class="table table-responsive"></table>');
        	
        	var count = 0;
        	for (var i = 0, len = list.length; i < len; i+=3) {
        		var $tr = $('<tr></tr>');
                
        		while (count < 3) {
        			if (i + count < len) {
        				$checkbox = '<td><input type="checkbox" value="' + list[i + count].id + '" name="privilege">' + list[i + count].description + '[' + list[i + count].method + ']</td>';
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
                url: 'role/create.html',
                method: 'POST',
                data: JSON.stringify(getFormData()),
                contentType: 'application/json',
                success: function(data) {
                	data = JSON.parse(data);
                	if (data.retCode == 200) {
                        alert('新建成功');
                        $('.mainContent').load('role/list.html');
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
        	var name = $('#name').val();
        	var description = $('#description').val();
        	var privilegeList = [];
        	$('input[name=privilege]:checked').each(function() {
				privilegeList.push($(this).val());
			});
			var data = {
				name: name,
				description: description,
				privilegeIds: privilegeList
			}
			return data;
        }

        $('#showRoleList').on('click', function() {
            $('.mainContent').load('role/list.html');
        });

	});

})(jQuery);