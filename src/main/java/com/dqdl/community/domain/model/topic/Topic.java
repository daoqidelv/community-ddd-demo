/**
 * 
 */
package com.dqdl.community.domain.model.topic;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月16日
 *
 */
public class Topic {
	/**
	 * 话题id
	 */
	private long id;
	/**
	 * 话题标题
	 */
	private String title;
	/**
	 * 话题描述
	 */
	private String description;
	/**
	 * 话题创建时间
	 */
	private Timestamp createTime;
	/**
	 * 话题下的帖子列表
	 */
	private Set<TopicPost> posts;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return the posts
	 */
	public Set<TopicPost> getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(Set<TopicPost> posts) {
		this.posts = posts;
	}

}
