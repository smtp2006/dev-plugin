package ox.andalu.wms.dao.auth;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ox.andalu.wms.domain.auth.Authority;
import ox.andalu.wms.domain.auth.Role;

@Transactional
public interface RoleDao {
	/**
	 * 创建角色
	 * @param role
	 * @return
	 */
	Integer createRole(Role role);
	
	Role loadDefaultRoleByUserId(Long userId);
	/**
	 * 创建权限
	 * @param authority
	 * @return
	 */
	Integer createAuthority(Authority authority);
	/**
	 * 根据用户PK加载当前用户的所有权限
	 * @param userId
	 * @return
	 */
	List<Authority> loadDefaultAuthoritiesByUserId(Long userId);
}
