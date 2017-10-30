/**
 * 权限分类管理-角色管理
 */
define(["core", "tplengine"],
		function(core, tplengine){
	
	/**
	 * 页面元素
	 */
	var $btnSearch = $("#btn-search"),//查询按钮
		$btnBatchdel = $("#btn-batchdel"),//批量删除
		$btnAdd = $("#btn-add"),//新增
		$listTab = $("#list-tab"),//查询列表
		$formSearch = $("#form-search")//查询表单
		;
	
	/**
	 * 页面初始化
	 */
	//加载列表
	initList();
	
	/**
	 * 事件绑定
	 */
	//查询按钮
	$btnSearch.click(function(){
		$listTab.datagrid('load', core.getFormData($formSearch));
	});
	//批量删除按钮
	$btnBatchdel.click(delBatch);
	//新增
	$btnAdd.click(add);
	
	/**
	 * 方法声明
	 */
	//初始化列表
	function initList(){
		$listTab.datagrid({
			url: 'auth/rolemgr/list',
			columns: [[
				{field: "ID", hidden:true},
				{field: "ROLE_NAME", title: "角色名称", width: 150},
				{field: "ROLE_DESC", title: "角色描述", width: 500},
				{field: "HD", title: "操作", width: 200, formatter: function(val, row, idx){
					if(row.ID == '1'){
						return '禁止操作';
					}
					return '<a onclick="APP.P.view(' + idx + ');" title="查看" class="grid-icon"><span class="fa fa-eye"></span><span>查看</span></a>'
					+ '<a onclick="APP.P.edit(' + idx + ');" title="编辑" class="grid-icon"><span class="fa fa-edit"></span><span>编辑</span></a>'
					+ '<a onclick="APP.P.perm(' + idx + ');" title="授权" class="grid-icon"><span class="fa fa-check"></span><span>授权</span></a>'
					+ '<a onclick="APP.P.delOne(' + idx + ');" title="删除" class="grid-icon"><span class="fa fa-remove"></span><span>删除</span></a>'
					;
				}},
			]],
			toolbar:[{
				iconCls:'icon-xinzeng',
				id:'auth_permmgr_tjjs',
				text:"新增角色",
				handler:function(){
					add();
				}
			}]
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
	
	//删除单条数据
	APP.P.delOne = function(idx){
		del([$listTab.datagrid("getData").rows[idx]]);
	};
	
	//批量删除数据
	function delBatch(){
		getSelectMu(function(rows){
			del(rows);
		});
	}
	
	//删除数据
	function del(rows){
		$.messager.confirm('确认','确定删除所选记录?',function(r){
			if (r){
				core.submitAjax({
					url: "auth/rolemgr/del",
					data: {
						ids: core.getSelectFields(rows, "ID")
					},
					success: function(data){
						initList();
					}
				});
			}
		});
	}
	
	/*新增和编辑的公共配置*/
	var addEditConfig = {
		tpl: "scripts/biz/auth/permmgr/tpl/roleedit.tpl",
		surl: "auth/rolemgr/edit",
		type: "1",
		width: 600,
		height: 350,
		success: function(data, $win){
			initList();
			$win.dialog("destroy");
		}
	};
	
	//新增
	function add(){
		tplengine.openWinWithEdit($.extend({}, addEditConfig, {
			title: "新增角色"
		}));
	}
	
	//编辑
	APP.P.edit = function(idx){
		var row = $listTab.datagrid("getData").rows[idx];
		var newRow = {
			roleName: row.ROLE_NAME,
			roleDesc: row.ROLE_DESC,
			appId: row.APP_ID,
			id: row.ID
		};
		tplengine.openWinWithEdit($.extend({}, addEditConfig, {
			title: "编辑角色",
			data: newRow
		}));
	};
	
	//查看
	APP.P.view = function(idx){
		tplengine.openWinWithEdit({
			tpl: "scripts/biz/auth/permmgr/tpl/roleview.tpl",
			type: "0",
			width:450,
			height:450,
			title: "角色信息",
			data: $listTab.datagrid("getData").rows[idx]
		});
	};
	
	//为角色分配权限
	var $curTree = null;
	APP.P.perm = function(idx){
		var row = $listTab.datagrid("getData").rows[idx];
		tplengine.openWinWithEdit({
			tpl: "scripts/biz/auth/permmgr/tpl/roleperm.tpl",
			type: "1",
			dialogConfig: {
				width:450,
				height:450,
			},
			data: {roleId: row.ID},
			surl: "auth/rolemgr/setPerms",
			title: "角色授权",
			tplsuccess: function($form){
				//加载权限信息并生成
				$.ajax({
					url: "auth/rolemgr/getPermsAll",
					data: {roleId: row.ID},
					type: 'get',
					success: function(data){
						$curTree = $("<ul>").appendTo($form.find("#permtree"));
						$curTree.tree({
							data: data,
							checkbox: true,
							lines: true,
							onLoadSuccess: function(){
								$curTree.tree("expand", $curTree.tree("getRoot").target);
							}
						});
					}
				});
			},
			beforeSubmit: function($form){
				//生成需要提交的权限ids
				var ids = handlePostTreeNode($curTree.tree('getChecked', ['checked','indeterminate']));
				$form.find("input[name=ids]").val(ids);
				return true;
			}
		});
	};
	function handlePostTreeNode(nodes){
		var ids = [];
		for(var i in nodes){
			var node = nodes[i];
			ids.push(node.id);
		}
		return ids.join("&");
	}
	
});
