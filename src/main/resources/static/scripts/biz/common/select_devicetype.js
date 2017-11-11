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
		$tag.combotree({
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
				items = toTree(items, null);
				console.dir(items);
				return items;
			},
			onLoadSuccess: function(){
				$tag.combotree('setValue', $tag.val());
			}
		});
		
	}
	
	// 线性数据转化为树。
	function toTree(data, parent_id) {
		var tree = [];
		var temp;
		for (var i = 0; i < data.length; i++) {
			if (data[i].par_id == parent_id) {
				var obj = data[i];
				obj.text = obj.name;
				temp = toTree(data, data[i].id);
				if (temp.length > 0) {
					obj.children = temp;
				}
				tree.push(obj);
			}
		}
		return tree;
	}

	return {init: init};

});