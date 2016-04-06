(function($, $$){
    
    $(function() {
        
        function WJTemplateManager() {
            this.createNewTemplateBtn = $("#createNewTemplateBtn");
        }
        
        WJTemplateManager.prototype.init = function () {
            this.createNewTemplateBtn.on('click', function() {
                $(".mainContent").load('/wjt/create.html');
            });
        }
  
        WJTemplateManager.prototype.load_data = function() {
            $$.get('/custom/wjt/list_data.json', function(data) {
                var container = $('#wjt_table_body').empty();
                $.map(data.list, function(item, i) {
                    if (i % 2 == 0) {
                        $tr = $('<tr role="row" class="odd"></tr>');
                    } else {
                        $tr = $('<tr role="row" class="even"></tr>');
                    }
                    $tr.append('<td>' + (i + 1) + '</td>');
                    $tr.append('<td>' + item.name + '</td>');
                    $tr.append('<td>' + item.desc + '</td>');
                    $tr.append('<td>' + item.beginTime + '</td>');
                    $tr.append('<td>' + item.endTime + '</td>');
                    $tr.append('<td>' + item.status + '</td>');
                    $tr.append('<td>\
                                    <a class="btn waves-effect waves-light blue">查看</a>\
                                    <a class="btn waves-effect waves-light red">删除</a>\
                                </td>');
                    $tr.appendTo(container);
                });
                
                var pagination = $('#pagination').empty();
                var currentPage = data.currentPage;
                var totalPage = (data.totalCount + data.pageSize - 1) / data.pageSize;
                pagination.append('第' + currentPage + '页, 共' + parseInt(totalPage) + '页');
            });
        }
        
        var wjTemplateManager = new WJTemplateManager();
        wjTemplateManager.init();  
        wjTemplateManager.load_data();
    });
    
})(jQuery, ajax);