 var createTempApp=angular.module('createTempApp',[]);
 createTempApp.controller('createTempController',function($scope,$http){
 	/*$http.get("",function(response){
 		var test=response.createTemplate;
 		function setdata(){
 			$scope.name=test.name;
 			$scope.description=test.description;
 			$scope.templateJspUrl=test.templateJspUrl;
 			$scope.startTime=test.startTime;
 			$scope.endTime=test.endTime;

 		}
 	})*/
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
 		createTemplate=getdata();
 		console.log(createTemplate);
 	}
 });