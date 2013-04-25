/**
 * https://github.com/smtp2006/bean-validate-plugin.git.
 */
package com.github.smtp2006.bean.validate.digester;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester3.ObjectCreateRule;
import org.xml.sax.Attributes;

/**
 * @author wanghua
 * @version 2013-4-25 下午9:52:16
 */
public class SingletonObjectCreateRule extends ObjectCreateRule {
    /**
     * .
     */
    private static Map<String, Object> cache = new HashMap<String, Object>();
    /**
     * 对象锁.
     */
    private static Object lock = new Object();

    /**
     * 默认构造函数.
     */
    public SingletonObjectCreateRule() {
        super(null, "class");
    }

    /**
     * 带Class的构造函数.
     * @param clazz 按指定clazz值创建对象.
     */
    public SingletonObjectCreateRule(final Class<?> clazz) {
        super(clazz);
    }

    /**
     * @param attributeName 按某属性值创建对象.
     * @param clazz 按指定clazz值创建对象.
     */
    public SingletonObjectCreateRule(final String attributeName,
            final Class<?> clazz) {
        super(attributeName, clazz);
    }

    /**
     * @param attributeName 按某属性值创建对象.
     * @param className 按指定className值创建对象.
     */
    public SingletonObjectCreateRule(final String attributeName,
            final String className) {
        super(className, attributeName);
    }

    /**
     * @param className 按指定className值创建对象.
     */
    public SingletonObjectCreateRule(final String className) {
        super(className);
    }

    @Override
    public final void begin(final String namespace, final String name,
            final Attributes attributes) throws Exception {
        // 如果属性名为空，则采用默认属性class
        if (attributeName == null) {
            attributeName = "class";
        }
        String value = attributes.getValue(attributeName);
        // 如果属性值不为空，则根据属性值创建对象
        if (value != null) {
            // 锁定cache
            synchronized (lock) {
                Object instance = cache.get(value);
                // 如果cache有则把cache值push到digester堆栈
                if (instance != null) {
                    getDigester().push(instance);
                } else {
                    // 如果cache没有则按父类构造
                    super.begin(namespace, name, attributes);
                }

                // 把堆栈对象Push到cache
                cache.put(value, getDigester().peek());
            }

        } else {
            // 如果属性值为空，则按父类构造
            super.begin(namespace, name, attributes);
        }
    }
}
