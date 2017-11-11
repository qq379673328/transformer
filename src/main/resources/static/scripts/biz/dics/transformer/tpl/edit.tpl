<form class="des-survey-eidtwin" method="post">
	<input type="hidden" name="id" value="<%=data.id%>"/>
	<table class="showPage">
		<tr>
			<td class="td-odd"><font color="red">*</font>变电站名称</td>
			<td class="td-even">
				<input name="name" value="<%=data.name%>"
					class="easyui-validatebox" required="required"/>
			</td>
		</tr>
		<tr>
			<td class="td-odd"><font color="red">*</font>分组</td>
			<td class="td-even">
				<input name="type" type="radio" value="公司属变电站" checked="checked" />
				公司属变电站
				<input name="type" type="radio" value="用户属变电站" />
				用户属变电站
			</td>
		</tr>
		<tr>
			<td class="td-odd">描述</td>
			<td class="td-even">
				<textarea name="desc"
					rows=5
					class="easyui-validatebox"><%=data.desc%></textarea>
			</td>
		</tr>
		
	</table>
</form>