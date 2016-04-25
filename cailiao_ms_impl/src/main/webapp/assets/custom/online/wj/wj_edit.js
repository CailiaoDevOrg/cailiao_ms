(function($) {

	$(function() {

		// alert($('#wjId').val());
		loadData();

		function loadData() {
			var wjId = $('#wjId').val();
            $.ajax({
	            url: '/online/wj/detail/' + wjId + '.html',
	            method: 'GET',
	            contentType: 'application/json',
	            success: function(data) {
	            	data = JSON.parse(data);
	            	if (data.retCode == 200) {
	                    _renderData(data);
	            	} else {
	            		alert('系统忙，加载数据失败');
	            	}
	            },
	            error: function(data) {
	            	alert('网络出现问题，加载数据失败');
	            }
	        });
		}

		function _renderData(data) {
			var jsonContentObj = JSON.parse(data.body.questionnaireContent.jsonContent);
			__renderBaseInfo(jsonContentObj.baseinfo);
		}

		function __renderBaseInfo(data) {
			$('#bi_qyName').val(data.bi_qyName);
			$('#bi_scLineName').val(data.bi_scLineName);
			$('#bi_scLineScale').val(data.bi_scLineScale);
			$('#bi_qyAddress').val(data.bi_qyAddress);
			$('#bi_linkman').val(data.bi_linkman);
			$('#bi_phoneNumber').val(data.bi_phoneNumber);
		}

	});

})(jQuery);