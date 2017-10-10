package com.dqdl.community.domain.model.post;

/**
 * 帖子置顶消息，value object
 * @author daoqidelv
 * @createdate 2017年10月10日
 */
public class PostTopInfo {
	/**
	 * 帖子id
	 */
	private long postId;
	/**
	 * 置顶标志。true -- 置顶， false -- 不置顶。
	 */
	private boolean isTop;
	/**
	 * 置顶位置，当isTop == true时，该字段有意义。
	 */
	private int topIndex;
	
	public PostTopInfo(long postId, boolean isTop, int topIndex) {
		this.setPostId(postId);
		this.setTop(isTop);
		this.setTopIndex(topIndex);
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public boolean isTop() {
		return isTop;
	}

	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}

	public int getTopIndex() {
		return topIndex;
	}

	public void setTopIndex(int topIndex) {
		this.topIndex = topIndex;
	}

}
