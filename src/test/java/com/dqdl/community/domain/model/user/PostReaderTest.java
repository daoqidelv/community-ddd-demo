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
	

}
