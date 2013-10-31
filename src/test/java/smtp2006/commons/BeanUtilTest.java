/**
 * Copyright (c) 2013.
 */
package smtp2006.commons;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import smtp2006.commons.BeanUtil;

/**
 * @author 王华
 * @version 2013年10月30日 下午4:14:21
 * 
 */
public class BeanUtilTest {
    @Test
    public void test_populate() {
        BeanUtilTestBean tb = new BeanUtilTestBean();
        String name = "TargetBean";
        Properties props = new Properties();
        props.setProperty("name", name);
        // prefix is null
        try {
            BeanUtil.populate(tb, props, null);
        } catch (Exception e) {
            Assert.fail("populate fail");
        }
        System.out.println(tb.getName());
        Assert.assertEquals(name, tb.getName());
        // prefix is empty
        tb.setName(null);
        props.setProperty("name", name);
        try {
            BeanUtil.populate(tb, props, "");
        } catch (Exception e) {
            Assert.fail("populate fail");
        }
        System.out.println(tb.getName());
        Assert.assertEquals(name, tb.getName());

        // prefix has value
        tb.setName(null);
        props.setProperty("target.name", "target." + name);
        try {
            BeanUtil.populate(tb, props, "target.");
        } catch (Exception e) {
            Assert.fail("populate fail");
        }
        System.out.println(tb.getName());
        Assert.assertEquals("target." + name, tb.getName());

        // prefix has value
        tb.setName(null);
        props.setProperty("target.name", "target." + name);
        props.setProperty("target.pwd", "target." + name);
        try {
            BeanUtil.populate(tb, props, "target.");
        } catch (Exception e) {
            Assert.fail("populate fail");
        }
        System.out.println(tb.getName());
        Assert.assertEquals("target." + name, tb.getName());
    }

}
