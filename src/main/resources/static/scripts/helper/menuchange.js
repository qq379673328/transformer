/*
 * 左侧菜单切换
 */
define(["jquery", "core", "tplengine", "backbone"], function($, core, tplengine, bb){
	
	var change = function(tplpath, jspath, cb){
		//重置页面变量
		APP.P = {};
		//销毁easyui生成的多余标签-main之外所有
		clear();
		//清空主内容
		var $content = $("#main-content");
		//$content.html('<i class="fa fa-spinner fa-spin fa-3x fa-fw margin-bottom"></i>');
		//判断是同步页面还是模版页面:同步页面jspath为空
		if(!jspath){//同步页面
			var $iframe = $("<iframe id='page-iframe' scrolling=no height=400 frameborder=0 width=100%>")
				.attr("src", tplpath);
			$content.html($iframe);
			resetPageChangeParams();
			if(cb) cb();
		}else{//模版文件
			$.ajax({
				url: tplpath,
				success: function(tpl){//加载模板
					//编译模版
					tpl = _.template(tpl)({data: APP.APP_PREPAGE_PARAMS || {}});
					//处理权限
					tpl = tplengine.handleHtmlPermission(tpl);
					//渲染模版
					$content.html(tpl);
					tplengine.handleHtml($content);
					//卸载当前js
					if(window.__curentMenu){
						requirejs.undef(window.__curentMenu);
					}
					if(cb) cb();
					//加载js
					window.__curentMenu = jspath;
					require([jspath], null, function(err){
						console.error(err.stack);
						var errinfo = "";
						for(var idx in err.requireModules){
							errinfo += err.requireModules[idx] + ",";
						}
						//alert("模块加载失败-menuchange[" + errinfo + "]");
					});
					
					resetPageChangeParams();
					
				},
				error: function(){
					alert("模板加载失败");
				}
			});
		}
		
	};
	//重置页面跳转参数
	function resetPageChangeParams(){
		//通过js跳转页面,传入的参数只能生效一次,重新跳转之后失效
		/*if(APP.APP_PREPAGE_PARAMS_FLAG){
			APP.APP_PREPAGE_PARAMS_FLAG = false;
			APP.APP_PREPAGE_PARAMS = undefined;
		}*/
	}
	
	//清空非main内容
	var clear = function(){
		$("body>div").not("#header,#content").remove();
	};
	
	/**
	 * 页面菜单相关
	 */
	var $menus = $("#main-menus"),//左侧菜单
		$navigation = $("#main-navigation"),//顶部导航
		$content = $("#main-content"),//页面主体
		$location1 = $("#location-1"),//位置1
		$location2 = $("#location-2"),//位置2
		$location3 = $("#location-3")//位置3
		;
	var menusMap = {},
		menusDesc = {},
		rootMenuId = ""
		;
	//生成左侧菜单树
	function loadMenus(cb){
		core.submitAjax({
			url: "api/base/getMyMenus",
			method: "get",
			success: function(data){
				
				rootMenuId = data.mfVO.mfId;
				handleNode(data, null, 1);
				//为页面左侧菜单以及右侧主要内容设置高度,否则无法正常出现滚动条
				var height = $(window).height() - $(".top").height() - 20 - 30;
				//$menus.css({height: height});
				//$content.css({height: height - 40});
				
				var root = menusMap[rootMenuId];
				for(var i = 0; i < root.length; i++){
					//创建导航
					createOneNav(root[i]);
					//默认加载第一个左侧菜单
					if(i == 0){
						var first = root[i];
						loadLeftMenu(first.children, false, first);
					}
				}
				// 首页
				$navigation.prepend($(
				'<li class="navli">' +
					'<a class="item logout" href="#">' +
						'<i class="fa fa-4x fa-home"></i><br/>' +
						'<span>首页</span>' +
					'</a>' +
				'</li>').data('item', {mfVO: {mfId: 'index'}}))
				;
				
				if(cb) cb(root[0]);
			}
		});
	}
	function handleNode(node, parNode, level){
		var children = node.children;
		menusDesc[node.mfId] = node.mfDesc;
		if(parNode){
			var pitem = parNode.mfVO;
			if(!menusMap[pitem["mfId"]]){
				menusMap[pitem["mfId"]] = [node];
			}else{
				menusMap[pitem["mfId"]].push(node);
			}
		}
		node["mfLevel"] = level;
		if(children){
			for(var i in children){
				var newLevel = level + 1;
				handleNode(children[i], node, newLevel);
			}
		}
	}
	//创建导航
	//顶部导航配置
	var DEFAULT_IMG = "image/default-menu.png";
	var DEFAULT_LIWIDTH = "li-150";
	var NAV_CONFIG = {
		img_mgr: {img: "fa-magic"},
		img_view: {img: "fa-eye"},
		system_mgr: {img: "fa-cog"}
	};
	
	function createOneNav(mf){
		var item = mf.mfVO;
		//图片
		var imgSrc = NAV_CONFIG[item.mfId] ? NAV_CONFIG[item.mfId].img : DEFAULT_IMG;
		//链接地址
		var link = item.mfLink;
		
		var liContent = $("<a href='javascript: void(0);'>"
				+ "<i class='fa fa-4x " + imgSrc + "'></i><br/>"
				//+ "<img src='" + imgSrc + "' width='60' height='55' /><br/>"
				+ item.mfName
				+ "</a>");
		
		var $li = $("<li class='navli'>")
			.append(liContent)
			.data("item", mf);
		$navigation.append($li);
		if(!link){//非链接加载左侧菜单
			$li.click(function(){
				//为导航添加样式
				var $lisNav = $navigation.find("li");
				$lisNav.removeClass("selected");
				$(this).addClass("selected");
				$location1.html(mf.mfVO.mfName);
				//置空菜单以及内容区域
				clear();
				$menus.empty();
				$content.empty();
				
				APP.LASTNAV = item.mfId;
				loadLeftMenu(mf.children, true, item);
			});
		}else{//链接
			liContent.attr("href", link);
		}
		//文字宽度
		var liWidthCls = NAV_CONFIG[item.mfId] ? NAV_CONFIG[item.mfId].liWidthCls : DEFAULT_LIWIDTH;
		if(liWidthCls){
			$li.addClass(liWidthCls);
		}else{
			$li.addClass("li-95");
		}
	}
	//加载左侧菜单
	function loadLeftMenu(children, isClickNav, item){
		$menus.html("");
		if(children){
			$menus.show();
			var desc = item.mfName ? item.mfName : item.mfVO.mfName;
			var $title = $("<div class='title'>" + desc + "</div>");
			if($menus.find(".title").size() == 0){
				$title.addClass("title-bold");
				$menus.append($title);
				$menus.append("<div class='line'></div>");
			}else{
				$title.addClass("title-lv2");
				$menus.append($title);
			}
			var $ul = $("<ul class='tab'>").appendTo($menus);
			for(var j = 0; j < children.length; j++){
				createOneLevelMenu(children[j], $ul, true);
			}
			//自动切换到第一个可跳转页面
			var $as = $menus.find("a");
			if(isClickNav && $as && $as.length > 0){
				//切换到特殊地址-否则若地址无变化,则无法触发路由事件
				//APP.R.navigate("#null", {trigger: true});
				//切换地址
				var href = $($as[0]).attr("href");
				if(/^index#.*/.test(href)){
					href = href.substr(5);
				}
				//若地址无变化则重新加载页面(处理点击导航地址没有变化的时候不加载内容的bug的)
				if(href==="#"+Backbone.history.getHash()){
					window.location.reload();
				}else{
					APP.R.navigate(href, {trigger: true});
				}
				
				return;
			}
		}
	}
	
	//处理单级菜单
	function createOneLevelMenu(menu, $ul, isroot){
		var children = menu.children;
		var hasChildren = (children && children.length > 0) ? true : false;
		var mfLink = menu.mfVO.mfLink,
			mfName = menu.mfVO.mfName;
		var $li = $("<li>");
		//子菜单
		if((children && children.length > 0) || !menu.mfVO.mfLink){
			if(menu.mfLevel == "3"){//特定级别菜单才显示
				$li = $("<div class='title title-lv2'></div>");
			}else{
				$li = $("<div class='title'></div>");
			}
		}
		$li.data("menu", menu)
			.data("haschildren", hasChildren)
			.appendTo($ul);
		//是否为链接
		if(mfLink){
			$li.append("<a href='index" + mfLink + "'>" + getNTab(menu.mfLevel - 1) + mfName + "</a>");
		}else{
			$li.append(getNTab(menu.mfLevel - 1) + mfName);
		}
		if(!isroot){
		}
		/*$li.click(function(){
			var haschildren = $(this).data("haschildren");
			if(haschildren){
				if($(this).data("showChild")){
					$(this).next().find("ul, li").hide().data("showChild", false);
					$(this).next().hide();
					$(this).data("showChild", false);
				}else{
					$(this).next().find(">li").show();
					$(this).next().show();
					$(this).data("showChild", true);
				}
			}
		});*/
		if(children && children.length > 0){
			var $ul = $("<ul/>");
			$li.after($ul);
			for(var i = 0; i < children.length; i++){
				createOneLevelMenu(children[i], $ul, false);
			}
		}
	}
	//根据路由地址切换菜单的显示
	function showMenuByUrl(menuMFId, navMFId){
		if(navMFId == 'pwd_edit'){
			$("#menu-li-pwdedit").addClass('selected');
		}else{
			$("#menu-li-pwdedit").removeClass('selected');
		}
		
		$location1.html("");
		$location2.html("");
		$location3.html("");
		//顶部导航
		var $lisNav = $navigation.find("li");
		$lisNav.removeClass("selected");
		$lisNav.each(function(idx, el){
			var $li = $(el);
			var item = $li.data("item");
			if(item && item.mfVO.mfId == navMFId){
				$li.addClass("selected");
				$location1.html(item.mfVO.mfName);
				//加载左侧菜单
				loadLeftMenu(item.children, false, item);
				return false;
			}
		});
		//处理左侧菜单
		var $lis = $menus.find("li");
		$lis.find("a").removeClass("selected");
		$lis.each(function(idx, el){
			var $li = $(el);
			var item = $li.data("menu");
			if(item.mfVO.mfId == menuMFId){
				$li.show().find("a").addClass("selected");
				$li.siblings().show();
				$location2.html("<span>&gt;</span>");
				$location3.html(item.mfVO.mfName);
				showParent($li);
				return false;
			}
		});
	}
	function showParent($li){
		var $par = $li.parent();
		var tagName = $par[0].tagName;
		if(tagName == "ul" || tagName == "UL"){
			$par.prev().data("showChild", true).show();
			$par.siblings().show();
			showParent($par);
		}else if(tagName == "li" || tagName == "li"){
			$par.show();
			showParent($par);
		}
	}
	function getNTab(n){
		return "";
		var ret = "";
		n--;
		n--;
		for(var i = 0; i < n; i++){
			ret += "&nbsp;&nbsp;";
		}
		return ret;
	}
	
	/**
	 * 重新设置iframe的高度
	 */
	function reinitIframe(){
	$("iframe").each(function(idx, iframe){
		if($(iframe).is(":visible") == true){
			try{
				var bHeight = iframe.contentWindow.document.body.scrollHeight,
				dHeight = iframe.contentWindow.document.documentElement.scrollHeight,
				height = Math.max(bHeight, dHeight);
				iframe.height =  height;
			}catch (ex){}
		}
	});
	}
	window.setInterval(reinitIframe, 500);
	
	return {
		change: change,
		clear: clear,
		showMenuByUrl: showMenuByUrl,
		loadMenus: loadMenus,
		loadLeftMenu: loadLeftMenu
	};
});
