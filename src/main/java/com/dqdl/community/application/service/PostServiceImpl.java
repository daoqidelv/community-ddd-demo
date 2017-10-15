package com.dqdl.community.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dqdl.community.application.assembler.PostAssembler;
import com.dqdl.community.domain.model.post.Post;
import com.dqdl.community.domain.model.user.PostAuthor;
import com.dqdl.community.domain.model.user.PostReader;
import com.dqdl.community.domain.repository.IPostRepository;
import com.dqdl.community.infrastructure.exception.BusinessException;
import com.dqdl.community.ui.dto.base.RequestDto;
import com.dqdl.community.ui.dto.post.DeletePostReqBody;
import com.dqdl.community.ui.dto.post.DeletePostRespBody;
import com.dqdl.community.ui.dto.post.PostingReqBody;
import com.dqdl.community.ui.dto.post.PostingRespBody;
import com.dqdl.community.ui.dto.post.QueryPostDetailReqBody;
import com.dqdl.community.ui.dto.post.QueryPostDetailRespBody;
/**
 * 
 * @author daoqidelv
 * @createdate 2017年10月15日
 */
@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private IPostRepository postRepository;
	
	@Autowired
	private PostAssembler postAssembler;
	

	@Override
	public PostingRespBody posting(RequestDto<PostingReqBody> requestDto) throws BusinessException {
		PostingReqBody postingReqBody = requestDto.getBody();
		/**
		 *NOTE： 请求参数校验交给了validation，这里无需校验userId和postId是否为空
		 */
		String userId = postingReqBody.getUserId();
		String title = postingReqBody.getTitle();
		String sourceContent = postingReqBody.getSourceContent();
		
		long userIdInLong = Long.valueOf(userId);
		
		/**
		 * 组装domain model entity
		 * NOTE：这里的PostAuthor不需要从repository重载，原因在于：deletePost场景需要用户登录后才能操作，
		 * 		在进入service之前，已经在controller层完成了用户身份鉴权，故到达这里的userId肯定是合法的用户
		 */
		PostAuthor postAuthor = new PostAuthor(userIdInLong);
		Post post = postAuthor.posting(title, sourceContent);
		
		/**
		 * NOTE：使用repository将model entity 写入存储
		 */
		postRepository.save(post);
		
		/**
		 * NOTE：使用postAssembler将Post model组装成dto返回。
		 */
		return postAssembler.assemblePostingRespBody(post);
	}
	
	@Override
	public DeletePostRespBody delete(RequestDto<DeletePostReqBody> requestDto) throws BusinessException {
		DeletePostReqBody deletePostReqBody = requestDto.getBody();
		
		/**
		 *NOTE： 请求参数校验交给了validation，这里无需校验userId和postId是否为空
		 */
		String userId = deletePostReqBody.getUserId();
		String postId = deletePostReqBody.getPostId();
		
		long userIdInLong = Long.valueOf(userId);
		long postIdInLong = Long.valueOf(postId);
		
		/**
		 * 组装domain model entity
		 * NOTE：这里的PostAuthor不需要从repository重载，原因在于：deletePost场景需要用户登录后才能操作，
		 * 		在进入service之前，已经在controller层完成了用户身份鉴权，故到达这里的userId肯定是合法的用户
		 */
		PostAuthor postAuthor = new PostAuthor(userIdInLong);
		/**
		 * 从repository中重载domain model entity
		 * 借此判断该postId是否真的存在帖子
		 */
		Post post = postRepository.query(postIdInLong);
		
		postAuthor.deletePost(post);
		
		postRepository.delete(post);		
		
		return null;
	}


	@Override
	public QueryPostDetailRespBody queryPostDetail(RequestDto<QueryPostDetailReqBody> requestDto)
			throws BusinessException {
		QueryPostDetailReqBody queryPostDetailReqBody = requestDto.getBody();
		
		String readerId = queryPostDetailReqBody.getReaderId();
		String postId = queryPostDetailReqBody.getPostId();
		
		long readerIdInLong = Long.valueOf(readerId);
		long postIdInLong = Long.valueOf(postId);
		
		//TODO 可能有一些权限校验，比如：判定该读者是否有查看作者帖子的权限等。这里暂且不展开讨论。
		PostReader postReader = new PostReader(readerIdInLong);
		
		Post post = postRepository.query(postIdInLong);
		
		/**
		 * NOTE: 使用postAssembler将domain层的model组装成dto，组装过程：
		 * 		1、完成类型转换、数据格式化；
		 * 		2、将多个model组合成一个dto，一并返回。
		 */
		return postAssembler.assembleQueryPostDetailRespBody(post);
	}	

}
