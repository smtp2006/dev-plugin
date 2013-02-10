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
    private List<Menu> children;
    /** 编码 */
    private String code;
    private String description;
    /** 显示顺序 */
    private int displayOrder;
    /** 是否是叶子节点 */
    private boolean isLeaf;
    /** URL是否是相对路径 */
    private boolean isRelative;
    /** 层级 */
    private int level;
    /** 名称 */
    private String name;
    private Long parentId;
    /** 需要的权限 */
    private String role;

    /** 状态 */
    private int status;

    /** uri */
    private String uri;

    /**
     * @return the children
     */
    public List<Menu> getChildren() {
        return children;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @return the displayOrder
     */
    public int getDisplayOrder() {
        return displayOrder;
    }

    /**
     * @return the isLeaf
     */
    public boolean getIsLeaf() {
        return isLeaf;
    }

    /**
     * @return the isRelative
     */
    public boolean getIsRelative() {
        return isRelative;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param children
     *            the children to set
     */
    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param displayOrder
     *            the displayOrder to set
     */
    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * @param isLeaf
     *            the isLeaf to set
     */
    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * @param isRelative
     *            the isRelative to set
     */
    public void setIsRelative(boolean isRelative) {
        this.isRelative = isRelative;
    }

    /**
     * @param level
     *            the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param parentId
     *            the parentId to set
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @param uri
     *            the uri to set
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

}
