 var createTempApp=angular.module('createTempApp',[]);
 createTempApp.controller('createTempController',function($scope,$http){
 	//console.log(name);
 	$scope.submit=function(){

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
 		console.log(createTemplate);
 	}
 });