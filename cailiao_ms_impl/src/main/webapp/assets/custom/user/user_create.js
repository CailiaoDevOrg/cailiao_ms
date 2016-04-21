(function($, CryptoJS) {
    
    $(function() {

        (function() {

            $.ajax({
                url: '/role/getList.html',
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
                var $div = $('#roleList').empty();
                var list = data.body.roleList;
                if (list.length == 0) {
                    $div.append('暂时没有可以选择的角色');
                    return;
                }
                var $table = $('<table class="table table-responsive"></table>');
                var count = 0;
                for (var i = 0, len = list.length; i < len; i+=3) {
                    var $tr = $('<tr></tr>');
                    while (count < 3) {
                        if (i + count < len) {
                            $checkbox = '<td><input type="checkbox" value="' + list[i + count].id + '" name="role">' + list[i + count].name + '</td>';
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
                if (true) {//补充参数校验 _validIsNotNull(objArr)
                    $.ajax({
                        url: '/user/create.html',
                        method: 'POST',
                        data: JSON.stringify(getFormData()),
                        contentType: 'application/json',
                        success: function(data) {
                        	data = JSON.parse(data);
                        	if (data.retCode == 200) {
                                alert('新建成功');
                                $('.mainContent').load('/user/list.html');
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

            function getFormData() {
                var roleIds = [];
                $('input[name=role]:checked').each(function() {
                    roleIds.push($(this).val());
                });
                var data = {
                    accountId: $('#accountId').val(),
                    password: CryptoJS.MD5($('#password').val()).toString(),
                    description: $('#description').val(),
                    email: $('#email').val(),
                    status: $('#status').val(),
                    factoryId: $('#factoryId').val(),
                    roleIds: roleIds
                }
                return data;
            }
            
            $('#showUserList').on('click', function() {
                 $(".mainContent").load('/user/list.html');
            });
        })();
        
    });
    
})(jQuery, CryptoJS);