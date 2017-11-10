"use strict";
/**
 * 编辑
 */
define(["jquery", "core", "tplengine", "simpleupload", "jquery.lightbox"],
	function($, core, tplengine, simpleupload) {
	
	/**
	 * 默认参数
	 */
	var DEFAULT_ITEM_WIDTH = 100,
		DEFAULT_ITEM_HEIGHT = 100
		;
	
	// 是否查看
	var IS_VIEW = core.getQueryString("IS_VIEW");
	// 隐藏相关操作
	if(IS_VIEW){
		$('.btn-add,.btn-danger,.btn-edit,.btn-save,.zone-verify').remove();
	}
	
	// 调整宽度
	var centerWidth = $(window).width() - $(".im-left").width() - $(".im-right").width() - 50;
	$(".im-location").width(centerWidth);
	$(".im-center").width(centerWidth);
	$(".im-center-max").width($(window).width() - $(".im-left").width() - 50);
	
	// 页面元素
	var $tagImgWrap = $('#tag-wrap'),// 中间图片容器-变电站
		$tagImgWrapDevice = $('#tag-wrap-device'),// 中间图片容器-设备
		$tagTransformers = $("#tag-transformers"),// 变电站容器
		$tagItems = $('#tag-items'),// 设备列表容器
		$tagItemsPart = $('#tag-items-part'),// 部件列表容器
		ITEMS = [],// 当前设备列表
		ITEMS_PART = [],// 当前部件列表
		CURRENT_TRANSFORMER = null,// 当前变电站
		CURRENT_WD = null,// 当前接线图
		CURRENT_DEVICE = null,// 当前设备
		CURRENT_DEVICE_IMG = null,// 当前设备图
		CURRENT_PART = null,// 当前部件
		
		$zoneDevice = $("#zone-device"),// 区域-变电站管理
		$zoneTransformer = $("#zone-transformer"),// 区域-设备管理
		$zonePart = $("#zone-part"),// 区域-部件管理
		
		$btnWdSave = $("#btn-wd-save"),// 按钮-保存接线图位置大小
		$btnDeviceImgSave = $("#btn-deviceimg-save"),// 按钮-保存接线图位置大小
		
		$btnVerifyWd = $("#btn-verify-wd"),// 审核-接线图
		$btnVerifyDeviceImg = $("#btn-verify-deviceImg")// 审核-设备图
		
		;
	
	// 权限按钮-审核
	var IS_VERIFY = false;
	if(IS_VIEW || !core.hasPermission('img_mgr_verify')){// 无权限
		$btnVerifyWd.remove();
		$btnVerifyDeviceImg.remove();
	}else{
		IS_VERIFY = true;
	}
	
	// 切换显示状态
	function changeStateTransformer(){
		$zoneDevice.hide();
		$zonePart.hide();
		$zoneTransformer.show();
	}
	function changeStateDevice(){
		$zoneTransformer.hide();
		$zonePart.hide();
		$zoneDevice.show();
	}
	function changeStatePart(){
		$zoneTransformer.hide();
		$zoneDevice.hide();
		$zonePart.show();
	}
	
	// 返回-设备管理
	$("#btn-back-device").click(function(){
		CURRENT_PART = null;
		CURRENT_DEVICE_IMG = null;
		changeStateTransformer();
		refreshLocation();
	});
	// 返回-部件管理
	$("#btn-back-part").click(function(){
		changeStateDevice();
		refreshLocation();
		$btnDeviceImgSave.hide();
	});
	// 刷新当前选择信息
	function refreshLocation(){
		var $tagLocationInfos = $("#tag-location-infos");
		$tagLocationInfos.html('');
		var split = "&nbsp;&gt;&nbsp;";
		if(CURRENT_TRANSFORMER){
			$tagLocationInfos.append(CURRENT_TRANSFORMER.name);
		}
		if(CURRENT_WD){
			$tagLocationInfos.append(split + CURRENT_WD.desc);
		}
		if(CURRENT_DEVICE){
			$tagLocationInfos.append(split + CURRENT_DEVICE.name);
		}
		if(CURRENT_DEVICE_IMG){
			$tagLocationInfos.append(split + CURRENT_DEVICE_IMG.desc);
		}
		if(CURRENT_PART){
			$tagLocationInfos.append(split + CURRENT_PART.desc);
		}
	}
	
	// 刷新变电站
	function refreshTransFormer(){
		$tagTransformers.html("加载中...");
		// 加载左侧变电站数据
		core.submitAjax({
			url: 'api/transformer/list',
			type: 'get',
			data: {state: '01'},
			success: function(data){
				data = data || [];
				var typeMap = {};
				for(var i in data){
					var item = data[i];
					var type = item.type;
					if(typeMap[type]){
						typeMap[type].push(item);
					}else{
						typeMap[type] = [item];
					}
				}
				$tagTransformers.html('');
				$tagTransformers.append($("<div class='lv1'>").html('濮阳市供电区变电站'));
				for(var type in typeMap){
					$tagTransformers.append($("<div class='lv2'>").html(type));
					for(var j in typeMap[type]){
						var item = typeMap[type][j];
						
						$tagTransformers.append(
							$("<div class='lv3'>")
								.data('data', item)
								.attr('title', item.desc)
								.html(item.name)
								.prepend("<i class='fa fa-bolt'></i>&nbsp;&nbsp;")
								.click(function(){
									// 切换变电站
									changeTransFormer($(this).data('data'), $(this));
								})
						);
					}
				}
				// 默认切换第一个变电站
				if(data.length > 0){
					changeTransFormer(data[0], $tagTransformers.find(".lv3:first"));
				}else{// 无变电站
					changeTransFormer();
				}
			}
		});
	}
	refreshTransFormer();
	
	// 切换变电站
	function changeTransFormer(item, $tag){
		
		$btnWdSave.hide();
		$btnDeviceImgSave.hide();
		
		CURRENT_TRANSFORMER = item;
		CURRENT_WD = null;
		CURRENT_DEVICE = null;
		CURRENT_DEVICE_IMG = null;
		CURRENT_PART = null;
		showCurrentItem();
		
		refreshLocation();
		// 切换状态
		changeStateTransformer();
		
		// 变电站为空
		if(!item){
			$("#im-transformer-withdata").hide();
			$("#im-transformer-nodata").show();
		}else{
			$("#im-transformer-withdata").show();
			$("#im-transformer-nodata").hide();
		}
		
		$tagTransformers.find(".lv3").removeClass("select");
		$tag.addClass("select");
		// 刷新接线图
		if(item){
			refreshWg(item.id);
		}else{
			refreshWg();
		}
	}
	
	/////////// 接线图相关/////////////
	// 刷新接线图-通过变电站id
	function refreshWg(tfId){
		
		if(tfId){// 有变电站
			// 加载变电站的详细信息
			core.submitAjax({
				url: 'api/transformer/getDetailById/' + tfId,
				type: 'get',
				data: {
					isView: IS_VIEW
				},
				success: function(data){
					// 接线图信息
					var wgs = data.wiringdiagrams || [];
					// 渲染接线图列表
					$("#tag-select-wg").combobox({
						width: 400,
						data: wgs,
						editable: false,
						valueField: 'id',
						textField: 'desc',
						onSelect: function(record){
							// 切换接线图
							changeWg(record);
						}
					});
					// 默认显示
					var DEFAULT_TRANS = null;
					if(CURRENT_WD){
						for(var i in wgs){
							if(wgs[i].id == CURRENT_WD.id){
								DEFAULT_TRANS = wgs[i];
							}
						}
					}
					if(!DEFAULT_TRANS){
						DEFAULT_TRANS = wgs.length > 0 ? wgs[0] : null;
					}
					if(DEFAULT_TRANS){
						$("#tag-select-wg").combobox('setValue', DEFAULT_TRANS.id);
					}
					// 切换接线图
					changeWg(DEFAULT_TRANS);
				}
			});
		}else{// 无变电站
			changeWg();
		}
	}
	
	/**
	 * 审核接线图
	 */
	$btnVerifyWd.click(function(){
		tplengine.openWinWithEdit({
			title: '审核-接线图',
			tpl: 'scripts/biz/imgmgr/tpl/verify.tpl',
			dialogConfig:{
				width: 500,
				height: 300
			},
			data: {
				id: CURRENT_WD.id
			},
			surl: 'api/wiringdiagram/verify',
			success: function(data, $win){
				refreshWg(CURRENT_TRANSFORMER.id);
				$win.dialog("close");
			}
		})
	});
	
	/**
	 * 审核设备图
	 */
	$btnVerifyDeviceImg.click(function(){
		tplengine.openWinWithEdit({
			title: '审核-设备图',
			tpl: 'scripts/biz/imgmgr/tpl/verify.tpl',
			dialogConfig:{
				width: 500,
				height: 300
			},
			data: {
				id: CURRENT_DEVICE_IMG.id
			},
			surl: 'api/deviceimg/verify',
			success: function(data, $win){
				refreshDeviceImg(CURRENT_DEVICE.id);
				$win.dialog("close");
			}
		})
	});
	
	/**
	 * 审核部件历史
	 */
	function verifyPartHis(item, cb){
		tplengine.openWinWithEdit({
			title: '审核',
			tpl: 'scripts/biz/imgmgr/tpl/verify.tpl',
			dialogConfig:{
				width: 500,
				height: 300
			},
			data: item,
			surl: 'api/parthis/verify',
			success: function(data, $win){
				if(cb) cb(item);
				$win.dialog("close");
			}
		})
	}
	
	// 切换接线图
	function changeWg(item){
		
		$btnWdSave.hide();
		$btnDeviceImgSave.hide();
		
		CURRENT_WD = item;
		refreshLocation();
		if(!item){// 无接线图
			$("#im-wg-withdata").hide();
			$("#im-wg-nodata").show();
			$("#tag-wg-withdata").hide();
			$("#tag-wg-nodata").show();
			
			// 隐藏相关信息
			$("#tag-img-info-nodata").show();
			$("#tag-img-info-withdata").hide();
			
			// 刷新设备列表
			refreshItemsData();
			
		}else{// 有接线图
			$("#im-wg-withdata").show();
			$("#im-wg-nodata").hide();
			$("#tag-wg-withdata").show();
			$("#tag-wg-nodata").hide();
			
			// 接线图信息
			var wgId = item.id,
				wgImgId = item.imgId,
				wgImgDownloadUrl = "upfiles/" + item.path,
				wgUploadTime = item.uploadTime,
				wgUploadUser = item.uploadUserDesc,
				wgDesc = item.desc,
				tfId = item.transformerId
				;
			
			// 显示接线图信息
			var verifyStatus = item.verifyStatus;
			$("#tag-img-info-nodata").hide();
			$("#tag-img-info-withdata").show();
			$("#wd-info-uploadTime").html(core.transTimeStamp(wgUploadTime));
			$("#wd-info-user").html(wgUploadUser);
			$("#wd-info-desc").html(wgDesc);
			$("#wd-info-verifyStatus").html(item.verifyStatusDesc);
			$("#wd-info-verifyUser").html(item.verifyUserDesc);
			$("#wd-info-verifyContent").html(item.verifyContent);
			$("#wd-info-verifyTime").html(core.transTimeStamp(item.verifyTime));
			
			// 加载接线图设备列表信息
			core.submitAjax({
				url: 'api/device/list',
				type: 'get',
				data: {wiringdiagramId: wgId},
				success: function(data){
					refreshItemsData(data);
				}
			});
			
			// 渲染接线图图片
			$tagImgWrap.html('');
			var $imgMain = $("<img id='tag-img' />")
				.attr('src', wgImgDownloadUrl)
				.css({
					position: 'absolute',
					left: '0px',
					top: '0px',
					'z-index': 1
				})
				.appendTo($tagImgWrap)
				.load(function(){
					// 设置容器宽高
					$tagImgWrap.width($("#tag-img").width()).height($("#tag-img").height());
				});
		}
		
	}
	
	// 添加接线图
	$("#btn-wd-add").click(function(){
		if(!CURRENT_TRANSFORMER){
			core.alertMessage("无变电站信息");
			return;
		}
		tplengine.openWinWithEdit({
			title: '添加接线图',
			tpl: 'scripts/biz/imgmgr/tpl/wd-add.tpl',
			data: {
				transformerId: CURRENT_TRANSFORMER.id,
				x: 0,
				y: 0,
				width: DEFAULT_ITEM_WIDTH,
				height: DEFAULT_ITEM_HEIGHT
			},
			surl: 'api/wiringdiagram/add',
			success: function(data, $win){
				refreshWg(CURRENT_TRANSFORMER.id);
				$win.dialog("close");
			},
			beforeSubmit: function($form){
				if($form.find("input[name=imgId]").val()){
					return true;
				}else{
					core.alertMessage("请上传接线图");
					return false;
				}
			},
			tplsuccess: function($win){
				// 文件上传
				simpleupload.simpleupload({
					$div: $win.find("#fileupload-tag"),
					attachType: "wg",
					progressbar: $("#progress-bar"),
					hidFileId: "imgId"
				});
			}
		})
	});
	
	// 编辑接线图
	$("#btn-wd-edit").click(function(){
		if(!CURRENT_WD){
			core.alertMessage("无接线图信息");
			return;
		}
		tplengine.openWinWithEdit({
			title: '编辑接线图',
			tpl: 'scripts/biz/imgmgr/tpl/wd-add.tpl',
			data: CURRENT_WD,
			surl: 'api/wiringdiagram/edit',
			success: function(data, $win){
				refreshWg(CURRENT_TRANSFORMER.id);
				$win.dialog("close");
			},
			beforeSubmit: function($form){
				if($form.find("input[name=imgId]").val()){
					return true;
				}else{
					core.alertMessage("请上传接线图");
					return false;
				}
			},
			tplsuccess: function($win){
				// 文件上传
				simpleupload.simpleupload({
					$div: $win.find("#fileupload-tag"),
					attachType: "wg",
					progressbar: $("#progress-bar"),
					hidFileId: "imgId",
					defaultValue: CURRENT_WD.imgId
				});
			}
		})
	});
	
	// 保存接线图中设备位置信息
	$btnWdSave.click(function(){
		var data = [];
		$("#im-wg-withdata .item-drag").each(function(){
			var item = $(this).data('data');
			data.push({
				id: item.id,
				x: item.x,
				y: item.y,
				w: item.width,
				h: item.height
			});
		});
		core.submitAjax({
			url: "api/wiringdiagram/updateXyWh",
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify(data),
			success: function(data){
				$btnWdSave.hide();
			}
		})
	});
	
	// 删除接线图
	$("#btn-wd-del").click(function(){
		if(!CURRENT_WD){
			core.alertMessage("无接线图信息");
			return;
		}
		$.messager.confirm('确认','确定删除当前接线图?删除后不可撤销。',function(r){
			if (r){
				core.submitAjax({
					url: "api/wiringdiagram/del",
					data: {
						ids: CURRENT_WD.id
					},
					success: function(data){
						refreshWg(CURRENT_TRANSFORMER.id);
					}
				});
			}
		});
	})
	
	/////////////////设备相关/////////////////
	// 添加设备
	$("#btn-device-add").click(function(){
		if(!CURRENT_WD){
			core.alertMessage("无接线图信息");
			return;
		}
		tplengine.openWinWithEdit({
			title: '添加设备',
			tpl: 'scripts/biz/imgmgr/tpl/device-add.tpl',
			data: {
				wiringdiagramId: CURRENT_WD.id,
				x: 0,
				y: 0,
				width: DEFAULT_ITEM_WIDTH,
				height: DEFAULT_ITEM_HEIGHT
			},
			surl: 'api/device/add',
			success: function(data, $win){
				$win.dialog("close");
				addDevice(data);
			},
			tplsuccess: function($win){
				// 文件上传
				/*simpleupload.simpleupload({
					$div: $win.find("#fileupload-tag"),
					attachType: "device",
					progressbar: $("#progress-bar"),
					hidFileId: "imgId"
				});*/
			}
		})
	});
	
	// 编辑设备
	$("#btn-device-edit").click(function(){
		if(!CURRENT_DEVICE){
			core.alertMessage("无设备信息");
			return;
		}
		tplengine.openWinWithEdit({
			title: '编辑设备',
			tpl: 'scripts/biz/imgmgr/tpl/device-add.tpl',
			data: CURRENT_DEVICE,
			surl: 'api/device/edit',
			success: function(data, $win){
				$win.dialog("close");
				// 更新设备信息
				updateDevice(data);
			},
			tplsuccess: function($win){
				// 文件上传
				simpleupload.simpleupload({
					$div: $win.find("#fileupload-tag"),
					attachType: "device",
					progressbar: $("#progress-bar"),
					hidFileId: "imgId",
					defaultValue: CURRENT_DEVICE.imgId
				});
			}
		})
	});
	
	// 删除设备
	$("#btn-device-del").click(function(){
		if(!CURRENT_DEVICE){
			core.alertMessage("无设备信息");
			return;
		}
		$.messager.confirm('确认','确定删除当前设备？【删除后不可撤销】',function(r){
			if (r){
				core.submitAjax({
					url: "api/device/del",
					data: {
						ids: CURRENT_DEVICE.id
					},
					success: function(data){
						removeDevice(CURRENT_DEVICE);
					}
				});
			}
		});
	})
	
	// 拖动事件
	function onDrag(e){
		var d = e.data;
		var data = $(e.target).data('data');
		if (d.left < 0){d.left = 0}
		if (d.top < 0){d.top = 0}
		if (d.left + $(d.target).outerWidth() > $(d.parent).width()){
			d.left = $(d.parent).width() - $(d.target).outerWidth();
		}
		if (d.top + $(d.target).outerHeight() > $(d.parent).height()){
			d.top = $(d.parent).height() - $(d.target).outerHeight();
		}
		
		if(data){
			data.x = parseInt(d.left);
			data.y = parseInt(d.top);
			// 更新当前数据中的位置信息
			updateDeviceList(data);
			
			$btnWdSave.show();
		}
		
	}
	
	// 改变大小事件
	function onResize(e){
		var d = e.data;
		var data = $(e.target).data('data');
		if (d.left < 0){d.left = 0}
		if (d.top < 0){d.top = 0}
		var $dTarget = $(d.target);
		var $tagImg = $("#tag-img");
		if (d.left + $dTarget.outerWidth() > $tagImg.width()){
			$dTarget.width($tagImg.width() - d.left);
		}
		if (d.top + $dTarget.outerHeight() > $tagImg.height()){
			$dTarget.height($tagImg.height() - d.top);
		}
		
		if(data){
			data.width = $dTarget.width();
			data.height = $dTarget.height();
			// 更新当前数据中的大小信息
			updateDeviceList(data);
		}
		
		$btnWdSave.show();
		
	}

	////////////////设备相关////////////////////
	// 重新渲染设备列表数据
	function refreshItemsData(data){
		$tagItems.html('');
		for(var i in data){
			var item = data[i];
			// 渲染数据
			addDevice(item);
		}
	}
	
	// 添加一个设备
	function addDevice(item){
		if(!item) return;
		
		// 数据
		if(!ITEMS) ITEMS = [];
		ITEMS.splice(0, 0, item);
		
		// 列表
		// 设备信息
		$tagItems.prepend(
			$('<div class="item-drag-right"></div>')
				.html(item.name)
				.attr('title', item.name)
				.prepend(
					$('<i class="fa fa-eye im-view-detail">&nbsp;&nbsp;详情</i>')
						.data('data', item)
						.click(function(){
							// 查看设备管理
							viewDevice($(this).data('data'));
						}
				))
				.data('data', item)
				.click(function(){
					selectItem($(this).data('data'));
				})
		);
		
		// 图片
		var $item = $('<div class="item-drag"></div>');
		$tagImgWrap.append($item);
		$item.css({
			width: item.width,
			height: item.height,
			left: item.x + 'px',
			top: item.y + 'px'
		})
		.append($('<i class="item-drag-viewdetail fa fa-eye" title="详情"></i>')
				.data('data', item)
				.click(function(){
					// 查看设备管理
					viewDevice($(this).data('data'));
				})
		)
		// 数据
		.data('data', item)
		// 提示信息
		.tooltip({
			content: item.name 
				//+ (item.path ? ("<br/><img src='upfiles/"+ item.path + "' width=200 />") : '')
				+ "<br/>" + item.desc
				, 
			trackMouse: true})
		// 点击事件
		.click(function(){
			selectItem($(this).data('data'));
		});
		if(!IS_VIEW){
			// 可拖动
			$item.draggable({
				onDrag: onDrag,
				disabled: IS_VIEW
			});
			// 可调整大小
			$item.resizable({
				maxWidth: $("#tag-img").width(),
				maxHeight: $("#tag-img").height(),
				minWidth: 20,
				minHeight: 20,
				onStopResize: onResize
			});
		}
	}
	
	// 移除一个设备
	function removeDevice(item){
		if(!item) return;
		
		// 数据
		for(var i in ITEMS){
			if(ITEMS[i].id == item.id){
				ITEMS.splice(i, 1);
				break;
			}
		}
		
		// 列表
		$tagItems.find(".item-drag-right").each(function(){
			if($(this).data('data').id == item.id){
				$(this).remove();
			}
		});
		
		// 图片
		$tagImgWrap.find(".item-drag").each(function(){
			if($(this).data('data').id == item.id){
				$(this).remove();
			}
		});
		
		// 刷新信息
		showCurrentItem();
		
	}
	
	// 更新一个设备
	function updateDevice(item){
		if(!item) return;
		
		// 数据
		for(var i in ITEMS){
			if(ITEMS[i].id == item.id){
				ITEMS[i] = item;
			}
		}
		
		// 列表
		updateDeviceList(item);
		
		// 图片
		$tagImgWrap.find(".item-drag").each(function(){
			if($(this).data('data').id == item.id){
				$(this).data('data', item)
					.css({
						left: item.x + 'px',
						top: item.y + 'px',
						width: item.width,
						height: item.height
					})
					.tooltip({
						content: item.name 
							+ (item.path ? ("<br/><img src='upfiles/"+ item.path + "' width=200 />") : '')
							+ "<br/>" + item.desc
							, 
						trackMouse: true});
			}
		});
	}
	// 更新列表中的对象数据
	function updateDeviceList(item){
		if(!item) return;
		$tagItems.find(".item-drag-right").each(function(){
			if($(this).data('data').id == item.id){
				$(this).data('data', item);
			}
		});
		
		// 若当前选择对象一致，则更新显示信息
		if(CURRENT_DEVICE && CURRENT_DEVICE.id == item.id){
			showCurrentItem(item);
		}
	}
	
	// 选中某一个设备元素
	function selectItem(item){
		// 图片中元素
		$tagImgWrap.find('.select').removeClass('select');
		$tagImgWrap.find('.item-drag').each(function(){
			if($(this).data('data').id == item.id){
				$(this).addClass('select');
				return false;
			}
		});
		
		// 列表中元素
		$tagItems.find('.select').removeClass('select');
		$tagItems.find('.item-drag-right').each(function(){
			if($(this).data('data').id == item.id){
				$(this).addClass('select');
				return false;
			}
		});
		
		// 显示元素信息
		showCurrentItem(item);
	}

	// 显示当前选中元素的信息
	function showCurrentItem(item){
		CURRENT_DEVICE = item;
		refreshLocation();
		if(item){
			$("#tag-currentdevice-unselect").hide();
			$("#tag-currentdevice-select").show();
			
			// 显示设备相关信息
			$("#info-device-name").html(item.name);// 名称
			$("#info-device-desc").html(item.desc);// 描述
			$("#info-device-width").html(item.width);// 宽
			$("#info-device-height").html(item.height);// 高
			$("#info-device-x").html(item.x);// x
			$("#info-device-y").html(item.y);// y
		}else{
			$("#tag-currentdevice-select").hide();
			$("#tag-currentdevice-unselect").show();
		}
	}
	showCurrentItem();
	
	
	///////////////////////// 设备管理页面
	// 查看设备管理 
	function viewDevice(device){
		CURRENT_DEVICE = device;
		refreshLocation();
		// 切换状态
		changeStateDevice();
		// 获取设备图信息
		refreshDeviceImg(device.id);
	}
	
	/////////// 设备图相关/////////////
	// 刷新设备图-通过设备id
	function refreshDeviceImg(id){
		if(id){// 有设备
			// 加载设备详情
			core.submitAjax({
				url: 'api/device/getDetailById/' + id,
				data: {
					isView: IS_VIEW
				},
				type: 'get',
				success: function(data){
					// 设备图信息
					var deviceImgs = data.deviceImgs || [];
					// 渲染设备图列表
					$("#tag-select-device").combobox({
						width: 400,
						data: deviceImgs,
						editable: false,
						valueField: 'id',
						textField: 'desc',
						onSelect: function(record){
							// 切换设备图
							changeDeviceImg(record);
						}
					});
					
					// 默认显示
					var DEFAULT_DI = null;
					if(CURRENT_DEVICE_IMG){
						for(var i in deviceImgs){
							if(deviceImgs[i].id == CURRENT_DEVICE_IMG.id){
								DEFAULT_DI = deviceImgs[i];
							}
						}
					}
					if(!DEFAULT_DI){
						DEFAULT_DI = deviceImgs.length > 0 ? deviceImgs[0] : null;
					}
					if(DEFAULT_DI){
						$("#tag-select-device").combobox('setValue', DEFAULT_DI.id);
					}
					// 切换接线图
					changeDeviceImg(DEFAULT_DI);
					
				}
			});
		}else{// 无设备
			changeDeviceImg();
		}
	}
	
	// 切换设备图
	function changeDeviceImg(item){
		
		$btnDeviceImgSave.hide();
		
		CURRENT_DEVICE_IMG = item;
		refreshLocation();
		if(!item){// 无设备图
			$("#im-deviceimg-withdata").hide();
			$("#im-deviceimg-nodata").show();
			
			// 隐藏相关信息
			$("#tag-img-info-device-nodata").show();
			$("#tag-img-info-device-withdata").hide();
			
			// 刷新部件列表
			refreshPartItemsData();
			
		}else{// 有设备图
			$("#im-deviceimg-withdata").show();
			$("#im-deviceimg-nodata").hide();
			
			// 设备图信息
			var deviceImgId = item.id,
				deviceImgImgId = item.imgId,
				deviceImgImgDownloadUrl = "upfiles/" + item.path,
				deviceImgUploadTime = item.uploadTime,
				deviceImgUploadUser = item.uploadUserDesc,
				deviceImgDesc = item.desc,
				deviceId = item.deviceId
				;
			
			// 显示接线图信息
			$("#tag-img-info-device-nodata").hide();
			$("#tag-img-info-device-withdata").show();
			$("#wd-info-device-uploadTime").html(core.transTimeStamp(deviceImgUploadTime));
			$("#wd-info-device-user").html(deviceImgUploadUser);
			$("#wd-info-device-desc").html(deviceImgDesc);
			$("#wd-info-device-verifyStatus").html(item.verifyStatusDesc);
			$("#wd-info-device-verifyUser").html(item.verifyUserDesc);
			$("#wd-info-device-verifyContent").html(item.verifyContent);
			$("#wd-info-device-verifyTime").html(core.transTimeStamp(item.verifyTime));
			
			// 加载设备图部件列表信息
			core.submitAjax({
				url: 'api/part/list',
				type: 'get',
				data: {deviceImgId: deviceImgId},
				success: function(data){
					refreshPartItemsData(data);
				}
			});
			
			// 渲染设备图图片
			$tagImgWrapDevice.html('');
			var $imgMain = $("<img id='tag-img-device' />")
				.attr('src', deviceImgImgDownloadUrl)
				.css({
					position: 'absolute',
					left: '0px',
					top: '0px',
					'z-index': 1
				})
				.appendTo($tagImgWrapDevice)
				.load(function(){
					// 设置容器宽高
					$tagImgWrapDevice.width($("#tag-img-device").width()).height($("#tag-img-device").height());
				});
		}
		
	}
	
	// 添加设备图
	$("#btn-deviceimg-add").click(function(){
		if(!CURRENT_DEVICE){
			core.alertMessage("无设备信息");
			return;
		}
		tplengine.openWinWithEdit({
			title: '添加设备图',
			tpl: 'scripts/biz/imgmgr/tpl/deviceimg-add.tpl',
			data: {
				deviceId: CURRENT_DEVICE.id,
				x: 0,
				y: 0,
				width: DEFAULT_ITEM_WIDTH,
				height: DEFAULT_ITEM_HEIGHT
			},
			surl: 'api/deviceimg/add',
			success: function(data, $win){
				refreshDeviceImg(CURRENT_DEVICE.id);
				$win.dialog("close");
			},
			beforeSubmit: function($form){
				if($form.find("input[name=imgId]").val()){
					return true;
				}else{
					core.alertMessage("请上传设备图");
					return false;
				}
			},
			tplsuccess: function($win){
				// 文件上传
				simpleupload.simpleupload({
					$div: $win.find("#fileupload-tag"),
					attachType: "deviceimg",
					progressbar: $("#progress-bar"),
					hidFileId: "imgId"
				});
			}
		})
	});
	
	// 编辑设备图
	$("#btn-deviceimg-edit").click(function(){
		if(!CURRENT_DEVICE_IMG){
			core.alertMessage("无设备图信息");
			return;
		}
		tplengine.openWinWithEdit({
			title: '编辑设备图',
			tpl: 'scripts/biz/imgmgr/tpl/deviceimg-add.tpl',
			data: CURRENT_DEVICE_IMG,
			surl: 'api/deviceimg/edit',
			success: function(data, $win){
				refreshDeviceImg(CURRENT_DEVICE.id);
				$win.dialog("close");
			},
			beforeSubmit: function($form){
				if($form.find("input[name=imgId]").val()){
					return true;
				}else{
					core.alertMessage("请上传设备图");
					return false;
				}
			},
			tplsuccess: function($win){
				// 文件上传
				simpleupload.simpleupload({
					$div: $win.find("#fileupload-tag-device"),
					attachType: "deviceimg",
					progressbar: $("#progress-bar-device"),
					hidFileId: "imgId",
					defaultValue: CURRENT_DEVICE_IMG.imgId
				});
			}
		})
	});
	
	// 删除设备图
	$("#btn-deviceimg-del").click(function(){
		if(!CURRENT_DEVICE_IMG){
			core.alertMessage("无设备图信息");
			return;
		}
		$.messager.confirm('确认','确定删除当前设备图?删除后不可撤销。',function(r){
			if (r){
				core.submitAjax({
					url: "api/deviceimg/del",
					data: {
						ids: CURRENT_DEVICE_IMG.id
					},
					success: function(data){
						refreshDeviceImg(CURRENT_DEVICE.id);
					}
				});
			}
		});
	})
	
	/////////////////部件相关/////////////////
	// 添加部件
	$("#btn-part-add").click(function(){
		if(!CURRENT_DEVICE_IMG){
			core.alertMessage("无设备图信息");
			return;
		}
		tplengine.openWinWithEdit({
			title: '添加部件',
			tpl: 'scripts/biz/imgmgr/tpl/part-add.tpl',
			data: {
				deviceImgId: CURRENT_DEVICE_IMG.id,
				x: 0,
				y: 0,
				width: DEFAULT_ITEM_WIDTH,
				height: DEFAULT_ITEM_HEIGHT
			},
			surl: 'api/part/add',
			success: function(data, $win){
				$win.dialog("close");
				addPart(data);
			},
			tplsuccess: function($win){
				// 文件上传
				/*simpleupload.simpleupload({
					$div: $win.find("#fileupload-tag"),
					attachType: "device",
					progressbar: $("#progress-bar"),
					hidFileId: "imgId"
				});*/
			}
		})
	});
	
	// 编辑部件
	$("#btn-part-edit").click(function(){
		if(!CURRENT_PART){
			core.alertMessage("无部件信息");
			return;
		}
		tplengine.openWinWithEdit({
			title: '编辑部件',
			tpl: 'scripts/biz/imgmgr/tpl/part-add.tpl',
			data: CURRENT_PART,
			surl: 'api/part/edit',
			success: function(data, $win){
				$win.dialog("close");
				// 更新部件信息
				updatePart(data);
			},
			tplsuccess: function($win){
				// 文件上传
				simpleupload.simpleupload({
					$div: $win.find("#fileupload-tag"),
					attachType: "device",
					progressbar: $("#progress-bar"),
					hidFileId: "imgId",
					defaultValue: CURRENT_PART.imgId
				});
			}
		})
	});
	
	// 删除部件
	$("#btn-part-del").click(function(){
		if(!CURRENT_PART){
			core.alertMessage("无部件信息");
			return;
		}
		$.messager.confirm('确认','确定删除当前部件？【删除后不可撤销】',function(r){
			if (r){
				core.submitAjax({
					url: "api/part/del",
					data: {
						ids: CURRENT_PART.id
					},
					success: function(data){
						removePart(CURRENT_PART);
					}
				});
			}
		});
	})
	
	// 保存设备图中部件位置大小信息
	$btnDeviceImgSave.click(function(){
		var data = [];
		$("#im-deviceimg-withdata .item-drag").each(function(){
			var item = $(this).data('data');
			data.push({
				id: item.id,
				x: item.x,
				y: item.y,
				w: item.width,
				h: item.height
			});
		});
		core.submitAjax({
			url: "api/part/updateXyWh",
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify(data),
			success: function(data){
				$btnDeviceImgSave.hide();
			}
		})
	});
	
	// 拖动事件
	function onDragPart(e){
		var d = e.data;
		var data = $(e.target).data('data');
		if (d.left < 0){d.left = 0}
		if (d.top < 0){d.top = 0}
		if (d.left + $(d.target).outerWidth() > $(d.parent).width()){
			d.left = $(d.parent).width() - $(d.target).outerWidth();
		}
		if (d.top + $(d.target).outerHeight() > $(d.parent).height()){
			d.top = $(d.parent).height() - $(d.target).outerHeight();
		}
		
		if(data){
			data.x = parseInt(d.left);
			data.y = parseInt(d.top);
			// 更新当前数据中的位置信息
			updatePartList(data);
		}
		
		$btnDeviceImgSave.show();
		
	}
	
	// 改变大小事件
	function onResizePart(e){
		var d = e.data;
		var data = $(e.target).data('data');
		if (d.left < 0){d.left = 0}
		if (d.top < 0){d.top = 0}
		var $dTarget = $(d.target);
		var $tagImg = $("#tag-img-device");
		if (d.left + $dTarget.outerWidth() > $tagImg.width()){
			$dTarget.width($tagImg.width() - d.left);
		}
		if (d.top + $dTarget.outerHeight() > $tagImg.height()){
			$dTarget.height($tagImg.height() - d.top);
		}
		
		if(data){
			data.width = $dTarget.width();
			data.height = $dTarget.height();
			// 更新当前数据中的大小信息
			updatePartList(data);
		}
		
		$btnDeviceImgSave.show();
		
	}

	////////////////部件相关////////////////////
	// 重新渲染部件列表数据
	function refreshPartItemsData(data){
		$tagItemsPart.html('');
		for(var i in data){
			var item = data[i];
			// 渲染数据
			addPart(item);
		}
	}
	
	// 添加一个部件
	function addPart(item){
		if(!item) return;
		
		// 数据
		if(!ITEMS_PART) ITEMS_PART = [];
		ITEMS_PART.splice(0, 0, item);
		
		// 列表
		// 部件信息
		$tagItemsPart.prepend(
			$('<div class="item-drag-right"></div>')
				.html(item.name)
				.attr('title', item.name)
				.prepend(
					$('<i class="fa fa-eye im-view-detail">详情</i>')
						.data('data', item)
						.click(function(){
							// 查看部件
							viewPart($(this).data('data'));
						}
				))
				.data('data', item)
				.click(function(){
					selectItemPart($(this).data('data'));
				})
		);
		
		// 图片
		var $item = $('<div class="item-drag"></div>');
		$tagImgWrapDevice.append($item);
		$item.css({
			width: item.width,
			height: item.height,
			left: item.x + 'px',
			top: item.y + 'px'
		})
		// 数据
		.data('data', item)
		.append($('<i class="item-drag-viewdetail fa fa-eye" title="详情"></i>')
				.data('data', item)
				.click(function(){
					// 查看部件
					viewPart($(this).data('data'));
				})
		)
		// 提示信息
		.tooltip({
			content: item.name 
				//+ (item.path ? ("<br/><img src='upfiles/"+ item.path + "' width=200 />") : '')
				+ "<br/>" + item.desc
				, 
			trackMouse: true})
		// 点击事件
		.click(function(){
			selectItemPart($(this).data('data'));
		});
		if(!IS_VIEW){
			// 可拖动
			$item.draggable({
				onDrag: onDragPart,
				disabled: IS_VIEW
			});
			// 可调整大小
			$item.resizable({
				maxWidth: $("#tag-img-device").width(),
				maxHeight: $("#tag-img-device").height(),
				minWidth: 20,
				minHeight: 20,
				onStopResize: onResizePart,
				disabled: IS_VIEW
			});
		}
		
	}
	
	// 移除一个部件
	function removePart(item){
		if(!item) return;
		
		// 数据
		for(var i in ITEMS_PART){
			if(ITEMS_PART[i].id == item.id){
				ITEMS_PART.splice(i, 1);
				break;
			}
		}
		
		// 列表
		$tagItemsPart.find(".item-drag-right").each(function(){
			if($(this).data('data').id == item.id){
				$(this).remove();
			}
		});
		
		// 图片
		$tagImgWrapDevice.find(".item-drag").each(function(){
			if($(this).data('data').id == item.id){
				$(this).remove();
			}
		});
		
		showCurrentItemPart();
		
	}
	
	// 更新一个部件
	function updatePart(item){
		if(!item) return;
		
		// 数据
		for(var i in ITEMS_PART){
			if(ITEMS_PART[i].id == item.id){
				ITEMS_PART[i] = item;
			}
		}
		
		// 列表
		updatePartList(item);
		
		// 图片
		$tagImgWrapDevice.find(".item-drag").each(function(){
			if($(this).data('data').id == item.id){
				$(this).data('data', item)
					.css({
						left: item.x + 'px',
						top: item.y + 'px',
						width: item.width,
						height: item.height
					})
					.tooltip({
						content: item.name 
							+ (item.path ? ("<br/><img src='upfiles/"+ item.path + "' width=200 />") : '')
							+ "<br/>" + item.desc
							, 
						trackMouse: true});;
			}
		});
	}
	// 更新列表中的对象数据
	function updatePartList(item){
		if(!item) return;
		$tagItemsPart.find(".item-drag-right").each(function(){
			if($(this).data('data').id == item.id){
				$(this).data('data', item);
			}
		});
		
		// 若当前选择对象一致，则更新显示信息
		if(CURRENT_PART && CURRENT_PART.id == item.id){
			showCurrentItemPart(item);
		}
	}
	
	// 选中某一个部件元素
	function selectItemPart(item){
		// 图片中元素
		$tagImgWrapDevice.find('.select').removeClass('select');
		$tagImgWrapDevice.find('.item-drag').each(function(){
			if($(this).data('data').id == item.id){
				$(this).addClass('select');
				return false;
			}
		});
		
		// 列表中元素
		$tagItemsPart.find('.select').removeClass('select');
		$tagItemsPart.find('.item-drag-right').each(function(){
			if($(this).data('data').id == item.id){
				$(this).addClass('select');
				return false;
			}
		});
		
		// 显示元素信息
		showCurrentItemPart(item);
	}

	// 显示当前选中元素的信息-部件
	function showCurrentItemPart(item){
		CURRENT_PART = item;
		if(item){
			$("#tag-currentpart-unselect").hide();
			$("#tag-currentpart-select").show();
			
			// 显示设备相关信息
			$("#info-part-name").html(item.name);// 名称
			$("#info-part-desc").html(item.desc);// 描述
			$("#info-part-width").html(item.width);// 宽
			$("#info-part-height").html(item.height);// 高
			$("#info-part-x").html(item.x);// x
			$("#info-part-y").html(item.y);// y
		}else{
			$("#tag-currentpart-select").hide();
			$("#tag-currentpart-unselect").show();
		}
	}
	showCurrentItemPart();
	
	/////////////////// 查看部件
	function viewPart(part){
		CURRENT_PART = part;
		changeStatePart();
		refreshPartHisInfos();
		refreshLocation();
	}
	// 初始化分页
	$('#part-pp').pagination({
		total: 0,
		pageSize: 10,
		onSelectPage: function(pageNumber, pageSize){
			refreshPartHisInfos({
				page: pageNumber,
				rows: pageSize,
				timeBegin: $("#date-begin").datebox('getValue'),
				timeEnd: $("#date-end").datebox('getValue')
			});
		}
	});
	$("#date-begin").datebox();
	$("#date-end").datebox();
	// 查询
	$("#btn-parthis-search").click(function(){
		refreshPartHisInfos({
			page: 1,
			rows: 10,
			timeBegin: $("#date-begin").datebox('getValue'),
			timeEnd: $("#date-end").datebox('getValue'),
			verifyStatus: $("select[name=verifyStatus]").val()
		});
	});
	// 添加-部件历史信息
	$("#btn-parthis-add").click(function(){
		tplengine.openWinWithEdit({
			title: '新增',
			tpl: 'scripts/biz/imgmgr/tpl/parthis-add.tpl',
			data: {
				partId: CURRENT_PART.id
			},
			surl: 'api/parthis/add',
			success: function(data, $win){
				refreshPartHisInfos();
				$win.dialog("close");
			},
			tplsuccess: function($win){
				// 文件上传
				simpleupload.simpleupload({
					$div: $win.find("#fileupload-tag"),
					attachType: "parthis",
					progressbar: $("#progress-bar"),
					hidFileId: "imgId"
				});
			}
		})
	});
	var LAST_PARAMS = null;
	// 刷新列表数据
	function refreshPartHisInfos(params){
		if(params){
			LAST_PARAMS = params;
		}else{
			params = LAST_PARAMS;
		}
		var $partList = $("#part-list");
		$partList.html('加载中...');
		
		if(!params){
			params = {
				page: 1,
				rows: 10
			}
		}
		params.partId = CURRENT_PART.id;
		
		if(IS_VIEW){// 查看只显示已审核通过
			params.verifyStatus = '1';
		}
		
		core.submitAjax({
			url: "api/parthis/list",
			type: 'get',
			data: params,
			success: function(data){
				$partList.html('');
				$('#part-pp').pagination('refresh', {
					total: data.total,
					pageNumber: params.page
				});
				for(var i in data.rows){
					var item = data.rows[i];
					var imgPath = item.path ? "upfiles/" + item.path : 'images/blank.jpg';
					var content = item.content;
					var createTime = core.transTimeStamp(item.createTime);
					var $item = $("<div class='part-his-item'></div>")
						.data('data', item)
						// 审核信息
						.append(!IS_VIEW ? '<div class="his-item-verify" title="'+ ('' + item.verifyUserDesc + '/' + core.transTimeStamp(item.verifyTime) + '/' + item.verifyContent) + '"><span class="fa fa-eye"></span>' + item.verifyStatusDesc + '</div>' : '')
						// 图片
						.append('<img class="his-item-left" src="'+ imgPath +'" />')
						.append($("<div class='his-item-center'></div>")
							// 创建时间
							.append(createTime)
							.append('<br/><br/>')
							// 描述
							.append('<span title="' + content + '">' + content + '</span>')
						)
						.append($("<div class='his-item-right'></div>")
							// 查看
							.append($('<div class="btn btn-view" href="'+ imgPath +'" title="'+ createTime +'&nbsp;&nbsp;' + content 
									+'" ><i class="fa fa-eye"></i>&nbsp;&nbsp;查看</div>').data('data', item).click(function(){
								var item = $(this).data('data');
								tplengine.openWin({
									title: '查看',
									dialogConfig: {
										maximized: true,
										minimizable: false,
										maximizable: false
									},
									tpl: 'scripts/biz/imgmgr/tpl/parthis-view.tpl',
									data: item
								})
							}))
							// 编辑
							.append(IS_VIEW ? null : $('<div class="btn btn-edit"><i class="fa fa-pencil"></i>&nbsp;&nbsp;编辑</div>').data('data', item).click(function(){
								var item = $(this).data('data');
								tplengine.openWinWithEdit({
									title: '编辑',
									tpl: 'scripts/biz/imgmgr/tpl/parthis-add.tpl',
									data: item,
									surl: 'api/parthis/edit',
									success: function(data, $win){
										refreshPartHisInfos();
										$win.dialog("close");
									},
									tplsuccess: function($win){
										// 文件上传
										simpleupload.simpleupload({
											$div: $win.find("#fileupload-tag"),
											attachType: "parthis",
											progressbar: $("#progress-bar"),
											hidFileId: "imgId",
											defaultValue: item.imgId
										});
									}
								})
							}))
							// 删除
							.append(IS_VIEW ? null : $('<div class="btn btn-danger"><i class="fa fa-remove"></i>&nbsp;&nbsp;删除</div>').data('data', item).click(function(){
								
								var item = $(this).data('data');
								$.messager.confirm('确认','确定删除?删除后不可撤销。',function(r){
									if (r){
										core.submitAjax({
											url: "api/parthis/del",
											data: {
												ids: item.id
											},
											success: function(){
												refreshPartHisInfos();
											}
										});
									}
								});
							}))
							// 审核
							.append(!IS_VERIFY ? null : $('<div class="btn btn-edit"><i class="fa fa-check"></i>&nbsp;&nbsp;审核</div>').data('data', item).click(function(){
								var item = $(this).data('data');
								verifyPartHis(item, function(srcItem){
									refreshPartHisInfos();
								});
							}))
						)
						;
					$partList.append($item);
				}
				
				// 灯箱效果
				$(".his-item-right .btn-view").lightBox({
					fixedNavigation: true,
					txtImage: '',
					txtOf: '/'
				});
			}
		});
	}
	
});
