/**
 * 
 *
 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
 * @date 2015-7-15
 */
package cn.com.sinosoft.tbf.auth.permmgr.model;

/**
 * 角色信息
 * @author	<a href="mailto:nytclizy@gmail.com">李志勇</a>
 * @date	2015-7-15
 */
public class RoleVO {
	
	private String roleId;
	private String roleName;
	private String roleDesc;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
}
