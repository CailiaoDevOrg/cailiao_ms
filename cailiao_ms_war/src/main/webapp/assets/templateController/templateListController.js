 /*var templateListApp=angular.module('templateListApp',[]);
 var List='';
 templateListApp.controller('templateListController',function($scope,$http){
 	$http.get("/assets/testjson/templateList.json").success(function(resp){
 		List=resp.data;
 		
 	});
 });
*/
 	$(function(){
 		var data= [
        {
            "id": 0,
            "name":"第一模板",
            "status": 1,
            "url": "0.html",
            "modifyTime":"2016-03-01",
            "lastModifyTime":"2016-03-13"
        },
        {
            "id": 1,
            "name":"第二模板",
            "status": 0,
            "url": "1.html",
            "modifyTime":"2016-03-02",
            "lastModifyTime":"2016-03-15"
        },
        {
            "id": 2,
            "name":"第三模板",
            "status": 1,
            "url": "2.html",
            "modifyTime":"2016-03-03",
            "lastModifyTime":"2016-03-16"
        },
        {
            "id": 4,
            "name":"第四模板",
            "status": 0,
            "url": "1.html",
            "modifyTime":"2016-03-02",
            "lastModifyTime":"2016-03-15"
        },
        {
            "id": 5,
            "name":"第五模板",
            "status": 1,
            "url": "2.html",
            "modifyTime":"2016-03-03",
            "lastModifyTime":"2016-03-16"
        },
        {
            "id": 6,
            "name":"第六模板",
            "status": 0,
            "url": "1.html",
            "modifyTime":"2016-03-02",
            "lastModifyTime":"2016-03-15"
        },
        {
            "id": 7,
            "name":"第七模板",
            "status": 1,
            "url": "2.html",
            "modifyTime":"2016-03-03",
            "lastModifyTime":"2016-03-16"
        }
    ];



      
      $("#templateList").bootstrapTable({
             // url:"/assets/testjson/templateList.json",
              dataType: "json",
              pagination: true, //分页
              pageList: [5, 10, 15],
              pageSize:5,
              height:450, 
              showRefresh : true,
              search: true, //显示搜索框,
              showColumns : true,
              data:data,
              columns: [
                            {
                               title: '模板编号',
                                field: 'code',
                                width:100,
                                formatter:codeFormatter
                            }, 
                            {
                               title: '模板名称',
                                field: 'name',
                                width:150
                            }, 
                            {
                               title: '创建时间',
                                field: 'modifyTime',
                                width:100
                            }, 
                            {
                               title: '最近修改',
                                field: 'lastModifyTime',
                                width:100
                            }, 
                            {
                               title: 'url',
                                field: 'url',
                                width:100
                            }, 
                            {
                               title: '状态',
                                field: 'status',/*0为已发布，1为编辑中*/
                                width:100,
                                formatter:statusFormatter,
                            }, 
                            {
                                title: '操作',
                                field: 'status',
                                align: 'center',
                                width:100,
                                formatter:operateFormatter,
                                //events:editEvents
                            }
                ]
    });
  $(".edit").on('click',function(){
      var $this=this;
      var id=$this.id;
      window.open("/jsp/scanTemp.html?="+id,"_blank");
    })      
}); 	
 	function codeFormatter(value,row,index){
      return index+1;
    };

    function statusFormatter(value,row,index){
    	if(value==1){
    		return['<span>编辑中</span>']
    	}else{
    		return['<span>已发布</span>']
    	}
    };

    function operateFormatter(value, row, index) {
      if(value==0){
        return ['<input type="button" value="编辑" class="btn btn-info scan" disabled="disabled" id="List',
        row.id,
        '" >'].join('');
      } else{
        return ['<input type="button" value="编辑" class="btn btn-primary edit" id="List',
        row.id,
        '">'].join('');
      }    
    } ;



             
    