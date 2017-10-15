package com.dqdl.community.infrastructure.repository.translator;

import org.springframework.stereotype.Component;

import com.dqdl.community.domain.model.post.Post;
import com.dqdl.community.domain.model.post.PostStatus;
import com.dqdl.community.infrastructure.dao.entity.oracle.PostEntity;

/**
 * 将不同repository返回的entity翻译层domain层认识的model对象
 * NOTE：通常情况下，我们可以直接使用domain层的model对象写入存储，这样就不需要translator存在了，比如demo中使用memory repository完成model的存取；
 * 		实际项目中，并不会这么理想，往往有很多遗留的系统，需要我们使用translator做翻译。
 * 		另一个常见的场景是：部分字段的值在持久化层的entity和domain层的model中是不一样的，比如：持久化层的isDelete是使用char表示（'0','1'），而在domain的model层则使用boolean类型表示，这时候就需要使用assembler进行翻译。
 * @author daoqidelv
 * @createdate 2017年9月23日
 */
@Component
public class PostRepositoryTranslator {

	public Post translateFromPostEntity(PostEntity postEntity) {
		if(postEntity == null) {
			return null;
		}
		Post post = new Post(postEntity.getId());
		post.setPostingTime(postEntity.getPosting_time());
		post.setSourceContent(postEntity.getSource_content());
		//类型转换
		post.setStatus(PostStatus.getPostStatus(postEntity.getStatus())); 
		post.setTitle(postEntity.getTitle());
		post.setSourceContent(postEntity.getSource_content());
		return null;		
	}
	
	public PostEntity translateFromPost(Post post) {
		if(post == null) {
			return null;
		}
		PostEntity postEntity = new PostEntity();
		postEntity.setId(post.getId());
		postEntity.setAuthor_id(post.getAuthorId());
		postEntity.setPosting_time(post.getPostingTime());
		postEntity.setSource_content(postEntity.getSource_content()); 
		//类型转换
		postEntity.setStatus(post.getStatus().getCode()); 
		postEntity.setTitle(post.getTitle());
		return postEntity;
	}
		
}
