package com.dqdl.community.domain.repository;

import com.dqdl.community.domain.model.post.Post;

public interface IPostRepository {
	
	Post query(long postId);
	
	int save(Post post);

}
