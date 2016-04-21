(function($) {

	$(function() {

		$('#showInterfaceList').on('click', function() {
			$('.mainContent').load('/privilege/list.html');
		});

		$('#submit').on('click', function() {
			$.ajax({
                url: '/privilege/create.html',
                method: 'POST',
                data: JSON.stringify(getFormData()),
                contentType: 'application/json',
                success: function(data) {
                	data = JSON.parse(data);
                	if (data.retCode == 200) {
                        alert('新建成功');
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
		
		function getFormData() {
			var url = $('#url').val();
			var description = $('#description').val();
			var method = [];
			$('input[name=method]:checked').each(function() {
				method.push($(this).val());
			});
			if (method.length == 0) {
				method.push('GET');
			}
			var data = [];
			for (var i = 0, len = method.length; i < len; i++) {
				data.push({
					url: url,
		    	    description: description,
		    	    method: method[i]
				});
			}
		    return data;
		}
	});

})(jQuery);