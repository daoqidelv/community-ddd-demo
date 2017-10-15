package com.dqdl.community.ui.dto.post;

import com.dqdl.community.ui.dto.base.ResponseBody;

/**
 * QueryPostDtail响应体
 * @author daoqidelv
 * @createdate 2017年10月15日
 */
public class QueryPostDetailRespBody extends ResponseBody {
	/**
	 * 帖子id
	 */
	private String postId;
	/**
	 * 帖子作者用户编号
	 */
	private String authorId;
	/**
	 * 帖子标题
	 */
	private String title;
	/**
	 * 帖子正文
	 */
	private String sourceContent;
	/**
	 * 帖子发帖时间
	 */
	private String postingTime;

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSourceContent() {
		return sourceContent;
	}

	public void setSourceContent(String sourceContent) {
		this.sourceContent = sourceContent;
	}

	public String getPostingTime() {
		return postingTime;
	}

	public void setPostingTime(String postingTime) {
		this.postingTime = postingTime;
	}
	
}
