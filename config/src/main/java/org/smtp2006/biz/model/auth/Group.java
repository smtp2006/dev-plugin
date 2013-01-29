package org.smtp2006.biz.model.auth;

import org.smtp2006.biz.model.BO;

/**
 * @author hua.wanghuawh
 * 
 */
public class Group extends BO {
    /**
	 * 
	 */
    private static final long serialVersionUID = 5617395691080654748L;
    /** Organization的名称 */
    private String name;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
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
    /** Organization的状态 */
    private Integer status;

}
