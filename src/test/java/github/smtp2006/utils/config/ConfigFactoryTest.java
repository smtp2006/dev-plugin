package github.smtp2006.utils.config;

import org.junit.Assert;
import org.junit.Test;

public class ConfigFactoryTest {
    @Test
    public void testGetConfig() throws Exception {
        TestConfigBean config = (TestConfigBean) ConfigFactory.getConfig(TestConfigBean.class.getName());
        Assert.assertNotNull(config);
        System.out.println(config);
    }
}
