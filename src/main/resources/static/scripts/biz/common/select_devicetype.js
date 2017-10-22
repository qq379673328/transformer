"use strict";
/**
 * 选择器-设备类型
 */
define(["selectDeviceType"], function(){

	// 初始化选择器
	function init($tag, params, openWinWithEdit){
		if(!$tag) return;

		// 下拉框
		$tag.combobox({
			url: 'api/devicetype/list?state=01',
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
				return data ? data.data : [];
			},
			onLoadSuccess: function(){
				$tag.combobox('setValue', $tag.val());
			}
		});
		
	}

	return {init: init};

});