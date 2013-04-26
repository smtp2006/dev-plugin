/**
 * https://github.com/smtp2006/bean-validate-plugin.git.
 */
package com.github.smtp2006.bean.validate.rule;

/**
 * @author wanghua
 * @version 2013-4-19 下午11:21:39
 */
public interface Rule {
    /**
     * {@link Rule#validate(Object)}失败{@link Rule#format()}结果的分隔符.
     */
    String ERROR_MESSAGE_SPLITER = ";";

    /**
     * @version 2013-4-21 下午11:22:57
     * @param value 被校验的对象
     * @return 校验成功=true
     */
    boolean validate(Object value);

    /**
     * @version 2013-4-19 下午11:26:35
     * @return {@link Rule#validate(Object)}失败返回的消息格式，e.g:{0} is required.
     */
    String format();
}
