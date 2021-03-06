package com.haos.domain.employee.query;

import com.haos.common.util.page.BaseQuery;
/**
 * Employee function query value class
 * @author WangYue
 *
 */

public class EmployeeFunQuery extends BaseQuery  {
	private static final long serialVersionUID = 1L;

    
    /**
     *  employee code
     */
    private String employeeCode;
    
    /**
     * function code
     */
    private String funCode;
    
    /**
     * yes or not  delete
     */
    private int yn;
    
    /**
     * yes or not  read
     */
    private int isRead;

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }


    public String getFunCode() {
        return funCode;
    }

    public void setFunCode(String funCode) {
        this.funCode = funCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public int getRead() {
        return isRead;
    }

    public void setRead(int read) {
        isRead = read;
    }
}