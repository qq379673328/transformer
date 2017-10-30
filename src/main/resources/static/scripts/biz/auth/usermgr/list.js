/**
 * 人员管理
 */
define(["core", "tplengine"], function(core, tplengine){
	
	/**
	 * 页面元素
	 */
	var $btnSearch = $("#btn-search"),//查询按钮
		$btnAdd = $("#btn-add"),//新增
		$listTab = $("#list-tab"),//查询列表
		$formSearch = $("#form-search")//查询表单
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
	//查询按钮
	$btnSearch.click(function(){
		$listTab.datagrid('load', core.getFormData($formSearch));
	});
	//新增
	$btnAdd.click(add);
	
	// 根据idx获取行数据
	function getRowByIdx(idx){
		return $listTab.datagrid("getData").rows[idx];
	}
	
	/**
	 * 方法声明
	 */
	//初始化列表
	function initList(){
		$listTab.datagrid({
			url: 'auth/usermgr/list',
			columns: [[
				{field: "id", hidden:true},
				{field: "loginName", title: "登录名", width: 100},
				{field: "name", title: "姓名", width: 100},
				{field: "createTime", title: "注册时间", width: 120, formatter: function(val){
					return core.transTimeStamp(val);
				}},
				{field: "isUsed", title: "状态", width:60, formatter: function(val, row){
					val = "";
					if(row.isUsed == "02"){//禁用
						val = "<i class='fa fa-lock'></i> 禁用";
					}else{
						val = "<i class='fa fa-unlock'></i> 启用";
					}
					return val;
				}},
				{field: "HD", title: "操作", width: 100, formatter: function(val, row, idx){
					if(row.id == '1'){
						return '禁止操作';
					}
					return '<a onclick="APP.P.edit(' + idx + ');" title="编辑" class="grid-icon"><span class="fa fa-edit"></span><span>编辑</span></a>'
					+ '<a onclick="APP.P.resetpwd(' + idx + ');" title="重置密码" class="grid-icon"><span class="fa fa-key"></span><span>重置密码</span></a>'
					+ '<a onclick="APP.P.enable(' + idx + ');" title="启用" class="grid-icon"><span class="fa fa-check"></span><span>启用</span></a>'
					+ '<a onclick="APP.P.disable(' + idx + ');" title="禁用" class="grid-icon"><span class="fa fa-ban"></span><span>禁用</span></a>'
					+ '<a onclick="APP.P.perm(' + idx + ');" title="分配角色" class="grid-icon"><span class="fa fa-edit"></span><span>分配角色</span></a>'
					//+ '<a onclick="APP.P.del(' + idx + ');" title="删除" class="grid-icon"><span class="fa fa-close"></span><span>删除</span></a>'
					;
				}}
			]],
			toolbar:[{
				iconCls:'icon-xinzeng',
				id:'auth_usermgr_tjyh',
				text:"新增",
				handler:function(){
					add();
				}
			}]
		});
		
	}
	
	//删除
	APP.P.del = function(idx){
		$.messager.confirm('确认','确定删除所选记录?',function(r){
			if (r){
				core.submitAjax({
					url: "auth/usermgr/del",
					data: {id: getRowByIdx(idx).id},
					success: function(data){
						reloadList();
					}
				});
			}
		});
	}
	
	/*新增和编辑的公共配置*/
	var addEditConfig = {
		tpl: "scripts/biz/auth/usermgr/tpl/useredit.tpl",
		dialogConfig:{
			width: 500
		},
		type: "1",
		success: function(data, $win){
			reloadList();
			$win.dialog("destroy");
		}
	};
	
	//新增
	function add(){
		tplengine.openWinWithEdit($.extend({}, addEditConfig, {
			title: "新增用户",
			surl: "auth/usermgr/add",
			data: {
				isUsed: "1"//默认启用
			}
		}));
	}
	
	//编辑
	APP.P.edit = function(idx){
		tplengine.openWinWithEdit($.extend({}, addEditConfig, {
			title: "编辑用户",
			surl: "auth/usermgr/edit",
			data: getRowByIdx(idx)
		}));
	};
	
	//禁用
	APP.P.disable = function(idx){
		$.messager.confirm('确认','确定禁用所选记录?',function(r){
			if (r){
				core.submitAjax({
					url: "auth/usermgr/disable",
					data: {id: getRowByIdx(idx).id},
					success: function(data){
						reloadList();
					}
				});
			}
		});
	}
	
	//启用
	APP.P.enable = function(idx){
		core.submitAjax({
			url: "auth/usermgr/enable",
			data: {id: getRowByIdx(idx).id},
			success: function(data){
				reloadList();
			}
		});
	}
	
	//重置密码
	APP.P.resetpwd = function(idx){
		core.submitAjax({
			url: "auth/usermgr/resetPwd",
			data: {ids: getRowByIdx(idx).id}
		});
	}
	
	//为用户分配角色
	APP.P.perm = function(idx){
		tplengine.openWinWithEdit({
			tpl: "scripts/biz/auth/usermgr/tpl/userrole.tpl",
			type: "1",
			dialogConfig: {
				width:450,
				height:450,
			},
			data: {
				userId: getRowByIdx(idx).id
			},
			surl: "auth/usermgr/setRole",
			title: "分配角色",
			tplsuccess: function($form){
				//加载角色信息并生成
				$.ajax({
					url: "auth/rolemgr/getRolesByUserId",
					type: 'post',
					data: {
						userId: getRowByIdx(idx).id
					},
					success: function(data){
						var $ul = $("<ul class='user-role-mgr'>").appendTo($form.find("#rolelist"));
						for(var idx in data){
							var item = data[idx];
							var $input = $("<input type='radio' value='"+item.ID+"' name='roleIds' />");
							if(item.isown == '1'){
								$input.attr("checked", true);
							}
							$("<li>").append($input).append(item['ROLE_NAME']+"<br/>")
							.appendTo($ul);
						}
					}
				});
			},
			success: function(data, $win){
				reloadList();
				$win.dialog("destroy");
			}
		});
	}
	
});
