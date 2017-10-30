/*
 * 应用路由
 */
define(["underscore", "mc", "backbone"], function(_, mc, backbone){
	var customRouter = {
			
		// 首页
		"": {
			script: "index/index",
			tpl: "scripts/biz/index/tpl/index.tpl",
			menuSelect: ["", "index"],
			isMax: true
		},
			
		// 图片管理
		"img-mgr": {
			script: "imgmgr/index",
			tpl: "scripts/biz/imgmgr/tpl/index.tpl",
			menuSelect: ["", "img_mgr"],
			isMax: true
		},
		// 图片查看
		"img-view": {
			script: "imgmgr/index",
			tpl: "scripts/biz/imgmgr/tpl/index.tpl",
			menuSelect: ["", "img_view"],
			isMax: true
		},
		
		// 用户权限管理-用户管理
		"auth-user": {
			script: "auth/usermgr/list",
			tpl: "scripts/biz/auth/usermgr/tpl/list.tpl",
			menuSelect: ["", "system_mgr"]
		},
		
		// 用户权限管理-角色管理
		"auth-role": {
			script: "auth/permmgr/list",
			tpl: "scripts/biz/auth/permmgr/tpl/list.tpl",
			menuSelect: ["", "system_mgr"]
		},
		
		// 数据字典-变电站
		"dics-transformer": {
			script: "dics/transformer/list",
			tpl: "scripts/biz/dics/transformer/tpl/list.tpl",
			menuSelect: ["transformer", "system_mgr"]
		},
		
		// 数据字典-设备类型
		"dics-devicetype": {
			script: "dics/devicetype/list",
			tpl: "scripts/biz/dics/devicetype/tpl/list.tpl",
			menuSelect: ["devicetype", "system_mgr"]
		},
		
		// 修改密码
		"user-pwdchange": {
			script: "auth/userinfo/alterpwd",
			tpl: "scripts/biz/auth/userinfo/tpl/alterpwd.tpl",
			isMax: true,
			menuSelect: ["", "pwd_edit"]
		},
		
		// 系统配置-系统参数
		"system-config-params": {
			script: "system/config/list",
			tpl: "scripts/biz/system/config/tpl/list.tpl",
			menuSelect: ["system_mgr_config_params", "system_mgr"]
		},
			
	};
	//页面元素
	var $menu = $("#main-menus");
	var $rightContent = $("#content>.right");
	
	//处理路由
	
	APP.R = {};
	var routerConfig = {routes: {}};
	var c = 0;
	_.map(customRouter, function(config, path){
		var tpl = config.tpl,
			script = config.script;
		var funName = "viewchange_" + c;
		c++;
		routerConfig.routes[path] = funName;
		routerConfig[funName] = function(){
			//页面参数
			APP.APP_VIEW_PARAMS = arguments;
			//设置左侧菜单的显示状态
			if(config.isMax){
				$menu.hide();
				$rightContent.addClass("right-max");
			}else{
				$menu.show();
				$rightContent.removeClass("right-max");
			}
			//切换导航以及菜单选中状态
			var menuSelect = config.menuSelect;
			if(menuSelect){
				mc.showMenuByUrl(menuSelect[0], menuSelect[1]);
			}
			//加载资源
			mc.change("" + tpl, !script ? null : "scripts/biz/" + script, function(){
				
			});
		};
	});
	
	//特殊地址，用于强制刷新当前页面地址
	routerConfig.routes["null"] = function(){};
	
	var CustomRoute = Backbone.Router.extend(routerConfig);
	
	var init = function(){
		APP.R = new CustomRoute();
		Backbone.history.start();
	};
	
	return {
		init : init
	};
});
			
