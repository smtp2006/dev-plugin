/**
 * https://github.com/smtp2006/bean-validate-plugin.git 
 */
package com.github.smtp2006.bean.validate;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wanghua
 * @version 2013-4-22 上午12:35:08
 * 
 */
public class ClassValidatorLoader {
    // ------------------------------------------------------ Static Variables
    private static final Logger logger = LoggerFactory.getLogger(ClassValidatorLoader.class);
    /**
     * 
     */
    public static final String CLASS_VALIDATOR_EXT = ".xml";

    /**
     * @param klass
     * @return
     * @throws IOException
     */
    public Map<Class<?>, Map<String, ClassValidator<?>>> loadClassValidator(Class<?> klass) throws IOException {
        if (klass == null) {
            throw new IllegalArgumentException("klass must not be null");
        }
        Map<Class<?>, Map<String, ClassValidator<?>>> ret = new HashMap<Class<?>, Map<String, ClassValidator<?>>>();
        // get resouces from classpath
        Enumeration<URL> resources = ClassValidatorLoader.class.getClassLoader().getResources(
                klass.getName() + CLASS_VALIDATOR_EXT);
        if (resources != null) {
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                // load resouce
                Map<Class<?>, Map<String, ClassValidator<?>>> urlMap = loadFromUrl(url);
                if (urlMap != null && !urlMap.isEmpty()) {
                    for (Map.Entry<Class<?>, Map<String, ClassValidator<?>>> entry : urlMap.entrySet()) {
                        if (ret.containsKey(entry.getKey())) {
                            throw new RuntimeException("has duplicate namespace `" + entry.getKey()
                                    + "`, please check classpath");
                        }
                    }
                }
            }
        }

        return ret;
    }

    private Map<Class<?>, Map<String, ClassValidator<?>>> loadFromUrl(URL url) {
        logger.debug("try to load resouce: {}", url);
        Map<Class<?>, Map<String, ClassValidator<?>>> ret = new HashMap<Class<?>, Map<String, ClassValidator<?>>>();

        return ret;
    }
}
