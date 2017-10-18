"use strict";
define(
		[ "jquery", "core", "tplengine" ],
		function($, core, tplengine) {
			/**
			 * 页面操作元素声明
			 */

			$(document).ready(function(e) {
				var $userUl = $(".user .username ul");
				$userUl.hide();
				$userUl.prev().click(function() {
					if ($userUl.hasClass("expand")) {
						$userUl.removeClass("expand");
						$userUl.hide();
					} else {
						$userUl.addClass("expand");
						$userUl.show();
					}
				});
			});

			var $formpwd = $("#alterpwdForm");
			var $btnSubmit = $("#btn-submit");// 提交按钮
			var params = {
				$form : $formpwd,// jquery form 对象
				url : "auth/userinfo/alterPwd",// 提交地址
				rules : {
					oldpassword : {
						required : true
					},
					newpassword : {
						required : true,
						password : true
					},
					confirmpassword : {
						required : true,
						password : true
					}
				},
				extvalid : function() {
					var npwd = $("input[name='newpassword']").val();
					var cpwd = $("input[name='confirmpassword']").val();
					if ($.trim(npwd).length < npwd.length) {
						core.alertMessage("<div style=\"color:#F00;text-align:center\">密码的首尾不能包含空格！</div>");
						return false;
					}
					if (npwd != cpwd) {
						core.alertMessage("<div style=\"color:#F00;text-align:center\">两次输入的新密码不一致!</div>");
						return false;
					}
					return true;
				},
				success : function() {
				}// 表单提交成功回调函数
			};
			// 需要new一个SubmitForm，再用里面的submit提交
			var f = new core.SubmitForm(params);
			$btnSubmit.click(alterPwd);
			function alterPwd() {
				f.submit();
			}

		});