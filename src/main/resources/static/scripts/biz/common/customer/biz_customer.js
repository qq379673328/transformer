"use strict";
/**
 * 添加|编辑-客户
 */
define(["core"],function(core){
	
	var windowHeight = $(window),
		dialogHeight = windowHeight < 650 ? windowHeight - 50 : 650;

	/*新增和编辑的公共配置*/
	var addEditConfig = {
		tpl: "scripts/biz/common/customer/tpl/edit.tpl",
		dialogConfig: {
			width: 1000,
			height: dialogHeight
		}
	};

	// 新增
	function add(openWinWithEdit, cb){
		openWinWithEdit($.extend({}, addEditConfig, {
			title: "新增客户",
			surl: "api/base/customer/add",
			success: function(data, $win){
				$win.dialog("destroy");
				if(cb) cb(data);
			}
		}));
	}

	// 编辑
	function edit(id, openWinWithEdit, cb){
		core.submitAjax({
			url: "api/base/customer/get/" + id,
			type: "get",
			success: function(data){
				openWinWithEdit($.extend({}, addEditConfig, {
					title: "编辑客户",
					surl: "api/base/customer/edit",
					data: data,
					success: function(data, $win){
						$win.dialog("destroy");
						if(cb) cb(data);
					}
				}));
			}
		});
	}
	
	// 查看
	function view(id, openWin){
		core.submitAjax({
			url: "api/base/customer/get/" + id,
			type: "get",
			success: function(data){
				openWin({
					tpl: "scripts/biz/common/customer/tpl/view.tpl",
					title: "客户信息",
					data: data,
					dialogConfig: {
						width: 1000,
						height: dialogHeight
					}
				});
			}
		});
	}

	return {
		add: add,// 新增
		edit: edit,// 编辑
		view: view//查看
	};

});