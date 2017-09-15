<div class="showPage">
	<h3>基本信息</h3>
	<table>
		<tr>
			<td class="td-odd" width=10%>客户名称</td>
			<td class="td-even" width=20%>
				<%=data.name%>
			</td>
			<td class="td-odd" width=10%>客户类型</td>
			<td class="td-even" width=20%>
				<%=data.typeDesc%>
			</td>
			<td class="td-odd" width=10%>地区</td>
			<td class="td-even">
				<%=data.areaDesc%>
			</td>
		</tr>
		<tr>
			<td class="td-odd">联系人</td>
			<td class="td-even">
				<%=data.contact%>
			</td>
			<td class="td-odd">地址</td>
			<td class="td-even">
				<%=data.address%>
			</td>
			<td class="td-odd"></td>
			<td class="td-even"></td>
		</tr>
	</table>
	<h3>个人信息</h3>
	<table>
		<tr>
			<td class="td-odd" width=10%>联系电话1</td>
			<td class="td-even" width=20%>
				<%=data.contactPhone1%>
			</td>
			<td class="td-odd" width=10%>联系电话2</td>
			<td class="td-even" width=20%>
				<%=data.contactPhone2%>
			</td>
			<td class="td-odd" width=10%></td>
			<td class="td-even"></td>
		</tr>
		<tr>
			<td class="td-odd">邮箱</td>
			<td class="td-even">
				<%=data.email%>
			</td>
			<td class="td-odd">QQ</td>
			<td class="td-even">
				<%=data.qq%>
			</td>
			<td class="td-odd">微信</td>
			<td class="td-even">
				<%=data.wechat%>
			</td>
		</tr>
	</table>
	<h3>经营信息</h3>
	<table>
		<tr>
			<td class="td-odd" width=10%>欠款限额</td>
			<td class="td-even" width=20%><%=data.arrearsMax%></td>
			<td class="td-odd" width=10%>期初应收款</td>
			<td class="td-even" width=20%><%=data.receiveBegin%></td>
			<td class="td-odd" width=10%></td>
			<td class="td-even"></td>
		</tr>
	</table>
	<h3>其它</h3>
	<table>
		<tr>
			<td class="td-odd">备注</td>
			<td class="td-even" colspan="5">
				<%=data.comment%>
			</td>
		</tr>
		<tr>
			<td class="td-odd" width=10%>状态</td>
			<td class="td-even" width=20%>
				<%=data.stateDesc%>
			</td>
			<td class="td-odd" width=10%>创建时间</td>
			<td class="td-even" width=20%>
				<span class="edit-timestamp" data-type="1"><%=data.createTime%></span>
			</td>
			<td class="td-odd" width=10%>创建人</td>
			<td class="td-even"><%=data.createUserName%></td>
		</tr>
		<tr>
			<td class="td-odd">更新时间</td>
			<td class="td-even">
				<span class="edit-timestamp" data-type="1"><%=data.updateTime%></span>
			</td>
			<td class="td-odd">更新人</td>
			<td class="td-even"><%=data.updateUserName%></td>
			<td class="td-odd"></td>
			<td class="td-even"></td>
		</tr>
	</table>
</div>