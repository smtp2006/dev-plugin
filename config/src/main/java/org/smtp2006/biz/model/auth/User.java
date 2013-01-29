package ox.andalu.wms.domain.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import ox.andalu.wms.domain.AObject;

public class User extends BO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2237386400981630823L;
	/** PK */
	private Long id;
	/** 登录名 */
	private String userName;
	/** 昵称 */
	private String nickName;
	/** 真实姓名 */
	private String realName;
	/** 密码 */
	private String password;
	/** 邮箱 */
	private String email;
	/** 状态 */
	private Integer status;
	/** 用户类型 */
	private Integer type;
	/** 组织 */
	private Long orgId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Map<String, Object> toMap() {
		if (this == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.hasLength(this.userName)) {
			map.put("userName", userName.trim() + "%");
		}
		if (StringUtils.hasLength(this.nickName)) {
			map.put("nickName", nickName.trim() + "%");
		}
		if (StringUtils.hasLength(this.realName)) {
			map.put("realName", realName.trim() + "%");
		}
		if (StringUtils.hasLength(this.email)) {
			map.put("email", email.trim() + "%");
		}
		if (type != null) {
			map.put("type", type);
		}
		if (orgId != null) {
			map.put("orgId", orgId);
		}
		if (status != null) {
			map.put("status", status + 1);
		}
		return map;
	}
}
