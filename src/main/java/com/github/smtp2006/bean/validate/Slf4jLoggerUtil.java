/**
 * 
 */
package com.github.smtp2006.bean.validate;

import org.slf4j.Logger;

/**
 * @author hua.wanghuawh
 * 
 */
public class Slf4jLoggerUtil {
    /**
     * @param logger
     * @param msg
     * @param e
     */
    public static void exception(Logger logger, String msg, Exception e) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg, e);
        } else {
            logger.error(msg + " with exception:" + e.getMessage());
        }

    }
}
