package com.dqdl.community.infrastructure.dao.entity.oracle;

import java.sql.Timestamp;

/**
 * oracle仓库相关基础entity
 * create_time 和 last_update_time是数据模型层独有的属性，他和domain层无关。因此他们的赋值交给持久化层完成，比如oracle仓库这两个字段一般取oracle的systimestamp。
 * @author daoqidelv
 * @createdate 2017年9月24日
 */
public class BaseEntity {
	/**
	 * 记录创建时间戳
	 */
	private Timestamp create_time;
	
	/**
	 * 记录最后更新时间戳
	 */
	private Timestamp last_update_time;

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Timestamp getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Timestamp last_update_time) {
		this.last_update_time = last_update_time;
	}
	
	

}
