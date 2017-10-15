package com.dqdl.community.infrastructure.exception;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.dqdl.community.constant.ReturnCode;
import com.dqdl.community.infrastructure.util.ApplicationUtil;

/**
 * 异常处理器
 * @author daoqidelv
 * @createdate 2017年9月23日
 */
@Component
public class ExceptionHandler {
	
	private static Logger logger = LogManager.getLogger(ExceptionHandler.class);
	
	private final static String SYSTEM_EXCEPTION_PREFIX_CHARACTOR = "9";
	
	@Autowired
	private ApplicationUtil applicationUtil;

	public Map<String, String> handle(Exception e) {
		
		Map<String, String> resultMap = new HashMap<String, String>(2);
		//NOTE：原来默认返回的是NETWORK_EXCEPTION，不太合理，更改为默认返回UNKNOWN_ERROR
		String returnCode = ReturnCode.UNKNOWN_ERROR;
		String returnMsg = null;
		//依据异常类型进行分别处理，将异常信息转义为用户友好的提示信息
		if (e instanceof DataAccessException) {
			returnCode = ReturnCode.DATEACCESS_ERROR;
			returnMsg = applicationUtil.getReturnMsg(returnCode);
			logger.error("DataAccessException: ", e);
		} else if (e instanceof CommunicationException) {
			returnCode = ReturnCode.CONNECTION_ERROR;
			returnMsg = applicationUtil.getReturnMsg(returnCode);
			logger.error("ConnectionException: ", e);
		} else if (e instanceof BusinessException) {
			returnCode = ((BusinessException) e).getCode();
			if(returnCode == null ) {
				returnCode = ((BusinessException) e).getMessage();
			}
			if(((BusinessException) e).getArguments() != null) {
				returnMsg = applicationUtil.getReturnMsg(returnCode);
			} else {
				returnMsg = applicationUtil.getReturnMsg(returnCode, ((BusinessException) e).getArguments());
			}
			//只当系统异常时，才将exception堆栈输出
			if(returnCode.startsWith(SYSTEM_EXCEPTION_PREFIX_CHARACTOR)){
				logger.error("BusinessException: ", e);
			}
		} else if (e instanceof OutsideServiceException) {
			returnCode = ((OutsideServiceException) e).getReturnCode();
			returnMsg = ((OutsideServiceException) e).getReturnMsg();
			logger.error("OutsideServiceException: ",e);
		} else {
			//原来默认返回的是NETWORK_EXCEPTION，不太合理，更改为默认返回UNKNOWN_ERROR
			returnCode = ReturnCode.UNKNOWN_ERROR;
			returnMsg = applicationUtil.getReturnMsg(returnCode);
			logger.error("unknown exception: ",e);
		}	
		
		resultMap.put("errorCode", returnCode);
		resultMap.put("errorMsg", returnMsg);
		return resultMap;
	}
}
