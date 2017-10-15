package com.dqdl.community.ui.dto.post;

import org.hibernate.validator.constraints.NotEmpty;

import com.dqdl.community.ui.dto.base.RequestBody;
/**
 * DeletePost请求体
 * @author daoqidelv
 * @createdate 2017年10月15日
 */
public class DeletePostReqBody extends RequestBody {
	/**
	 * 删帖用户id
	 */
	@NotEmpty(message="{request.userId.not.empty}")
	private String userId;
	
	/**
	 * 帖子id
	 */
	@NotEmpty(message="{request.postId.not.empty}")
	private String postId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	

}
