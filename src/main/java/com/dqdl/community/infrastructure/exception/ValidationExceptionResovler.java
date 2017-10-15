package com.dqdl.community.infrastructure.exception;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.dqdl.community.constant.ReturnCode;

/**
 * validation exception resovler
 * @author daoqidelv
 * @createdate 2017年9月23日
 */
public class ValidationExceptionResovler extends AbstractHandlerExceptionResolver {
	private static Logger logger = LogManager.getLogger(ValidationExceptionResovler.class);
	
	public ValidationExceptionResovler() {
		// 设置order，在DefaultHandlerExceptionResolver之前执行
		this.setOrder(0);
	}
	
	/**
	 * Handle the case where an argument annotated with {@code @Valid} such as
	 * an {@link RequestBody} or {@link RequestPart} argument fails validation.
	 * 
	 * 自定义ValidationException 异常处理器
	 * 获取到具体的validation 错误信息，并组装CommonResponse，返回给调用方。
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @param handler the executed handler
	 * @return an empty ModelAndView indicating the exception was handled
	 * @throws IOException potentially thrown from response.sendError()
	 */
	@ResponseBody
	protected ModelAndView handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
			HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		logger.debug("Validation failed! ", ex);
		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
		StringBuffer errmsgBF = new StringBuffer();  
		for(ObjectError error : errors) {
			String massage = error.getDefaultMessage();
			errmsgBF.append(massage);
			errmsgBF.append("||");
		}
		String errmsgString = errmsgBF.toString();
		errmsgString = errmsgString.substring(0, errmsgString.length()-2);
		
		Map<String,Object> map = new TreeMap<String,Object>();
		map.put("returnCode", ReturnCode.INVALID_PARAMTER);
		//错误信息细节使用validation返回的多个error的拼接
		map.put("returnMsg", errmsgString); 
		map.put("body", null);
        
        ModelAndView mav = new ModelAndView();
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setAttributesMap(map);        
		mav.setView(view);	
		return mav;
	}


	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		if(ex instanceof MethodArgumentNotValidException) {
			try {
				return handleMethodArgumentNotValidException( (MethodArgumentNotValidException)ex, request, response, handler);
			} catch (IOException e) {
				logger.error("doResolveException: ", e);
			}
		}
		return null;
	}
	

}
