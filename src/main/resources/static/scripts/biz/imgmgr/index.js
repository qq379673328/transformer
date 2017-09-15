"use strict";
/**
 * 编辑
 */
define(["jquery", "core", "tplengine", "simpleupload"],
	function($, core, tplengine, simpleupload) {
	
	// 调整中心区域宽度
	$(".im-center").width($(window).width() - $(".im-left").width() - $(".im-right").width());
	
	// 页面元素
	var $tagWrap = $('#tag-wrap'),// 中间图片容器
		$tagTransformers = $("#tag-transformers"),// 变电站容器
		$tagItems = $('#tag-items'),// 设备列表容器
		$tagCurrent = $('#tag-current'),// 当前选择设备
		ITEMS = []// 当前设备列表
		;
	
	// 加载左侧变电站数据
	core.submitAjax({
		url: 'api/transformer/list',
		method: 'get',
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
				
				// 默认切换第一个变电站
				if(data.length > 0){
					changeTransFormer(data[0], $tagTransformers.find(".lv3:first-child"));
				}
			}
		}
	});
	
	// 切换变电站
	function changeTransFormer(item, $tag){
		$tagTransformers.find(".lv3").removeClass("select");
		$tag.addClass("select");
		// 加载变电站的详细信息
		core.submitAjax({
			url: 'api/transformer/getDetail',
			method: 'get',
			data: {id: item.id},
			success: function(data){
				// 接线图信息
				var wgs = data.wg || [];
				// 渲染接线图列表
				$("#tag-select-wg").combobox({
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
				}
			}
		});
	}
	
	// 切换接线图
	function changeWg(item){
		// 接线图信息
		var wgId = item.id,
			wgImgId = item.imgId,
			wgDesc = item.desc,
			tfId = item.transformerId
			;
		
		// 加载接线图设备列表信息
		core.submitAjax({
			url: 'api/device/list',
			method: 'get',
			data: {transformerId: tfId, state: '01'},
			success: function(data){
				ITEMS = data;
				
				refreshItemsData();
			}
		})
	}
	
	// 拖动事件
	function onDrag(e){
		var d = e.data;
		if (d.left < 0){d.left = 0}
		if (d.top < 0){d.top = 0}
		if (d.left + $(d.target).outerWidth() > $(d.parent).width()){
			d.left = $(d.parent).width() - $(d.target).outerWidth();
		}
		if (d.top + $(d.target).outerHeight() > $(d.parent).height()){
			d.top = $(d.parent).height() - $(d.target).outerHeight();
		}
	}

	// 获取图片的原始宽高
	function getNaturalSize (Domlement) {
		var natureSize = {};
		if(window.naturalWidth && window.naturalHeight) {
		natureSize.width = Domlement.naturalWidth;
		natureSize.height = Domlement.naturalHeight;
		} else {
		var img = new Image();
		img.src = Domlement.src;
		natureSize.width = img.width;
		natureSize.height = img.height;
		}
		return natureSize;
	}

	// 加载图片
	var $imgMain = $("<img id='tag-img' />")
		.attr('src', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504864710754&di=986db691b7cf721c4df0ad2485b3101f&imgtype=0&src=http%3A%2F%2Fgbres.dfcfw.com%2FFiles%2Fpicture%2F20140420%2Fsize500%2FC9A6BCF26FE71C31D721A2E7B1A463AC.jpg')
		.css({
			position: 'absolute',
			left: '0px',
			top: '0px',
			'z-index': 1
		})
		.appendTo($tagWrap)
		.load(function(){
			// 设置容器宽高
			var imgWH = getNaturalSize(document.getElementById('tag-img'));
			$tagWrap.width(imgWH.width).height(imgWH.height);
		});
		

	// 从列表中移除指定数据
	function removeItemFromList(item){
		for(var i in ITEMS){
			if(ITEMS[i].id == item.id){
				ITEMS.splice(i, 1);
				break;
			}
		}
		refreshItemsData();
	}
	// 往列表中添加数据
	function addItemToList(item){
		ITEMS.push(item);
		refreshItemsData();
	}
	// 重新渲染列表数据
	function refreshItemsData(){
		$tagItems.html('');
		for(var i in ITEMS){
			var item = ITEMS[i];
			$tagItems.append(
				$('<div class="item-drag-right"></div>')
					.html(item.info)
					.data('data', item)
					.tooltip({content: '点击添加-' + item.info})
					.click(function(){
						$(this).tooltip('destroy');
						addOne($(this).data('data'));
					})
			);
		}
	}

	// 添加一个
	function addOne(item){
		// 从列表中移除数据
		removeItemFromList(item);

		// 单个元素
		var $item = $('<div class="item-drag"></div>');
		$tagWrap.append($item);
		$item.css({
			width: item.width,
			height: item.height,
			left: item.x,
			top: item.y
		})
		// 数据
		.data('data', item)
		// 内容
		//.html(item.info)
		// 提示信息
		.tooltip({content: item.info, trackMouse: true})
		// 划过效果
		.hover(function(){
			$(this).find('.btn-remove').show();
		}, function(){
			$(this).find('.btn-remove').hide();
		})
		// 点击事件
		.click(function(){
			selectDragItem($(this));
		})
		// 可拖动
		.draggable({
			onDrag: onDrag
		});
		// 移除按钮
		var $btnRemove = $('<div class="btn-remove">x</div>')
			.hide()
			.click(function(){
				var $item = $(this).parent('.item-drag');
				addItemToList($item.data('data'));
				$item.tooltip('destroy').remove();
			})
			.appendTo($item);
	}

	// 选中某一个元素
	function selectDragItem($tag){
		$tagWrap.find('.select').removeClass('select');
		$tag.addClass('select');
		// 显示元素信息
		showCurrentItem($tag.data('data'));
	}

	// 显示当前选中元素的信息
	function showCurrentItem(item){
		if(item){
			$tagCurrent
				.show()
				.html('')
				.append('<h1>当前选中</h1><br/>')
				.append('名称：' + item.info)
				;
		}else{
			$tagCurrent.hide();
		}
	}
	
	// 文件上传
	simpleupload.simpleupload({
		$div: $("#fileupload-tag"),
		attachType: "wg",
		filetype: ["png", "PNG", "jpg", "JPG"],
		filemax: 20 * 1024 * 1024,
		progressbar: $("#progress-bar"),
		hidFileId: "fileId"
	});
	
});
