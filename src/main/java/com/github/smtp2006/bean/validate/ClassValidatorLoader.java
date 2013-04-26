/**
 * https://github.com/smtp2006/bean-validate-plugin.git 
 */
package com.github.smtp2006.bean.validate;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.digester3.Digester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.smtp2006.bean.validate.digester.SingletonObjectCreateRule;
import com.github.smtp2006.bean.validate.rule.RuleChain;

/**
 * @author wanghua
 * @version 2013-4-22 上午12:35:08
 * 
 */
class ClassValidatorLoader {
    // ------------------------------------------------------ Static Variables
    /**
     * logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(ClassValidatorLoader.class);
    /**
     * Java Bean Class扩展名.
     */
    public static final String CLASS_VALIDATOR_EXT = ".xml";

    /**
     * @param klass 要加载的Class
     * @return 加载Class.xml为Map，key=ClassValidator#name, value=ClassValidator.
     * @throws Exception Digester解析异常
     */
    public synchronized Map<String, ClassValidator<?>> loadClassValidator(Class<?> klass) throws Exception {
        if (klass == null) {
            throw new IllegalArgumentException("klass must not be null");
        }
        Map<String, ClassValidator<?>> ret = null;
        // get resouces from classpath
        String fileName = klass.getName().replace(".", "/") + CLASS_VALIDATOR_EXT;
        logger.debug("loadClassValidator from file:{}", fileName);
        Enumeration<URL> resources = ClassValidatorLoader.class.getClassLoader().getResources(fileName);
        if (resources != null && resources.hasMoreElements()) {
            ret = new HashMap<String, ClassValidator<?>>();
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                // load resouce
                Map<String, ClassValidator<?>> urlMap = loadFromUrl(url);
                if (urlMap != null && !urlMap.isEmpty()) {
                    for (Map.Entry<String, ClassValidator<?>> entry : urlMap.entrySet()) {
                        String classValidatorKey = klass.getName() + "#" + entry.getKey();
                        if (ret.containsKey(classValidatorKey)) {
                            throw new RuntimeException("has duplicate namespace `" + classValidatorKey
                                    + "`, please check classpath");
                        }
                        ret.put(classValidatorKey, entry.getValue());
                    }
                }
            }
        }
        if (ret == null) {
            throw new RuntimeException("there is 0 " + klass.getName() + CLASS_VALIDATOR_EXT
                    + " in the classpath, please check");
        }
        return ret;
    }
    /**
     * 
     * @version 2013-4-27 下午11:17:21
     * @param url Class.xml的URL
     * @return 加载URL指定的文件
     * @throws Exception Digester异常
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private Map<String, ClassValidator<?>> loadFromUrl(URL url) throws Exception {
        logger.debug("try to load resouce: {}", url);
        Digester digester = new Digester();
        // digester.setValidating(true);
        // push Map
        digester.push(new HashMap<String, ClassValidator>());
        // parse ClassValidator
        digester.addCallMethod("classValidator", "put", 2);
        digester.addCallParam("classValidator", 0, "name");

        digester.addObjectCreate("classValidator", ClassValidator.class);
        digester.addSetProperties("classValidator");

        // parse ClassValidator.List#propertyValidators
        digester.addObjectCreate("classValidator/propertyValidators", ArrayList.class);

        // parse ClassValidator.List#propertyValidators.propertyValidator
        digester.addObjectCreate("classValidator/propertyValidators/propertyValidator", PropertyValidator.class);
        digester.addCallMethod("classValidator/propertyValidators/propertyValidator/property", "setProperty", 0);

        digester.addObjectCreate("classValidator/propertyValidators/propertyValidator/ruleChain", RuleChain.class);

        // digester.addObjectCreate("classValidator/propertyValidators/propertyValidator/ruleChain/rules/rule", null,
        // "class");
        digester.addRule("classValidator/propertyValidators/propertyValidator/ruleChain/rules/rule",
                new SingletonObjectCreateRule());
        digester.addSetNext("classValidator/propertyValidators/propertyValidator/ruleChain/rules/rule", "addRule");
        digester.addSetNext("classValidator/propertyValidators/propertyValidator/ruleChain", "setRuleChain");

        digester.addSetNext("classValidator/propertyValidators/propertyValidator", "add");

        // parse ClassValidator.setPropertyValidators
        digester.addSetNext("classValidator/propertyValidators", "setPropertyValidators", List.class.getName());

        digester.addCallParam("classValidator", 1, true);
        Map classValidators = digester.parse(url);
        return classValidators;
    }
}
