(function($){

	$(function() {

		$.ajax({
            url: '/privilege/getList.html',
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

	});

})(jQuery);