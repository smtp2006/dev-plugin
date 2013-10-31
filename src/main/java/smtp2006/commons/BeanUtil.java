/**
 * Copyright (c) 2013.
 */
package smtp2006.commons;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author 王华
 * @version 2013年10月29日 下午5:26:05
 * 
 */
public abstract class BeanUtil {
    private static final Logger logger = LoggerFactory.getLogger(BeanUtil.class);
    @SuppressWarnings("rawtypes")
    public static void populate(Object bean, Map properties, String prefix) throws IllegalAccessException, InvocationTargetException {
        logger.debug("prefix is : {}", prefix);
        // Do nothing unless both arguments have been specified
        if ((bean == null) || (properties == null)) {
            return;
        }
        // Loop through the property name/value pairs to be set
        Iterator entries = properties.entrySet().iterator();
        while (entries.hasNext()) {

            // Identify the property name and value(s) to be assigned
            Map.Entry entry = (Map.Entry) entries.next();
            String name = (String) entry.getKey();
            if (name == null) {
                continue;
            }
            if (!StringUtils.isEmpty(prefix) && name.startsWith(prefix)) {
                name = name.substring(name.indexOf(prefix) + prefix.length());
                logger.debug("name is : {}", name);
                // Perform the assignment for this property
                setProperty(bean, name, entry.getValue());
            } else {
                logger.debug("name is : {}", name);
                setProperty(bean, name, entry.getValue());
            }
            

        }

    }
    private static void setProperty(Object bean ,String name, Object value) {
        try {
            BeanUtils.setProperty(bean, name, value);
        } catch (Exception e) {
            logger.error("setProperty error class: {}, name: {}, value: {}", new Object[] {bean.getClass(), name, value});
        }
        
    }
}
