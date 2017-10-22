<form class="showPage">
	<table>
		<tr>
			<td>
				<b class="edit-timestamp" data-type="1"><%=data.createTime%></b>
				<br/>
				<b><%=data.content%></b>
				<br/>
			</td>
		</tr>
		<tr>
			<td>
				<%if(data.path){%>
					<img src="upfiles/<%=data.path%>" />
				<%}else{%>
					未上传图片
				<%}%>
			</td>
		</tr>
	</table>
</form>