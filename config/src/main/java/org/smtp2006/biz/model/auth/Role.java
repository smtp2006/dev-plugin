package org.smtp2006.biz.model.auth;

import org.smtp2006.biz.model.BO;

/**
 * @author hua.wanghuawh
 * 
 */
public class Role extends BO implements AuthConstants {
    /**
	 * 
	 */
    private static final long serialVersionUID = 5220653900172503452L;
    /** 角色的编码：org_code */
    private String code;
    /** 显示的顺序 */
    private Integer displayOrder;
    /** 角色的名称 */
    private String name;
    /** 角色的状态：可用/禁用 */
    private Integer status = INT_ENABLED;
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    /**
     * @return the displayOrder
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * @param displayOrder
     *            the displayOrder to set
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

}
