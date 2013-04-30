/**
 * http://github.com/smtp2006 
 */
package com.github.smtp2006.bean.validate;

import java.util.List;

import com.github.smtp2006.bean.validate.rule.Rule;
import com.github.smtp2006.bean.validate.rule.RuleChain;

/**
 * @author wanghua
 * @version 2013-4-21 下午9:59:33
 * 
 */
public class PropertyValidator {

    // ------------------------------------------------------ Instance Variables
    /**
     * 被校验的属性.
     */
    private String property;
    /**
     * 需要校验的规则.
     */
    private RuleChain ruleChain;

    // ------------------------------------------------------ Constructor
    /**
     * 默认构造函数.
     */
    public PropertyValidator() {
    }

    /**
     * @param property 被校验的属性
     * @param ruleChain 需要校验的规则
     */
    public PropertyValidator(String property, RuleChain ruleChain) {
        super();
        this.property = property;
        this.ruleChain = ruleChain;
    }

    // ------------------------------------------------------ Getters & Setters
    /**
     * @return the property
     */
    public String getProperty() {
        return property;
    }

    /**
     * @param property
     *            the property to set
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * @return the ruleChain
     */
    public RuleChain getRuleChain() {
        return ruleChain;
    }

    /**
     * @param ruleChain
     *            the ruleChain to set
     */
    public void setRuleChain(RuleChain ruleChain) {
        this.ruleChain = ruleChain;
    }

    /**
     * @param value 属性值
     * @return 校验失败的规则
     */
    public List<Rule> validate(Object value) {
        return ruleChain.validate(value);
    }

}
