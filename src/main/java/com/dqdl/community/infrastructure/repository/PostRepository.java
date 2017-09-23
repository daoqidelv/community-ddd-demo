package com.dqdl.community.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dqdl.community.domain.model.post.Post;
import com.dqdl.community.domain.repository.IPostRepository;
import com.dqdl.community.infrastructure.repository.translator.PostRepositoryTranslator;

@Repository
public class PostRepository implements IPostRepository {
	
	@Autowired
	private IPostRepository postMemoryRepository;
	
	@Autowired
	private PostRepositoryTranslator postRepositoryTranslator;

	public Post query(long postId) {
		//TODO maybe need 'postRepositoryTranslator' to translate entity to domain model object.
		
		return postMemoryRepository.query(postId);
	}

	public int save(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

}
