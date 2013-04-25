/**
 * 
 */
package com.github.smtp2006.bean.validate.rule;

/**
 * 
 * @author wanghua
 * @version 2013-4-19 下午11:21:39
 * 
 */
public interface Rule {
    /**
     * 
     */
    String ERROR_MESSAGE_SPLITER = ";";

    /**
     * 
     * @version 2013-4-21 下午11:22:57
     * @param value
     * @return
     */
    boolean validate(Object value);

    /**
     * 
     * @version 2013-4-19 下午11:26:35
     * @return
     */
    String format();

}
