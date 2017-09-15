<form class="des-survey-eidtwin" method="post">
	<input type="hidden" name="id" value="<%=data.id%>"/>
	<table class="showPage">
		<tr>
			<td class="td-odd"><font color="red">*</font>设备类型名称</td>
			<td class="td-even">
				<input name="name" value="<%=data.name%>"
					class="easyui-validatebox" required="required"/>
			</td>
		</tr>
	</table>
</form>