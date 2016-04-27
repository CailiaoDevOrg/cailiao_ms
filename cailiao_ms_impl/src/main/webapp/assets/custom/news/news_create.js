(function($) {
    
    $(function() {

        (function() {
            
            _registerDatePicker([$('#beginTime'), $('#endTime')]);
            
            $('#submit').on('click', function() {
            	var $this = $(this);
            	$this.attr('disabled', true);
                if (true) {//补充参数校验 _validIsNotNull(objArr)
                    var data = {
                        title: $('#title').val(),
                        content: $('#content').val(),
                        beginTime: $('#beginTime').val(),
                        endTime: $('#endTime').val(),
                        url: $('#url').val(),
                        level: $('#level').val()
                    };
                    $.ajax({
                        url: 'news/publish.html',
                        method: 'POST',
                        data: JSON.stringify(data),
                        contentType: 'application/json',
                        success: function(data) {
                        	data = JSON.parse(data);
                        	if (data.retCode == 200) {
                                alert('新建成功');
                                $('.mainContent').load('/news/list.html');
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
                } else {
                    alert('please check input param');
                    $this.removeAttr('disabled');
                }
            });
            
            $('#showNewsList').on('click', function() {
                 $(".mainContent").load('news/list.html');
            });
        })();
        
        function _registerDatePicker(jQueryObjArr) {
            if ($.isArray(jQueryObjArr)) {
                for (var i = 0, len = jQueryObjArr.length; i < len; i++) {
                    jQueryObjArr[i].datepicker({
                        format: 'yyyy-mm-dd',
                    });
                }
            }
        }
        
    });
    
})(jQuery);