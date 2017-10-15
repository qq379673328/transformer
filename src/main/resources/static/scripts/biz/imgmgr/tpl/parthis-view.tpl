<form class="showPage">
	<table>
		<tr>
			<td class="td-odd">内容</td>
			<td class="td-even">
				<%=data.content%>
			</td>
		</tr>
		<tr>
			<td class="td-odd">图片</td>
			<td class="td-even">
				<%if(data.path){%>
					<img src="upfiles/<%=data.path%>" />
				<%}else{%>
					未上传
				<%}%>
			</td>
		</tr>
	</table>
</form>