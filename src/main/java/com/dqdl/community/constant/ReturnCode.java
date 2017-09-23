/**
 * 
 */
package com.dqdl.community.constant;

/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月16日
 *
 */
public class ReturnCode {

	/**
	 * 帖子原文至少包含16个字
	 */
	public final static String SUCCESS = "0000";
	
	/** 
	 * 9999:失败
	 */
	public static final String ERROR = "9999";	
	/** 
	 * 9001:系统繁忙
	 */
	public static final String CONNECTION_ERROR = "9001";
	/** 
	 * 9002:未知错误
	 */
	public static final String UNKNOWN_ERROR = "9002";
	/** 
	 * 9003:数据库异常
	 */
	public static final String DATEACCESS_ERROR = "9003";	
	

	/** 
	 * 1000:非法参数
	 */
	public static final String INVALID_PARAMTER = "1000";	
	
	
	/************************************ bussiness return code ********************************************/
	
	/**
	 * 帖子原文至少包含16个字
	 */
	public final static String POST_SOURCE_CONTENT_AT_LEAST_SIXTEEN_WORDS = "2000";
	
	/**
	 * 一个帖子最多只能加入五个话题
	 */
	public final static String ONE_POST_MOST_JOIN_INTO_FIVE_TOPICS = "2001";
	
	/**
	 * 帖子不存在
	 */
	public final static String POST_IS_NOT_EXIT = "2002";
	/**
	 * 不能删除非本人发布的帖子
	 */
	public final static String CAN_NOT_DELETE_OTHER_USERS_POST = "2003";

}
