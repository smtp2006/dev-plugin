package org.smtp2006.biz.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hua.wanghuawh
 * 
 */
public abstract class BO implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -841155712381060396L;
    private Long id;

    private Date version;

    /**
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * @return
     */
    public Date getVersion() {
        return version;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param version
     */
    public void setVersion(Date version) {
        this.version = version;
    }

}
