/**
 * https://github.com/smtp2006/bean-validate-plugin.git.
 */
package com.github.smtp2006.bean.validate;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.smtp2006.bean.validate.rule.Rule;

/**
 * Used to validate one bean`s properties.
 * 
 * <pre>
 *  <b>
 *      Each property can have a PropertyValidator with a RuleChain#List<Rule>.
 *  </b>
 * </pre>
 * @author wanghua
 * @version 2013-4-21 下午10:34:44
 * @param <T>
 */
public class ClassValidator<T> {
    // ------------------------------------------------------ Static Variables
    /**
     * log class.
     */
    private static final Logger logger = LoggerFactory.getLogger(ClassValidator.class);
    /**
     * ClassValidator的默认命名空间.
     */
    public static final String DEFAULT_NAME = "default";
    // ------------------------------------------------------ Instance Variables
    /**
     * 指定哪些属性需要校验.
     */
    private List<PropertyValidator> propertyValidators;
    /**
     * 默认命名空间.
     */
    private String name = DEFAULT_NAME;


    /**
     * @version 2013-4-21 下午11:38:54
     * @param value 被校验对象
     * @return 返回校验失败的字段以及字段对应校验失败的规则
     */
    public final Map<String, List<Rule>> validate(T value) {
        Map<String, List<Rule>> failures = null;
        if (propertyValidators != null) {
            for (PropertyValidator proValidator : propertyValidators) {
                Object proValue = null;
                try {
                    proValue = BeanUtils.getProperty(value, proValidator.getProperty());
                } catch (Exception e) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("getProperty(" + proValidator.getProperty() + ") failure", e);
                    } else {
                        logger.warn("getProperty(" + proValidator.getProperty()
                                + ") failure with exception :" + e.getMessage());
                    }
                    // if no getter, continue
                    continue;
                }
                List<Rule> proValidate = proValidator.validate(proValue);
                // property validate failure;
                if (proValidate != null) {
                    // init faulures
                    if (failures == null) {
                        failures = new TreeMap<String, List<Rule>>();
                    }
                    failures.put(proValidator.getProperty(), proValidate);
                }
            }
        }
        return failures;
    }

    /**
     */
    public ClassValidator() {
        super();
    }

    /**
     * @param propertyValidators 指定哪些属性需要校验.
     */
    public ClassValidator(List<PropertyValidator> propertyValidators) {
        super();
        this.propertyValidators = propertyValidators;
    }

    // ------------------------------------------------------ Getters & Setters

    /**
     * @return the propertyValidators
     */
    public List<PropertyValidator> getPropertyValidators() {
        return propertyValidators;
    }

    /**
     * @param propertyValidators the propertyValidators to set
     */
    public void setPropertyValidators(List<PropertyValidator> propertyValidators) {
        this.propertyValidators = propertyValidators;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the name
     */
    public String getNameSpace() {
        return this.getClass().getName() + "#" + name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
