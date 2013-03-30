package org.smtp2006.biz.model.auth;

import org.smtp2006.biz.model.BO;

/**
 * @author hua.wanghuawh
 * 
 */
public class User extends BO {
    /**
	 * 
	 */
    private static final long serialVersionUID = -2237386400981630823L;
    /** 邮箱 */
    private String email;
    /** 昵称 */
    private String nickName;
    /** 密码 */
    private String password;
    /** 真实姓名 */
    private String realName;
    /** 状态 */
    private Integer status;
    /** 用户类型 */
    private Integer type;
    /** 登录名 */
    private String userName;

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param nickName
     *            the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param realName
     *            the realName to set
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
