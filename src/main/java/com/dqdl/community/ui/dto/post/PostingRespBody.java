package com.dqdl.community.ui.dto.post;

import com.dqdl.community.ui.dto.base.ResponseBody;

/**
 * Posting响应体
 * @author daoqidelv
 * @createdate 2017年10月15日
 */
public class PostingRespBody extends ResponseBody {
	
	private String postId;

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}
}
