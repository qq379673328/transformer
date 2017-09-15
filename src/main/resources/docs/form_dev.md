# 表单的编写

	注意：此种写法也在普通的模版页面或者htm页面适用。只是无验证功能。

## 普通码表-select

	<input name="collectMethod"
		value="<%=data.card.collectMethod%>" 
		class="spe-tag"
		data-spe='{"type":"codeselect","codetype":"person.infocollectionway"}' />
	
	注意：
		1、codetype代表码表类型。


## 普通码表-radio

	<div data-name="income"
		data-value="<%=data.ex.INCOME%>"
		class="spe-tag" 
		data-spe='{"type":"coderadio","codetype":"survey.income", "targetIds": "#test", targetValue:"1"}'></div>
	<tr id="test">
		<td></td>
	</tr>
	
	注意：
		1、codetype代表码表类型。
		2、若要为radio添加验证规则，如：required：true，需要将之前的name属性调整为data-name属性。否则验证会出错
		3、targetIds代表触发显示的目标选择器(jquery选择器),targetValue为触发目标显示的值。即：当radio选择1的时候，#test显示，选择其他数据时，#test隐藏。

## 普通码表-checkbox

	<div data-name="income"
		data-value="<%=data.ex.INCOME%>"
		class="spe-tag" 
		data-spe='{"type":"codebox","codetype":"survey.income", "targetIds": "#test", targetValue:"1", "changename":true}'></div>
	<tr id="test">
		<td></td>
	</tr>
	
	注意：
		1、codetype代表码表类型。
		2、若要为checkbox添加验证规则，如：required：true，需要将之前的name属性调整为data-name属性。否则验证会出错
		3、changename代表为不同的checkbox框赋不同的name，name命名规则为原始name+序号。默认为false。
		4、targetIds代表触发显示的目标选择器(jquery选择器),targetValue为触发目标显示的值。即：当check选择1的时候，#test显示，选择其他数据时，#test隐藏。

## 年月输入-yearmonth
	<input class="spe-tag" 
		value="<%=data.test%>"
		data-spe="{'type': 'yearmonth'}" 
		name="test">

	注意：
		1、格式为yyyy-MM: 2015-05

## 年输入-year
	<input class="spe-tag" 
		value="<%=data.test%>"
		data-spe="{'type': 'year'}" 
		name="test">

	注意：
		1、格式为yyyy: 2015

## 格式化时间戳显示
	<span class="edit-timestamp" data-type="1"><%=data.UPDATE_TIME%></span>
	
	1、type：1-timestamp(yyyy-MM-dd HH:mm:ss),0-date(yyyy-MM-dd)

## 业务选择器

### 各个类型TYPE

	biz-select-customer：客户
	biz-select-goods：商品
	biz-select-staff：员工
	biz-select-store：门店
	biz-select-supplier：供应商
	biz-select-warehouse：仓库
	
	biz-select-type-customer：客户类型
	biz-select-type-account：账户类型
	biz-select-type-goods：商品分类
	biz-select-type-management：经营类型
	biz-select-type-duty：职位类型
	biz-select-type-area:地区	

	用例
	<input class="spe-tag" 
		value="<%=data.test%>"
		data-spe='{"type": "biz-select-customer", "isShowAdd": true, "required": true}' 
		name="test">
	