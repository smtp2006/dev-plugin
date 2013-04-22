/**
 * https://github.com/smtp2006/bean-validate-plugin.git 
 */
package com.github.smtp2006.bean.validate;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
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
public class ClassValidatorFactory {
    // ------------------------------------------------------ Static Variables
    private static final Logger logger = LoggerFactory.getLogger(ClassValidatorFactory.class);
    private static ClassValidatorLoader loader = new ClassValidatorLoader();
    private static Map<Class<?>, Map<String, ClassValidator<?>>> classValidatorCache = new HashMap<Class<?>, Map<String, ClassValidator<?>>>();
    private static Map<String, MessageFormat> messageFormatCache = new ConcurrentHashMap<String, MessageFormat>();

    /**
     * @param obj
     * @return
     * @throws IOException
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

                        propertyResult.append(mf.format(new Object[] { entry.getKey() }));
                    }
                    ret.put(entry.getKey(), propertyResult.toString());
                }
            }

        }
        return ret;
    }
}
