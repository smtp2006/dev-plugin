package ox.andalu.wms.domain.auth;

import org.springframework.security.core.GrantedAuthority;

import ox.andalu.wms.domain.AObject;

/**
 * 权限，可以通过该权限来限制Menu
 * 
 * @author wanghua
 * 
 */
public class Authority extends BO implements GrantedAuthority, IAuthConstants {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8547017833933564514L;
	/** 权限 */
	private String role;
	/** 名称 */
	private String name;
	/** 显示的顺序 */
	private Integer displayOrder;

	private Integer status;

	public Authority() {
	}

	public Authority(String name) {
		this.name = name;
		this.role = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Override
	public String getAuthority() {
		return role;
	}

	public int hashCode() {
		return this.role.hashCode();
	}

	public String toString() {
		return this.role;
	}

	public boolean equals(Object obj) {
		if (obj instanceof String) {
			return obj.equals(this.role);
		}

		if (obj instanceof GrantedAuthority) {
			GrantedAuthority attr = (GrantedAuthority) obj;

			return this.role.equals(attr.getAuthority());
		}

		return false;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

}
