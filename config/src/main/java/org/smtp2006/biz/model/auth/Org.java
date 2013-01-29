package ox.andalu.wms.domain.auth;

import ox.andalu.wms.domain.AObject;

public class Org extends BO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5617395691080654748L;
	/** Organization的名称 */
	private String name;
	/** Organization的状态 */
	private Integer status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
