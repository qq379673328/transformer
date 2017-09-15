"use strict";
define(
		[ "jquery", "underscore" ],
		function($, _) {

	var INFO_ERR = "操作失败,服务器异常",
		INFO_SUCCESS = "操作成功",
		REQUEST_ERR = "0",
		REQUEST_SUCCESS = "1",
		REQUEST_UNAUTH = "401",// 未登录
		REQUEST_DENY = "403"// 无权限
		;

	/*
	 * 使用数据填充表单
	 */
	var renderForm = function($form, data) {
		if (!$form || $form.length == 0) {
			return;
		}
		$form[0].reset();
		if (data) {
			_.each(data, function(val, key) {
				$form.find("[name=" + key + "]").val(val).html(val);
			});
		}
	};
	/**
	 * 显示提示信息
	 */
	var showMessage = function(message) {
		$.messager.show({
			title : '信息',
			msg : message,
			timeout : 5000,
			showType : 'slide',
			style : {
				position : "fixed",
				bottom : "0px",
				right : "0px",
				left : "",
				top : ""
			}
		});
	};
	/**
	 * 弹出提示信息
	 */
	var alertMessage = function(message) {
		$.messager.alert('提示', message);
	};

	// 封装ajax请求
	function handleAjaxConfig(p) {
		return {
			success : function(data, status, xhr) {
				if (data && data.success == REQUEST_ERR) { // 请求失败
					alertMessage(data.msg || INFO_ERR);
					if (p.error) {
						p.error(data.msg);
					}
				} else if (data && data.success == REQUEST_SUCCESS) { // 请求成功
					if (p.type == 'post' || p.type == 'POST' || !p.noshowInfo) {
						showMessage(data.msg || INFO_SUCCESS);
					}
					if (p.success) {
						p.success(data.data, status, xhr);
					}
				} else if (data && data.success == REQUEST_UNAUTH) { // 未登录
					$.messager.alert('消息', '登录超时', 'info', function(){
						logout();
					});
				} else if (data && data.success == REQUEST_DENY) { // 无权限
					$.messager.alert('消息', '无权访问【用户已失效，请重新登录】', 'info', function(){
						logout();
					});
				}
			},
			error : function(xhr, status, thrown) {
				if (p.error) {
					p.error(INFO_ERR);
				}
				handleAjaxError(xhr, status, thrown);
			}
		};
	}
	// 处理ajax错误
	var reloadPageFlag = false;
	var handleAjaxError = function(xhr, status, thrown) {
		switch (parseInt(xhr.status)) {
		case 400:
			alertMessage("请求参数异常");
			break;
		case 401:
			$.messager.alert('消息', '未授权，请重新登录', 'info', function(){
				logout();
			});
			break;
		case 403:
			$.messager.alert('消息', '无权访问【用户已失效，请重新登录】', 'info', function(){
				logout();
			});
			break;
		case 409:
			$.messager.alert('消息', '未授权，请重新登录', 'info', function(){
				logout();
			});
			break;
		case 404:
			alertMessage("未知请求");
			break;
		case 405:
			showMessage(xhr.responseJSON.ex.message);
			break;
		case 500:
			alertMessage(INFO_ERR);
			break;
		case 0:
			alertMessage("无法连接服务器");
			break;
		case 200:
			if(xhr.responseText == 'This session has been expired (possibly due to multiple concurrent logins being attempted as the same user).'){
				$.messager.alert('消息', '账号在其它地方登陆，您已被踢出，请重新登录。', 'info', function(){
					logout();
				});
			}else{
				alertMessage("服务器异常");
			}
			break;
		default:
			// alertMessage("未知错误");
		}
	};

	// 处理ajax返回数据
	var handleAjaxResultData = function(data) {
		if (!data) {
			return data;
		} else {
			var dataSuccess = data.success;
			if (dataSuccess === REQUEST_SUCCESS) { // 成功
				return data.data;
			} else if (dataSuccess === REQUEST_ERR) { // 失败
				return;
			} else if (dataSuccess === REQUEST_UNAUTH) { // 未授权
				$.messager.alert('消息', '登录超时，请重新登录', 'info', function(){
					logout();
				});
				return;
			} else if (data && data.success == REQUEST_DENY) { // 无权限
				$.messager.alert('消息', '无权访问【用户已失效，请重新登录】', 'info', function(){
					logout();
				});
				return;
			}
		}
	};

	// 退出
	function logout() {
		window.location.href = "logout";
	}

	/**
	 * 发送ajax-用于查询,参数与$.ajax一致 params:{ noshowInfo:
	 * true|false,//查询成功后提示信息是否显示，true是不显示默人为false }
	 */
	var submitAjax = function(params) {
		if (params) {
			params.noshowInfo = params.noshowInfo === undefined ? true
					: params.noshowInfo;
			params.type = params.type || 'post';
		}
		var config = $.extend({
			dataType : "json",
			type : "post"
		}, params);
		$.ajax($.extend(config, handleAjaxConfig(params)));
	};

	// 转换数组为对象
	function convertArray(o) {
		var v = {};
		for ( var i in o) {
			var value = o[i].value;
			if (typeof (v[o[i].name]) == 'undefined') {
				v[o[i].name] = (value === '' || value === null) ? undefined
						: value;
			} else {
				v[o[i].name] += "," + value;
			}
		}
		return v;
	}

	/*
	 * 收集表单中数据为对象
	 */
	var getFormData = function($form) {
		if (!$form) {
			return {};
		}
		return convertArray($form.serializeArray());
	};

	// 在一个容器中显示加载状态
	var showLoading = function($tag) {
		$tag.html('<i class="my-loading fa fa-spinner fa-spin fa-2x fa-fw margin-bottom"></i>');
	};
	// 关闭容器中加载状态
	var closeLoading = function($tag) {
		$tag.find(".my-loading").remove();
	};

	// 滚动到表单中的某个元素
	var scrollToFormEl = function($el) {
		if (!$el || $el.length == 0) {
			return;
		}
		var $form = $el.parents("form");
		if ($form.data("isScrolling")) {
			return;
		}
		$form.data("isScrolling", true);
		$form.parents(".panel-body").animate({
			scrollTop : $el.position().top - $form.position().top
		}, 1000, null, function() {
			$form.data("isScrolling", false);
		});
	};

	/* 创建日期-yyyy-MM-dd格式数据创建日期类型日期 */
	var newDate = function(date) {
		if (!date) {
			return null;
		}
		var dateSp = date.split("-");
		return new Date(dateSp[0], parseInt(dateSp[1]) - 1, dateSp[2]);
	};
	/* 将日期类型的数据转成fmt的格式如:("yyyy-mm-dd") */
	Date.prototype.pattern = function(fmt) {
		var o = {
			"M+" : this.getMonth() + 1, // 月份
			"d+" : this.getDate(), // 日
			"h+" : this.getHours() % 12 == 0 ? 12
					: this.getHours() % 12, // 小时
			"H+" : this.getHours(), // 小时
			"m+" : this.getMinutes(), // 分
			"s+" : this.getSeconds(), // 秒
			"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
			"S" : this.getMilliseconds()
		// 毫秒
		};
		var week = {
			"0" : "/u65e5",
			"1" : "/u4e00",
			"2" : "/u4e8c",
			"3" : "/u4e09",
			"4" : "/u56db",
			"5" : "/u4e94",
			"6" : "/u516d"
		};
		if (/(y+)/.test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		}
		if (/(E+)/.test(fmt)) {
			fmt = fmt
					.replace(
							RegExp.$1,
							((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f"
									: "/u5468")
									: "")
									+ week[this.getDay() + ""]);
		}
		for ( var k in o) {
			if (new RegExp("(" + k + ")").test(fmt)) {
				fmt = fmt.replace(RegExp.$1,
						(RegExp.$1.length == 1) ? (o[k])
								: (("00" + o[k])
										.substr(("" + o[k]).length)));
			}
		}
		return fmt;
	}
	/* 格式化时间戳为yyyy-MM-dd HH:mm:ss */
	var transTimeStamp = function(timestamp, type) {
		type = type == 0 ? 0 : 1; // 0:date, 1:timestamp
		if (!timestamp) {
			return "";
		}
		var date = new Date(parseFloat(timestamp));
		if (type == 1) {
			return date.getFullYear() + "-"
					+ add0((date.getMonth() + 1)) + "-"
					+ add0(date.getDate()) + " "
					+ add0(date.getHours()) + ":"
					+ add0(date.getMinutes()) + ":"
					+ add0(date.getSeconds());
		} else {
			return date.getFullYear() + "-"
					+ add0((date.getMonth() + 1)) + "-"
					+ add0(date.getDate());
		}
	};

	function add0(n) {
		if (n < 10) {
			return "0" + n;
		} else {
			return n;
		}
	}

	/*
	 * 初始化一个可验证的表单 params:{ 
	 * 	$form: "form",//jquery form 对象 
	 * 	url: "",//提交地址 
	 * 	isJsonData: false,// 是否提交json格式数据，默认否 
	 * 	extvalid: function(){return true|false;},//扩展验证-需要返回true或者false 
	 * 	validSuccess: function(){},//验证成功回调函数 
	 * 	success: function(){},//表单提交成功回调函数
	 * }
	 */
	function SubmitForm(params) {
		var _this = this;
		_this.$form = params.$form;
		_this.params = params;
		var isJsonData = params.isJsonData;
		this.validate = function() {

			// 验证jquery easyui datebox
			var valid = true;
			// 扩展验证
			if (params.extvalid) {
				var extValid = params.extvalid(_this.$form);
				valid = valid && extValid;
			}

			// 使用jquery validate 验证
			return valid && _this.$form.form('validate');
		};

		_this.submit = function(submitCb) {
			if (_this.validate()) { // 验证
				// 验证成功回调函数
				if (params.validSuccess)
					params.validSuccess();
				// 提交
				if (!isJsonData) {
					_this.$form.ajaxSubmit($.extend({
						url : _this.params.url,
						type : "POST"
					}, handleAjaxConfig(params)));
				} else {
					var jsonItemsData = _this.$form.find(
							"input[name=extData]").val();
					if (jsonItemsData) {
						var formData = getFormData(_this.$form);
						submitAjax($.extend({
							url : _this.params.url,
							contentType : "application/json",
							data : JSON.stringify($.extend(formData,
									JSON.parse(jsonItemsData)))
						}, params));
					}
				}
			} else {
				scrollToFormEl($(_this.$form.find(".valid-error")[0]));
				// 验证失败回调函数
				if (params.validError)
					params.validError();
			}

		};
	}
	;

	/* 导出excel */
	var exportJsonExcel = function(data) {
		data = JSON.stringify(data);
		var $form = $("<form>").attr("method", "POST").attr("action",
				"exportSimpleTable").append(
				"<input type='hidden' name='tableJson' value='" + data
						+ "' />").append(
				"<input type='hidden' name='title' value='导出' />")
				.appendTo($("body"));
		$form.submit();
		$form.remove();
	};

	/*
	 * 获取easyui多行数据指定列值，拼接为字符串, 默认为“,”
	 * 
	 * @param rows 选择行-notnull @param field 列名-notnull @param spe
	 * 分隔符-默认为","
	 */
	var getSelectFields = function(rows, field, spe) {
		spe = spe || ",";
		var ids = "";
		var len = rows.length;
		for (var i = 0; i < len; i++) {
			ids += rows[i][field];
			if (i != len - 1) {
				ids += ",";
			}
		}
		return ids;
	};

	/**
	 * 导出form
	 * 
	 * @param $form
	 * @param url
	 *            导出地址
	 */
	var exportForm = function($form, url) {
		$form.clone().hide().appendTo("body").attr("method", "POST")
				.attr("action", url).submit().remove();
	};

	/**
	 * 切换地址
	 * 
	 * @url router中地址
	 * @data 传入新页面的数据
	 */
	var changeUrl = function(url, data) {
		APP.APP_PREPAGE_PARAMS = data;
		APP.APP_PREPAGE_PARAMS_FLAG = true;
		if (url) {
			APP.R.navigate(url, {
				trigger : true
			});
		}
	};
	
	// 打印指定区域
	var printZone = function(html){
		var newWin = window.open();
		newWin.document.open();
		// 自定义样式
		newWin.document.write(
		"<style>" +
			"table{width: 100%;border-collapse: collapse;}" +
			"h3{text-align: center;}" +
			".edit-list-data {border-top:1px solid; border-left: 1px solid;}" +
			".edit-list-data td,.edit-list-data th{border-right:1px solid; border-bottom: 1px solid; text-align: center;}" +
			".print-time{position: absolute; left: 10px; top: 10px;}" +
		"</style>");
		// 打印时间
		var cd = new Date();
		var printTime = cd.getFullYear() + "/" + cd.getMonth() + "/" + cd.getDate()
			 + " " + cd.getHours() + ":" + cd.getMinutes() + ":" + cd.getSeconds();
		var printTimeHtml = "<div class='print-time'>打印时间：" + printTime + "</div>"
		newWin.document.write(printTimeHtml + html);
		newWin.document.close();
		newWin.location.reload();
		newWin.focus();
		newWin.print();
		newWin.close();
	};
	
	//验证批量删除
	var verifyDelAll = function(rows){
		var i = 0;
		for(i;i<rows.length;i++){
			if(rows[i].auditSate == '未审核' || rows[i].auditSate == '01'){
			}else{
				alertMessage("只能删除未审核数据！");
				return false;
			}
		}
		return true;
	}
	
	// 从浏览器地址栏获取参数，如：http://ip:port/a/b/#p1=2
	// getQueryString('p1') --- 2
	function getQueryString(name) {
		var reg = new RegExp("(^|&|\\?)" + name + "=([^&]*)(&|$)");
		var r = window.location.hash.match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}
	
	//判断用户是否具有功能点权限
	var permissions = null;
	var hasPermission = function(id) {
		if (permissions == null) {
			submitAjax({
				url: "api/system/user/getMyPermissions",
				type: "get",
				async: false,
				success: function(data) {
					permissions = !data ? [] : data;
					var temp = {};
					for (var i in permissions) {
						temp[permissions[i].mfKey] = true;
					}
					permissions = temp;
				}
			});
		}
		return !permissions[id] ? false : true;
	};
	
	return {
		changeUrl : changeUrl,// 跳转url
		getQueryString: getQueryString,//从浏览器地址栏获取参数
		hasPermission: hasPermission, //是否有权限

		submitAjax : submitAjax,// ajax请求
		handleAjaxResultData : handleAjaxResultData,// 处理ajax请求结果
		handleAjaxError : handleAjaxError,// 处理ajax错误结果

		showMessage : showMessage,// 显示消息
		alertMessage : alertMessage,// 提示消息

		SubmitForm : SubmitForm,// 构造提交表单
		renderForm : renderForm,// 使用数据填充表单
		exportForm : exportForm,// 导出excel表单
		getFormData : getFormData,// 获取表单数据
		exportJsonExcel : exportJsonExcel,// 导出json格式excel数据
		getSelectFields : getSelectFields,// 获取easyui datagrid选择的字段列

		convertArray : convertArray,// 转换为数组
		scrollToFormEl : scrollToFormEl,// 滚动到元素

		showLoading : showLoading,// 显示加载提示
		closeLoading : closeLoading,// 隐藏加载提示

		transTimeStamp : transTimeStamp,// 转换时间戳
		newDate : newDate,// 创建新日期
		
		printZone: printZone,// 打印指定区域
		verifyDelAll:verifyDelAll,//批量删除验证
		
		// grid行无效公共样式
		rowStyleDisable: 'background-color: #b1b1b1;color: #fff;'
		
	};
});