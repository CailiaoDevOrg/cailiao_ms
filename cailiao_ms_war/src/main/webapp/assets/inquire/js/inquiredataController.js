/*inquire*/
var inquireApp=angular.module('inquireApp',[]);
inquireApp.controller('inquiredataController',function($scope){
	console.log("ok");
});

inquireApp.controller('inquirehtmlController',function($scope){
	$(".tabcontent").css("display","none");
	$(".tabcontent").eq(0).css("display","block");
	$("#tab li").click(function(){
		var Index=$(this).index();
		$("#tab li").removeClass("active");
		$("#tab li").eq(Index).addClass("active");
		console.log("ok2");
		$(".tabcontent").css("display","none");
		$(".tabcontent").eq(Index).css("display","block");
		console.log(Index);
	});
})