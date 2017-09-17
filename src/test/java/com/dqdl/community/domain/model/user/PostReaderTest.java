package com.dqdl.community.domain.model.user;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.dqdl.community.constant.ExceptionCode;
import com.dqdl.community.domain.model.post.Post;
import com.dqdl.community.domain.model.post.PostStatus;
import com.dqdl.community.exception.BusinessException;

public class PostReaderTest {
	
	private PostReader postReader;
	private Post post;
	private long userId;
	
	@Before
	public void setUp() throws Exception {
		userId = 40;
		postReader = new PostReader(userId);
		post = new Post(userId, "测试帖子",  "测试帖子内容，内容必须大于16个字，字数不够我来凑！");
	}
	
	@Test
	public void deletePostSuccess() {
		try {
			post = postReader.deletePost(post);
			assertTrue(PostStatus.HAS_DELETED.equals(post.getStatus()));	
		} catch (BusinessException e) {
			fail("unExpected an BussinessException to be thrown, " + e.getMessage());
		}
	}
	
	@Test
	public void deletePostFailWhenPostIsNull() {
		try {
			postReader.deletePost(null);
			fail("expected an BussinessException to be thrown, but do not catch.");
		} catch (BusinessException e) {
			assertTrue(ExceptionCode.POST_IS_NOT_EXIT.equals(e.getMessage()));
		}
	}

	@Test
	public void deletePostFailWhenPostIsNotMine() {
		try {
			Post otherPost = new Post(41, "测试帖子",  "测试帖子内容，内容必须大于16个字，字数不够我来凑！");
			postReader.deletePost(otherPost);
			fail("expected an BussinessException to be thrown, but do not catch.");
		} catch (BusinessException e) {
			assertTrue(ExceptionCode.CAN_NOT_DELETE_OTHER_USERS_POST.equals(e.getMessage()));
		}
	}
}
