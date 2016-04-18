var timeFormat = (function() {
	function getLocalTime(nS) {     
	    return new Date(parseInt(nS)).toLocaleString().replace(/:\d{1,2}$/,' ');     
	} 
	
	return {
		formatTime : getLocalTime
	}
})(jQuery);