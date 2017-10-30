"use strict";
/**
 * 首页
 */
define(["jquery", "core"],
	function($, core) {
	
	// 获取首页配置信息
	core.submitAjax({
		url: 'api/system/config/list',
		type: 'get',
		success: function(data){
			if(data){
				for(var i in data){
					var item = data[i];
					if(item.key == '左侧文字'){
						$("#index-content-left").html(item.content);
					}else if(item.key == '右侧图片'){
						$("#index-content-right").append('<img style="width: 100%" src="upfiles/' + item.filePath + '" />');
					}
				}
			}
		}
	});
	
});
