(function($) {
    
    $(function() {

        (function() {
            
            _registerDatePicker([$('#beginTime'), $('#endTime')]);
            var objArr = [$('#name'), $('#desc'), $('#pageUrl'), $('#beginTime'), $('#endTime')];
            $('#submit').on('click', function() {
                if (_validIsNotNull(objArr)) {
                    var data = {
                        id: $('#id').val(),
                        name: $('#name').val(),
                        description: $('#desc').val(),
                        beginTime: $('#beginTime').val(),
                        endTime: $('#endTime').val(),
                        templateUrl: $('#pageUrl').val()
                    };
                    $.ajax({
                        url: '/wjt/saveTemp.html',
                        method: 'PUT',
                        data: JSON.stringify(data),
                        contentType: 'application/json',
                        success: function(data) {
                        	data = JSON.parse(data);
                        	if (data.retCode == 200) {
                                alert('更改成功');
                                $('.mainContent').load('/wjt/list.html');
                        	} else {
                        		alert('系统忙，请稍后重试');
                        	}
                        },
                        error: function(data) {
                        	alert('网络出现问题，请稍后重试');
                        }
                    });
                } else {
                    alert('please check input param');
                }
            });
            
            $('#showWjTemplateList').on('click', function() {
                 $(".mainContent").load('/wjt/list.html');
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
        
        function _validIsNotNull(jQueryObjArr) {
            if ($.isArray(jQueryObjArr)) {
                for (var i = 0, len = jQueryObjArr.length; i < len; i++) {
                    if (jQueryObjArr[i].val() === '' || jQueryObjArr[i].val() === undefined) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        
    });
    
})(jQuery);