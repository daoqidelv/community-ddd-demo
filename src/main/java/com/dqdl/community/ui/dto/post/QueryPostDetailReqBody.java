package com.dqdl.community.ui.dto.post;

import org.hibernate.validator.constraints.NotEmpty;

import com.dqdl.community.ui.dto.base.RequestBody;

public class QueryPostDetailReqBody extends RequestBody {
	
	/**
	 * 读者用户编号
	 */
	@NotEmpty(message="{request.userId.not.empty}")
	private String readerId;
	
	/**
	 * 帖子id
	 */
	@NotEmpty(message="{request.postId.not.empty}")
	private String postId;	
	

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	

}
