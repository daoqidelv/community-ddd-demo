/**
 * 
 */
package com.dqdl.community.domain.model.post;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.dqdl.community.constant.CommonConstants;
import com.dqdl.community.constant.ReturnCode;
import com.dqdl.community.domain.model.topic.TopicPost;
import com.dqdl.community.domain.model.user.PostAuthor;
import com.dqdl.community.domain.service.contentfilter.PostMainBodyContentFilterChain;
import com.dqdl.community.domain.service.contentfilter.PostTitleContentFilterChain;
import com.dqdl.community.infrastructure.exception.BusinessException;



/**
 * 帖子实体
 * @author DAOQIDELV
 * @CreateDate 2017年9月16日
 *
 */
public class Post {
	
    /**
    * 帖子id
    */
    private long id;
    /**
     *帖子作者
     */  
    private long authorId;    
    /**
     * 帖子标题
     */
    private String title;
    /**
     * 帖子源内容
     */
    private String sourceContent;
    /**
     * 发帖时间
     */
    private Timestamp postingTime;    
    /**
     * 帖子状态
     * NOTE：使用enum实现，限定status的字典值
	 * @see com.dqdl.community.domain.model.post.PostStatus
     */
    private PostStatus status;
    /**
     * 帖子作者
     */
    private PostAuthor postAuthor;
    
    /**
     * 帖子加入的话题
     */
    private Set<TopicPost> topics = new HashSet<TopicPost>();
    
    private static int MAX_JOINED_TOPICS_NUM = 5;
    
    private Post() {
    	this.postingTime = new Timestamp(System.currentTimeMillis());    	
    }
    
    public Post(long id) {
    	this.setId(id);
    }
    
    public Post(long authorId, String title, String sourceContent) {
    	this();
    	this.setAuthorId(authorId);
    	this.setTitle(title);
    	this.setSourceContent(sourceContent);
    	this.setPostAuthor(new PostAuthor(authorId));
    }
    
    /**
     * 删除帖子
     */
    public void delete() {
    	this.setStatus(PostStatus.HAS_DELETED);
    }
    
    /**
     * 将帖子关联话题 
     * @param topicIds 话题集合
     */
    public void joinTopics(String topicIds) throws BusinessException{
    	if(StringUtils.isEmpty(topicIds)) {
    		return;
    	}
    	String[] topicIdArray = topicIds.split(CommonConstants.COMMA);
		for(int i=0; i<topicIdArray.length; i++) {
			TopicPost topicPost = new TopicPost(Long.valueOf(topicIdArray[i]), this.getId());
    		this.topics.add(topicPost);
    		if(topicSize() > MAX_JOINED_TOPICS_NUM) {
    			throw new BusinessException(ReturnCode.ONE_POST_MOST_JOIN_INTO_FIVE_TOPICS);
    		}
		}
    }
    
    /**
     * 获取本帖子加入的话题数，参考jdk collection的api设计
     * @return 本帖子加入的话题数
     */
    public int topicSize() {
    	return this.topics.size();
    }
    
    /**
     * 过滤帖子内容，内容过滤通过，则置status为‘00’，否则置为‘01’
     * @param titleFilter 标题用内容过滤器
     * @param mainBodyfilter 正文用内容过滤器
     */
    public void filt(PostTitleContentFilterChain titleFilter, PostMainBodyContentFilterChain mainBodyfilter) {
    	if(!this.filtTitle(titleFilter)) {
    		this.setStatus(PostStatus.WAIT_VERIFY);
    	} else if(!this.filtContent(mainBodyfilter)) {
    		this.setStatus(PostStatus.WAIT_VERIFY);
    	} else {
    		this.setStatus(PostStatus.HAS_POSTED);
    	}
    }
    
    /**
     * 过滤标题
     * @param filter
     * @return
     */
    private boolean filtTitle(PostTitleContentFilterChain filter) {    	
    	if(StringUtils.isEmpty(this.getTitle())) {
    		return true;
    	}
		return filter.filtTitle(this);    	
    }
    
    /**
     * 过滤正文
     * @param filter
     * @return
     */
    private boolean filtContent(PostMainBodyContentFilterChain filter) {    	
		return filter.filtMainBody(this);    		
    }
    
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
	 * @return the authorId
	 */
	public long getAuthorId() {
		return authorId;
	}
	/**
	 * @param authorId the authorId to set	 * 
	 * NOTE: avoid client only modify authorId, but not modify PostAuthor at the same time， set this setter private
	 */
	private void setAuthorId(long authorId) {
		Assert.isTrue(authorId > 0, "Post's authorId must greater than ZERO.");
		this.authorId = authorId;
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
	 * @return the sourceContent
	 */
	public String getSourceContent() {
		return sourceContent;
	}
	/**
	 * @param sourceContent the sourceContent to set
	 */
	public void setSourceContent(String sourceContent) {
		//增加Assert断言，使实体满足一定的sepcification规格，参考Evans的《领域驱动设计》P154
		Assert.isTrue(!StringUtils.isEmpty(sourceContent), "Post's sourceContent must NOT be empty.");
		Assert.isTrue(sourceContent.length() >= 16, "Post's sourceContent at least have 16 words.");
		this.sourceContent = sourceContent;
	}
	/**
	 * @return the postingTime
	 */
	public Timestamp getPostingTime() {
		return postingTime;
	}
	/**
	 * @param postingTime the postingTime to set
	 */
	public void setPostingTime(Timestamp postingTime) {
		this.postingTime = postingTime;
	}

	/**
	 * @return the topics
	 */
	public Set<TopicPost> getTopics() {
		return topics;
	}

	/**
	 * @param topics the topics to set
	 */
	public void setTopics(Set<TopicPost> topics) {
		this.topics = topics;
	}

	/**
	 * @return the status
	 */
	public PostStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(PostStatus status) {
		this.status = status;
	}

	public PostAuthor getPostAuthor() {
		return postAuthor;
	}

	/**
	 * NOTE: avoid client only modify postAuthor, but not modify authorId at the same time, set this setter private
	 * @param postAuthor
	 */
	private void setPostAuthor(PostAuthor postAuthor) {
		this.postAuthor = postAuthor;
	}
	
}
