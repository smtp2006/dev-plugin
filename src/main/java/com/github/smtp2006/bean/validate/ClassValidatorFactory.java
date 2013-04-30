/**
 * https://github.com/smtp2006/bean-validate-plugin.git 
 */
package com.github.smtp2006.bean.validate;

import static org.junit.Assert.assertNotNull;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.smtp2006.bean.validate.rule.Rule;

/**
 * @author wanghua
 * @version 2013-4-22 下午9:07:30
 * 
 */
public abstract class ClassValidatorFactory {
    // ------------------------------------------------------ Static Variables
    /**
     * logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(ClassValidatorFactory.class);
    /**
     * 代理.
     */
    private static ClassValidatorLoader loader = new ClassValidatorLoader();
    /**
     * 
     */
    private static Map<Class<?>, Map<String, ClassValidator<?>>> classValidatorCache 
                                = new HashMap<Class<?>, Map<String, ClassValidator<?>>>();
    /**
     * 
     */
    private static Map<String, MessageFormat> messageFormatCache 
                                = new ConcurrentHashMap<String, MessageFormat>();
    /**
     * 
     * @version 2013-4-29 上午2:09:21
     * @param obj 校验对象
     * @param namespace 指定命名空间校验规则
     * @return 校验失败的消息
     * @throws Exception 加载规则文件异常
     */
    public static Map<String, String> validate(Object obj, String namespace) throws Exception {
        assertNotNull(obj);

        Map<String, String> ret = null;

        // get from cache
        Map<String, ClassValidator<?>> classValidators = classValidatorCache.get(obj.getClass());
        // if null, try to load class.xml from classpath
        if (classValidators == null) {
            if (classValidatorCache.containsKey(obj.getClass())) {
                throw new RuntimeException("There is 0 " + obj.getClass()
                        + ClassValidator.DEFAULT_NAME + " in the classpath");
            }
            classValidatorCache.put(obj.getClass(), null);
            logger.debug("try to loadClassValidator({})", obj.getClass().getName());
            classValidators = loader.loadClassValidator(obj.getClass());
        }
        if (classValidators != null) {
            ClassValidator defaultClassValidator = classValidators.get(obj.getClass().getName() + "#"
                    + ClassValidator.DEFAULT_NAME);
            if (defaultClassValidator == null) {
                logger.error("can not find ClassValidator with namespace = {}", obj.getClass().getName() + "#"
                        + ClassValidator.DEFAULT_NAME);
            }
            Map<String, List<Rule>> validateResult = defaultClassValidator.validate(obj);
            if (validateResult != null && !validateResult.isEmpty()) {
                ret = new HashMap<String, String>(validateResult.size());

                for (Map.Entry<String, List<Rule>> entry : validateResult.entrySet()) {
                    StringBuilder propertyResult = new StringBuilder();
                    for (Rule rule : entry.getValue()) {
                        if (propertyResult.length() > 0) {
                            propertyResult.append(";");
                        }
                        MessageFormat mf = messageFormatCache.get(rule.format());
                        if (mf == null) {
                            mf = new MessageFormat(rule.format());
                            messageFormatCache.put(rule.format(), mf);
                        }

                        propertyResult.append(mf.format(new Object[] {entry.getKey() }));
                    }
                    ret.put(entry.getKey(), propertyResult.toString());
                }
            }

        }
        return ret;
    }
    /**
     * @param obj 需要校验的对象
     * @return 按默认Class.getName() + "#default"命名空间对应的ClassValidator校验，校验失败返回错误提示
     * @throws Exception 运行时异常和Digester异常
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Map<String, String> validate(Object obj) throws Exception {
        assertNotNull(obj);

        Map<String, String> ret = null;

        // get from cache
        Map<String, ClassValidator<?>> classValidators = classValidatorCache.get(obj.getClass());
        // if null, try to load class.xml from classpath
        if (classValidators == null) {
            logger.debug("try to loadClassValidator({})", obj.getClass().getName());
            classValidators = loader.loadClassValidator(obj.getClass());
        }
        if (classValidators != null) {
            ClassValidator defaultClassValidator = classValidators.get(obj.getClass().getName() + "#"
                    + ClassValidator.DEFAULT_NAME);
            if (defaultClassValidator == null) {
                logger.error("can not find ClassValidator with namespace = {}", obj.getClass().getName() + "#"
                        + ClassValidator.DEFAULT_NAME);
            }
            Map<String, List<Rule>> validateResult = defaultClassValidator.validate(obj);
            if (validateResult != null && !validateResult.isEmpty()) {
                ret = new HashMap<String, String>(validateResult.size());

                for (Map.Entry<String, List<Rule>> entry : validateResult.entrySet()) {
                    StringBuilder propertyResult = new StringBuilder();
                    for (Rule rule : entry.getValue()) {
                        if (propertyResult.length() > 0) {
                            propertyResult.append(";");
                        }
                        MessageFormat mf = messageFormatCache.get(rule.format());
                        if (mf == null) {
                            mf = new MessageFormat(rule.format());
                            messageFormatCache.put(rule.format(), mf);
                        }

                        propertyResult.append(mf.format(new Object[] {entry.getKey() }));
                    }
                    ret.put(entry.getKey(), propertyResult.toString());
                }
            }

        }
        return ret;
    }
}
