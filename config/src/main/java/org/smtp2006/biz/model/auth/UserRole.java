package ox.andalu.wms.domain.auth;

import ox.andalu.wms.domain.AObject;
/**
 * 用户拥有的角色
 * @author wanghua
 *
 */
public class UserRole extends BO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1236777401489876773L;
	/**
	 * 
	 */
	private Long userId;
	private Long roleId;
	/**该角色是否是用户登录时的默认角色*/
	private Boolean isDefault=false;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Boolean isDefault() {
		return isDefault;
	}
	public void setDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
	
}
