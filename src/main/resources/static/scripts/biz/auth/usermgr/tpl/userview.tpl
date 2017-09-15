<form class="des-survey-eidtwin">
	<table class="showPage">
		<tr>
			<td class="td-odd">登录名</td>
			<td class="td-even">
				<span><%=data.LOGIN_NAME%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">姓名</td>
			<td class="td-even">
				<span><%=data.NAME%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">性别</td>
			<td class="td-even">
				<span><%=data.SEX_DESC%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">联系方式</td>
			<td class="td-even">
				<span><%=data.PHONE%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">邮箱</td>
			<td class="td-even">
				<span><%=data.EMAIL%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">所属部门</td>
			<td class="td-even">
				<span><%=data.ORG_CODE_DESC%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">拥有角色</td>
			<td class="td-even">
				<span><%=data.USER_ROLE_DESC%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">创建时间</td>
			<td class="td-even">
				<span class="edit-timestamp" data-type="1"><%=data.CREATE_TIME%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd">创建人</td>
			<td class="td-even">
				<span><%=data.CREATE_USER_DESC%></span>
			</td>
		</tr>
	</table>
</form>