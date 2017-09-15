<form class="des-survey-eidtwin">
	<input type="hidden" name="id" value="<%=data.id%>"/>
	<table class="showPage">
		<tr>
			<td class="td-odd"><font color="red">*</font>角色名称</td>
			<td class="td-even">
				<input name="roleName" value="<%=data.roleName%>"
					class="easyui-validatebox" required="required"/>
			</td>
		</tr>
		<tr>
			<td class="td-odd"><font color="red">*</font>角色描述</td>
			<td class="td-even">
				<textarea rows="5" name="roleDesc"
					style="width: 80%"
					class="easyui-validatebox" required="required"><%=data.roleDesc%></textarea>
			</td>
		</tr>
	</table>
</form>