<form class="des-survey-eidtwin" method="post">
	<input type="hidden" name="id" value="<%=data.id%>"/>
	<table class="showPage">
		<tr>
			<td class="td-odd">模块</td>
			<td class="td-even"><%=data.moduleDesc%></td>
		</tr>
		<tr>
			<td class="td-odd">描述</td>
			<td class="td-even"><%=data.key%></td>
		</tr>
		<tr>
			<td class="td-odd"><font color="red">*</font>内容</td>
			<td class="td-even">
				<%if(data.type == '1'){%>
					<textarea rows="20" cols="100" name="content" wrap="hard"><%=data.content%></textarea>
				<%}else if(data.type == '2'){%>
					<div id="fileupload-tag"></div>
					<div id="progress-bar" class="easyui-progressbar" style="width:400px;"></div>
				<%}%>
			</td>
		</tr>
	</table>
</form>