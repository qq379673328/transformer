//全局变量
var APP = {
	// 全局页面参数-从路由地址中获取的参数
	APP_VIEW_PARAMS : [],
	// 路由对象
	R : {},
	// 页面对象
	P : {}
};

/*
 * 应用入口
 */
requirejs.config({
	enforceDefine: true,
	baseUrl: '.',
	paths: {
		jquery: "scripts/libs/jquery-1.11.1.min",
		underscore: "scripts/libs/underscore-1.8.3.min",
		backbone: "scripts/libs/backbone-1.3.3.min",
		easyui: "scripts/libs/jquery-easyui-1.4/jquery.easyui.min",
		"jquery.form": "scripts/libs/jquery.form",
		json2: "scripts/libs/json2",
	
		// 公共
		router: "scripts/router",
		core: "scripts/helper/core",
		tplengine: "scripts/helper/tplengine",
		mc: "scripts/helper/menuchange",
		simpleupload: "scripts/helper/fileupload/simpleupload",
		"jquery.ui.widget": "scripts/libs/jquery-upload/jquery.ui.widget",
		fileupload:"scripts/libs/jquery-upload/jquery.fileupload",
		transport: "scripts/libs/jquery-upload/jquery.iframe-transport",
		
		// 业务
		selectDeviceType: "scripts/biz/common/select_devicetype"
	
	},
	shim : {
		easyui: {deps : ["jquery"]},
		backbone: {deps : ["underscore"]},
		"jquery.form": {deps : ["jquery"]}
	}
});

define([ "jquery", "core", "router", "mc"],
	function($, core, router, mc) {
	
		// ajax不缓存
		$.ajaxSetup({cache:false});
		
		// 必填项国际化
		var NOTNULL_DESC = '该输入项为必输项';
		$.fn.numberbox.defaults.missingMessage = NOTNULL_DESC;
		$.fn.combobox.defaults.missingMessage = NOTNULL_DESC;
		$.fn.combotree.defaults.missingMessage = NOTNULL_DESC;
		$.fn.combogrid.defaults.missingMessage = NOTNULL_DESC;
		$.fn.textbox.defaults.missingMessage = NOTNULL_DESC;
		
		// 自定义easyui的验证
		$.extend($.fn.validatebox.defaults.rules, {
			minLength : {// 最小长度
				validator : function(value, param) {
					return value.length >= param[0];
				},
				message : '输入内容长度必须大于 {0}'
			},
			maxLength : {// 最大长度
				validator : function(value, param) {
					return value.length <= param[0];
				},
				message : '输入内容长度必须小于 {0}'
			},
			digits: {// 整数
				validator : function(value) {
					return !isNaN(value) && value%1 === 0;
				},
				message : '输入内容必须为整数'
			},
			number: {// 数字
				validator : function(value) {
					return !isNaN(value);
				},
				message : '输入内容必须为数字'
			},
			price: {// 金额
				validator : function(value) {
					return  /(^[1-9]\d*(\.\d{1,2})?$)|(^[0]{1}(\.\d{1,2})?$)/.test(value);
				},
				message : '金额不能小于零且最多包含两位小数'
			},
			idcard: {// 身份证号
				validator : function(value) {
					return /^(\d{14}|\d{17})(\d|[xX])$/.test(value);
				},
				message : '身份证号格式错误'
			},
			multipleTo: {// 倍数
				validator: function (value, param) {
					return value % $(param[0]).val()<=1;
				},
				message: '被合并数量必须是合并数量的倍数'
			},
			phone: {//手机号码
				validator: function (value, param) {
					return /^(?:13\d|15\d|18\d)-?\d{5}(\d{3}|\*{3})$/.test(value);
				},
				message: '手机号码输入不正确！'
			},
			compareTo: {// 比较
				validator: function (value, param) {
					return value<=$(param[0]).val();
				},
				message: '合并数量不能大于库存数量'
			},
			equalTo: {// 是否相等
				validator: function (value, param) { 
					return $(param[0]).val() == value; 
				}, message: '内容不一致'
			},
			compartTime:{//比较日期前后
				validator: function (value, param) {
					return $(param[0]).datetimebox('getValue')<value;
				},
				message: '结束日期必须大于起始日期'
			},
			todayLte:{// 小于等于今天
				validator: function (value, param) {
					return value ? !(value > formatDate(new Date())) : true;
				},
				message: '日期不能大于今天'
			},
			todayGte:{// 大于等于今天
				validator: function (value, param) {
					return value ? !(value < formatDate(new Date())) : true;
				},
				message: '日期不能小于今天'
			}
		});

		// 配置全局ajax
		$.ajaxSetup({
			error : function(jqXHR, textStatus, errorThrown) {
				core.handleAjaxError(jqXHR, textStatus, errorThrown);
			}
		});

		/**
		 * 页面菜单相关
		 */
		var $menus = $("#main-menus"),//左侧菜单
			$navigation = $("#main-navigation"),//顶部导航
			$content = $("#page-main-content"),//页面主体
			$location1 = $("#location-1"),//位置1
			$location2 = $("#location-2"),//位置2
			$location3 = $("#location-3")//位置3
			;
		// 初始化菜单
		mc.loadMenus(function(mf){
			/*初始化应用路由*/
			router.init();
			
			//若没有导航和菜单被选中,默认跳转第一个导航,第一个菜单
			/*var $selectMenu = $menus.find(".selected");
			var $selectNav = $navigation.find(".selected");
			if($selectMenu.size() == 0 && $selectNav.size() == 0){
				var toUrl = "";
				//判断第一个导航是否为链接
				var dataItem = $navigation.find("li:first").data("item");
				var firNavLink = dataItem ? dataItem.mfVO.mfLink : null;
				if(firNavLink){
					toUrl = firNavLink;
				}else{
					toUrl = $menus.find("li:first a").attr("href");
				}
				//切换地址
				APP.R.navigate(toUrl, {trigger: true});
				//为导航添加样式
				var $content = $("#main-content");//页面主体
				var $lisNav = $navigation.find("li");
					$lisNav.removeClass("selected");
//				$(this).addClass("selected");
				$("#location-1").html($("#main-menus").find("li:first a").text());
				//置空菜单以及内容区域
				mc.clear();
				$menus.empty();
				$content.empty();
				var item = mf.mfVO;
				APP.LASTNAV = item.mfId;
				mc.loadLeftMenu(mf.children, true, item);
				return;
			}*/

		});

		//日期框格式化
		$.fn.datebox.defaults.formatter = function(date){
			return formatDate(date);
		}
		function formatDate(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1<10?'0'+(date.getMonth()+1):date.getMonth()+1;
			var d = date.getDate()<10?'0'+date.getDate():date.getDate();
			return y+'-'+m+'-'+d;
		}
		//日期框当前日期
		$.fn.datebox.defaults.parser = function(s){
			var t = Date.parse(s);
			if (!isNaN(t)){
				return new Date(t);
			} else {
				return new Date();
			}
		}
		
		// 覆盖easyui datagrid
		$.fn.datagrid.defaults.onLoadError = function(xhr, status, err) {// 默认
			core.handleAjaxError(xhr, status, err);
		};
		
		$.fn.datagrid.defaults.cache = false;// 禁止缓存
		$.fn.datagrid.defaults.modal = false;// 非模态
		$.fn.datagrid.defaults.title = "查询结果";// 默认 title
		$.fn.datagrid.defaults.fitColumns = true;// 表格默认铺满
		$.fn.datagrid.defaults.autoRowHeight = true;//自动行高
		$.fn.datagrid.defaults.nowrap = false;//是否换行
		$.fn.datagrid.defaults.scrollbarSize = 0;// 滚动条大小
		//$.fn.datagrid.defaults.pageSize = 10;// 分页大小
		//$.fn.datagrid.defaults.pageList = [ 10, 20, 50, 100 ];// 分页组
		$.fn.datagrid.defaults.method = "GET";// 请求方式
		$.fn.datagrid.defaults.rownumbers = true;// 是否显示行号
		$.fn.datagrid.defaults.singleSelect = true;// 默认单行选择
		$.fn.datagrid.defaults.pagination = true;// 是否显示分页
		$.fn.datagrid.defaults.striped = true;// 是否显示条纹
		$.fn.datagrid.defaults.noheader = true;// 是否显示header
		$.fn.datagrid.defaults.checkOnSelect = false;// 用户点击行的时候复选框是否会选中
		$.fn.datagrid.defaults.selectOnCheck = false;
		// 调整服务端默认返回格式
		$.fn.datagrid.defaults.loadFilter = function(data) {
			return core.handleAjaxResultData(data);
		};
		$.fn.datebox.defaults.width = 100;
		$.fn.datebox.defaults.height = 27;
		$.fn.combo.defaults.height = 27;
		$.fn.combo.defaults.editable = false;
		$.fn.combobox.defaults.height = 27;
		$.fn.combobox.defaults.editable = false;
		$.fn.combotree.defaults.height = 27;
		$.fn.textbox.defaults.height = 27;
		
		/*
		 * $.fn.datagrid.defaults.onRowContextMenu = function(e){//阻止默认右键
		 * //阻止默认右键菜单 e.preventDefault(); };
		 */

		// 动态设置部分页面区域宽高
		var windowWidth = $(window).width(),
			windowHeight = $(window).height(),
			topHeight = $('.app>.page-top').height(),
			bottomHeight = $('.app>.page-bottom').height(),
			leftWidth = $('.app>.page-left').width(),
			navHeight = $('#page-main-nav').height();
		
		// 动态设置表格列数
		var pageSize = 10;
		if(windowHeight <= 768){
			pageSize = 10;
		}else if(windowHeight <= 900){
			pageSize = 12;
		}else if(windowHeight <= 1080){
			pageSize = 15;
		}else if(windowHeight <= 1200){
			pageSize = 18;
		}else if(windowHeight <= 1600){
			pageSize = 28;
		}
		$.fn.datagrid.defaults.pageSize = pageSize;// 分页大小

		// 覆盖easyui 弹出框
		$.fn.dialog.defaults.title = "";// 标题
		$.fn.dialog.defaults.border = true;// 是否显示border
		$.fn.dialog.defaults.shadow = true;// 是否显示阴影
		$.fn.dialog.defaults.closable = true;// 是否可关闭
		$.fn.dialog.defaults.maximizable = true;// 是否可最大化
		$.fn.dialog.defaults.modal = true;// 是否为模态
		$.fn.dialog.defaults.draggable = true;// 是否可拖动
		$.fn.dialog.defaults.resizable = true;// 是否可调整大小
		//$.fn.dialog.defaults.width = 700;// 宽度
		//$.fn.dialog.defaults.height = 400;// 高度
		// $.fn.dialog.defaults.top = $(".top").height() + 20;//距离顶部高度
		// $.fn.dialog.defaults.left = 241;//距离左侧距离
		
		$.fn.pagination.defaults.layout = ['first', 'prev', 'links', 'next', 'last'];
		$.fn.pagination.defaults.links = 10;
		$.fn.pagination.defaults.showPageList = false;

		// 覆盖easyui 默认 pagination - 增加导出excel按钮
		$.fn.datagrid.defaults.onLoadSuccess = function(params) {
			var curExpRows = params.rows,
				curExpCols = $(this).datagrid("options").columns;
			// 增加标签
			var $panel = $(this).datagrid("getPanel");
			$panel.parent().find(".datagrid-topext").remove();
			var $topext = $("<div class='datagrid-topext'>").prependTo($panel.parent());
			// 导出excel按钮
			var $expExcelBtn = $('<span class="btn btn-small btn-white"><i class="fa fa-file-excel-o"></i>&nbsp;导出本页</span>')
				.click(function() {
				var data = [];
				
				// 表头
				for (var i in curExpCols) {
					var curExpColIns = curExpCols[i];
					var rowHead = [];
					for(var j in curExpColIns){
						var curCol = curExpColIns[j];
						if (!curCol.title
							|| curCol.title == "操作"
							|| curCol.hidden == true
							) {
							continue;
						} else {
							rowHead.push({
								cols : curCol.colspan || '1',
								rows : curCol.rowspan || '1',
								val: curCol.title
							});
						}
					}
					data.push(rowHead);
				}
				
				// 数据项
				$panel.find(".datagrid-view2 .datagrid-btable tr").each(function(){
					var $tr = $(this);
					var rowData = [];
					$tr.find("td").each(function(){
						var $td = $(this);
						if($td.is(':hidden')
							|| $td.attr("field") == 'ck'
							|| $td.attr("field") == 'HD'){
							return true;
						}
						rowData.push({cols : 1, rows : 1, val : handleExpVal($td.find(".datagrid-cell").html())});
					});
					data.push(rowData);
				});
				
				core.exportJsonExcel(data);
			});
			var title = $(this).datagrid("options").title||"查询结果";
			// 不显示title
			title = '';
			$topext.append("<span>"+title+"</span>").append($expExcelBtn);
		};
		// 处理datagrid导出的值-操作列等
		function handleExpVal(val) {
			if (val && (/<a/.test(val) || /<i/.test(val))) {
				return "";
			} else {
				return val;
			}
		}
		
		// 处理首页页面元素的权限信息
		(function() {
			$("[permission]").each(function() {
				if (!core.hasPermission($(this).attr("permission"))) {
					$(this).remove();
				}
			});
		})();
		
		// 格式化float：如：Math.formatFloat(1.2323, 2) => 1.23
		Math.formatFloat = function(f, digit){
			if(f === undefined || f == null) return f;
			return new Number(f).toFixed(digit);
			/*var m = Math.pow(10, digit);
			return parseInt(f * m, 10)/m;*/
		} 

	}, function(err) {
		var errinfo = "";
		for ( var idx in err.requireModules) {
			errinfo += err.requireModules[idx] + ",";
		}
		alert(errinfo + " 资源加载失败");
	});
