/**
 * https://github.com/smtp2006/bean-validate-plugin.git 
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
 * 
 *  <b> Each property can have a PropertyValidator with a RuleChain#List<Rule>.</b>
 * 
 * </pre>
 * 
 * @author wanghua
 * @version 2013-4-21 下午10:34:44
 * 
 */
public class ClassValidator<T> {
    // ------------------------------------------------------ Static Variables
    private static final Logger logger = LoggerFactory.getLogger(ClassValidator.class);
    // ------------------------------------------------------ Instance Variables
    private List<PropertyValidator> propertyValidators;

    //

    /**
     * 
     * @version 2013-4-21 下午11:38:54
     * @param value
     * @return
     */
    public Map<String, List<Rule>> validate(T value) {
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
                        logger.warn("getProperty(" + proValidator.getProperty() + ") failure with exception-->"
                                + e.getMessage());
                    }

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
     * @param propertyValidators
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
     * @param propertyValidators
     *            the propertyValidators to set
     */
    public void setPropertyValidators(List<PropertyValidator> propertyValidators) {
        this.propertyValidators = propertyValidators;
    }

}