(function($) {
    
    $(function() {

        (function() {
            
            _registerDatePicker([$('#beginTime'), $('#endTime')]);
            var objArr = [$('#name'), $('#desc'), $('#pageUrl'), $('#beginTime'), $('#endTime')];
            $('#submit').on('click', function() {
                if (_validIsNotNull(objArr)) {
                    var data = {
                        name: $('#name').val(),
                        desc: $('#desc').val(),
                        beginTime: $('#beginTime').val(),
                        endTime: $('#endTime').val(),
                        pageUrl: $('#pageUrl').val()
                    }
                    $.post('/wjt/new/save.html', data, function() {
                        _resetForm(objArr);
                        alert('新建成功');
                    });
                } else {
                    alert('please check input param');
                }
            });
            
            $('#showWjTemplateList').on('click', function() {
                 $(".mainContent").load('/wjt/list');
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
        
        function _resetForm(jQueryObjArr) {
            if ($.isArray(jQueryObjArr)) {
                for (var i = 0, len = jQueryObjArr.length; i < len; i++) {
                    jQueryObjArr[i].val('');
                }
            }
        }
    });
    
})(jQuery);