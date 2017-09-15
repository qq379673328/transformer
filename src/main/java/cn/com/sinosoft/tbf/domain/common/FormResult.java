package cn.com.sinosoft.tbf.domain.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

/**
 * 表单提交返回结果-更新、删除、新增时action请返回此对象
 * @date	2014-10-29
 */
public class FormResult {

	/**
	 * 成功
	 */
	public static final String SUCCESS = "1";
	/**
	 * 失败
	 */
	public static final String ERROR = "0";

	/**
	 * 是否成功:1-成功,0-失败
	 */
	String result;
	/**
	 * 返回信息
	 */
	String message;
	/**
	 * 返回的数据
	 */
	Object data;

	/**
	 * 默认result为SUCCESS
	 */
	public FormResult(BindingResult errors){
		this.result = ERROR;
		this.message = genMessageByErrors(errors);
	}

	public FormResult(){
		this.result = SUCCESS;
	}

	/**
	 * 根据错误消息生存信息
	 *
	 * @param errors
	 *            错误消息
	 * @return 信息字符串
	 */
	private String genMessageByErrors(Errors errors) {
		if (errors == null || !errors.hasErrors()) {
			return "";
		}
		StringBuffer message = new StringBuffer();
		for (ObjectError error : errors.getAllErrors()) {
			message.append(error.getDefaultMessage());
			message.append("\r");
		}
		return message.toString();
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
