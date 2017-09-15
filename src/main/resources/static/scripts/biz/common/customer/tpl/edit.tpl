<form class="showPage">
	<input type="hidden" name="id" value="<%=data.id%>"/>
	<h3>基本信息</h3>
	<table class="bg-zone">
		<tr>
			<td class="td-odd"><font color="red">*</font>客户名称</td>
			<td class="td-even">
				<input name="name" value="<%=data.name%>"
					class="easyui-validatebox" data-options="required:true,validType:'maxLength[100]'"/>
			</td>
			<td class="td-odd">客户类型</td>
			<td class="td-even">
				<input name="type" value="<%=data.type%>"
					class="spe-tag" data-spe='{"type": "biz-select-type-customer", "isShowAdd": true}'/>
			</td>
			<td class="td-odd"><font color="red">*</font>地区</td>
			<td class="td-even">
				<input class="spe-tag"
					name="area"
					value="<%=data.area%>"
					data-spe='{"type": "biz-select-type-common", "isShowAdd": true, "selectType": "area", "required": true}' 
					>
			</td>
		</tr>
		<tr>
			<td class="td-odd"><font color="red">*</font>联系人</td>
			<td class="td-even">
				<input name="contact" value="<%=data.contact%>" 
					class="easyui-validatebox" data-options="required:true, validType:'maxLength[100]'"/>
			</td>
			<td class="td-odd"><font color="red">*</font>地址</td>
			<td class="td-even">
				<input name="address" value="<%=data.address%>"
					class="easyui-validatebox" data-options="required:true, validType:'maxLength[100]'"/>
			</td>
			<td class="td-odd"></td>
			<td class="td-even"></td>
		</tr>
	</table>
	<h3>个人信息</h3>
	<table class="bg-zone">
		<tr>
			<td class="td-odd"><font color="red">*</font>联系电话1</td>
			<td class="td-even">
				<input name="contactPhone1" value="<%=data.contactPhone1%>"
					class="easyui-validatebox" data-options="required:true,validType:'maxLength[50]'"/>
			</td>
			<td class="td-odd">联系电话2</td>
			<td class="td-even">
				<input name="contactPhone2" value="<%=data.contactPhone2%>"
					class="easyui-validatebox" data-options="validType:'maxLength[100]'"/>
			</td>
			<td class="td-odd"></td>
			<td class="td-even"></td>
		</tr>
		<tr>
			<td class="td-odd">邮箱</td>
			<td class="td-even">
				<input name="email" value="<%=data.email%>"
					class="easyui-validatebox" data-options="validType:'maxLength[50]'"/>
			</td>
			<td class="td-odd">QQ</td>
			<td class="td-even">
				<input name="qq" value="<%=data.qq%>"
					class="easyui-validatebox" data-options="validType:'maxLength[20]'"/>
			</td>
			<td class="td-odd">微信</td>
			<td class="td-even">
				<input name="wechat" value="<%=data.wechat%>"
					class="easyui-validatebox" data-options="validType:'maxLength[50]'"/>
			</td>
		</tr>
	</table>
	<h3>经营信息</h3>
	<table class="bg-zone">
		<tr>
			<td class="td-odd"><font color="red">*</font>欠款限额</td>
			<td class="td-even">
				<input name="arrearsMax" value="<%=data.arrearsMax%>"
					class="easyui-validatebox" data-options="required:true,validType:'price'"/>
				
				<span class="fa fa-question-circle-o easyui-tooltip"
					title="超过欠款限额的客户会在【系统管理/预警提醒/客户欠款提醒】中显示。"></span>
			</td>
			<% if(data.id){ %>
			<% }else{ %>
				<td class="td-odd"><font color="red">*</font>期初应收款</td>
				<td class="td-even">
					<input name="receiveBegin" value="<%=data.receiveBegin%>"
						class="easyui-validatebox" data-options="required:true,validType:'price'" />
						
					<span class="fa fa-question-circle-o easyui-tooltip"
						title="新增客户之前客户的欠款，若不为0，则数据添加之后会在【财务管理/收款】中显示。<br/>注意：此信息不可编辑。"></span>
				</td>
			<% } %>
			<td class="td-odd"></td>
			<td class="td-even"></td>
		</tr>
	</table>
	<h3>其它</h3>
	<table class="bg-zone">
		<tr>
			<td class="td-odd">备注</td>
			<td class="td-even" colspan="5">
				<textarea name="comment" rows="4"><%=data.comment%></textarea>
			</td>
		</tr>
	</table>
</form>