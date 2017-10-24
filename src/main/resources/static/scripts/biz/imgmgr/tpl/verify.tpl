<form class="showPage">
	<input type="hidden" name="id" value="<%=data.id%>"/>
	<table>
		<tr>
			<td class="td-odd"><font color="red">*</font>是否通过</td>
			<td class="td-even">
				<input name="status" value="1" type="radio" checked="true"/>通过
				<input name="status" value="9" type="radio"/>不通过
			</td>
		</tr>
		<tr>
			<td class="td-odd">审核意见</td>
			<td class="td-even">
				<textarea name="content"></textarea>
			</td>
		</tr>
	</table>
</form>