<div>
	<div class="searchzone">
		<form id="form-search">
			<ul>
				<li><span class="input-name">客户名称</span><input class="input" name="name"/></li>
				<li><span class="input-name">联系人</span><input class="input" name="contact"/></li>
				<li><span class="input-name">联系电话</span><input class="input" name="phone"/></li>
				<li>
					<span class="input-name">状态</span><span data-name="state"
							class="spe-tag spe-tag-wrapper"
							data-spe='{"type":"coderadio","codetype":"common.state","allText":"不限"}'></span>
				</li>
			</ul>
			<ul class="btns">
				<li><span id="btn-search" class="btn btn-search"><i class="fa fa-search"></i>&nbsp;查询</span></li>
			</ul>
		</form>
	</div>

	<div class="btns-row">
		<div id="btn-add" class="btn btn-add" permission="manager_base_people_customer_add"><i class="fa fa-plus"></i>&nbsp;新增</div>
		<div id="btn-batch-enable" class="btn btn-add" permission="manager_base_people_customer_enable"><i class="fa fa-unlock"></i>&nbsp;撤销删除</div>
		<div id="btn-batch-disable" class="btn btn-danger" permission="manager_base_people_customer_disable"><i class="fa fa-lock"></i>&nbsp;删除</div>
	</div>

	<table id="list-tab" class="fixgrid"></table>
</div>