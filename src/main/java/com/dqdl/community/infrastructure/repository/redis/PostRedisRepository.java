package com.dqdl.community.infrastructure.repository.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dqdl.community.domain.model.post.Post;
import com.dqdl.community.domain.repository.IPostRepository;
import com.dqdl.community.infrastructure.repository.translator.PostRepositoryTranslator;

/**
 * redis cache 仓库
 * @author daoqidelv
 * @createdate 2017年9月23日
 */
@Repository
public class PostRedisRepository implements IPostRepository {

	@Autowired
	private PostRepositoryTranslator postRepositoryTranslator;
	
	/**
	 * NOTE: maybe return 
	 */
	@Override
	public Post query(long postId) {
		//TODO maybe need 'postRepositoryTranslator' to translate entity to domain model object.
		
		//TODO use redisClient to query cache
		return null;
	}

	@Override
	public int save(Post post) {
		//TODO use redisClient to save cache
		return 1;
	}

	@Override
	public int delete(Post post) {
		//TODO use redisClient to remove cache
		return 0;
	}

}
