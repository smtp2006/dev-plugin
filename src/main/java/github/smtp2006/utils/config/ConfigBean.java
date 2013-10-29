/**
 * Copyright (c) 2013.
 */
package github.smtp2006.utils.config;

import java.util.Properties;

/**
 * 配置Bean
 * 
 * @author 王华
 * @version 2013年10月29日 下午5:12:57
 * 
 */
public class ConfigBean implements ConfigAware {
    /**
     * 原始配置信息.
     */
    private Properties config;

    public Properties getConfig() {
        return config;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }

    /**
     * 返回指定key的配置
     * 
     * @param key
     * @return
     */
    public String getConfig(String key) {
        return getConfig(key, null);
    }

    /**
     * 返回指定key的配置, 如果不包含指定key, 返回默认值defaultValue
     * 
     * @param key
     * @param defaultValue 默认值
     * @return
     */
    public String getConfig(String key, String defaultValue) {
        if (config == null) {
            throw new IllegalStateException("No config properties");
        }
        return config.getProperty(key, defaultValue);
    }
}
