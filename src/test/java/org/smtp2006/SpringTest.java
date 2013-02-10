package org.smtp2006;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath*:spring/spring.xml" })
public class SpringTest extends AbstractJUnit4SpringContextTests {

}
