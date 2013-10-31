/**
 * Copyright (c) 2013.
 */
package smtp2006.commons.context.impl;

import java.util.HashMap;

import smtp2006.commons.context.Context;

/**
 * @author 王华
 * @version 2013年10月31日 上午11:24:31
 * 
 */
public class ThreadLocalContext extends HashMap implements Context {
    /**
     * 
     */
    private static final long serialVersionUID = -3652981795004100102L;

    private static final ThreadLocal<ThreadLocalContext> contextThreadLocal = new ThreadLocal<ThreadLocalContext>();

    public static final String DATE_FORMAT = "yyyyMMddHHMMSS";

    /**
     * 返回当前上下文
     * 
     * @return
     */
    public static ThreadLocalContext getContext() {
        ThreadLocalContext ctx = contextThreadLocal.get();
        if (ctx == null) {
            setContext(new ThreadLocalContext());
            ctx = contextThreadLocal.get();
        }
        return ctx;
    }

    public static void setContext(ThreadLocalContext context) {
        contextThreadLocal.set(context);
    }
}
