package org.smtp2006.biz.service.dao.auth;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AuthorityDao {
	/**
	 * 
	 * @param authority
	 * @return
	 */
	int createAuthority(Authority authority);

	/**
	 * set name=#{name}
	 * 
	 * @param authority
	 * @return
	 */
	int updateAuthority(Authority authority);

	/**
	 * set enabled=#{enabled}
	 * 
	 * @param map
	 */
	void updateAuthoritiesStatus(Map<String, Object> map);

	/**
	 * 
	 * @param ids
	 */
	int deleteAuthorityByKeys(List<String> ids);

	/**
	 * 查询 <if test="name"> and upper(name) like upper(#{name}) </if> <if
	 * test="enabled"> and enabled=#{enabled} </if> <if test="displayOrder"> and
	 * display_order=#{displayOrder} </if> <if test="start"> limit #{start},
	 * #{end} </if>
	 * 
	 * @param map
	 * @return
	 */
	List<Authority> loadAuthorities(Map<String, Object> map);

	/**
	 * 查询 <if test="name"> and upper(name) like upper(#{name}) </if> <if
	 * test="enabled"> and enabled=#{enabled} </if> <if test="displayOrder"> and
	 * display_order=#{displayOrder} </if> <if test="start"> limit #{start},
	 * #{end} </if>
	 * 
	 * @param map
	 * @return
	 */
	int countAuthorities(Map<String, Object> map);
}
