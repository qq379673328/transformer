<form class="des-survey-eidtwin" method="post">
	<input type="hidden" name="id" value="<%=data.id%>"/>
	<table class="showPage">
		<tr>
			<td class="td-odd">父级类型</td>
			<td class="td-even">
				<input name="parId" value="<%=data.parId%>" 
					class="spe-tag"
					data-spe='{"type":"select-device-type", "isLevel1": "true"}'/>
			</td>
		</tr>
		<tr>
			<td class="td-odd"><font color="red">*</font>类型</td>
			<td class="td-even">
				<input name="name" value="<%=data.name%>"
					class="easyui-validatebox" required="required"/>
			</td>
		</tr>
	</table>
</form>