"use strict";
/**
 * 基础信息-客户
 */
define(["jquery", "core", "tplengine", "bizCustomer"],
	function($, core, tplengine, bizCustomer) {
	/**
	 * 页面操作元素声明
	 */
	var $btnSearch = $("#btn-search"),//查询按钮
		$btnBatchDel = $("#btn-batch-del"),//批量删除
		$btnAdd = $("#btn-add"),//新增
		$listTab = $("#list-tab"),//查询列表
				$btnBatchEnable = $("#btn-batch-enable"),//批量启用
		$btnBatchDisable = $("#btn-batch-disable"),//批量禁用
		$formSearch = $("#form-search");//查询表单
		

	/**
	 * 页面初始化
	 */
	//加载列表
	initList();

	/**
	 * 事件绑定
	 */
	//查询按钮
	$btnSearch.click(loadList);
	//批量删除按钮
	$btnBatchDel.click(delBatch);
	//新增
	$btnAdd.click(add);
			//批量启用按钮
	$btnBatchEnable.click(enableBatch);
	//批量禁用按钮
	$btnBatchDisable.click(disableBatch);

	/**
	 * 方法声明
	 */
	//初始化列表
	function initList(){
		$listTab.datagrid({
			url:'api/base/customer/list',
			title: '客户查询结果',
			queryParams: core.getFormData($formSearch),
			rowStyler: function(index, row){
				if (row.state == '02'){
					return core.rowStyleDisable;
				}
			},
			columns:[[
				{field: "id", hidden:true},
				{field: "ck", checkbox:true},
				{field: "name", title: "客户名称", width: 100},
				{field: "contact", title: "联系人", width: 100},
				{field: "contactPhone1", title: "电话", width: 100, formatter: function(val, row, idx){
					return row.contactPhone1 + ' ' + row.contactPhone2;
				}},
				{field: "address", title: "地址", width: 100},
				{field: "createTime", title: "创建时间", width: 100, formatter: function(val){
					return core.transTimeStamp(val, 0);
				}},
				{field: "stateDesc", title: "状态", width: 50},
				{field: "HD", title: "操作", width: 150,
					formatter: function(val, row, idx){
					var str = '<a onclick="APP.P.view(' + idx + ');" title="查看" class="grid-icon">查看</a>'
						if(core.hasPermission("manager_base_people_customer_edit")){
							str+= '&nbsp;&nbsp;<a onclick="APP.P.edit(' + idx + ');" title="编辑" class="grid-icon">编辑</a>';
						}
						if(row.state == '01'){
							if(core.hasPermission("manager_base_people_customer_disable")){
								str += '&nbsp;&nbsp;<a onclick="APP.P.disableItem(' + idx + ');" title="删除" class="grid-icon">删除</a>';
							}
						}else{
							if(core.hasPermission("manager_base_people_customer_enable")){
								str += '&nbsp;&nbsp;<a onclick="APP.P.enableItem(' + idx + ');" title="撤销删除" class="grid-icon">撤销删除</a>';
							}
						}
					return str;
				}}
			]]
		});
	}
	//获取多行选择数据
	function getSelectMu(cb){
		var rows = $listTab.datagrid("getChecked");
		if(!rows || rows.length == 0){
			core.alertMessage("请选择数据");
			return;
		}else{
			if(cb) cb(rows);
		}
	}
	//加载列表
	function loadList(){
		$listTab.datagrid('load', core.getFormData($formSearch));
	}
	//重新加载列表
	function reloadList(){
		$listTab.datagrid('reload');
	}
	// 获取操作行数据id
	function getOneRowId(idx){
		return $listTab.datagrid("getData").rows[idx].id;
	}

	// 批量删除
	function delBatch(){
		getSelectMu(function(rows){
			del(core.getSelectFields(rows, "id"));
		});
	}
	// 单行删除
	APP.P.delItem = function(idx){
		del(getOneRowId(idx));
	};
	// 删除
	function del(ids){
		$.messager.confirm('确认', '确定删除所选记录?', function(r){
			if (r){
				core.submitAjax({
					url: "api/base/customer/del",
					data: {
						ids: ids
					},
					success: function(data){
						reloadList();
					}
				});
			}
		});
	}

	// 新增
	function add(){
		bizCustomer.add(
			tplengine.openWinWithEdit,
			function(){
				reloadList();
			});
	}

	// 编辑
	APP.P.edit = function(idx){
		bizCustomer.edit(
			getOneRowId(idx),
			tplengine.openWinWithEdit,
			function(){
				reloadList();
			});
	};
	
	// 查看
	APP.P.view = function(idx){
		bizCustomer.view(getOneRowId(idx), tplengine.openWin);
	};
	
	// 批量启用
	function enableBatch(){
		getSelectMu(function(rows){
			enable(core.getSelectFields(rows, "id"));
		})
	}
	// 单行启用
	APP.P.enableItem = function(idx){
		enable(getOneRowId(idx));
	};
	// 启用
	function enable(ids){
		core.submitAjax({
			url: "api/base/customer/enable",
			data: {
				ids: ids
			},
			success: function(data){
				reloadList();
			}
		});
	};

	// 批量禁用
	function disableBatch(){
		getSelectMu(function(rows){
			disable(core.getSelectFields(rows, "id"));
		})
	}
	// 单行禁用
	APP.P.disableItem = function(idx){
		disable(getOneRowId(idx));
	};
	// 禁用
	function disable(ids){
	$.messager.confirm('确认', '确定删除所选记录?', function(r){
		if(r){
			core.submitAjax({
				url: "api/base/customer/disable",
				data: {
					ids: ids
				},
				success: function(data){
					reloadList();
				}
			});
		}
	});
	};
	
});
