package com.dqdl.community.domain.model.user;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author daoqidelv
 * @createdate 2017年10月15日
 */
public class UserTest {
	
	private User user;
	private long userId;
	
	@Before
	public void setUp() throws Exception {
		userId = 40;
		user = new User(userId);
	}
	
	@Test
	public void isMyselfTrueWhenOtherUserIsSelf() {
		User otherUser = new User(userId);
		assertTrue(user.isMyself(otherUser));		
	}
	
	@Test
	public void isMyselfFalseWhenOtherUserIsNull() {
		assertFalse(user.isMyself(null));		
	}
	
	
	@Test
	public void isMyselfFalseWhenOtherUserIsNotSelf() {
		User otherUser = new User(41);
		assertFalse(user.isMyself(otherUser));		
	}

}
