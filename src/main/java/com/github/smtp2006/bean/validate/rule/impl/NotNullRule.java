/**
 * http://github.com/smtp2006 
 */
package com.github.smtp2006.bean.validate.rule.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.smtp2006.bean.validate.rule.Rule;

/**
 * Value不能为空
 * 
 * @author wanghua
 * @version 2013-4-21 下午10:21:22
 * 
 */
@XmlRootElement(name = "rule")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotNullRule implements Rule {

    /*
     * (non-Javadoc)
     * 
     * @see com.github.smtp2006.bean.validate.rule.Rule#validate(java.lang.Object)
     */
    @Override
    public boolean validate(Object value) {
        return value != null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.github.smtp2006.bean.validate.rule.Rule#errorMessage()
     */
    @Override
    public String format() {
        return "{0} must not be null";
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.github.smtp2006.bean.validate.rule.Rule#getClassName()
     */
    @Override
    @XmlAttribute(name = "class")
    public String getClassName() {
        return this.getClass().getName();
    }

}
