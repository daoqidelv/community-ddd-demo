/**
 * 
 */
package com.dqdl.community.constant;

/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月16日
 *
 */
public class ExceptionCode {
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
