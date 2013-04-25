/**
 * https://github.com/smtp2006/bean-validate-plugin.git.
 */
package com.github.smtp2006.bean.validate.digester;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author wanghua
 * @version 2013-4-26 下午10:29:50
 */
public class SingletonObjectCreateRuleTest {
    /**
     * 默认构造函数.
     */
    @Test
    public void SingletonObjectCreateRule() {
        SingletonObjectCreateRule rule = new SingletonObjectCreateRule();
        assertNotNull(rule);
    }

    /**
     * 带Class的构造函数.
     * @param clazz 按指定clazz值创建对象.
     */
    @Test
    public void SingletonObjectCreateRule$Class() {
        SingletonObjectCreateRule rule = new SingletonObjectCreateRule(
                Object.class);
        assertNotNull(rule);
    }

    /**
     * @param attributeName 按某属性值创建对象.
     * @param clazz 按指定clazz值创建对象.
     */
    @Test
    public void SingletonObjectCreateRule$AttributeName$Class() {
        SingletonObjectCreateRule rule = new SingletonObjectCreateRule("class",
                Object.class);
        assertNotNull(rule);
    }

    /**
     * @param attributeName 按某属性值创建对象.
     * @param className 按指定className值创建对象.
     */
    public void SingletonObjectCreateRule$AttributeName$ClassName() {
        SingletonObjectCreateRule rule = new SingletonObjectCreateRule("class",
                Object.class.getName());
        assertNotNull(rule);
    }

    /**
     * @param className 按指定className值创建对象.
     */
    public void SingletonObjectCreateRule$ClassName(final String className) {

        SingletonObjectCreateRule rule = new SingletonObjectCreateRule(
                Object.class.getName());
        assertNotNull(rule);
    }
}
