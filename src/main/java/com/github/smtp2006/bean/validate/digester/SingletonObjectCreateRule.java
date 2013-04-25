/**
 * https://github.com/smtp2006/bean-validate-plugin.git 
 */
package com.github.smtp2006.bean.validate.digester;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester3.ObjectCreateRule;
import org.xml.sax.Attributes;

/**
 * @author wanghua
 * @version 2013-4-25 下午9:52:16
 * 
 */
public class SingletonObjectCreateRule extends ObjectCreateRule {
    private static Map<String, Object> cache = new HashMap<String, Object>();

    private Object lock = new Object();

    /**
     * @param clazz
     */
    public SingletonObjectCreateRule() {
        super(null, "class");
    }

    /**
     * @param clazz
     */
    public SingletonObjectCreateRule(Class<?> clazz) {
        super(clazz);
    }

    /**
     * @param attributeName
     * @param clazz
     */
    public SingletonObjectCreateRule(String attributeName, Class<?> clazz) {
        super(attributeName, clazz);
    }

    /**
     * @param className
     * @param attributeName
     */
    public SingletonObjectCreateRule(String className, String attributeName) {
        super(className, attributeName);
    }

    /**
     * @param className
     */
    public SingletonObjectCreateRule(String className) {
        super(className);
    }

    @Override
    public void begin(String namespace, String name, Attributes attributes) throws Exception {
        if (attributeName == null) {
            attributeName = "class";
        }
        String value = attributes.getValue(attributeName);
        if (value != null) {
            synchronized (lock) {
                Object instance = cache.get(value);
                if (instance != null) {
                    getDigester().push(instance);
                } else {
                    super.begin(namespace, name, attributes);
                }
            }
            cache.put(value, getDigester().peek());
        } else {
            super.begin(namespace, name, attributes);
        }
    }
}
