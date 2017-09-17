/**
 * 
 */
package com.dqdl.community.domain.model.post;

import org.junit.Before;
import org.junit.Test;

import com.dqdl.community.constant.ExceptionCode;
import com.dqdl.community.domain.model.post.Post;
import com.dqdl.community.domain.model.post.PostAuthor;
import com.dqdl.community.exception.BusinessException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月16日
 *
 */
public class PostAuthorTest {
	
	private PostAuthor postAuthor;
	private long authorId;
	
	@Before
	public void setUp() throws Exception {
		authorId = 40;
		postAuthor = new PostAuthor(authorId);
	}
	
	@Test
	public void postingSuccess() {
		String title = "测试帖子";
		String sourceContent = "测试帖子内容，内容必须大于16个字，字数不够我来凑！";
		Post post;
		try {
			post = postAuthor.posting(title, sourceContent);
			assertTrue(post != null);
			assertTrue(title.equals(post.getTitle()));
			assertTrue(sourceContent.equals(post.getSourceContent()));
			assertTrue(postAuthor.getId() == post.getAuthorId());	
		} catch (BusinessException e) {
			fail("unExpected an BussinessException to be thrown, " + e.getMessage());
		}	
	}
	
	@Test
	public void postingSuccessWhenTitleIsEmpty() {
		String sourceContent = "测试帖子内容，内容必须大于16个字，字数不够我来凑！";
		Post post;
		try {
			post = postAuthor.posting(null, sourceContent);
			assertTrue(post != null);
			assertTrue(sourceContent.equals(post.getSourceContent()));
			assertTrue(postAuthor.getId() == post.getAuthorId());	
		} catch (BusinessException e) {
			fail("unExpected an BussinessException to be thrown, " + e.getMessage());
		}	
	}
	
	@Test
	public void postingSuccessWhenSoureContentIsLessThanSixteen() {
		String sourceContent = "测试帖子内容，内容小16个字";
		try {
			postAuthor.posting(null, sourceContent);
			fail("Expected an BussinessException to be thrown, but don‘t catch." );
		} catch (BusinessException e) {
			assertTrue(ExceptionCode.POST_SOURCE_CONTENT_AT_LEAST_SIXTEEN_WORDS.equals(e.getMessage()));
		}	
	}


}
