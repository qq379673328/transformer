<form class="des-survey-eidtwin" method="post">
	<input type="hidden" name="id" value="<%=data.id%>"/>
	<table class="showPage">
		<tr>
			<td class="td-odd"><font color="red">*</font>登录名</td>
			<td class="td-even">
				<%if(data.id){%>
					<span><%=data.loginName%></span>
				<%}else{%>
					<input name="loginName" value="<%=data.loginName%>"
						class="easyui-validatebox" required="required"/>
				<%}%>
			</td>
		</tr>
		<tr>
			<td class="td-odd"><font color="red">*</font>姓名</td>
			<td class="td-even">
				<input name="name" value="<%=data.name%>"
					class="easyui-validatebox" required="required"/>
			</td>
		</tr>
		<tr>
			<td class="td-odd"><font color="red">*</font>是否启用</td>
			<td class="td-even">
				<div data-name="isUsed" data-value="<%=data.isUsed%>"
					class="spe-tag"
					data-spe='{"type":"coderadio","codetype":"common.yesno"}'></div>
			</td>
		</tr>
	</table>
</form>