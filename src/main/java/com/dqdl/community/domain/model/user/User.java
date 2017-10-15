package com.dqdl.community.domain.model.user;

import org.springframework.util.Assert;

/**
 * 用户 实体
 * @author daoqidelv
 * @createdate 2017年10月15日
 */
public class User {
	/**
	 * 用户id
	 */
	private long id;

	public User() {
		super();
	}
	
	public User(long id) {
		this.setId(id);
	}
	
	/**
	 * 判定另外一个用户是否是本人
	 * @param otherUser
	 * @return 
	 * 	true —— 本人
	 *  false —— 非本人
	 */
	public boolean isMyself(User otherUser) {
		if(this.equals(otherUser)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean equals(Object anObject) {
		if(anObject == null) {
			return false;
		}  
		if(this == anObject) {
			return true;
		} 
		if(anObject instanceof User) {
			if(this.id == ((User)anObject).getId()) {
				return true;
			}
		}
		return false;		
	}
	
	@Override
	public int hashCode() {
		return Long.hashCode(this.id);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		Assert.isTrue(id > 0, "User's Id must greater than ZERO.");
		this.id = id;
	}

}
