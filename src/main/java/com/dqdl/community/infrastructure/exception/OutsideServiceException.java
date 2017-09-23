package com.dqdl.community.infrastructure.exception;

/**
 * 第三方服务返回异常，配合transport使用
 * @author daoqidelv
 * @createdate 2017年9月23日
 */
public class OutsideServiceException  extends Exception{
	
	private static final long serialVersionUID = 462459296204180016L;

	private String returnCode;
	
	private String returnMsg;

	public OutsideServiceException() {
        super();
    }
	
    public OutsideServiceException(String returnCode, String returnMsg) {
        super(returnCode+":"+returnMsg);
    }
    
	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
    
    
}
