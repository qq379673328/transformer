"use strict";
/**
 * 工具包
 */
define(["jquery", "underscore", "json2", "core", 
        "selectDeviceType",
	"easyui", "jquery.form"
	],
	function($, _, JSON, core, selectDeviceType) {

	//数据码表页面缓存
	var typeCodesCache = {},
		orgCache = null,
		streetCache = null;

	//初始化编码表缓存
	var initCodeCache = function(type) { //type="com.sex|test"
		if (!type) {
		return;
		}
		core.submitAjax({
		url: "api/base/getInitCodes",
		type: "GET",
		async: false,
		data: {
			type: type
		},
		success: function(data) {
			for (var i = 0; i < data.length; i++) {
			if (data[i].length > 0) {
				typeCodesCache[data[i][0].codeType] = data[i];
			}
			}
		}
		});
	};

	//获取某种类型码
	function getTypeCodes(type) {
		var codes = [];
		if (typeCodesCache[type]) { //缓存中存在
			return typeCodesCache[type];
		}
		core.submitAjax({
			url: "api/base/getTypeCodes",
			type: "GET",
			async: false,
			data: {
				type: type
			},
			success: function(data) {
				codes = data;
				typeCodesCache[type] = data;
			}
		});
		return codes;
	}

	/**
	 * 往容器中加载模版
		params = {
		$div: "",//jquery div 容器
		data: {},//模板数据
		tpl: "",//模板路径-tpl与tpldata二选一
		tpldata: "",//模版内容-页面内模版，优先级高于tpl
		beforeHandle: "",//模版解析之前处理
		success: function(){},//加载成功回调
		error: function(){},//加载失败回调
		}
	 */
	var renderTpl = function(params) {
		if (!params.$div) {
			return;
		}
		var $div = params.$div;
		//清空
		//$div.html('<i class="fa fa-spinner fa-spin fa-3x fa-fw margin-bottom"></i>');
		var tpl = null;
		if (params.tpldata) {
			tpl = params.tpldata;
		if (params.success) {
			params.success(tpl);
		}
		if (params.error) {
			params.error();
		}
		} else {
			//获取模板
			$.ajax({
				url: params.tpl,
				cache: true,
				success: function(tpldata) {
					tpl = tpldata;
					if (params.beforeHandle) {
						var ret = params.beforeHandle(tpl);
						if (ret) tpl = ret;
					}
					var html = _.template(tpl)({
						data: params.data ? params.data : {}
					});
					html = handleHtmlPermission(html);
					$div.html(html);
					handleHtml($div);
					
					// 重新渲染jquery-easyui
					$.parser.parse($div);
					
					if (params.success) {
						params.success($(html));
					}
				},
				error: function() {
				core.alertMessage("模板加载失败");
					if (params.error) {
						params.error();
					}
				}
			});
		}
	};

	//处理html中的权限-无权限就隐藏
	var handleHtmlPermission = function(html) {
		var $html = $(html);
		$html.filter("[permission]").each(function() {
			if (!core.hasPermission($(this).attr("permission"))) {
				$(this).remove();
			}
		});
		$html.find("[permission]").each(function() {
			if (!core.hasPermission($(this).attr("permission"))) {
				$(this).remove();
			}
		});
		return $html;
	};

	//创建下拉框
	var createCodeSelect = function(params) {
		var $tag = params.$tag, //标签
			codetype = params.codetype; //字典类型码
		var items = [{codeValue:'', codeDesc: '全部'}];
		items = items.concat(getTypeCodes(codetype));
		$tag.combobox({
			data: items,
			valueField: 'codeValue',
			textField: 'codeDesc',
			value: $tag.val(),
			required: params.required,
			editable:false
		});
	};

	//创建radio
	var createCodeRadio = function(params) {
		var $tag = params.$tag, //标签
			name = params.name, //name
			value = params.value, //默认值
			codetype = params.codetype; //字典类型码

		// 默认不限radio
		if (params.allText) {
		var allTextRadio = $("<input type='radio' />")
			.attr("name", name)
			.attr("value", '');
		if (value === undefined) {
			allTextRadio.attr("checked", "checked");
		}
		var $label = $("<label class='radio-label' />").append(allTextRadio).append("<i></i>").append(params.allText);
			$tag.append($label);
		}

		var data = getTypeCodes(codetype);
		for (var idx in data) {
			var item = data[idx];
			var $radio = $("<input type='radio' />")
				.attr("name", name)
				.attr("value", item["codeValue"]);
			if (item["codeValue"] == value) {
				$radio.attr("checked", "checked");
			}
			var $label = $("<label class='radio-label' />")
				.append($radio)
				.append(item["codeDesc"])
				;
			$tag.append($label);
		}
		//没有传值的话,默认选择第一个-废弃
		/*if(value === undefined || value == null){
		$tag.find("input:radio:first").attr("checked", "checked");
		}*/
		if (params.other) { //其他
			$tag.find("input:radio").click(function() { //移除其它
				$tag.find(".input-other").remove();
			});
			var $other = $("<input type='radio' />")
				.attr("name", name)
				.click(function() {
				if ($(this).is(':checked')) { //选中
					$tag.find("input:text").remove(); //删除多次点击其他生成的输入框
					$(this).after("<input class='input-other' type='text' name='" + params.other + "' />");
	
				}
				});
			if (params.otherValue) { //修改页面中给选择其他赋值
				if (!$tag.find("input:radio").attr('checked')) { //在有其他默认值得情况中如果都不选则给其他赋值
					$other.attr("checked", "checked");
					var otherInupt = $("<input class='input-other' type='text' name='" + params.other + "' value='" + params.otherValue + "' />");
					$("<span class='input-other'>").append("其他").append($other).append(otherInupt).appendTo($tag);
				}
	
			} else {
				$("<span class='input-other'>").append("其他").append($other).appendTo($tag);
			}
		}

		//单选框值触发指定容器显示
		if (params.targetIds) {
		var targetIds = params.targetIds,
			targetValue = params.targetValue;
		$tag.find("input:radio").each(function(idx, el) { //移除其它
			var elValue = $(el).val();
				//点击值触发显示隐藏
				if (targetValue.indexOf(elValue) != -1) {
				$(el).click(function() {
					$(targetIds).show();
				});
			} else {
				$(el).click(function() {
					$(targetIds).hide();
					$(targetIds).find("input").val(null);
					$(targetIds).find("textarea").val(null);
					$(targetIds).find("select").val(null);
					$(targetIds).find("input:radio").attr("checked", null);
					$(targetIds).find("input:checkbox").attr("checked", null);
					//隐藏出发对象的子触发对象
					$(targetIds).each(function(tidx, tel) {
					var $telDiv = $(tel).find(".spe-tag");
					if ($telDiv && $telDiv.data("spe") && $telDiv.data("spe")["targetIds"]) {
						var $tarEl = $($telDiv.data("spe")["targetIds"]);
						$tarEl.hide();
						$tarEl.find("input").val(null);
						$tarEl.find("textarea").val(null);
						$tarEl.find("select").val(null);
						$tarEl.find("input:radio").attr("checked", null);
						$tarEl.find("input:checkbox").attr("checked", null);
					}
					});
				});
			}
			//当前实际值决定是否显示
			if (targetValue.indexOf(value) != -1 
					&& (value != "" && value != null && value != undefined)) {
				$(targetIds).show();
			} else {
				$(targetIds).hide();
			}
		});
		}

	};
	/*
	 * 创建单选、复选框
	 */
	var createCodeBox = function(params) {
		var $tag = params.$tag, //标签
			name = params.name, //name
			codetype = params.codetype, //字典类型码
			value = params.value + '', //默认值
			changename = params.changename, //是否递增生成name-特殊使用
			tagtype = params.tagtype; //标签类型 radio|checkbox
		var $allTag = $("<input type='radio' />");
		var valArr = null;
		if (value && $.trim(value) != '') {
			valArr = value.split(',');
		}
		if (tagtype == "radio") {
			$tag.append($allTag)
				.append("全部：");
			}
			var data = getTypeCodes(codetype);
			for (var idx in data) {
			var item = data[idx];
			var checkBox = $("<input type='" + tagtype + "' name='" + (changename ? (name + idx) : name) + "' value='" + item["codeValue"] + "' />");
			if (valArr && _.contains(valArr, item["codeValue"])) {
				checkBox.attr('checked', true);
				$tag.append('<input type="hidden" name="hids" value="' + item["codeValue"] + '">');
			}
			$tag.append(checkBox);
			$tag.append(item["codeDesc"]);
	
			//为复选框特殊值进行处理-“无”
			var desc = item["codeDesc"];
			if (desc == "无") {
				$tag.data("specheckbox", $(checkBox));
				$(checkBox).click(function() {
				$(this).siblings("input:checkbox").removeAttr("checked");
				$(this).attr("checked", "checked");
	
				if (params.targetIds) {
					var $targetIds = $(params.targetIds);
					$targetIds.hide();
					$targetIds.find("input").val(null);
					$targetIds.find("textarea").val(null);
					$targetIds.find("select").val(null);
					$targetIds.find("input:radio").attr("checked", null);
					$targetIds.find("input:checkbox").attr("checked", null);
				}
				});
			} else {
				$(checkBox).click(function() {
				if ($tag.data("specheckbox")) {
					$tag.data("specheckbox").removeAttr("checked");
				}
				});
			}

		}

		//复选框值触发指定容器显示
		if (params.targetIds) {
			var targetIds = params.targetIds,
				targetValue = params.targetValue;
			$(targetIds).hide();
			$tag.find("input:checkbox").each(function(idx, el) {
				var elValue = $(el).val();
				//点击值触发显示隐藏
				if (isContainId(targetValue, elValue)) {
				$(el).click(function() {
					if (!$(el).is(':checked')) {
						$(targetIds).hide();
						$(targetIds).find("input").val(null);
						$(targetIds).find("textarea").val(null);
						$(targetIds).find("select").val(null);
						$(targetIds).find("input:radio").attr("checked", null);
						$(targetIds).find("input:checkbox").attr("checked", null);
					} else {
						$(targetIds).show();
					}
				});
				}
				//当前实际值决定是否显示
				if (isContainId(targetValue, value) 
						&& (value != "" && value != null && value != undefined)) {
					$(targetIds).show();
				}
			});
		}

	};

	//日期控件
	var dateboxbuttons = $.extend([], $.fn.datebox.defaults.buttons);
	dateboxbuttons.splice(1, 0, {
		text: '清除',
		handler: function(target) {
		$(target).datebox("setValue", "");
		}
	});

	/**
	 * 处理模版页面
	 */
	function handleHtml($html, data) {
		if (!data) data = {};
		if (!$html) {
		return;
		}
		//为特殊的标签赋值,日期、下拉框等
		var needValidDateBox = [],
		needValidSelect = [];
		//为普通标签赋值
		//select
		$html.find("select").each(function() {
		var val = $(this).data("value");
		if (val != null && val != undefined) {
			$(this).val(val);
		};
		});
		//radio
		$html.find("input:radio").each(function() {
		var radioName = $(this).attr("name"),
			radioValue = $(this).attr("value"),
			nameValue = data[radioName];
		if (nameValue == null || nameValue == undefined) {
			nameValue = data[radioName.toUpperCase()];
		}
		if (nameValue == null || nameValue == undefined) {
			nameValue = data[$(this).data("valname")];
		}
		if (nameValue == radioValue) {
			$(this).attr("checked", "checked");
		}
		});
		//为radio中的其它绑定事件
		$html.find(".field-other").each(function() {
		var name = $(this).attr("name"),
			$otherinput = $(this),
			$radioparent = $otherinput.parent();
		$otherinput.siblings().filter(":not(:last)").click(function() {
			$radioparent.find(".field-other").remove();
		});
		var $last = $otherinput.siblings().filter(":last");
		$last.click(function() {
			$radioparent.find(".field-other").remove();
			$radioparent.append(
			"<input class='field-other' type='text' name='" + name + "' />");
		});
		if (!$last.attr("checked")) {
			$otherinput.remove();
		}
		});
		//为带标记的赋值
		//统一加载特殊标记的码表
		var spetagCodeTypes = '',
		spetagCodeTypesTemp = {};
		$html.find(".spe-tag").each(function(idx, el) {
		var $this = $(this),
			spedata = $this.data("spe"),
			codeType = spedata.codetype;
		if (codeType && !spetagCodeTypesTemp[codeType]) {
			spetagCodeTypes += codeType + ",";
			spetagCodeTypesTemp[codeType] = true;
		}
		});
		if (spetagCodeTypes) {
		initCodeCache(spetagCodeTypes);
		}

		$html.find(".spe-tag").each(function(idx, el) {
			var $this = $(this),
				spedata = $this.data("spe"),
				type = spedata.type,
				required = spedata.required,
				dfvalue = spedata.value,
				codeType = spedata.codetype;
			if (type == "codeselect") { //下拉框
				createCodeSelect({
				codetype: codeType,
				$tag: $this,
				required: required
				});
			} else if (type == "select-device-type") { // 设备类型
				selectDeviceType.init($this, spedata, openWinWithEdit)
			} else if (type == "coderadio") { //radio
				var value = $this.data("value") !== "" ? $this.data("value") : $this.data("defaultvalue");
				createCodeRadio($.extend({}, {
				codetype: codeType,
				$tag: $this,
				name: $this.attr("name") ? $this.attr("name") : $this.data("name"),
				value: value
				}, spedata));
			} else if (type == "codebox") { //box
				createCodeBox($.extend({}, {
					codetype: codeType,
					$tag: $this,
					name: $this.attr("name") ? $this.attr("name") : $this.data("name"),
					value: $this.data("value"),
					changename: spedata.changename,
					tagtype: 'checkbox'
				}, spedata));
			} else if (type == "yearmonth") { //年月选择
				initYearMonth({$tag: $this});
			} else if (type == "year") { //年月选择
				initYear({$tag: $this});
			}
		
		});

		//格式化特殊标签
		$html.find(".edit-timestamp").each(function() {
			$(this).html(core.transTimeStamp($(this).html(), $(this).data("type")));
		});
		//格式化特殊标签
		$html.find(".edit-timestamp-input").each(function() {
			$(this).val(core.transTimeStamp($(this).val(), $(this).data("type")));
		});
		//为选择是否可触发其它显示的标签绑定事件
		$html.find(".combo-edit").hide();
		$html.find("tr").each(function() {
		var $tr = $(this);
		var combosrc = $tr.data("combosrc");
		if (combosrc) {
			var $combotar = $html.find(".combo-edit-" + combosrc);
			var curVal = $tr.find("input:checked").val();
			if (curVal == undefined || $($tr.find("input")[0]).attr("checked")) { //第一个选中否
				$combotar.hide();
			} else {
				$combotar.show();
			}
			//假设$tr下只存在多个radio,前几个为否，最后一个为是
			$($tr.find("input:not(:last)")).click(function() { //前几个
				var $intr = $(this).parent().parent();
				var incombotar =
					$html.find(".combo-edit-" + $intr.data("combosrc"));
				incombotar.hide();
				incombotar.find("input:hidden").val("");
				incombotar.find("input:text").val("");
				incombotar.find("input:radio").attr("checked", false);
				incombotar.find("select").val("");
				//清空子表数据
				destoryDateBox(incombotar.find(".edit-list-data tbody")); //销毁子表日期控件
				incombotar.find(".edit-list-data tbody").html("");
				//置空radio同时添加一同名的input:text,确保提交空name,否则数据不会更新
				var nameTemp = {};
				$intr.find(".temp-input").remove();
				incombotar.find("input:radio").each(function() {
					var name = $(this).attr("name");
					if (!nameTemp[name]) {
					nameTemp[name] = true;
					$intr.append(
						"<input class='temp-input' type='hidden' name='" + name + "' value='' />");
					}
				});
			});
			$($tr.find("input:last")).click(function() { //最后一个
				var $intr = $(this).parent().parent();
				var incombotar =
					$html.find(".combo-edit-" + $intr.data("combosrc"));
				//是-只显示与自己相关但是与其它无关的,
				//即不同时包含两个combo-edit-*,并且触发者只有一个combo-edit-*
				incombotar.each(function() {
					var comboeditCount = 0;
					var triggerComboeditCount = 0;
					var csp = $(this).attr("class").split(" ");
					var triggercsp = $intr.attr("class").split(" ");
					for (var i in csp) {
						var oneClass = csp[i];
						if (new RegExp("^combo-edit-.*").test(oneClass)) {
							comboeditCount++;
						}
					}
					for (var i in triggercsp) {
						var oneClass = triggercsp[i];
						if (new RegExp("^combo-edit-.*").test(oneClass)) {
							triggerComboeditCount++;
						}
					}
					//被触发者只有一个combo-edit属性或者触包者只有一个
					if (comboeditCount == 1 || triggerComboeditCount == 1) {
						$(this).show();
					}
				});
			});
		}
		});

	};

	//初始化年月选择标签
	function initYearMonth(config) {
		var $input = config["$tag"];
		$input.attr("readonly", "readonly");
		$input.addClass("widget-zoneinput");
		//绑定点击事件
		$input.click(function() {
		var $dialog = $("<div>").appendTo($("body")),
			$dialogContent = $("<div class='widget-zone-content'>")
			.appendTo($dialog);
		//绑定点击事件
		$dialog.dialog({
			title: '年-月 选择',
			closed: false,
			modal: true,
			left: null,
			width: 300,
			height: 400,
			onClose: function() {
				$dialog.dialog("destroy");
			}
		});
		$dialogContent.html("");
		//确认按钮
		var $btnOk = $("<div class='my-btn my-btn-cancle'>确认</div>").appendTo($dialogContent);
		//添加年份
		var $btnAddYear = $("<div class='my-btn my-btn-save'>增加年</div>")
			.css("float", "left")
			.appendTo($dialogContent);
		//清除按钮
		$("<div class='my-btn my-btn-reset'>清除</div>")
			.appendTo($dialogContent)
			.click(function() {
				$input.val("");
				$dialog.dialog("destroy");
			});
		//年份选择
		var $yearUl = $("<ul class='ym'>").appendTo($dialogContent);
		$("<li>").appendTo($yearUl).html("年份");
		var countYear = 5;
		var currentYear = new Date().getFullYear();
		for (var i = 0; i < countYear; i++) {
			var $li = $("<li>").appendTo($yearUl) //年份
				.html(currentYear - i)
				.click(function() {
					$yearUl.find(".ym-select").removeClass("ym-select");
					$(this).addClass("ym-select");
				});
			if (i == 0) {
				$li.addClass("ym-select");
			}
		}
		//月份选择
		var currentMonth = new Date().getMonth() + 1;
		var $monthUl = $("<ul class='ym'>").appendTo($dialogContent);
		$("<li>").appendTo($monthUl).html("月份");
		for (var i = 1; i <= 12; i++) {
			var $li = $("<li>").appendTo($monthUl) //月份
				.html(i < 10 ? "0" + i : i)
				.click(function() {
					$monthUl.find(".ym-select").removeClass("ym-select");
					$(this).addClass("ym-select");
				});
			if (i == currentMonth) {
				$li.addClass("ym-select");
			}
		}
		//添加年份
		$btnAddYear.click(function() {
			var countYear = 5;
			var currentYear = $yearUl.find("li:last").html();
			for (var i = 1; i <= countYear; i++) {
			$("<li />").appendTo($yearUl) //年份
				.html(currentYear - i)
				.click(function() {
					$yearUl.find(".ym-select").removeClass("ym-select");
						$(this).addClass("ym-select");
					});
			}
		});
		//确认
		$btnOk.click(function() {
			$input.val($yearUl.find(".ym-select").html() + "-" + $monthUl.find(".ym-select").html());
			$dialog.dialog("destroy");
		});
		});

	};
	

	// 初始化年月选择标签
	function initYear(config) {
		var $input = config["$tag"];
		$input.combobox({
			valueField : 'year',
			textField : 'year',
			panelHeight : 'auto'
		});
		var data = [];
		var startYear = new Date().getUTCFullYear();
		var endYear = 2017;
		for (var i = endYear; i >= startYear; i--) {
			data.push({"year" : i + ""});
		}
		$input.combobox("loadData", data);
		$input.combobox("setValue", startYear);
	}
	
	// 未选择获取全部选择标签值标记-与core.js保持一致
	var TAG_FLAG = "";

	/*处理一个表单-包含验证，提交按钮等*/
	var handleForm = function(formConfig) {
		var $form = formConfig["$form"],
		rules = formConfig["rules"],
		message = formConfig["message"],
		extvalid = formConfig["extvalid"],
		saveUrl = formConfig["saveUrl"],
		tplsuccess = formConfig["tplsuccess"],
		success = formConfig["success"],
		beforeSubmit = formConfig["beforeSubmit"], //表单提交之前
		data = formConfig["data"],
		child = formConfig["child"],
		title = formConfig["title"],
		type = formConfig["type"];
		//为特殊的标签赋值,日期、下拉框等
		var needValidDateBox = [],
		needValidSelect = [];

		//初始化可提交表单
		var $extDataInput = $("<input type='hidden' name='extData'>").appendTo($form);
		var $savebtn = $("<span class='btn btn-save'><i class='fa fa-save'></i>&nbsp;提交</span>");
		var $savingBtn = $("<span class='btn btn-save'>提交中...</span>").hide();
		var $validingBtn = $("<span class='btn btn-save'>校验中...</span>").hide();

		var editForm = new core.SubmitForm({
		$form: $form, //jquery form 对象
		url: saveUrl, //提交地址
		isJsonData: child ? true : false,
		rules: rules,
		datebox: needValidDateBox,
		selectvalid: needValidSelect,
		validSuccess: function() {
			$savebtn.hide();
			$validingBtn.hide();
			$savingBtn.show();
		},
		validError: function() {
			$savebtn.show();
			$validingBtn.hide();
			$savingBtn.hide();
			core.showMessage("校验失败");
		},
		message: message,
		extvalid: function($form) {
			//扩展的统一操作
			//收集list子表数据并为form添加额外数据extData
			var jsonListData = collectionExtData($form, data);
			if (!jsonListData.success) {
			return false; //验证失败
			} else {
			$extDataInput.val(JSON.stringify(jsonListData.data));
			}
			//扩展的验证操作
			var commonValid = extValidList($form);
			//为表单中的特殊复选框（name不一样）添加验证，name一样的复选框不用处理
			var validCheckBox = true;
			$form.find(".valid-error").remove();
			$form.find(".valid-checkbox").each(function(idx, el) {
			var $el = $(el);
			if (!$el.is(":visible")) {
				return true;
			}
			if ($el.find("input:checkbox:checked").length == 0) {
				validCheckBox = false;
				$el.append('<span class="valid-error">内容不能为空</span>');
				//滚动
				core.scrollToFormEl($el);
			}
			$el.find("input:checkbox").click(function() {
				if ($el.data("checkbox-click")) {
				return;
				} else {
				$el.data("checkbox-click", true);
				}

				if ($el.find("input:checkbox:checked").length == 0) {
				validCheckBox = false;
				$el.append('<span class="valid-error">内容不能为空</span>');
				} else {
				$el.find(".valid-error").remove();
				}
			});
			});

			//扩展验证
			var extValid = true;
			if (extvalid) {
			extValid = extvalid();
			}
			return commonValid && extValid && validCheckBox;
		},
		success: function(data) {
			$savebtn.show();
			$validingBtn.hide();
			$savingBtn.hide();
			success(data);
		},
		error: function(data) {
			$savebtn.show();
			$validingBtn.hide();
			$savingBtn.hide();
		}
		});

		//初始化扩展子列表数据
		$form.find(".edit-list-data").each(function() {
			var $table = $(this);
			var key = $table.data("key");
			if (!key || !child || !child[key]) {
				return;
			}
			var tableParams = $table.data("params") ? $table.data("params") : {},
				notEdit = tableParams["notEdit"];
			var tabHeaderField = child[key]["tabHeaderField"];
			var childConfig = child[key];
			// 是否可添加
			childConfig.addAble = childConfig.addAble === undefined ? true :childConfig.addAble;
			// 是否可移除
			childConfig.removeAble = childConfig.removeAble === undefined ? true :childConfig.removeAble;
			
			//添加新增一行按钮
			if (!notEdit && type == "1" && childConfig.addAble) {
				var fieldLength = tabHeaderField.length;
				var $addBtn = $("<div class='btn btn-blue'><i class='fa fa-plus'>&nbsp;&nbsp;添加</i></div>")
					.attr("class", "btn btn-addrow")
					.click(function() {
						addRow({
						$table: $table,
						$form: $form,
						fieldConfigs: tabHeaderField,
						tableParams: tableParams,
						type: type
						}, child[key]);
					});
				$table.after($addBtn);
				
				// 手动添加一行空数据
				if(!data || !data[key] || data[key].length == 0){
					$addBtn.click();
				}
			}
			
			//添加数据-初始化数据
			if (data && data[key]) {
				var items = data[key];
				for (var i in items) {
					addRow({
						$table: $table,
						$form: $form,
						item: items[i],
						fieldConfigs: tabHeaderField,
						tableParams: tableParams,
						type: type
					}, child[key]);
				}
			}
		
		});

		//为保存按钮绑定事件
		if (type == "1") { //编辑
		$("<div class='btn-submit-wrap'>")
			.append($savebtn)
			.append($savingBtn)
			.append($validingBtn)
			.appendTo($form);

		core.showLoading($savingBtn);

		$savebtn.click(function() {
			$savebtn.hide();
			$savingBtn.hide();
			var submitOk = true;
			$validingBtn.show(function() {
			if (beforeSubmit) {
				var beforeSubmitRet = beforeSubmit($form);
				if (!beforeSubmitRet) {
				submitOk = false;
				}
			}
			if (submitOk) {
				editForm.submit(function() {
				$savebtn.show();
				$savingBtn.hide();
				$validingBtn.hide();
				});
			} else {
				$savebtn.show();
				$savingBtn.hide();
				$validingBtn.hide();
			}
			});
		});
		}

		//为页面添加锚点-trlv1,trlv2
		var anchors = [];
		$form.find(".trlv1,.trlv2").each(function(idx, el) {
		var $el = $(el);
		var anchorDesc = $el.find("td").html();
		anchors.push({
			id: idx,
			desc: anchorDesc,
			$el: $el
		});
		});
		//超过2个生成锚点
		if (anchors.length > 2) {
		var anchorUlHeight = $(window).height() - 350;
		var anchorUlHeightMin = 50;
		var $anchorUl = $("<ul class='radius formanchors'>")
			.height(anchorUlHeightMin)
			.appendTo($form);
		$anchorUl.hover(function() {
			$anchorUl.addClass("formanchors-hover");
			$anchorUl.height(anchorUlHeight);
		}, function() {
			$anchorUl.removeClass("formanchors-hover");
			$anchorUl.height(anchorUlHeightMin);
		});
		for (var i in anchors) {
			var anchor = anchors[i];
			var $el = anchor.$el;
			$("<li>").appendTo($anchorUl)
			.html(anchor.desc)
			.data("$el", $el)
			.on("click", anchor, function(event) {
				$form.parents(".panel-body").animate({
				scrollTop: $(this).data("$el").position().top - $form.position().top
				}, 500);
			});
		}
		}
		if (tplsuccess) { //成功
		tplsuccess($form);
		}

		//将页面中所有标签设置为不可用
		if (type != "1" && type != "2") {
		$form.find("input").attr("disabled", "disabled");
		$form.find("textarea").attr("disabled", "disabled");
		$form.find("select").attr("disabled", "disabled");
		}

	};
	/*收集窗口内部子列表数据并验证*/
	function collectionExtData($surveyEditWin, data) {
		var ret = {
		success: true,
		data: {}
		};
		var allData = {};
		$surveyEditWin.find(".edit-list-data").each(function() {
		var listData = [];
		var $table = $(this);
		var key = $table.data("key");
		$table.find("tbody tr").each(function() {
			var $tr = $(this);
			var item = {};
			$tr.find("td").each(function() {
			var $td = $(this);
			//input
			var $inputs = $td.find("input");
			$inputs.each(function() {
				var $input = $(this);
				var name = $input.data("name");
				if (name) {
				item[name] = $input.val();
				} else {
				var attrname = $input.attr("name");
				if (attrname) {
					item[attrname] = $input.val();
				}
				}
			});
			//select
			var $select = $td.find("select");
			if ($select.length > 0) {
				item[$select.data("name")] = $select.val();
			}
			//textarea
			var $textarea = $td.find("textarea");
			if ($textarea.length > 0) {
				item[$textarea.data("name")] = $textarea.val();
			}
			});
			listData.push(item);
		});
		allData[key] = listData;
		});
		ret.data = allData;
		return ret;
	}
	/*在一个表格中生成一行数据*/
	function addRow(params, config) {
		var fieldConfigs = params["fieldConfigs"],
		type = params.type,
		item = params["item"],
		$table = params["$table"],
		tableParams = params["tableParams"] ? params["tableParams"] : {};
		var $tr = $("<tr>").appendTo($table);
		//序号列
		$("<td>")
			.html($table.find("tbody tr").length)
			.appendTo($tr);
		for (var idx in fieldConfigs) {
			var fieldConfig = fieldConfigs[idx];
			var inputName = fieldConfig["name"],
				fieldName = fieldConfig["fieldName"],
				fieldDescName = fieldConfig["fieldDescName"],
				fieldType = fieldConfig["type"],
				fieldRules = fieldConfig["rules"],
				fieldConfig = fieldConfig["config"],
				fieldValue = item ? item[fieldName] : null,
				fieldValueDesc = item && item[fieldDescName] ? item[fieldDescName] : null
			;
			var $td = $("<td>").appendTo($tr);
			if (!fieldType) { //默认类型
				var $input = $("<input type='text' >")
				.attr("name", inputName + "_" + Math.random())
				.data("name", inputName)
				.val(fieldValue);
				$td.html($input);
				if (fieldRules) {
				$input.validatebox(fieldRules);
				}
			} else if (fieldType == "datebox") { //日期类型
				var $input = $("<input type='text'>")
				.data("name", inputName)
				.attr("name", inputName);
				$td.html($input);
				$input.datebox({
					required: fieldRules && fieldRules.required ? fieldRules.required : false
				});
			} else if (fieldType == "select") { //下拉框
				var $input = $("<input />")
					.attr("name", inputName + "_" + Math.random())
					.val(fieldValue)
					.appendTo($td)
					;
				createCodeSelect({
					$tag: $input,
					codetype: fieldConfig["selectConfig"]["code"]
				});
			} else if (fieldType == "textarea") { //文本域
				var $textarea = $("<textarea>")
				.attr("name", inputName + "_" + Math.random())
				.data("name", inputName)
				.html(fieldValue)
				.appendTo($td);
				if (fieldRules) {
					$textarea.validatebox(fieldRules);
				}
			} else if (fieldType == "span") { //纯显示，不可编辑
				$("<span>")
				.attr("data-name", inputName)
				.html(fieldValue)
				.appendTo($td);
			} else if (fieldType == "hidden") { //隐藏字段，会提交
				var $input = $("<input type='hidden'>")
				.val(fieldValue)
				.attr("name", inputName)
				.attr("data-name", inputName);
				$td.hide().html($input);
			}
		
		}
		if (!tableParams["notEdit"] && type == "1" && config.removeAble) {
			//添加按钮-删除当前行
			$("<td class='btn btn-danger btn-delrow'><i class='fa fa-close'></i></td>")
				.click(function() {
					//销毁日期控件
					var $tr = $(this).parent();
					destoryDateBox($tr);
					//移除当前行
					$tr.remove();
					//重新生成行号
					$table.find("tbody tr").each(function(idx) {
						$($(this).find("td")[0]).html(idx + 1);
					});
					
					// 绑定文本输入框change事件
					if(config && config.onTextInputChange){
						config.onTextInputChange($(this), $(this).parents("tr"), $table, params.$form);
					}
	
				})
				.appendTo($tr);
		}
		
		//绑定文本输入框change事件
		if(config && config.onTextInputChange){
			config.onTextInputChange($(this), $(this).parents("tr"), $table, params.$form);
		}
		
		// 绑定文本输入框change事件
		if(config && config.onTextInputChange){
			$table.find("input[type=text]")
				.unbind('input propertychange')
				.bind('input propertychange', function(){
					config.onTextInputChange($(this), $(this).parents("tr"), $table, params.$form);
				});
		}
	}
	//销毁容器中的时间控件-class=spe-tag data-spe="{'type':'datebox'}"
	function destoryDateBox($el) {
		$el.find(".spe-tag").each(function() {
			if ($(this).data("spe").type == "datebox") {
				$(this).datebox("destroy");
			}
		});
	}

	function extValidList($form) {
		//检查日期是否验证通过
		var valid = true;
		$form.find(".valid-datebox").each(function() {
			//根据datebox的显示与否判断是否需要验证-$(this)为隐藏的,所以需要使用next()
			if ($(this).next().is(":visible")) {
				if (!$(this).datebox("isValid")) {
					core.scrollToFormEl($(this).next());
					valid = false;
					return false;
				}
			}
		});
		return valid;
	}

	//打开编辑窗口
	var openWinWithEdit = function(params) {
		var tpl = params["tpl"], //模版路径
		data = params["data"] ? params["data"] : {}, //数据
		type = params["type"] == undefined ? '1' : params["type"], //type:0 查看，1：编辑或者新增
		dialogConfig = $.extend({}, {}, params["dialogConfig"]), //弹出框配置
		title = params["title"], //标题
		child = params["child"], //子列表
		rules = params["rules"], //验证规则
		success = params["success"], //表单提交成功回调函数
		beforeSubmit = params["beforeSubmit"], //表单提交之前执行函数
		onClose = params["onClose"], //关闭回调函数
		surl = params["surl"], //保存路径
		mtplsuccess = params['tplsuccess']; //模板加载完成后回调函数

		var $win = $("<div>").appendTo($("body"));
		renderTpl({
		$div: $win,
		data: data,
		tpl: tpl,
		success: function() {
			$win.dialog($.extend({
				closed: false,
				title: title,
				onClose: function() {
					if (onClose) {
					onClose();
					}
					$win.dialog("destroy");
				}
			}, dialogConfig));
			handleForm({
				$form: $win.find("form"),
				saveUrl: surl,
				rules: rules,
				title: "" + title,
				data: data,
				type: type,
				child: child,
				beforeSubmit: beforeSubmit,
				success: function(data) {
					if (success) {
						success(data, $win);
					} else {
						$win.dialog("close");
					}
				},
				tplsuccess: function($form) {
					if (mtplsuccess)
					mtplsuccess($form);
				}
			});
		}
		});
		return $win;
	};

	//打开窗口
	var openWin = function(params) {
		var tpl = params["tpl"], //模版路径
		title = params["title"], //标题
		data = params["data"] ? params["data"] : {}, //数据
		dialogConfig = $.extend({}, {}, params["dialogConfig"]), //弹出框配置
		onClose = params["onClose"], //关闭回调函数
		tplsuccess = params['tplsuccess']; //模板加载完成后回调函数

		var $win = $("<div>").appendTo($("body"));
		renderTpl({
		$div: $win,
		data: data,
		tpl: tpl,
		success: function() {
			$win.dialog($.extend({
			closed: false,
			title: title,
			onClose: function() {
				if (onClose) {
				onClose();
				}else{
				$win.dialog("destroy");
				}
			}
			}, dialogConfig));
			
			// 添加打印弹出框功能
			/*var $btnPrint = $('<div id="btn-print-dialog" class="btn btn-add btn-print"><i class="fa fa-print">&nbsp;打印</i></div>')
				.click(function(){
					printZone($win, "#btn-print-dialog");
				});
			$win.append($btnPrint);*/
			
			if (tplsuccess) tplsuccess($win);
		}
		});
		return $win;
	};

	// 打印某个区域
	function printZone($zone, ignore){
		var $newZone = $zone.clone();
		if(ignore){
			$newZone.find(ignore).remove();
		}
		core.printZone($newZone.html());
	}

	return {

		renderTpl: renderTpl, //往容器中加载模板

		handleHtml: handleHtml, //处理html
		handleHtmlPermission: handleHtmlPermission, //处理html中的权限

		handleForm: handleForm, //处理表单
		openWinWithEdit: openWinWithEdit, //打开一个编辑窗口
		openWin: openWin, //打开一个窗口
		printZone: printZone // 打印某一个区域

	};
});