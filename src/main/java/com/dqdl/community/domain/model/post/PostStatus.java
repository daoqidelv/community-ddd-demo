/**
 * 
 */
package com.dqdl.community.domain.model.post;

import com.dqdl.community.constant.CommonConstants;

/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月17日
 * 帖子状态枚举类
 */
public enum PostStatus {
	/**
	 * 已发布
	 */
	HAS_POSTED("00","已发布"), 
	
	/**
	 * 等待运营审核
	 */
	WAIT_VERIFY("01", "等待运营审核"), 
	
	/**
	 * 已删除
	 */
	HAS_DELETED("99", "已删除"); 
	
	private String code;
	
	private String description;
	
	PostStatus(String code, String description) {
		this.code = code;
		this.description = description;
	}	

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}	

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	public static PostStatus getPostStatus(String code) throws IllegalArgumentException {
		if(CommonConstants.POST_STATUS_HAS_POSTED.equals(code)) {
			return HAS_POSTED;
		} else if(CommonConstants.POST_STATUS_WAIT_VERIFY.equals(code)) {
			return WAIT_VERIFY;
		} else if(CommonConstants.POST_STATUS_HAS_DELETED.equals(code)) {
			return HAS_DELETED;
		} else {
			throw new IllegalArgumentException("Can not find a PostStatus for this code: "+code);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString())
			.append(": code=").append(this.getCode())
			.append(", decsription=").append(this.getDescription());
		return sb.toString();
	}
}
