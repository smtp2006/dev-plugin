package org.smtp2006.biz.model.system;

import org.smtp2006.biz.model.BO;

/**
 * @author hua.wanghuawh
 * 
 */
public class Config extends BO {
    /**
	 * 
	 */
    private static final long serialVersionUID = 7286759897754409590L;
    /** 编码 */
    private String textField;
    /** 名称 */
    private String valueField;
    /** 状态 */
    private Integer status;
    /** 类型 */
    private Integer type;
    /** 显示顺序 */
    private Integer displayOrder;

    /**
     * @return
     */
    public String getTextField() {
        return textField;
    }

    /**
     * @param textField
     */
    public void setTextField(String textField) {
        this.textField = textField;
    }

    /**
     * @return
     */
    public String getValueField() {
        return valueField;
    }

    /**
     * @param valueField
     */
    public void setValueField(String valueField) {
        this.valueField = valueField;
    }

    /**
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * @param displayOrder
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}
