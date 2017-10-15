/**
 * 
 */
package com.dqdl.community.domain.model.topic;


/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月16日
 *
 */
public class TopicPost {
	
	private long postId;
	
	private long topicId;
	
	public TopicPost(long topicId, long postId) {
		this.setPostId(postId);
		this.setTopicId(topicId);
	}

	/**
	 * @return the postId
	 */
	public long getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/**
	 * @return the topicId
	 */
	public long getTopicId() {
		return topicId;
	}

	/**
	 * @param topicId the topicId to set
	 */
	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}
	
	@Override
	public boolean equals(Object anObject) {
		if (this == anObject) {
            return true;
        }
		if(anObject instanceof TopicPost) {
			if(this.postId == ((TopicPost)anObject).getPostId()
					&& this.topicId == ((TopicPost)anObject).getTopicId()) {
				return true;
			}
		} 
		return false;	
	}	
	
	@Override
    public int hashCode() {
    	return Long.hashCode(this.postId) ^ Long.hashCode(this.topicId);
    }

}
