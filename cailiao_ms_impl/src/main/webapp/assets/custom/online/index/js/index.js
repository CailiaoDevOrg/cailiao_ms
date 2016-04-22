(function($, $$) {
	
	$(function() {
		
		$.ajax({
            url: '/online/news/getList.html',
            method: 'GET',
            contentType: 'application/json',
            success: function(data) {
            	data = JSON.parse(data);
            	if (data.retCode == 200) {
            	    var $news = $('.centerdynomic').empty();
                    var newsList = data.body.newsList;
                    for (var i = 0, len = newsList.length > 7 ? 7 : newsList.length; i < len; i++) {
                    	var item = '<li title="' + newsList[i].content + '">\
                    		            <span><a href="' + newsList[i].url + '" style="color:; font-weight:;" target="_blank">' + newsList[i].title + '</a></span>\
                    		            <span class="right">&nbsp; &nbsp;' + $$.formatTime(newsList[i].publishedTime) + '</span>\
                    		        </li>';
                    	$news.append(item);
                    }
            	} else {
            		alert('系统忙，新闻无法加载');
            	}
            },
            error: function(data) {
            	alert('网络出现问题，新闻无法加载');
            }
        });
	});
	
})(jQuery, timeFormat);