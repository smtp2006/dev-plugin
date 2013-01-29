package ox.andalu.wms.domain.auth;

import ox.andalu.wms.domain.AObject;
import ox.andalu.wms.domain.IConstants;

public class Role extends BO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5220653900172503452L;
	/**角色的名称*/
	private String name;
	/**角色的编码：org_code*/
	private String code;
	/**角色的状态：可用/禁用*/
	private Integer status=Constants.INT_ENABLED;
	/**该角色属于哪个Organization*/
	private Long orgId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	
}
