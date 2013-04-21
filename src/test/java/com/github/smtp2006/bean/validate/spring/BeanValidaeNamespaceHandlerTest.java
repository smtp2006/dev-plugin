/**
 * 
 */
package com.github.smtp2006.bean.validate.spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.github.smtp2006.bean.validate.ClassValidator;

/**
 * @author hua.wanghuawh
 * 
 */
@ContextConfiguration(locations = {"classpath*:com/github/smtp2006/bean/validate/User.xml"})
public class BeanValidaeNamespaceHandlerTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    BeanFactory bf;
    @Test
    public void test() {
        System.out.println(bf == null);
        System.out.println(bf.getBean(ClassValidator.class));
    }
}
