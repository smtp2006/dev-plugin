package org.smtp2006.biz.model.system;

import java.util.List;

import org.smtp2006.biz.model.BO;

/**
 * @author hua.wanghuawh
 * 
 */
public class Menu extends BO {
    /**
	 * 
	 */
    private static final long serialVersionUID = -558133041466368659L;
    /** 编码 */
    private String code;
    /** 名称 */
    private String name;
    /** 是否是叶子节点 */
    private Boolean isLeaf;
    /** 层级 */
    private Integer level;
    /** 显示顺序 */
    private Integer displayOrder;
    /** 状态 */
    private Integer status;
    /** url */
    private String url;
    /** 需要的权限 */
    private String authority;
    /** URL是否是相对路径 */
    private Boolean isRelative;

    private Long parentId;

    private List<Menu> children;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

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
     * @return the isLeaf
     */
    public Boolean getIsLeaf() {
        return isLeaf;
    }

    /**
     * @param isLeaf
     *            the isLeaf to set
     */
    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * @return the level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     *            the level to set
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * @return the displayOrder
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * @param displayOrder
     *            the displayOrder to set
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
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
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * @param authority
     *            the authority to set
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * @return the isRelative
     */
    public Boolean getIsRelative() {
        return isRelative;
    }

    /**
     * @param isRelative
     *            the isRelative to set
     */
    public void setIsRelative(Boolean isRelative) {
        this.isRelative = isRelative;
    }

    /**
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     *            the parentId to set
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the children
     */
    public List<Menu> getChildren() {
        return children;
    }

    /**
     * @param children
     *            the children to set
     */
    public void setChildren(List<Menu> children) {
        this.children = children;
    }

}
