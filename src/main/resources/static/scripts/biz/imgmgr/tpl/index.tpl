<div class="im">

	<div class="im-left">
		<div id="tag-transformers"></div>
	</div>
	
	<div class="im-center" id="im-transformer-nodata">
		无变电站信息
	</div>
	<div class="im-center" id="im-transformer-withdata">
		<div class="im-center-title">
			<b>接线图：</b>
			<input id="tag-select-wg"/>
			
			<div id="btn-wd-add" class="fa fa-plus btn btn-add">&nbsp;&nbsp;添加接线图</div>
			
		</div>
		
		<div id="im-wg-withdata">
			<div id="tag-wrap"
				class="img-wrap"
				style="position: relative; float: left;"></div>
		</div>
		<div id="im-wg-nodata" class="align-center margin">
			无接线图信息，请点击【添加接线图】按钮添加。
		</div>
	</div>
	
	
	<div class="im-right">
		
		<div id="tag-img-info" style="background-color: orange; padding: 10px;">
			<h1>接线图信息</h1>
			<div id="tag-img-info-nodata">
				未选择
			</div>
			<div id="tag-img-info-withdata">
				<div>
					<span class="btn fa fa-plus" id="btn-wd-edit">&nbsp;&nbsp;编辑</span>
					&nbsp;&nbsp;<span class="btn btn-danger fa fa-remove" id="btn-wd-del">&nbsp;&nbsp;删除</span>
				</div>
				<b>上传时间：</b>
				<br/>
				<span id="wd-info-uploadTime"></span>
				<br/>
				
				<b>上传用户：</b>
				<br/>
				<span id="wd-info-user"></span>
				<br/>
				
				<b>接线图说明：</b>
				<br/>
				<span id="wd-info-desc"></span>
			</div>
		</div>
		
		<div style="background-color: #4edeb0; padding: 10px;">
			<h1>当前设备</h1>
			<div id="tag-currentdevice-unselect">
				未选择
			</div>
			<div id="tag-currentdevice-select">
				<span class="btn btn-edit fa fa-plus" id="btn-device-edit">&nbsp;&nbsp;编辑</span>
				&nbsp;&nbsp;<span class="btn btn-danger fa fa-plus" id="btn-device-del">&nbsp;&nbsp;删除</span>
				<div>
					<b>设备名：</b><span id="info-device-name"></span>
					<b>描述：</b><span id="info-device-desc"></span>
				</div>
			</div>
		</div>

		<div style="background-color: #ffbf49; padding: 10px;">
			<h1>设备列表</h1>
			<div id="tag-wg-nodata">
				未选择
			</div>
			<div id="tag-wg-withdata">
				<span class="btn btn-add fa fa-plus" id="btn-device-add">&nbsp;&nbsp;添加</span>
				<div id="tag-items"></div>
			</div>
		</div>

	</div>
</div>
