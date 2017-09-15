/**
#################################################################
#  创建人： 王浩男													#
#  日 期： 2016年03月28日											#
#  功 能： Echart统计图表公用js										#
#  文件名： common_chart_grid.js 									#
#################################################################
*/

define(["core",
         "echarts",
		 'echarts/chart/bar',// 使用柱状图就加载bar模块，按需加载
		 'echarts/chart/line',
         'echarts/chart/pie' ], function(util,ec){
	
	//初始化列表
	function initList($listTab,$formSearch,url,columns,isPage,fitCol,frozenColumns,rownumbers,isEditor){
		var params = core.getFormData($formSearch);
		params['rows'] = 10;
		params['page'] = 1;
		
		if(isPage==undefined){
			isPage = true;
		}
		if(fitCol==undefined){
			fitCol = true;
		}
		
		if(rownumbers==undefined){
			rownumbers = false;
		}
		
		if(frozenColumns==undefined){
			frozenColumns = [];
		}
		// add by liwei 20160815 isEditor 用来判断datagrid是否要支持在线编辑功能
		if(isEditor==undefined){
			$listTab.datagrid({
				method:'POST',
				url:url,
				/*pagination:isPage,*/
				fitColumns:fitCol,
				rownumbers:rownumbers,
				loadMsg:"加载中...",
				queryParams: params,
				frozenColumns:frozenColumns,
				columns:columns
			});
		}else{
			$listTab.datagrid({
				method:'POST',
				url:url,
				/*pagination:isPage,*/
				fitColumns:fitCol,
				rownumbers:rownumbers,
				loadMsg:"加载中...",
				queryParams: params,
				frozenColumns:frozenColumns,
				columns:columns,
				onClickRow: onClickRow
			});
			//自定义函数
			function getCacheContainer(t){
				var view = $(t).closest('div.datagrid-view');
				var c = view.children('div.datagrid-editor-cache');
				if (!c.length){
					c = $('<div class="datagrid-editor-cache" style="position:absolute;display:none"></div>').appendTo(view);
				}
				return c;
			}
			function getCacheEditor(t, field){
				var c = getCacheContainer(t);
				return c.children('div.datagrid-editor-cache-' + field);
			}
			function setCacheEditor(t, field, editor){
				var c = getCacheContainer(t);
				c.children('div.datagrid-editor-cache-' + field).remove();
				var e = $('<div class="datagrid-editor-cache-' + field + '"></div>').appendTo(c);
				e.append(editor);
			}
			var editors = $.fn.datagrid.defaults.editors;
			for(var editor in editors){
				var opts = editors[editor];
				(function(){
					var init = opts.init;
					opts.init = function(container, options){
						var field = $(container).closest('td[field]').attr('field');
						var ed = getCacheEditor(container, field);
						if (ed.length){
							ed.appendTo(container);
							return ed.find('.datagrid-editable-input');
						} else {
							return init(container, options);
						}
					}
				})();
				(function(){
					var destroy = opts.destroy;
					opts.destroy = function(target){
						if ($(target).hasClass('datagrid-editable-input')){
							var field = $(target).closest('td[field]').attr('field');
							setCacheEditor(target, field, $(target).parent().children());
						} else if (destroy){
							destroy(target);
						}
					}
				})();
			}
			// 按钮jieshou fangqi 不受权限控制
			$listTab.datagrid({
				toolbar: [{
				            iconCls:'icon-baocun',
				            id:'jieshou',
				            text:'接受',
				            handler:function(){
				            	accept();
				            }
				        },{
							iconCls: 'icon-redo',
							id:'fangqi',
							text:'放弃',
							handler: function(){
								reject();
							}
						}]
			});
			// 操作相关函数
			var editIndex = undefined;
			function endEditing(){
				if (editIndex == undefined){return true}
				if ($listTab.datagrid('validateRow', editIndex)){
					//暂时没用先注释掉
					//var ed = $listTab.datagrid('getEditor', {index:editIndex,field:'KPI_NUMERATOR'});
					//var textValue = $(ed.target).combobox('getText');
					//$listTab.datagrid('getRows')[editIndex]['productname'] = textValue;
					$listTab.datagrid('endEdit', editIndex);
					editIndex = undefined;
					return true;
				} else {
					return false;
				}
			}
			function onClickRow(index){
				if (editIndex != index){
					if (endEditing()){
						$listTab.datagrid('selectRow', index)
								.datagrid('beginEdit', index);
						editIndex = index;
					} else {
						$listTab.datagrid('selectRow', editIndex);
					}
				}
			}
			function accept(){
				if (endEditing()){
					$listTab.datagrid('acceptChanges');
				}
			}
			function reject(){
				$listTab.datagrid('rejectChanges');
				editIndex = undefined;
			}
			function getChanges(){
				var rows = $listTab.datagrid('getChanges');
				alert(rows.length+' rows are changed!');
			}
		}
		
		//设置分页控件 
	    /*var p = $listTab.datagrid('getPager'); 
	    $(p).pagination({ 
	        pageSize: 10,//每页显示的记录条数，默认为10 
	        pageList: [10,20,50],//可以设置每页记录条数的列表 
	        beforePageText: '第',//页数文本框前显示的汉字 
	        afterPageText: '页    共 {pages} 页', 
	        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
	    }); */
	}
	
	//加载列表
	function loadList($listTab,$formSearch){
		$listTab.datagrid('load', core.getFormData($formSearch));
	}
	
	//重新加载列表
	function reloadList(){
		$listTab.datagrid('reload');
	}
	
	/**
	 * 动态渲染饼图表抽象函数
	 * @param datalist 
	 * @param seriesname 指标参数
	 * @param seriesvalue 指标对应值参数
	 * @param charttype  图表类型：'pie'
	 * @param titlename  图表关键标题名
	 * @param heightPx 图高度
	 */
	function renderEntityPieChart(datalist, titlename, charttype, seriesname,seriesvalue,divID,widthPx,heightPx,orient,x) {
		var legendData = [], legendRtData = [];
		var ret  = [];
		$(datalist).each(function(dIdx,dItem){
			var temp = {};
			legendRtData.push(dItem[seriesname]);
			temp['name'] = dItem[seriesname];
			temp['value'] = dItem[seriesvalue];
			ret.push(temp);
		});
		
		legendData = removeRepeatData(legendRtData);

		if(widthPx==undefined){
			widthPx = '49%';
		}
		if(heightPx==undefined){
			heightPx = '370px';
		}
		
		// 图表上面的指标显示方式-横竖
		if(orient==undefined){
			orient = 'vertical';
		}
		// 图表上面的指标显示方式-靠左 居中 靠右
		if(x==undefined){
			x = 'left';
		}
		
		//外层容器宽度
		$('#'+divID).parent().css({width: widthPx});
		//$('#'+divID).parent().css({"marginLeft":"25%"});// add by liwei 饼图居中
		//外层容器标题
		var titleDiv = $('#'+divID).parent().find('.chart_detail_title');
		if(titleDiv){
			titleDiv.html(titlename);
		}
		$('#'+divID).css({width: "100%",height:heightPx});
		if(document.getElementById(divID)!=null){
			var myChart1 = ec.init(document.getElementById(divID));
			var option = {
					color:['#76a6ef', '#1CB50B', '#B6A2DE', '#ff8a38','#10C2E0','#EAE614',  
		    	           '#E67D9E', '#AB1297', '#1278AB', '#7DAB12','#FB1B1B', '#ff6347', 
		    	           '#7b68ee', '#00fa9a', '#ffd700','#6b8e23', '#ff00ff', '#3cb371', 
		    	           '#b8860b', '#30e0e0','#acb5bc', '#596068'
		    	    ],
					title : {
						text : titleDiv?'':titlename,
						textStyle : {
							color : '#434349'
						},
						x : 'center'
					},
				    tooltip : {
				        show: false,
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient : orient,
				        x : x,
				        data:legendData
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            restore : {show: false},
				            saveAsImage : {show: true}
				        }
				    },
				    calculable : true,
				    series : [
				        {
				            name:'构成：',
				            type:'pie',
				            clockWise:true,
				            startAngle: 135,
				            /*center : ['55%', '44%'],
				            radius : ['60%', '50%'],*/
				            radius : '55%',
				            center: ['50%', '60%'],
				            itemStyle :　{
				                normal : {
				                    label : {
				                        show : true,
				                        formatter : "{b}：{d}%",
				                        textStyle : {
				                            fontSize : '14',
				                            fontFamily : '微软雅黑',
				                        },
				                    },
				                    labelLine : {
				                        show : true
				                    }
				                },
				                emphasis : {
				                    label : {
				                        show : true,
				                        position : 'center',
				                        formatter : "{b} : {c}\n\n"+"{d}%",
				                        textStyle : {
				                            color:'#596068',
				                            fontSize : '17',
				                            fontFamily : '微软雅黑',
				                            fontWeight : '400'
				                        },
				                    }
				                }
				            },
				            data:ret
				        }
				    ]
				};
			
			myChart1.setOption(option);
			
			if($('#'+divID).parents().find('.flushOpt').length>1 
					&& $('#'+divID).parents().find('.laOpt').length>1 
						&& $('#'+divID).parents().find('.suoOpt').length>1){
				$('#'+divID).parent().find('.flushOpt').unbind().bind('click',reflushOpt);
				$('#'+divID).parent().find('.laOpt').unbind().bind('click',laOpt);
				$('#'+divID).parent().find('.suoOpt').unbind().bind('click',suoOpt);
			}else{
				$('#'+divID).parents().find('.flushOpt').on('click',reflushOpt);
				$('#'+divID).parents().find('.laOpt').on('click',laOpt);
				$('#'+divID).parents().find('.suoOpt').on('click',suoOpt);
			}
			
			//刷新操作
			function reflushOpt(){
				myChart1.component.toolbox._onRestore();
			}
			
			//拉伸操作
			function laOpt(){
				$(this).parent().css({'left':'90.5%'});
				if($(this).parent().parent().attr('style')){
					$(this).parent().parent().data('style',$(this).parent().parent().attr('style'));
				}
				$(this).parent().parent().animate({top:"0px",left:"0px",width:"100%",height:"100%"},100,function(){
					$(this).css({'overflow':'hidden','z-index':9999,'position':'absolute','box-shadow':'5px 5px 5px rgba(210,210,210 ,0.5'});
					$(this).find('.laOpt img').attr('src','images/toolbar/la-01.png');
					$(this).find('.suoOpt img').attr('src','images/toolbar/suo-03.png');
					var option_new = myChart1.getOption();
					myChart1 = ec.init(document.getElementById(divID));
					myChart1.setOption(option_new);
					scrollOffset($(this).offset()); 
				});
			}
				
			//收缩操作
			function suoOpt(){
				$(this).parent().css({'left':'76.5%'});
				$(this).parent().parent().animate({top:"0px",left:"0px"},100,function(){
					$(this).removeAttr('style');
					$(this).find('.laOpt img').attr('src','images/toolbar/la-03.png');
					$(this).find('.suoOpt img').attr('src','images/toolbar/suo-01.png');
					if($(this).data('style')){
						$(this).attr('style',$(this).data('style'));
					}
					var option_new = myChart1.getOption();
					myChart1 = ec.init(document.getElementById(divID));
					myChart1.setOption(option_new);
					scrollOffset($(this).offset()); 
				});
			}
			
		}
	};
	
	
	/**
	 * 动态渲染饼图表抽象函数
	 * @param datalist 
	 * @param seriesname 指标参数
	 * @param seriesvalue 指标对应值参数
	 * @param charttype  图表类型：'pie'
	 * @param titlename  图表关键标题名
	 */
	function renderEntityPieChart_Old(datalist, titlename, charttype, seriesname,seriesvalue,divID,widthPx) {
		var legendData = [], legendRtData = [];
		var ret  = [],
			done = {
					name : '访问来源',
					type : charttype,
					radius : '52%',
					center : ['60%', '44%'],
					data : []
				   };
		
		$(datalist).each(function(dIdx,dItem){
			var temp = {};
			legendRtData.push(dItem[seriesname]);
			temp['name'] = dItem[seriesname];
			temp['value'] = dItem[seriesvalue];
			done.data.push(temp);
		});
		
		legendData = removeRepeatData(legendRtData);
		ret.push(done);

		if(widthPx==undefined){
			widthPx="49%";
		}
		//外层容器宽度
		$('#'+divID).parent().css({width: widthPx});
		//外层容器标题
		var titleDiv = $('#'+divID).parent().find('.chart_detail_title');
		if(titleDiv){
			titleDiv.html(titlename);
		}
		$('#'+divID).css({width: "100%", height:"370px"});
		if(document.getElementById(divID)!=null){
			var myChart = ec.init(document.getElementById(divID));
		    var option = {
	    		color:['#76a6ef', '#1CB50B', '#B6A2DE', '#ff8a38','#10C2E0','#EAE614',  
	    	           '#E67D9E', '#AB1297', '#1278AB', '#7DAB12','#FB1B1B', '#ff6347', 
	    	           '#7b68ee', '#00fa9a', '#ffd700','#6b8e23', '#ff00ff', '#3cb371', 
	    	           '#b8860b', '#30e0e0','#acb5bc', '#596068'
	    	    ],
				title : {
					text : titleDiv?'':titlename,
					textStyle : {
						color : '#434349'
					},
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					x : 'left',
					y : 'top',
					data : legendData
				},
				toolbox : {
					show : true,
					feature : {
						mark : {
							show : false
						},
						magicType : {
			                show: true, 
			                type: ['pie'],
			                option: {
			                    funnel: {
			                        x: '25%',
			                        width: '50%',
			                        funnelAlign: 'left',
			                        max: 1548
			                    }
			                }
			            },
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				calculable : true,
				series : ret
			};
			myChart.setOption(option);
		}
	};

	/**
	* 动态渲染折线图表抽象函数
	* @param jsonData  数据列表
	* @param xAxisName x轴指标项名: 'name'
	* @param xdw x轴指标项单位: '月'
	* @param ydw y轴指标项单位: '元'
	* @param seriesNames 统计指标项名: ['年龄','成绩']
	* @param seriesIndex 统计指标项索引: ['age','score']
	* @param $divId 渲染的目标Id
	* @param chartType 图表类型（bar、line）
	* @param title 图表标题
	* @param heightPx 图高度
	*/
	function renderMultiEntityChart(jsonData,xAxisName,seriesNames,seriesIndex,divID,chartType,titlename,titleLink,widthPx,xdw,ydw,stack,month,heightPx){
		var legendData=[],legendRtData = [],seriesData=[],xAxisData=[],
		xAxisStyle={
				value:'',
				textStyle: {
                    color: 'red',
                    fontStyle: 'normal',
                    fontWeight: 'bold',
                    fontSize:24
                  }
		};
		var xLastAxisStyle={
				value:'',
				textStyle: {
					 color: 'red',
	                 fontFamily: 'sans-serif',
	                 fontSize: 12,
	                 fontWeight: 'bold'
                  }
		};
		$(seriesIndex).each(function (sIdx, sItem) {
			var chartSeriesItem = {
	   				name:seriesNames[sIdx],
	   				type:chartType,
	   				data:[]
		   	};
			$(jsonData).each(function(dIdx,dItem){
				if(stack!=undefined){
					$(stack).each(function(n,value){
						if(value==seriesNames[sIdx]){
							chartSeriesItem['stack'] = '费用';
						}
					});
				}
				legendRtData.push(seriesNames[sIdx]);
				chartSeriesItem.data.push(dItem[sItem])
			});
			seriesData.push(chartSeriesItem);
		});
		
		legendData = removeRepeatData(legendRtData);
		
		if(xAxisName!=''){
			$(jsonData).each(function(dIdx,dItem){
				if(month!=undefined){
					if(month==dItem[xAxisName]){
						xAxisStyle.value = dItem[xAxisName];
						xAxisData.push(xAxisStyle);
					}else if(dItem[xAxisName].split(")").length>1){
						xLastAxisStyle.value = dItem[xAxisName];
						xAxisData.push(xLastAxisStyle);
					}else{
						xAxisData.push(dItem[xAxisName]?dItem[xAxisName]:xAxisName);
					}
				}else{
					xAxisData.push(dItem[xAxisName]?dItem[xAxisName]:xAxisName);
				}
			});
		}
		
		if(xdw==undefined){
			xdw='';
		}
		
		if(ydw==undefined){
			ydw='';
		}
		
		if(widthPx==undefined){
			widthPx="49%";
		}
		if(heightPx==undefined){
			heightPx="370px";
		}
		//外层容器宽度
		$('#'+divID).parent().css({width: widthPx});
		//外层容器标题
		var titleDiv = $('#'+divID).parent().find('.chart_detail_title');
		if(titleDiv){
			titleDiv.html(titlename);
		}
		$('#'+divID).css({width: "100%",height:heightPx});//height:"370px"
		
		if(document.getElementById(divID)!=null){
			var myChart2 = ec.init(document.getElementById(divID));
		    var option = {
	    		color:['#76a6ef', '#1CB50B', '#B6A2DE', '#ff8a38','#10C2E0','#EAE614',  
	    	           '#E67D9E', '#AB1297', '#1278AB', '#7DAB12','#FB1B1B', '#ff6347', 
	    	           '#7b68ee', '#00fa9a', '#ffd700','#6b8e23', '#ff00ff', '#3cb371', 
	    	           '#b8860b', '#30e0e0','#acb5bc', '#596068'
	    	    ],
				title : {
					text : titleDiv?'':titlename,
					link : titleLink,
					textStyle : {
						color : '#434349',
						fontSize: 16,
					},
					x:'center',
		    		y:'top'
				},
				tooltip : {
			        trigger: 'axis'
			    },
		        legend: {
		        	padding:[2,0,5,0],
		        	x:'center',
		        	y:'bottom',
		        	data:legendData
		        },
			    grid:{
			    	y2:83
			    },
		        toolbox: {
		            show : true,
		            feature : {
		                //mark : {show: true},
		                magicType : {show: true, type: ['line','bar','stack','tiled']},
		                restore : {show: false},
		                saveAsImage : {show: true}
		            }
		        },
		        xAxis : [{
					type : 'category',
					boundaryGap : true,
					data : xAxisData,
					axisLine : {    // 轴线
		                show: true,
		                lineStyle: {
		                    color: '#888888',
		                    type: 'solid',
		                    width: 2
		                }
		            },
					axisLabel : {
		                show:true,
		                interval: 'auto',    // {number}
		                rotate: 15,
		                margin: 8,
		                formatter: '{value}'+xdw,
		                textStyle: {
		                    color: 'blue',
		                    fontFamily: 'sans-serif',
		                    fontSize: 12,
		                    //fontStyle: 'italic',
		                    fontWeight: 'bold'
		                }
		            },
			        splitLine : {
		                show:true,
		                lineStyle: {
		                    color: '#d7dee2',
		                    type: 'dashed',
		                    width: 1
		                }
		            }
				}],
		        yAxis : [{	
		             	 	type : 'value',
		             	 	axisLine : {    // 轴线
		    	                show: true,
		    	                lineStyle: {
		    	                    color: '#d7dee2',
		    	                    type: 'dashed',
		    	                    width: 1
		    	                }
		    	            },
		             	 	axisLabel : {
				                show:true,
				                interval: 'auto',    // {number}
				                rotate: -45,
				                margin: 18,
				                formatter: '{value}'+ydw,    // Template formatter!
				                textStyle: {
				                    color: '#1e90ff',
				                    fontFamily: 'verdana',
				                    fontSize: 10,
				                    fontStyle: 'normal',
				                    //fontWeight: 'bold'
				                }
				            },
				            splitLine : {
				                show:true,
				                lineStyle: {
				                    color: '#d7dee2',
				                    type: 'dashed',
				                    width: 1
				                }
				            }
		                }],
		        series :seriesData
		    };
		    
			myChart2.setOption(option);
			
			window.onresize_2 = function () {
		    	myChart2.resize(); //使第一个图表适应
		    }
			
			if($('#'+divID).parents().find('.flushOpt').length>1 
					&& $('#'+divID).parents().find('.laOpt').length>1 
						&& $('#'+divID).parents().find('.suoOpt').length>1){
				$('#'+divID).parent().find('.flushOpt').unbind().bind('click',reflushOpt);
				$('#'+divID).parent().find('.laOpt').unbind().bind('click',laOpt);
				$('#'+divID).parent().find('.suoOpt').unbind().bind('click',suoOpt);
			}else{
				$('#'+divID).parents().find('.flushOpt').on('click',reflushOpt);
				$('#'+divID).parents().find('.laOpt').on('click',laOpt);
				$('#'+divID).parents().find('.suoOpt').on('click',suoOpt);
			}
			
			//刷新操作
			function reflushOpt(){
				myChart2.component.toolbox._onRestore();
			}
			
			//拉伸操作
			function laOpt(){
				$(this).parent().parent().animate({top:"0px",left:"0px",width:"100%",height:"100%"},100,function(){
					$(this).css({'overflow':'hidden','z-index':9999,'position':'absolute','box-shadow':'5px 5px 5px rgba(210,210,210 ,0.5'});
					$(this).find('.laOpt img').attr('src','images/toolbar/la-01.png');
					$(this).find('.suoOpt img').attr('src','images/toolbar/suo-03.png');
					$('#tt').tabs('resize',{width:'100%'});
					$('#tt_detail').tabs('resize',{width:'100%'});
					window.onresize_2();
					scrollOffset($(this).offset());
				});
			}
				
			//收缩操作
			function suoOpt(){
				$(this).parent().parent().animate({top:"0px",left:"0px"},100,function(){
					$(this).removeAttr('style');
					$(this).find('.laOpt img').attr('src','images/toolbar/la-03.png');
					$(this).find('.suoOpt img').attr('src','images/toolbar/suo-01.png');
					$('#tt').tabs('resize',{width:'100%'});
					$('#tt_detail').tabs('resize',{width:'100%'});
					window.onresize_2();
					scrollOffset($(this).offset()); 
				});
			}
		    
		}
	}
	
	/**
	* 动态渲染双坐标图表抽象函数
	* @param jsonData  数据列表
	* @param xAxisName x轴指标项名: 'name'
	* @param xdw x轴指标项单位: '月'
	* @param seriesNames1 统计指标项名: ['门诊量','住院量']
	* @param seriesIndex1 统计指标项索引: ['mzl','zyl']
	* @param yAxisIndex1 左边y轴: 0
	* @param chartType1 图表类型2
	* @param dw1 左边y轴单位
	* @param seriesNames2 统计指标项名: ['门诊费用','住院费用']
	* @param seriesIndex2 统计指标项索引: ['mzfy','zyfy']
	* @param yAxisIndex2 右边边y轴: 1
	* @param chartType2 图表类型2
	* @param dw2 右边y轴单位
	* @param $divId 渲染的目标Id
	* @param title 图表标题
	*/
	function renderMixChart(jsonData,xAxisName,seriesNames1,seriesIndex1,yAxisIndex1,chartType1,dw1,seriesNames2,seriesIndex2,yAxisIndex2,chartType2,dw2,divID,widthPx,titlename,xdw,month){
		var legendData=[],legendRtData=[],seriesData=[],xAxisData=[],
		xAxisStyle={
					value:'',
					textStyle: {
	                    color: 'red',
	                    fontStyle: 'normal',
	                    fontWeight: 'bold',
	                    fontSize:24
	                  }
				  };
		 var xLastAxisStyle={
					value:'',
					textStyle: {
						 color: 'red',
		                 fontFamily: 'sans-serif',
		                 fontSize: 12,
		                 fontWeight: 'bold'
	                  }
			};
		$(seriesIndex1).each(function (sIdx, sItem) {
			var chartSeriesItem1 = {
	   				name:seriesNames1[sIdx],
	   				type:chartType1,
	   				yAxisIndex:yAxisIndex1,
	   				data:[]
		   	};
			$(jsonData).each(function(dIdx,dItem){
				legendRtData.push(seriesNames1[sIdx]);
				chartSeriesItem1.data.push(dItem[sItem])
			});
			seriesData.push(chartSeriesItem1);
		});
		
		$(seriesIndex2).each(function (sIdx, sItem) {
			var chartSeriesItem2 = {
	   				name:seriesNames2[sIdx],
	   				type:chartType2,
	   				yAxisIndex:yAxisIndex2,
	   				data:[]
		   	};
			$(jsonData).each(function(dIdx,dItem){
				legendRtData.push(seriesNames2[sIdx]);
				chartSeriesItem2.data.push(dItem[sItem])
			});
			seriesData.push(chartSeriesItem2);
		});
		
		legendData = removeRepeatData(legendRtData);
		
		if(xAxisName!=''){
			$(jsonData).each(function(dIdx,dItem){
				if(month!=undefined){
					if(month==dItem[xAxisName]){
						xAxisStyle.value = dItem[xAxisName];
						xAxisData.push(xAxisStyle);
					}else if(dItem[xAxisName].split(")").length>1){
						xLastAxisStyle.value = dItem[xAxisName];
						xAxisData.push(xLastAxisStyle);
					}else{
						xAxisData.push(dItem[xAxisName]?dItem[xAxisName]:xAxisName);
					}
				}else{
					xAxisData.push(dItem[xAxisName]?dItem[xAxisName]:xAxisName);
				}
			});
		}
		
		if(xdw==undefined){
			xdw='';
		}
		
		if(widthPx==undefined){
			widthPx="49%";
		}
		//外层容器宽度
		$('#'+divID).parent().css({width: widthPx});
		//外层容器标题
		var titleDiv = $('#'+divID).parent().find('.chart_detail_title');
		if(titleDiv){
			titleDiv.html(titlename);
		}
		$('#'+divID).css({width: "100%", height:"370px"});
		if(document.getElementById(divID)!=null){
			var myChart3 = ec.init(document.getElementById(divID));
		    var option = {
	    		color:['#76a6ef', '#1CB50B', '#B6A2DE', '#ff8a38','#10C2E0','#EAE614',  
	    	           '#E67D9E', '#AB1297', '#1278AB', '#7DAB12','#FB1B1B', '#ff6347', 
	    	           '#7b68ee', '#00fa9a', '#ffd700','#6b8e23', '#ff00ff', '#3cb371', 
	    	           '#b8860b', '#30e0e0','#acb5bc', '#596068'
	    	    ],
				title : {
					text : titleDiv?'':titlename,
								//link : titleLink,
								textStyle : {
									color : '#434349',
									fontSize: 16,
								},
								x:'center',
					    		y:'top'
							},
						    tooltip : {
						        trigger: 'axis'
						    },
						    grid:{
						    	y2:83
						    },
						    legend: {
						    	data:legendData,
						        x:'center',
					        	y:'bottom',
					        	padding:[2,0,5,0]
						    },
						    toolbox: {
						        show : true,
						        feature : {
						            //mark : {show: true},
						            //dataView : {show: true},
						            magicType : {show: true, type: ['line', 'bar']},
						            restore : {show: false},
						            saveAsImage : {show: true}
						        }
						    },
						    xAxis : [
						        {
						            type : 'category',
						            position: 'bottom',
						            boundaryGap: true,
						            axisLine : {    // 轴线
						                show: true,
						                lineStyle: {
						                    color: '#888888',
						                    type: 'solid',
						                    width: 2
						                }
						            },
						            axisLabel : {
						                show:true,
						                interval: 'auto',    // {number}
						                rotate: 15,
						                margin: 8,
						                formatter: '{value}'+xdw,
						                textStyle: {
						                    color: 'blue',
						                    fontFamily: 'sans-serif',
						                    fontSize: 12,
						                    //fontStyle: 'italic',
						                    fontWeight: 'bold'
						                }
						            },
						            splitLine : {
						                show:true,
						                lineStyle: {
						                    color: '#d7dee2',
						                    type: 'dashed',
						                    width: 1
						                }
						            },
						            data : xAxisData
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value',
						            position: 'left',
						            boundaryGap: [0,0.1],
						            axisLine : {    // 轴线
						                show: true,
						                lineStyle: {
						                    color: '#d7dee2',
						                    width: 1,
						                    type:'dashed'
						                }
						            },
						            axisTick : {    // 轴标记
						                show:false,
						                length: 10,
						                lineStyle: {
						                    color: 'green',
						                    type: 'solid',
						                    width: 2
						                }
						            },
						            axisLabel : {
						                show:true,
						                interval: 'auto',    // {number}
						                rotate: -45,
						                margin: 18,
						                formatter: '{value}'+dw1,    // Template formatter!
						                textStyle: {
						                    color: '#1e90ff',
						                    fontFamily: 'verdana',
						                    fontSize: 10,
						                    fontStyle: 'normal',
						                    //fontWeight: 'bold'
						                }
						            },
						            splitLine : {
						                show:true,
						                lineStyle: {
						                    color: '#d7dee2',
						                    type: 'dashed',
						                    width: 1
						                }
						            }
						        },
						        {
						        	type: 'value',
						            splitNumber: 10,
						            axisLabel : {
						            	rotate: 40,
						            	textStyle: {
						                    color: '#1e90ff',
						                    fontFamily: 'verdana',
						                    fontSize: 10,
						                    fontStyle: 'normal',
						                    //fontWeight: 'bold'
						                },
						                formatter: function (value) {
						                	return value + dw2
						                }
						            },
						            splitLine : {
						                show: false
						            },
						            axisLine : {    // 轴线
						                show: true,
						                lineStyle: {
						                    color: '#d7dee2',
						                    width: 1,
						                    type:'dashed'
						                }
						            }
						        }
						    ],
						    series : seriesData
						};
		    
			myChart3.setOption(option);
			
			window.onresize_3 = function () {
		    	myChart3.resize();
		    }
			
			if($('#'+divID).parents().find('.flushOpt').length>1 
					&& $('#'+divID).parents().find('.laOpt').length>1 
						&& $('#'+divID).parents().find('.suoOpt').length>1){
				$('#'+divID).parent().find('.flushOpt').unbind().bind('click',reflushOpt);
				$('#'+divID).parent().find('.laOpt').unbind().bind('click',laOpt);
				$('#'+divID).parent().find('.suoOpt').unbind().bind('click',suoOpt);
			}else{
				$('#'+divID).parents().find('.flushOpt').on('click',reflushOpt);
				$('#'+divID).parents().find('.laOpt').on('click',laOpt);
				$('#'+divID).parents().find('.suoOpt').on('click',suoOpt);
			}
			
			//刷新操作
			function reflushOpt(){
				myChart3.component.toolbox._onRestore();
			}
			
			//拉伸操作
			function laOpt(){
				$(this).parent().parent().animate({top:"0px",left:"0px",width:"100%",height:"100%"},100,function(){
					$(this).css({'overflow':'hidden','z-index':9999,'position':'absolute','box-shadow':'5px 5px 5px rgba(210,210,210 ,0.5'});
					$(this).find('.laOpt img').attr('src','images/toolbar/la-01.png');
					$(this).find('.suoOpt img').attr('src','images/toolbar/suo-03.png');
					$('#tt').tabs('resize',{width:'100%'});
					$('#tt_detail').tabs('resize',{width:'100%'});
					window.onresize_3();
					scrollOffset($(this).offset()); 
				});
			}
				
			//收缩操作
			function suoOpt(){
				$(this).parent().parent().animate({top:"0px",left:"0px"},100,function(){
					$(this).removeAttr('style');
					$(this).find('.laOpt img').attr('src','images/toolbar/la-03.png');
					$(this).find('.suoOpt img').attr('src','images/toolbar/suo-01.png');
					$('#tt').tabs('resize',{width:'100%'});
					$('#tt_detail').tabs('resize',{width:'100%'});
					window.onresize_3();
					scrollOffset($(this).offset()); 
				});
			}
			
		}
	}
	
	/**
	* 雷达图函数
	* @param datalist 后台数据
	* @param divID  div的ID
	* @param width 父窗口的宽度百分比
	* @param widthPx 父窗口的高度
	* @param titlename 标题
	* @param subtext 子标题
	*/
	function renderRadarChart(datalist,divID,width,heightPx,title,subTitle){
		$('#'+divID).parent().css({width: width});
		/*var titleDiv = $('#'+divID).parent().find('.chart_detail_title');
		if(titleDiv){
			titleDiv.html(title);
		}*/
		$('#'+divID).css({width:width,height:heightPx});
		// 给雷达图中的指标赋值
		var indicator = [],zbData = [];
		var temp_data = {};
		temp_data['value'] = [];
		$(datalist).each(function(name,value){
			var temp_zb = {};
			temp_zb['text'] = value.KPI_NAME;
			indicator.push(temp_zb);
			temp_data['value'].push(value.KPI_SQL);
		});
		temp_data['name'] = '重点指标';
		zbData.push(temp_data);
		if(document.getElementById(divID)!=null){
			var myChart_randar = ec.init(document.getElementById(divID));
			var zbSort = ['重点指标'];//'张医生','李医生'
			/*var indicator = [
		                {text : '挂号次数'},//, max  : 100
		                {text : '化验次数'},//, max  : 100
		                {text : '麻醉次数'},//, max  : 100
		                {text : '手术次数'},//, max  : 100
		                {text : '彩超次数'},//, max  : 100
		                {text : '其他'}//, max  : 100
		            ];*/
			/*var zbData = [
		                {
		                    value : [200, 42, 88, 94, 90, 86],
		                	name : '重点指标'
		                },
		                {
		                    value : [97, 32, 74, 95, 88, 92],
		                    name : '重点指标'
		                }
		            ];*/
			var option = {
					color:['#76a6ef', '#1CB50B', '#B6A2DE', '#ff8a38','#10C2E0','#EAE614',  
		    	           '#E67D9E', '#AB1297', '#1278AB', '#7DAB12','#FB1B1B', '#ff6347', 
		    	           '#7b68ee', '#00fa9a', '#ffd700','#6b8e23', '#ff00ff', '#3cb371', 
		    	           '#b8860b', '#30e0e0','#acb5bc', '#596068'
		    	    ],
				    title : {
				        text: title,
				        subtext: subTitle
				    },
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        x : 'center',
				        data:zbSort
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
				    calculable : true,
				    polar : [
				        {
				            indicator : indicator,
				            radius : 200
				        }
				    ],
				    series : [
				        {
				            name: '重点指标数据',
				            type: 'radar',
				            itemStyle: {
				                normal: {
				                    areaStyle: {
				                        type: 'default'
				                    }
				                }
				            },
				            data : zbData
				        }
				    ]
				};
			myChart_randar.setOption(option);
			
			window.onresize_3 = function () {
				myChart_randar.resize();
		    }
			
			if($('#'+divID).parents().find('.flushOpt').length>1 
					&& $('#'+divID).parents().find('.laOpt').length>1 
						&& $('#'+divID).parents().find('.suoOpt').length>1){
				$('#'+divID).parent().find('.flushOpt').unbind().bind('click',reflushOpt);
				$('#'+divID).parent().find('.laOpt').unbind().bind('click',laOpt);
				$('#'+divID).parent().find('.suoOpt').unbind().bind('click',suoOpt);
			}else{
				$('#'+divID).parents().find('.flushOpt').on('click',reflushOpt);
				$('#'+divID).parents().find('.laOpt').on('click',laOpt);
				$('#'+divID).parents().find('.suoOpt').on('click',suoOpt);
			}
			
			//刷新操作
			function reflushOpt(){
				myChart_randar.component.toolbox._onRestore();
			}
			
			//拉伸操作
			function laOpt(){
				$(this).parent().parent().animate({top:"0px",left:"0px",width:"100%",height:"100%"},100,function(){
					$(this).css({'overflow':'hidden','z-index':9999,'position':'absolute','box-shadow':'5px 5px 5px rgba(210,210,210 ,0.5'});
					$(this).find('.laOpt img').attr('src','images/toolbar/la-01.png');
					$(this).find('.suoOpt img').attr('src','images/toolbar/suo-03.png');
					$('#tt').tabs('resize',{width:'100%'});
					$('#tt_detail').tabs('resize',{width:'100%'});
					window.onresize_3();
					scrollOffset($(this).offset()); 
				});
			}
				
			//收缩操作
			function suoOpt(){
				$(this).parent().parent().animate({top:"0px",left:"0px"},100,function(){
					$(this).removeAttr('style');
					$(this).find('.laOpt img').attr('src','images/toolbar/la-03.png');
					$(this).find('.suoOpt img').attr('src','images/toolbar/suo-01.png');
					$('#tt').tabs('resize',{width:'100%'});
					$('#tt_detail').tabs('resize',{width:'100%'});
					window.onresize_3();
					scrollOffset($(this).offset()); 
				});
			}
			
		}
	}
	
	// 去除数据中重复数据
	function removeRepeatData(ar) {
		var m = [], f;
		for (var i = 0; i < ar.length; i++) {
			f = true;
			for (var j = 0; j < m.length; j++)
				if (ar[i] === m[j]) {
					f = false;
					break;
				}
			;
			if (f)
				m.push(ar[i])
		}
		return m;
		/*return m.sort(function(a, b) {
			return a - b
		});*/
	}
	
	function scrollOffset(scroll_offset) {
	    $("body,html").animate({
	      scrollTop: scroll_offset.top - 70
	    }, 0);
	}
	
    return {
    	loadListData:initList,
    	loadList:loadList,
    	loadBarChart:renderMultiEntityChart,
    	loadPieChart:renderEntityPieChart,
    	loadMixChart:renderMixChart,
    	loadRadarChart:renderRadarChart
    };
});