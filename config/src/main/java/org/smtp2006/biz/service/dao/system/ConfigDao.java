package org.smtp2006.biz.service.dao.system;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface ConfigDao {
	/**
	 * 创建
	 * 
	 * @param config
	 * @return
	 */
	int createConfig(Config config);

	void updateConfig(Config config);

	/**
	 * 查询
	 * <code><if test="valueField"> and #{valueField}=value_field </if></code>
	 * <code><if test="textField"> and #{textField}=text_field </if></code>
	 * <code><if test="status"> and #{status}=status </if></code>
	 * <code>	<if test="type"> and type=#{type} </if></code>
	 * 
	 * @param map
	 * @return
	 */
	List<Config> loadConfigs(Map<String, Object> map);

	/**
	 * count
	 * <code><if test="valueField"> and #{valueField}=value_field </if></code>
	 * <code><if test="textField"> and #{textField}=text_field </if></code>
	 * <code><if test="status"> and #{status}=status </if></code>
	 * <code>	<if test="type"> and type=#{type} </if></code>
	 * 
	 * @param map
	 * @return
	 */
	int countConfigs(Map<String, Object> map);

	/**
	 * 删除
	 * 
	 * @param ids
	 * @return
	 */
	int deleteConfigs(List<String> ids);

	/**
	 * 禁用
	 * 
	 * @param map
	 * @return
	 */
	int updateConfigsStatus(Map<String, Object> map);

	/**
	 * 
	 * @return
	 */
	List<Config> loadTypeList();
}
