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
        	for (var i = 0, len = list.length; i < len; i += 3) {
        		var $tr = $('<tr></tr>');

        		if (i + 2 < len) {
        			$checkbox1 = '<td><input type="checkbox" value="' + list[i].id + '" name="privilege">' + list[i].description + '[' + list[i].method + ']</td>';
        		    $checkbox2 = '<td><input type="checkbox" value="' + list[i + 1].id + '" name="privilege">' + list[i + 1].description + '[' + list[i + 1].method + ']</td>';
        		    $checkbox3 = '<td><input type="checkbox" value="' + list[i + 2].id + '" name="privilege">' + list[i + 2].description + '[' + list[i + 2].method + ']</td>';
        		} else {
        			var delta = i + 2 - len;

        		}

        		$tr.append($checkbox1);
        		$tr.append($checkbox2);
        		$tr.append($checkbox3);

        		$table.append($tr);
        	}
        	$div.append($table);
        }

	});

})(jQuery);