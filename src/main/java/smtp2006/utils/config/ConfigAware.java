/**
 * Copyright (c) 2013.
 */
package smtp2006.utils.config;

import java.util.Properties;

/**
 * 标记接口, 可配置模式
 * 
 * @author 王华
 * @version 2013年10月29日 下午5:13:15
 *
 */
public interface ConfigAware {
	/**
	 * 注入Properties.
	 * @param properties
	 */
	void setConfig(Properties properties);
	/**
	 * 返回配置Properties
	 * @return
	 */
	Properties getConfig();
}
