(function($){
    
    $(function() {
        
        function WJTemplateManager() {
            this.createNewTemplateBtn = $("#createNewTemplateBtn");
            this.table = $('#data-table-simple');
        }
        
        WJTemplateManager.prototype.init = function () {
            this.createNewTemplateBtn.on('click', function() {
                $(".mainContent").load('/wjt/create.html');
            });
            
            this.table.DataTable({
                paging: false,
                info: false
            });
            
        }
        
        var wjTemplateManager = new WJTemplateManager();
        wjTemplateManager.init();  
    });
    
})(jQuery);