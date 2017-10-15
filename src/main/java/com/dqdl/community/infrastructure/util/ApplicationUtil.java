package com.dqdl.community.infrastructure.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.dqdl.community.constant.ReturnCode;

/**
 * 应用相关工具类
 * @author daoqidelv
 * @createdate 2017年10月15日
 */
@Component
public class ApplicationUtil implements ApplicationContextAware {
	private static Logger logger = LogManager.getLogger(ApplicationUtil.class);
	
	private ApplicationContext applicationContext;
	
	/**
	 * local 语言
	 */
	
	private String localeLang;
	
	/**
	 * local 国家
	 */
	
	private String localeCountry;
	
	public ApplicationUtil() {
		this.localeCountry="CN";
		this.localeLang = "zh";
	}
	
	
    /**
	 * 获取固定提示信息
	 * 
	 * @param returnCode
	 * @return
	 */
	public String getReturnMsg(String returnCode) {
		try {
			return applicationContext.getMessage(returnCode, null, new Locale(localeLang, localeCountry));
		} catch (Exception e) {
			logger.warn("找不到该错误码对应的提示信息,key=" + returnCode, e);
		}
		return applicationContext.getMessage(ReturnCode.UNKNOWN_ERROR, null, new Locale(localeLang, localeCountry));
	}

	/**
	 * 获取动态提示信息
	 * 
	 * @param returnCode
	 * @param arguments
	 * @return
	 */
	public String getReturnMsg(String returnCode, Object... arguments) {
		try {
			return applicationContext.getMessage(returnCode, arguments, new Locale(localeLang, localeCountry));
		} catch (Exception e) {
			logger.warn("找不到该错误码对应的提示信息,key=" + returnCode, e);
		}
		return applicationContext.getMessage(ReturnCode.UNKNOWN_ERROR, null, new Locale(localeLang, localeCountry));
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
    public String convertTimestampToString(Timestamp timestamp, String pattern) {
        return (new SimpleDateFormat(pattern)).format(timestamp.getTime());
    }

}
