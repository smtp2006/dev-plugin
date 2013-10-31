package smtp2006.commons.config;

import org.junit.Assert;
import org.junit.Test;

import smtp2006.utils.config.ConfigFactory;

public class ConfigFactoryTest {
    @Test
    public void testGetConfig() throws Exception {
        ConfigTestBean config = (ConfigTestBean) ConfigFactory.getConfig(ConfigTestBean.class.getName());
        Assert.assertNotNull(config);
        System.out.println(config);
    }
}
