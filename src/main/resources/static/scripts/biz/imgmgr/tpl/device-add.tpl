<form class="showPage">
	<input type="hidden" name="id" value="<%=data.id%>"/>
	<input type="hidden" name="wiringdiagramId" value="<%=data.wiringdiagramId%>"/>
	<table>
		<tr>
			<td class="td-odd"><font color="red">*</font>名称</td>
			<td class="td-even">
				<input name="name"
					value="<%=data.name%>"
					class="easyui-validatebox" data-options="required:true,validType:'maxLength[200]'" />
			</td>
		</tr>
		<tr>
			<td class="td-odd">类型</td>
			<td class="td-even">
				<select name="typeId">
					<option value="1">变压器</option>
				</select>
			</td>
		</tr>
		<tr>
			<td class="td-odd"><font color="red">*</font>坐标：</td>
			<td class="td-even">
				x:
				<input name="x"
					value="<%=data.x%>"
					class="easyui-validatebox" data-options="required:true,validType:'digits'" />
				y:
				<input name="y"
					value="<%=data.y%>"
					class="easyui-validatebox" data-options="required:true,validType:'digits'" />
			</td>
		</tr>
		<tr>
			<td class="td-odd"><font color="red">*</font>大小：</td>
			<td class="td-even">
				宽:
				<input name="width"
					value="<%=data.width%>"
					class="easyui-validatebox" data-options="required:true,validType:'digits'" />
				高:
				<input name="height"
					value="<%=data.height%>"
					class="easyui-validatebox" data-options="required:true,validType:'digits'" />
			</td>
		</tr>
		<tr>
			<td class="td-odd">描述</td>
			<td class="td-even">
				<textarea name="desc"
					rows=5
					cols=60
					class="easyui-validatebox" data-options="validType:'maxLength[500]'"><%=data.desc%></textarea>
			</td>
		</tr>
		<tr>
			<td class="td-odd">设备图片</td>
			<td class="td-even">
				<div id="fileupload-tag"></div>
				<div id="progress-bar" class="easyui-progressbar" style="width:400px;"></div>
			</td>
		</tr>
	</table>
</form>