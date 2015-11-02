// jQuery 확장을 통한 플러그인 개발
jQuery.fn.setBackground = function(color){
	$(this).css("background",color);
	return $(this);
};
