package ox.andalu.wms.domain.auth;

import ox.andalu.wms.domain.AObject;

public class RoleAuthority extends BO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1236777401489876773L;
	/**角色*/
	private Long roleId;
	/**权限*/
	private Long authId;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getAuthId() {
		return authId;
	}
	public void setAuthId(Long authId) {
		this.authId = authId;
	}
	
}
