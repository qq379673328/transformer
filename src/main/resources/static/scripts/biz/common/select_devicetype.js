"use strict";
/**
 * 选择器-设备类型
 */
define(["selectDeviceType"], function(){

	// 初始化选择器
	function init($tag, params, openWinWithEdit){
		if(!$tag) return;
		
		var isLevel1 = params.isLevel1 || false;

		// 下拉框
		$tag.combobox({
			url: 'api/devicetype/list?state=01'+ (isLevel1 ? ('&isLevel1='+isLevel1) : ''),
			valueField: 'id',
			textField: 'name',
			required: params.required,
			method: 'get',
			icons: [{
				iconCls: 'icon-clear',
				iconAlign: 'right',
				handler: function(e){
					$tag.textbox('setValue', null);
					$tag.textbox('setText', '');
				}
			}],
			loadFilter: function(data){
				var items = data ? data.data : [];
				
				
				return items;
			},
			onLoadSuccess: function(){
				$tag.combobox('setValue', $tag.val());
			}
		});
		
	}

	return {init: init};

});