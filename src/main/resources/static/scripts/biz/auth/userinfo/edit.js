"use strict";
/**
 * 个人信息编辑
 */
define(["jquery", "util", "tplengine"], function($, util, tplengine) {
	//容器
	var $infocontent = $("#infocontent");
	
	//加载内容
	util.submitAjax({
		url: "auth/userinfo/getUserInfo",
		success: function(data){
			util.renderTpl({
				$div: $infocontent,
				data: data,
				tpl: "scripts/biz/auth/userinfo/tpl/editinfo.tpl",
				success: function(){
					tplengine.handleHtml($infocontent.find("form"), data);
					
					var sForm = new util.SubmitForm({
						$form: $infocontent.find("form"),
						url: "auth/userinfo/edit",
						rules: {
							loginName: {required: true},
							name: {required: true},
							email:{email:true},
						},
						success: function(){
							
						}
					});
					//保存按钮
					var $saveBtn = $infocontent.find("#saveBtn");
					$saveBtn.click(function(){
						sForm.submit();
					});
				}
			});
		}
	});
	
});