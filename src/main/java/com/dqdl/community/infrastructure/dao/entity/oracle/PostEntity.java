package com.dqdl.community.infrastructure.dao.entity.oracle;

import java.sql.Timestamp;

/**
 * 该类中属性命名不规范，目的是为了表述translator组件存在的意义。
 * 请忽略不规范命名，实际项目中，强烈推荐model和entity的属性名保持一致，如果能做到这一点，完全可以不要translator和entity。
 * 直接使用model进行持久化操作。
 * @author daoqidelv
 * @createdate 2017年10月15日
 */
public class PostEntity extends BaseEntity{
	/**
	 * 帖子id
	 */
	private long id;
	/**
	 * 帖子标题
	 */
	private String title;
	/**
	 * 帖子原文
	 */
	private String source_content;
	/**
	 * 帖子作者id
	 */
	private long author_id;
	/**
	 * 发帖时间
	 * NOTE： posting_time 和 BaseEntity.create_time不一样，posting_time是domain层赋值，在业务上表示发帖时间，而create_time是数据模型层的概念，和domain无关。
	 */
	private Timestamp posting_time;
	/**
	 * 帖子状态
	 */
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource_content() {
		return source_content;
	}

	public void setSource_content(String source_content) {
		this.source_content = source_content;
	}

	public long getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(long author_id) {
		this.author_id = author_id;
	}

	public Timestamp getPosting_time() {
		return posting_time;
	}

	public void setPosting_time(Timestamp posting_time) {
		this.posting_time = posting_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
