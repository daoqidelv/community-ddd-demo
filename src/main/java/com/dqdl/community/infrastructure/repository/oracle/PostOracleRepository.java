package com.dqdl.community.infrastructure.repository.oracle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dqdl.community.domain.model.post.Post;
import com.dqdl.community.domain.repository.IPostRepository;
import com.dqdl.community.infrastructure.dao.entity.oracle.PostEntity;
import com.dqdl.community.infrastructure.dao.oracle.PostMapper;
import com.dqdl.community.infrastructure.repository.translator.PostRepositoryTranslator;

/**
 * oracle 持久化 仓库
 * @author daoqidelv
 * @createdate 2017年9月23日
 */
@Repository
public class PostOracleRepository implements IPostRepository {
	

//	@Autowired  	
	/**
	 * 帖子相关数据库操作mapper
	 * TODO： 未配置spring-mybatis，为了能启动应用，将@Autowired 注释掉。实际项目中需要放开
	 */
	private PostMapper postMapper;
	
	@Autowired  
	private PostRepositoryTranslator postRepositoryTranslator;
	
	@Override
	public Post query(long postId) {
		PostEntity postEntity = postMapper.query(postId);
		return postRepositoryTranslator.translateFromPostEntity(postEntity);
	}

	@Override
	public int save(Post post) {
		PostEntity postEntity = postRepositoryTranslator.translateFromPost(post);
		return postMapper.save(postEntity);
	}

	@Override
	public int delete(Post post) {
		//TODO
		return 0;
	}

}