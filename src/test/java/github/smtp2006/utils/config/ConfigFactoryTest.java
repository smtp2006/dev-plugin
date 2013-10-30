package github.smtp2006.utils.config;

import org.junit.Assert;
import org.junit.Test;

public class ConfigFactoryTest {
    @Test
    public void testGetConfig() throws Exception {
        ConfigTestBean config = (ConfigTestBean) ConfigFactory.getConfig(ConfigTestBean.class.getName());
        Assert.assertNotNull(config);
        System.out.println(config);
    }
}
