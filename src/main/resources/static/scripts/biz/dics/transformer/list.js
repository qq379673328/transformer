/**
 * 变电站
 */
define(["core", "tplengine"], function(core, tplengine){
	
	/**
	 * 页面元素
	 */
	var $btnAdd = $("#btn-add"),//新增
		$listTab = $("#list-tab")//查询列表
		;
	
	/**
	 * 页面初始化
	 */
	//加载列表
	initList();
	
	//重新加载列表
	function reloadList(){
		$listTab.datagrid('reload');
	}
	
	/**
	 * 事件绑定
	 */
	//新增
	$btnAdd.click(add);
	
	/**
	 * 方法声明
	 */
	//初始化列表
	function initList(){
		$listTab.datagrid({
			url: 'api/transformer/list',
			pagination: false,
			loadFilter: function(data){
				return {rows: core.handleAjaxResultData(data)};
			},
			columns: [[
				{field: "id", hidden:true},
				{field: "name", title: "名称", width: 100},
				{field: "type", title: "分组", width: 100},
				{field: "desc", title: "描述", width: 100},
				{field: "createTime", title: "创建时间", width: 120, formatter: function(val){
					return core.transTimeStamp(val);
				}},
				{field: "state", title: "状态", width:60, formatter: function(val, row){
					val = "";
					if(row.state == "01"){//禁用
						val = "<i class='fa fa-lock'></i> 启用";
					}else{
						val = "<i class='fa fa-unlock'></i> 禁用";
					}
					return val;
				}},
				{field: "HD", title: "操作", width: 100, formatter: function(val, row, idx){
					var ret = '';
					if(core.hasPermission('system_mgr_dics_transformer_edit')) 
						ret += '<a onclick="APP.P.edit(' + idx + ');" title="编辑" class="grid-icon"><span class="fa fa-edit"></span><span>编辑</span></a>';
					if(core.hasPermission('system_mgr_dics_transformer_enable')) 
						ret += '<a onclick="APP.P.enable(' + idx + ');" title="启用" class="grid-icon"><span class="fa fa-lock"></span><span>启用</span></a>';
					if(core.hasPermission('system_mgr_dics_transformer_disable')) 
						ret += '<a onclick="APP.P.disable(' + idx + ');" title="禁用" class="grid-icon"><span class="fa fa-unlock"></span><span>禁用</span></a>';
					if(core.hasPermission('system_mgr_dics_transformer_del')) 
						ret += '<a onclick="APP.P.del(' + idx + ');" title="删除" class="grid-icon"><span class="fa fa-close"></span><span>删除</span></a>';
					return ret;
				}}
			]],
			toolbar: core.hasPermission('system_mgr_dics_transformer_add') ? 
				[{
					iconCls:'icon-add',
					id:'auth_usermgr_tjyh',
					text:"新增",
					handler:function(){
						add();
					}
				}] : []
		});
		
	}
	
	//获取单行选择数据
	function getSelectOne(cb){
		var rows = $listTab.datagrid("getChecked");
		if(!rows || rows.length != 1){
			core.alertMessage("请选择单条数据");
			return;
		}else{
			if(cb) cb(rows[0]);
		}
	}
	
	//删除
	APP.P.del = function(idx){
		$.messager.confirm('确认','确定删除所选记录?',function(r){
			if (r){
				var row = $listTab.datagrid("getData").rows[idx];
				core.submitAjax({
					url: "api/transformer/del",
					data: {
						ids: row.id
					},
					success: function(data){
						reloadList();
					}
				});
			}
		});
	}
	
	/*新增和编辑的公共配置*/
	var addEditConfig = {
		tpl: "scripts/biz/dics/transformer/tpl/edit.tpl",
		dialogConfig: {
			width: 500
		},
		type: "1",
		beforeSubmit: function($form){
			var value = $form.find('input[name=type]:checked').val();
			if(!value){
				core.alertMessage("请选择分组");
				return false;
			}else{
				return true;
			}
		},
		success: function(data, $win){
			reloadList();
			$win.dialog("destroy");
		}
	};
	
	//新增
	function add(){
		tplengine.openWinWithEdit($.extend({}, addEditConfig, {
			title: "新增变电站",
			surl: "api/transformer/add"
		}));
	}
	
	//编辑
	APP.P.edit = function(idx){
		var row = $listTab.datagrid("getData").rows[idx];
		tplengine.openWinWithEdit($.extend({}, addEditConfig, {
			title: "编辑变电站",
			surl: "api/transformer/edit",
			data: row,
			tplsuccess: function($form){
				$form.find('input[name=type]').each(function(){
					if($(this).val() == row.type){
						$(this).attr("checked", true);
					}
				});
			}
		}));
	};
	
	//禁用
	APP.P.disable = function(idx){
		var row = $listTab.datagrid("getData").rows[idx];
		$.messager.confirm('确认','确定禁用所选记录?',function(r){
			if (r){
				core.submitAjax({
					url: "api/transformer/disable",
					data: {
						ids: row.id
					},
					success: function(data){
						reloadList();
					}
				});
			}
		});
	}
	
	// 启用
	APP.P.enable = function(idx){
		var row = $listTab.datagrid("getData").rows[idx];
		core.submitAjax({
			url: "api/transformer/enable",
			data: {
				ids: row.id
			},
			success: function(data){
				reloadList();
			}
		});
	}
	
});
