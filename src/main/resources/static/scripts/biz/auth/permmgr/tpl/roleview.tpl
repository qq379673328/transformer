<form class="des-survey-eidtwin">
	<table class="showPage">
		<tr>
			<td class="td-odd">角色名称</td>
			<td class="td-even">
				<span><%=data.ROLE_NAME%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">角色描述</td>
			<td class="td-even">
				<span><%=data.ROLE_DESC%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">创建人</td>
			<td class="td-even">
				<span><%=data.CREATE_USER_DESC%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">创建时间</td>
			<td class="td-even">
				<span class="edit-timestamp" data-type="1"><%=data.CREATE_TIME%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">更新人</td>
			<td class="td-even">
				<span><%=data.UPDATE_USER_DESC%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">更新时间</td>
			<td class="td-even">
				<span class="edit-timestamp" data-type="1"><%=data.UPDATE_TIME%></span>
			</td>
		</tr>
	</table>
</form>