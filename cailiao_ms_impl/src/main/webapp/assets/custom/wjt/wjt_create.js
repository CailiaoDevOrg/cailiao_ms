(function($) {
    
    $(function() {

        (function() {
            
            _registerDatePicker([$('#beginTime'), $('#endTime')]);            
            $('#submit').on('click', function() {
                var data = {
                        name: $('#name').val(),
                        description: $('#desc').val(),
                        beginTime: $('#beginTime').val(),
                        endTime: $('#endTime').val(),
                        templateUrl: $('#pageUrl').val()
                    };
                if (_validIsNotNull(data)) {
                    
                    $.ajax({
                        url: '/wjt/saveTemp.html',
                        method: 'POST',
                        data: JSON.stringify(data),
                        contentType: 'application/json',
                        success: function(data) {
                        	data = JSON.parse(data);
                        	if (data.retCode == 200) {
                                alert('新建成功');
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
        
        function _validIsNotNull(data) {
            if (data==undefined) {
                return false;
            };
            if(data.name==undefined||data.name==""){
                alert('您输入的问卷模板的名称不能为空');
                return false;
            }else if(data.desc==undefined||data.desc==""){
                alert('您输入的问卷模板的描述不能为空');
                return false;
            }else if(data.beginTime==undefined||data.beginTime==""){
                alert('生效时间不能为空');
                return false;
            }else if(data.endTime==undefined||data.endTime==""){
                alert('失效时间不能为空');
                return false;
            }else if(data.pageUrl==undefined||data.pageUrl==""){
                alert('pageUrl不能为空');
                return false;
            }else if(data.beginTime>data.endTime){
                alert();
                return false;
            }
              return true;

        }
        
    });
    
})(jQuery);