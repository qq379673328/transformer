<form class="showPage">
	<input type="hidden" name="id" value="<%=data.id%>"/>
	<input type="hidden" name="partId" value="<%=data.partId%>"/>
	<table>
		<tr>
			<td class="td-odd">内容</td>
			<td class="td-even">
				<textarea name="content"
					rows=5
					cols=60
					class="easyui-validatebox" data-options="validType:'maxLength[500]'"><%=data.content%></textarea>
			</td>
		</tr>
		<tr>
			<td class="td-odd">图片</td>
			<td class="td-even">
				<div id="fileupload-tag"></div>
				<div id="progress-bar" class="easyui-progressbar" style="width:400px;"></div>
			</td>
		</tr>
	</table>
</form>