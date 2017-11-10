/**
 * 系统配置-参数配置
 */
define(["core", "tplengine", "simpleupload"], 
		function(core, tplengine, simpleupload){
	
	/**
	 * 页面元素
	 */
	var $listTab = $("#list-tab")//查询列表
		;
	
	/**
	 * 页面初始化
	 */
	//加载列表
	initList();
	
	//重新加载列表
	function reloadList(){
		$listTab.datagrid('reload');
	}
	
	/**
	 * 事件绑定
	 */
	// 根据idx获取行数据
	function getRowByIdx(idx){
		return $listTab.datagrid("getData").rows[idx];
	}
	
	/**
	 * 方法声明
	 */
	//初始化列表
	function initList(){
		$listTab.datagrid({
			url: 'api/system/config/list',
			pagination: false,
			loadFilter: function(data){
				return {rows: core.handleAjaxResultData(data)};
			},
			columns: [[
				{field: "id", hidden:true},
				{field: "moduleDesc", title: "模块", width: 100},
				{field: "key", title: "描述", width: 100},
				{field: "type", title: "类型", width: 100, formatter: function(val, row){
					if(val == '1'){
						return '文字';
					}else if(val == '2'){
						return '图片';
					}
				}},
				{field: "content", title: "内容", width: 800, formatter: function(val, row){
					if(row.type == '1'){
						return val;
					}else if(row.type == '2'){
						var srcPath = 'upfiles/' + row.filePath;
						return '<img width="100" src="' + srcPath + '" />';
					}
				}},
				{field: "HD", title: "操作", width: 100, formatter: function(val, row, idx){
					var ret = '';
					if(core.hasPermission('system_mgr_config_params_edit'))
						ret += '<a onclick="APP.P.edit(' + idx + ');" title="编辑" class="grid-icon"><span class="fa fa-edit"></span><span>编辑</span></a>';
					return ret;
				}}
			]]
		});
		
	}
	
	/*编辑*/
	var addEditConfig = {
		tpl: "scripts/biz/system/config/tpl/edit.tpl",
		dialogConfig:{
			width: 500
		},
		type: "1",
		success: function(data, $win){
			reloadList();
			$win.dialog("destroy");
		}
	};
	
	//编辑
	APP.P.edit = function(idx){
		var data = getRowByIdx(idx);
		var config = $.extend({}, addEditConfig, {
			title: "编辑配置信息",
			surl: "api/system/config/edit",
			data: data
		});
		if(data.type == '2'){// 图片
			config.tplsuccess = function($win){
				// 文件上传
				simpleupload.simpleupload({
					$div: $win.find("#fileupload-tag"),
					attachType: "wg",
					progressbar: $("#progress-bar"),
					hidFileId: "content",
					defaultValue: data.content
				});
			}
		}
		tplengine.openWinWithEdit(config);
	};
	
});
