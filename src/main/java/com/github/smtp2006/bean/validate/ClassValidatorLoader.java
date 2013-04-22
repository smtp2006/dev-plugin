/**
 * https://github.com/smtp2006/bean-validate-plugin.git 
 */
package com.github.smtp2006.bean.validate;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
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
    /**
     * @param klass
     * @return
     * @throws IOException
     */
    /**
     * @param klass
     * @return
     * @throws IOException
     */
    /**
     * @param klass
     * @return
     * @throws IOException
     */
    /**
     * @param klass
     * @return
     * @throws IOException
     */
    public synchronized Map<String, ClassValidator<?>> loadClassValidator(Class<?> klass) throws Exception {
        if (klass == null) {
            throw new IllegalArgumentException("klass must not be null");
        }
        Map<String, ClassValidator<?>> ret = new HashMap<String, ClassValidator<?>>();
        // get resouces from classpath
        Enumeration<URL> resources = ClassValidatorLoader.class.getClassLoader().getResources(
                klass.getName() + CLASS_VALIDATOR_EXT);
        if (resources != null) {
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                // load resouce
                Map<String, ClassValidator<?>> urlMap = loadFromUrl(url);
                if (urlMap != null && !urlMap.isEmpty()) {
                    for (Map.Entry<String, ClassValidator<?>> entry : urlMap.entrySet()) {
                        if (ret.containsKey(entry.getKey())) {
                            throw new RuntimeException("has duplicate namespace `" + entry.getKey()
                                    + "`, please check classpath");
                        }
                        ret.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        } else {
            throw new RuntimeException("there is 0 " + klass.getName() + CLASS_VALIDATOR_EXT
                    + " in the classpath, please check");
        }

        return ret;
    }

    private Map<String, ClassValidator<?>> loadFromUrl(URL url) throws Exception {
        logger.debug("try to load resouce: {}", url);
        Map<String, ClassValidator<?>> ret = new HashMap<String, ClassValidator<?>>();

        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        Element classValidators = document.getRootElement();
        if ("classValidators".equals(classValidators.getName())) {
        } else {
            throw new RuntimeException("RootElement must be : classValidators");
        }
        return ret;
    }
}
