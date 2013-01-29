package org.smtp2006.biz.model.auth;

import org.smtp2006.biz.model.Constants;

/**
 * @author hua.wanghuawh
 * 
 */
public interface AuthConstants extends Constants {
    /**
     * 默认的状态=1为有效
     */
    int USER_STATUS_DEFAULT = 1;
    /**
     * 帐号过期
     */
    int USER_STATUS_ACCOUNT_EXPIRED = 2;
    /**
     * 帐号被锁
     */
    int USER_STATUS_ACCOUNT_LOCKED = 3;
    /**
     * 密码过期
     */
    int USER_STATUS_CREDENTIALS_EXPIRED = 4;
    /**
	 * 
	 */
    String ROLE_PREFIX = "ROLE_";
}
