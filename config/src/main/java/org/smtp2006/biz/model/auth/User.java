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
    /** 登录名 */
    private String userName;
    /** 昵称 */
    private String nickName;
    /** 真实姓名 */
    private String realName;
    /** 密码 */
    private String password;
    /** 邮箱 */
    private String email;
    /** 状态 */
    private Integer status;
    /** 用户类型 */
    private Integer type;
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }
    /**
     * @param nickName
     *            the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    /**
     * @return the realName
     */
    public String getRealName() {
        return realName;
    }
    /**
     * @param realName
     *            the realName to set
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }
    /**
     * @param type
     *            the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }
}
