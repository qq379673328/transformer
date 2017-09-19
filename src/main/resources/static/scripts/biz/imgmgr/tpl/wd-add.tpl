<form class="showPage">
	<input type="hidden" name="id" value="<%=data.id%>"/>
	<input type="hidden" name="transformerId" value="<%=data.transformerId%>"/>
	<table>
		<tr>
			<td class="td-odd"><font color="red">*</font>名称</td>
			<td class="td-even">
				<input name="desc"
					value="<%=data.desc%>"
					class="easyui-validatebox" data-options="required:true,validType:'maxLength[200]'" />
			</td>
		</tr>
		<tr>
			<td class="td-odd"><font color="red">*</font>接线图图片</td>
			<td class="td-even">
				<div id="fileupload-tag"></div>
				<div id="progress-bar" class="easyui-progressbar" style="width:400px;"></div>
			</td>
		</tr>
	</table>
</form>