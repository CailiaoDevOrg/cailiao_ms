 var sacnTempApp=angular.module('sacnTempApp',[]);
 sacnTempApp.controller('scanTempController',function($scope,$http){

 	$http.get("",function(response){
 		//var test=response.createTemplate;
 	});
 	var teststr={
				 "createTemplate":[{
			 			"name":"name",
			 			"description":"description",
			 			"templateJspUrl":"templateJspUrl.html",
			 			"startTime":"2016-03-01",
			 			"endTime":"2016-03-15"
			 		}],
			 		"flag":0
			 		//"flag":1
			};
		var test=teststr.createTemplate[0];
 		console.log(test);
 		function setdata(){
 			$scope.name=test.name;
 			$scope.description=test.description;
 			$scope.templateJspUrl=test.templateJspUrl;
 			$scope.startTime=test.startTime;
 			$scope.endTime=test.endTime;

 		}
 		setdata();
 	function getdata(){
 		var name=$scope.name;
 		var description=$scope.description;
 		var templateJspUrl=$scope.templateJspUrl;
 		var startTime=$scope.startTime;
 		var endTime=$scope.endTime;
 		var createTemplate={
 			name:name,
 			description:description,
 			templateJspUrl:templateJspUrl,
 			startTime:startTime,
 			endTime:endTime
 		};
 		return createTemplate;
 	}
 	$scope.submit=function(){
 		alert("是否确认修改？");
 		createTemplate=getdata();
 		console.log(createTemplate);
 	}
 });