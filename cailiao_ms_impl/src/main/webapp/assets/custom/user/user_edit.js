(function($, CryptoJS) {
    
    $(function() {

        (function() {

            $('#showUserList').on('click', function() {
                 $(".mainContent").load('user/list.html');
            });

            loadData();

            function loadData() {
                var accountId = $('#accountId').val();
                if (accountId == undefined || accountId == '') {
                    return;
                }
                $.ajax({
                    url: 'user/getUserEditData/' + accountId + '.html',
                    method: 'GET',
                    success: function(data) {
                        data = JSON.parse(data);
                        if (data.retCode == 200) {
                            _renderData(data);
                        } else {
                            alert('系统忙，请稍后重试');
                        }
                    },
                    error: function(data) {
                        alert('网络出现问题，请稍后重试');
                    }
                });
            }

            function _renderData(data) {
                var user = data.body.userEditData.user;
                $('#name').val(user.accountId);
                $('#description').val(user.description);
                $('#email').val(user.email);
                // select 的选择问题明天解决
                
                var roleChecked = user.roleIds;
                var $div = $('#roleList').empty();
                var list = data.body.userEditData.roleList;
                var $table = $('<table class="table table-responsive"></table>');
                
                var count = 0;
                for (var i = 0, len = list.length; i < len; i+=3) {
                    var $tr = $('<tr></tr>');
                    while (count < 3) {
                        if (i + count < len) {
                            $checkbox = '<td><input type="checkbox" value="' + list[i + count].id + '" name="role">' + list[i + count].name + '</td>';
                            if ($.inArray(list[i + count].id, roleChecked) > -1) {
                                $checkbox = '<td><input type="checkbox" value="' + list[i + count].id + '" name="role" checked>' + list[i + count].name + '</td>';
                            }
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
                        url: 'user/update.html',
                        method: 'PUT',
                        data: JSON.stringify(getFormData()),
                        contentType: 'application/json',
                        success: function(data) {
                        	data = JSON.parse(data);
                        	if (data.retCode == 200) {
                                alert('更新成功');
                                $('.mainContent').load('user/list.html');
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
                var roleList = [];
                $('input[name=role]:checked').each(function() {
                    roleList.push($(this).val());
                });
                var data = {
                    accountId: $('#accountId').val(),
                    description: $('#description').val(),
                    email: $('#email').val(),
                    status: $('#status').val(),
                    factoryId: $('#factoryId').val(),
                    roleIds: roleList
                };
                return data;
            }            
            
        })();
        
    });
    
})(jQuery, CryptoJS);