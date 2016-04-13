(function($){
    
    $(function() {
        
        function WJTemplateListPage() {
            this.createNewTemplateBtn = $("#createNewTemplateBtn");
        }
        
        WJTemplateListPage.prototype.init = function () {
            this.createNewTemplateBtn.on('click', function() {
                $(".mainContent").load('/wjt/create.html');
            });
        }
  
        WJTemplateListPage.prototype.load_data = function() {
            $('#example').DataTable({
                ajax: {
                    url: '/custom/wjt/list_data.json',
                    dataSrc: 'list'
                },
                columns: [
                    { data: 'name' },
                    { data: 'desc' },
                    { data: 'beginTime' },
                    { data: 'endTime' },
                    { data: 'status' }
                ]
            });
        }

        var wjTemplateListPage = new WJTemplateListPage();
        wjTemplateListPage.init();  
        wjTemplateListPage.load_data();
    });
    
})(jQuery);