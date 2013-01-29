package ox.andalu.wms.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath*:spring.xml" })
public abstract class ATest extends AbstractJUnit4SpringContextTests {

}
