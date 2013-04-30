/**
 * https://github.com/smtp2006/bean-validate-plugin.git.
 */
package com.github.smtp2006.bean.validate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wanghua
 * @version 2013-4-29 上午1:56:12
 *
 */
public class Slf4jLoggerUtilTest {
    Logger logger = LoggerFactory.getLogger(Slf4jLoggerUtilTest.class);
    @Test
    public void testException(){
        Slf4jLoggerUtil.exception(logger, "error msg", new Exception("exception"));
    }
}
