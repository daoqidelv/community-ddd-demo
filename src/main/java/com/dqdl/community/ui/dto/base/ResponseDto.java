package com.dqdl.community.ui.dto.base;

/**
 * 响应dto
 * @author daoqidelv
 * @createdate 2017年10月15日
 */
public class ResponseDto implements UIDto{
	
    /**
     * 状态码
     */
    private String returnCode;

    /**
     * 提示信息
     */
    private String returnMsg;

    /**
     * 各个接口返回的数据
     */
    private Object body;

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

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
	
}
