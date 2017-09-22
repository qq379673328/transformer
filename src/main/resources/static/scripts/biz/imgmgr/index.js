"use strict";
/**
 * 编辑
 */
define(["jquery", "core", "tplengine", "simpleupload"],
	function($, core, tplengine, simpleupload) {
	
	// 调整中心区域宽度
	$(".im-center").width($(window).width() - $(".im-left").width() - $(".im-right").width() - 2);
	
	// 页面元素
	var $tagImgWrap = $('#tag-wrap'),// 中间图片容器
		$tagTransformers = $("#tag-transformers"),// 变电站容器
		$tagItems = $('#tag-items'),// 设备列表容器
		ITEMS = [],// 当前设备列表
		CURRENT_TRANSFORMER = null,// 当前变电站
		CURRENT_WD = null,// 当前接线图
		CURRENT_DEVICE = null// 当前选中设备
		;
	
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
								.html(item.name)
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
		CURRENT_TRANSFORMER = item;
		
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
					// 默认显示第一个
					if(wgs.length > 0){
						$("#tag-select-wg").combobox('setValue', wgs[0].id);
						// 切换接线图
						changeWg(wgs[0]);
					}else{
						changeWg();
					}
				}
			});
		}else{// 无变电站
			changeWg();
		}
	}
	
	// 切换接线图
	function changeWg(item){
		CURRENT_WD = item;
		
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
			$("#tag-img-info-nodata").hide();
			$("#tag-img-info-withdata").show();
			$("#wd-info-uploadTime").html(core.transTimeStamp(wgUploadTime));
			$("#wd-info-user").html(wgUploadUser);
			$("#wd-info-desc").html(wgDesc);
			
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
					'z-index': 1,
					'border-left': '1px solid #000',
					'border-right': '1px solid #000'
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
				transformerId: CURRENT_TRANSFORMER.id
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
					filetype: ["png", "PNG", "jpg", "JPG"],
					filemax: 20 * 1024 * 1024,
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
					filetype: ["png", "PNG", "jpg", "JPG"],
					filemax: 20 * 1024 * 1024,
					progressbar: $("#progress-bar"),
					hidFileId: "imgId",
					defaultValue: CURRENT_WD.imgId
				});
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
				wiringdiagramId: CURRENT_WD.id
			},
			surl: 'api/device/add',
			success: function(data, $win){
				$win.dialog("close");
				addDevice(data);
			},
			tplsuccess: function($win){
				// 文件上传
				simpleupload.simpleupload({
					$div: $win.find("#fileupload-tag"),
					attachType: "device",
					filetype: ["png", "PNG", "jpg", "JPG"],
					filemax: 20 * 1024 * 1024,
					progressbar: $("#progress-bar"),
					hidFileId: "imgId"
				});
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
					filetype: ["png", "PNG", "jpg", "JPG"],
					filemax: 20 * 1024 * 1024,
					progressbar: $("#progress-bar"),
					hidFileId: "imgId",
					defaultValue: CURRENT_WD.imgId
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
						delDevice(CURRENT_DEVICE);
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
			data.x = d.left;
			data.y = d.top;
			// 更新当前数据中的位置信息
			updateDeviceList(data);
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
		$tagItems.prepend(
			$('<div class="item-drag-right"></div>')
				.html(item.name)
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
		// 数据
		.data('data', item)
		// 提示信息
		.tooltip({content: item.name, trackMouse: true})
		// 点击事件
		.click(function(){
			selectItem($(this).data('data'));
		})
		// 可拖动
		.draggable({
			onDrag: onDrag
		})
		// 可调整大小
		.resizable({
			maxWidth: $("#tag-img").width(),
			maxHeight: $("#tag-img").height(),
			onStopResize: onResize
		})
		;
	}
	
	// 移除一个设备
	function removeDevice(item){
		if(!item) return;
		
		// 数据
		for(var i in ITEMS){
			if(ITEMS[i].id == item.id){
				ITEMS.splic(i, 1);
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
				$(this).data('data', item);
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
	
});
