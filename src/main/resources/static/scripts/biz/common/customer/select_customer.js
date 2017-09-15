"use strict";
/**
 * 选择器-客户
 */
define(["bizCustomer"], function(bizCustomer){

	// 初始化选择器
	function init($tag, params, openWinWithEdit){
		if(!$tag) return;

		// 下拉框
		$tag.combobox({
			url: 'api/base/customer/list/valid?state=01',
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
				var d = data.data;
				if(params.isShowAdd){
					var addRow = [{id: null, name: '', isAdd: true}];
					d = addRow.concat(d);
				}
				return d;
			},
			onLoadSuccess: function(){
				$tag.combobox('setValue', $tag.val());
				
				// 新增
				$tag.combobox("panel").find(".btn-select").click(function(){
					bizCustomer.add(openWinWithEdit, function(data){
						$tag.val(data.id);
						$tag.combobox('reload');
					});
				});
			},
			formatter: function(row){
				var opts = $(this).combobox('options');
				if(row.isAdd){
					return '<span class="btn btn-select">新增</span>';
				}else{
					return row[opts.textField];
				}
			}
		});
		
	}

	return {init: init};

});