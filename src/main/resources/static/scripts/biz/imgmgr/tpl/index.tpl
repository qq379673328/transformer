<div class="im">
	
	<div class="im-left">
		<div id="tag-transformers"></div>
	</div>
	<div class="im-location">
		<i class="fa fa-map-marker"></i>&nbsp;&nbsp;当前选择：<span id="tag-location-infos"></span>
	</div>
	<div id="zone-transformer">
		<div class="im-center" id="im-transformer-nodata">
			无变电站信息
		</div>
		<div class="im-center" id="im-transformer-withdata">
			<div></div>
		
			<div class="im-center-title">
				<b>接线图：</b>
				<input id="tag-select-wg"/>
				
				<div id="btn-wd-add" class="fa fa-plus btn btn-add">&nbsp;&nbsp;添加接线图</div>
				<div id="btn-wd-save" class="fa fa-save btn btn-save hide float-left">&nbsp;&nbsp;保存</div>
				
			</div>
			
			<div id="im-wg-withdata">
				<div id="tag-wrap"
					class="img-wrap"
					style="position: relative; margin: 0 auto;"></div>
			</div>
			<div id="im-wg-nodata" class="align-center margin">
				无接线图信息
			</div>
			<div class="im-center-title">&nbsp;</div>
		</div>
		
		<div class="im-right">
			
			<div id="tag-img-info">
				<h1><i class="fa fa-photo"></i>&nbsp;接线图</h1>
				<div id="tag-img-info-nodata">
					未选择
				</div>
				<div id="tag-img-info-withdata">
					<div>
						<span class="btn btn-edit fa fa-pencil" id="btn-wd-edit">&nbsp;&nbsp;编辑</span>
						&nbsp;&nbsp;<span class="btn btn-danger fa fa-remove" id="btn-wd-del">&nbsp;&nbsp;删除</span>
					</div>
					<b>上传时间：</b>
					<span id="wd-info-uploadTime"></span>
					<br/>
					
					<b>上传用户：</b>
					<span id="wd-info-user"></span>
					<br/>
					
					<b>接线图说明：</b>
					<br/>
					<span id="wd-info-desc"></span>
				</div>
			</div>
			
			<div>
				<h1><i class="fa fa-cube"></i>&nbsp;当前设备</h1>
				<div id="tag-currentdevice-unselect">
					未选择
				</div>
				<div id="tag-currentdevice-select">
					<span class="btn btn-edit fa fa-pencil" id="btn-device-edit">&nbsp;&nbsp;编辑</span>
					&nbsp;&nbsp;<span class="btn btn-danger fa fa-remove" id="btn-device-del">&nbsp;&nbsp;删除</span>
					<div>
						<b>设备名：</b><span id="info-device-name"></span><br/>
						<b>描述：</b><span id="info-device-desc"></span><br/>
						<span class="label">大小</span>
						<b>宽：</b><span id="info-device-width"></span>&nbsp;&nbsp;
						<b>高：</b><span id="info-device-height"></span><br/>
						<span class="label">位置</span>
						<b>X：</b><span id="info-device-x"></span>&nbsp;&nbsp;
						<b>Y：</b><span id="info-device-y"></span>
					</div>
				</div>
			</div>
	
			<div>
				<h1><i class="fa fa-list"></i>&nbsp;设备列表</h1>
				<div id="tag-wg-nodata">
					未选择
				</div>
				<div id="tag-wg-withdata">
					<span class="btn btn-add fa fa-plus" id="btn-device-add">&nbsp;&nbsp;添加设备</span>
					<div id="tag-items"></div>
				</div>
			</div>
	
		</div>
	</div>
	
	<div id="zone-device" style="display: none;">
	
		<div class="im-center">
			<div class="btn btn-back" id="btn-back-device"><i class="fa fa-reply"></i>&nbsp;&nbsp;返回</div>
			<div class="im-center-title">
				<b>设备图：</b>
				<input id="tag-select-device"/>
				
				<div id="btn-deviceimg-add" class="fa fa-plus btn btn-add">&nbsp;&nbsp;添加设备图</div>
				<div id="btn-deviceimg-save" class="fa fa-save btn btn-save hide float-left">&nbsp;&nbsp;保存</div>
				
			</div>
			
			<div id="im-deviceimg-withdata">
				<div id="tag-wrap-device"
					class="img-wrap"
					style="position: relative; margin: 0 auto;"></div>
			</div>
			<div id="im-deviceimg-nodata" class="align-center margin">
				无设备图信息
			</div>
			<div class="im-center-title">&nbsp;</div>
		</div>
		
		<div class="im-right">
			
			<div id="tag-img-info-device">
				<h1><i class="fa fa-photo"></i>&nbsp;设备图</h1>
				<div id="tag-img-info-device-nodata">
					未选择
				</div>
				<div id="tag-img-info-device-withdata">
					<b>上传时间：</b>
					<span id="wd-info-device-uploadTime"></span>
					<br/>
					
					<b>上传用户：</b>
					<span id="wd-info-device-user"></span>
					<br/>
					
					<b>设备图说明：</b>
					<br/>
					<span id="wd-info-device-desc"></span>
				</div>
			</div>
			
			<div>
				<h1><i class="fa fa-cube"></i>&nbsp;当前部件</h1>
				<div id="tag-currentpart-unselect">
					未选择
				</div>
				<div id="tag-currentpart-select">
					<span class="btn btn-edit fa fa-pencil" id="btn-part-edit">&nbsp;&nbsp;编辑</span>
					&nbsp;&nbsp;<span class="btn btn-danger fa fa-remove" id="btn-part-del">&nbsp;&nbsp;删除</span>
					<div>
						<b>部件名：</b><span id="info-part-name"></span><br/>
						<b>描述：</b><span id="info-part-desc"></span><br/>
						<span class="label">大小</span>
						<b>宽：</b><span id="info-part-width"></span>&nbsp;&nbsp;
						<b>高：</b><span id="info-part-height"></span><br/>
						<span class="label">位置</span>
						<b>X：</b><span id="info-part-x"></span>&nbsp;&nbsp;
						<b>Y：</b><span id="info-part-y"></span>
					</div>
				</div>
			</div>
	
			<div>
				<h1><i class="fa fa-list"></i>&nbsp;部件列表</h1>
				<div>
					<span class="btn btn-add fa fa-plus" id="btn-part-add">&nbsp;&nbsp;添加部件</span>
					<div id="tag-items-part"></div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="zone-part" style="display: none;">
		
		<div class="im-center">
			<div class="btn btn-back" id="btn-back-part"><i class="fa fa-reply"></i>&nbsp;&nbsp;返回</div>
			<div>
				上传日期：
				<input id="date-begin" />
				至
				<input id="date-end" />
				
				<div class="btn btn-search" id="btn-parthis-search">查询</div>
				<div class="btn btn-add" id="btn-parthis-add">添加</div>
			</div>
			
			<div id="part-pp" style="background:#efefef;border:1px solid #ccc;"></div>
			<div id="part-list"></div>
		
		</div>
			
	</div>
	
</div>

