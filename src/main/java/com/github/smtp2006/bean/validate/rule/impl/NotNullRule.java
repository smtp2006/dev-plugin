/**
 * http://github.com/smtp2006 
 */
package com.github.smtp2006.bean.validate.rule.impl;

import com.github.smtp2006.bean.validate.rule.Rule;

/**
 * Value不能为空
 * 
 * @author wanghua
 * @version 2013-4-21 下午10:21:22
 * 
 */
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

}
