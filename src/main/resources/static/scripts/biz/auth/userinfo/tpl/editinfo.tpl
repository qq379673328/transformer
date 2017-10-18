<form class="des-survey-eidtwin">
	<table class="showPage">
		<tr>
			<td colspan="2" class="td-title">个人信息修改</td>
		</tr>
		<tr>
			<td class="td-odd"><font color="red">*</font>登录名</td>
			<td class="td-even">
				<input type="hidden" name="loginName" value="<%=data.loginName%>"/>
				<span><%=data.loginName%></span>
			</td>
		</tr>
		<tr>
			<td class="td-odd"><font color="red">*</font>姓名</td>
			<td class="td-even">
				<input name="name" value="<%=data.name%>" />
			</td>
		</tr>
		<tr>
			<td class="td-odd">性别</td>
			<td class="td-even">
				<div name="sex" 
					data-value="<%=data.sex%>"
					class="spe-tag" 
					data-spe='{"type":"coderadio","codetype":"com.sex"}'></div>
			</td>
		</tr>
		<tr>
			<td class="td-odd">e-mail</td>
			<td class="td-even">
				<input name="email" value="<%=data.email%>"/>
			</td>
		</tr>
		<tr>
			<td class="td-odd">联系方式</td>
			<td class="td-even">
				<input name="phone" value="<%=data.phone%>"/>
			</td>
		</tr>
		<tr>
			<td class="td-odd"></td>
			<td class="td-even">
				<div id="saveBtn" class="btn btn-save"><i class="fa fa-save"></i>&nbsp;提交</div>
			</td>
		</tr>
	</table>
</form>