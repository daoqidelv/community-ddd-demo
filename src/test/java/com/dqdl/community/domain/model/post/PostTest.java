/**
 * 
 */
package com.dqdl.community.domain.model.post;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.dqdl.community.constant.ReturnCode;
import com.dqdl.community.domain.model.post.Post;
import com.dqdl.community.domain.model.post.PostStatus;
import com.dqdl.community.domain.model.topic.TopicPost;
import com.dqdl.community.domain.service.contentfilter.PostMainBodyContentFilterChain;
import com.dqdl.community.domain.service.contentfilter.PostTitleContentFilterChain;
import com.dqdl.community.infrastructure.exception.BusinessException;

/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月16日
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PostTest {
	private Post post;
	private long authorId;
	private long postId;
	private String postTitle;
	private String postSourceContent;
    @Mock
    private PostTitleContentFilterChain postTitleContentFilterChain;
    @Mock
    private PostMainBodyContentFilterChain postMainBodyContentFilterChain;
	
	@Before
	public void setUp() throws Exception {
		authorId = 40;
		postId = 40121;
		postTitle = "测试帖子";
		postSourceContent = "测试帖子内容，内容必须大于16个字，字数不够我来凑！";
		
		post = new Post(authorId,postTitle,postSourceContent);
		post.setId(postId);
	}
	
	@Test
	public void joinTopicsSuccess() {
		String topicIds = "12,13";
		try {
			this.post.joinTopics(topicIds);
			assertTrue(this.post.getTopics().size() == 2);	
			for(TopicPost topicPost : post.getTopics()) {
				assertTrue(topicPost.getPostId() == this.post.getId());
			}
		} catch (BusinessException e) {
			fail("unExpected an BussinessException to be thrown, " + e.getMessage());
		}
		
	}
	
	@Test
	public void joinTopicsWhenTopicIdsIsNull() {
		try {
			this.post.joinTopics(null);
			assertTrue(this.post.getTopics().size() == 0);	
		} catch (BusinessException e) {
			fail("unExpected an BussinessException to be thrown, " + e.getMessage());
		}
	}
	
	
	@Test
	public void joinTopicsFialWhenTopicSizeHasGreaterThanFive() {
		String topicIds = "12,13,14,15,16";
		try {
			this.post.joinTopics(topicIds);
			this.post.joinTopics("17");
			fail("expected an BussinessException to be thrown, but do not catch.");
		} catch (BusinessException e) {
			assertTrue(ReturnCode.ONE_POST_MOST_JOIN_INTO_FIVE_TOPICS.equals(e.getMessage()));
		}
	}
	
	@Test
	public void filtPassedWhenFiltContentPassed() {
		when(postTitleContentFilterChain.filtTitle(post)).thenReturn(true);
		when(postMainBodyContentFilterChain.filtMainBody(post)).thenReturn(true);
		post.filt(postTitleContentFilterChain, postMainBodyContentFilterChain);
		assertTrue(PostStatus.HAS_POSTED.equals(post.getStatus()));		
	}
	
	@Test
	public void filtFailedWhenFiltTitleNotPassed() {
		when(postMainBodyContentFilterChain.filtMainBody(post)).thenReturn(true);
		when(postTitleContentFilterChain.filtTitle(post)).thenReturn(false);
		post.filt(postTitleContentFilterChain, postMainBodyContentFilterChain);
		assertTrue(PostStatus.WAIT_VERIFY.equals(post.getStatus()));		
	}
	
	@Test
	public void filtFailedWhenFiltMainBodyNotPassed() {
		when(postMainBodyContentFilterChain.filtMainBody(post)).thenReturn(false);
		when(postTitleContentFilterChain.filtTitle(post)).thenReturn(true);
		post.filt(postTitleContentFilterChain, postMainBodyContentFilterChain);
		assertTrue(PostStatus.WAIT_VERIFY.equals(post.getStatus()));		
	}
	
	@Test
	public void filtPassedWhenFiltMainBodyPassedAndTitleIsNull() {
		when(postMainBodyContentFilterChain.filtMainBody(post)).thenReturn(true);
		when(postTitleContentFilterChain.filtTitle(post)).thenReturn(false);
		post.setTitle(null);
		post.filt(postTitleContentFilterChain, postMainBodyContentFilterChain);
		assertTrue(PostStatus.HAS_POSTED.equals(post.getStatus()));		
	}

}
