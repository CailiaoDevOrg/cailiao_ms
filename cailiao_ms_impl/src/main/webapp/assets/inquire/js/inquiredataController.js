/*inquire*/
var inquireApp=angular.module('inquireApp',[]);
inquireApp.controller('inquiredataController',function($scope){
	

});

inquireApp.controller('inquirehtmlController',function($scope){
	$(".tabcontent").css("display","none");
	$(".tabcontent").eq(0).css("display","block");

	$("#tab li").click(function()
	{
		var Index=$(this).index();
		$("#tab li").removeClass("active");
		$("#tab li").eq(Index).addClass("active");
		$(".tabcontent").css("display","none");
		$(".tabcontent").eq(Index).css("display","block");
	});

	$scope.search=function(){
		var data=
      {
        "retCode": 200,
        "retDesc": "SUCCESS",
        "body": {
            "questionnaireContentList": [
            	{
                    "id": 1,
                    "questionnaireTemplateId": 2,
                    "cementFactoryId": "红星水泥厂",
                    "productionLine": "第一生产线",
                    "modifyTime": "",
                    //时间戳
                    "lastModifyTime": "",
                    //时间戳
                    "jsonContent": "",
                    //这就是之前你保存的数据里面的那个jsonContent
                    "status": 2,
                    "rejectReason": "通过"
                },
                {
                    "id": 2,
                    "questionnaireTemplateId": 2,
                    "cementFactoryId": "葛洲坝水泥厂",
                    "productionLine": "第一生产线",
                    "modifyTime": "",
                    //时间戳
                    "lastModifyTime": "",
                    //时间戳
                    "jsonContent": "",
                    //这就是之前你保存的数据里面的那个jsonContent
                    "status": 1,
                    "rejectReason": "通过"
                },
                {
                    "id": 4,
                    "questionnaireTemplateId": 4,
                    "cementFactoryId": "红狮水泥厂",
                    "productionLine": "第一生产线",
                    "modifyTime": "",
                    //时间戳
                    "lastModifyTime": "",
                    //时间戳
                    "jsonContent": "",
                    //这就是之前你保存的数据里面的那个jsonContent
                    "status": 3,
                    "rejectReason": "通过"
                },
                {
                    "id": 5,
                    "questionnaireTemplateId": 2,
                    "cementFactoryId": "xxxs水泥厂",
                    "productionLine": "xxx生产线",
                    "modifyTime": "",
                    //时间戳
                    "lastModifyTime": "",
                    //时间戳
                    "jsonContent": "",
                    //这就是之前你保存的数据里面的那个jsonContent
                    "status": 2,
                    "rejectReason": "通过"
                },
                {
                    "id": 6,
                    "questionnaireTemplateId": 2,
                    "cementFactoryId": "xxxs水泥厂",
                    "productionLine": "xxx生产线",
                    "modifyTime": "",
                    //时间戳
                    "lastModifyTime": "",
                    //时间戳
                    "jsonContent": "",
                    //这就是之前你保存的数据里面的那个jsonContent
                    "status": 1,
                    "rejectReason": "通过"
                },
                {
                    "id": 7,
                    "questionnaireTemplateId": 4,
                    "cementFactoryId": "xxxs水泥厂",
                    "productionLine": "xxx生产线",
                    "modifyTime": "",
                    //时间戳
                    "lastModifyTime": "",
                    //时间戳
                    "jsonContent": "",
                    //这就是之前你保存的数据里面的那个jsonContent
                    "status": 3,
                    "rejectReason": "通过"
                }  
            ]
          }
      };
		$("#inquire_result_table").bootstrapTable({
              //url:"/assets/testjson/data.json",
              dataType: "json",
              pagination: true, //分页
              pageList: [5, 10, 15],
              pageSize:5,
              height:450, 
              showRefresh : true,
              search: true, //显示搜索框,
              showColumns : true,
              data:data.body.questionnaireContentList,
              columns: [
                            {
                               title: '编号',
                                field: 'code',
                                width:20,
                                formatter:codeFormatter
                            }, 
                            {
                               title: '生产线',
                                field: 'productionLine',
                                width:150
                            }, 
                            {
                               title: '水泥厂',
                                field: 'cementFactoryId',
                                width:150
                            }, 
                            {
                                title: '提交时间',
                                field: 'modifyTime',
                                align: 'center',
                                width:80
                               
                            }, 
                            {
                                title: '最近修改',
                                field: 'lastModifyTime',
                                align: 'center',
                                width:80
                               
                            }, 
                            {
                                title: '操作状态',
                                field: 'status',
                                align: 'center',
                                width:60,
                                formatter:operateFormatter,
                                events:editEvents
                            }
                ]
    });
	}
})

function codeFormatter(value,row,index){
      return index+1;
    };

    function operateFormatter(value, row, index) {
      if(value==2||value==3){
        return ['<input type="button" value="查看" class="btn btn-info scan" data-method="post">']
      } else{
        return ['<input type="button" value="审核" class="btn btn-primary edit" data-method="post">']
      }    
    };
             
    window.editEvents = {
      'click .scan': function (e,value,row,index) {      
          window.open("./scan.html?="+id,"_blank");
         console.log("ok");
      },
      'click .edit': function (e,value,row,index) {   
          window.open("./edit.html?="+id,"_blank");
         console.log("ok");
      }

    };