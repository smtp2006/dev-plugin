/**
 * Copyright (c) 2013.
 */
package smtp2006.commons.config;

/**
 * @author 王华
 * @version 2013年10月29日 下午5:55:42
 * 
 */
public class ConfigTestBean {
    private String host;
    private String port;
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    @Override
    public String toString() {
        return "TestConfigBean [host=" + host + ", port=" + port + "]";
    }
    
}
