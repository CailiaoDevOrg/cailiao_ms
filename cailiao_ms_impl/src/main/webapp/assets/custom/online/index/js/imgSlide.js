var Index=0;
$(function() {
    //定义全局变量，用来实现循环
    var i = 0;
    //基本幻灯事件
    $(".slideimg").hover(function() {
        
		//鼠标放在图片上时，清除之前的滚动。
		clearInterval(_interval);},function(){
			
		//然后从当前位置开始滚动
		_interval=setInterval(AutoChange,3000);
		//此处修改透明度
		
    });

    //写轮换函数
    function AutoChange() {
        $(".slideimg").eq(i)
                          .css("display", "block")
					      .siblings()
						  .css("display", "none");
		$(".showp").css("display","block");
		$(".imgindex").eq(i)
                          .addClass("hover")
						  .siblings()
						  .removeClass("hover");
	        i++;
			if(i==5){
				i=0;
			}
    	}
   	 _interval=setInterval(AutoChange, 2500);
	})
