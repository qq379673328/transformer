<div>
	<div class="name">用户查询</div>
	<div class="zone searchzone">
		<form id="form-search">
			<table class="">
				<tr class="tr-odd">
					<td class="td-odd">
					 <label for="name">姓名:</label>
					</td>
					<td class="td-even">
						<input name="name" />
					</td> 
					<td class="td-odd">
					 <label for="loginName">登录名:</label>
					</td>
					<td class="td-even">
						<input name="loginName"/>
					</td>
				</tr>
				<tr class="tr-odd">
					<td class="td-odd">
						状态:
					</td>
					<td class="td-even">
						<input type="radio" name="isuse" value="" checked="checked" />全部
						<input type="radio" name="isuse" value="0" />禁用
						<input type="radio" name="isuse" value="1" />启用
					</td>
					<td class="td-odd"></td>
					<td class="td-even">
						<span id="btn-search" class="my-btn my-btn-search">
							<i class="fa fa-search"></i>&nbsp;查询
						</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<table id="list-tab" class="fixgrid">
	</table>
</div>