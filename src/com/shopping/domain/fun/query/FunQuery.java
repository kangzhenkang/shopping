package com.shopping.domain.fun.query;

import com.shopping.common.util.page.BaseQuery;

/**
 * Fun information query value class
 * @author WangYue
 *
 */
public class FunQuery extends BaseQuery {
	
	/**
	 * Fun code
	 */
	private String funCode;
	
	/**
	 * Fun name
	 */
	private String funName;
	
    /**
     * function  status
     */
    private int isStatus;
    
	/**
	 * fun yes or no delete
	 */
	private int yn;

	public String getFunCode() {
		return funCode;
	}

	public void setFunCode(String funCode) {
		this.funCode = funCode;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}
	

	public int getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(int isStatus) {
		this.isStatus = isStatus;
	}


	public int getYn() {
		return yn;
	}

	public void setYn(int yn) {
		this.yn = yn;
	}
	
	

}
