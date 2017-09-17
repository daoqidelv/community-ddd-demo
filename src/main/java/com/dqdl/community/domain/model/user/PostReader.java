package com.dqdl.community.domain.model.user;

import com.dqdl.community.constant.ExceptionCode;
import com.dqdl.community.domain.model.post.Post;
import com.dqdl.community.exception.BusinessException;

public class PostReader extends User {

	public PostReader(long id) {
		super(id);
	}
	
	/**
     * 删帖
     * @param post 拟被删除的帖子实体
     * @return post 删帖后的帖子实体
	 * @throws BusinessException 
     */
    public Post deletePost(Post post) throws BusinessException {
        if (post == null) {
            throw new BusinessException(ExceptionCode.POST_IS_NOT_EXIT);
        }
        if (!this.isMyself(post.getPostAuthor())) {
            throw new BusinessException(ExceptionCode.CAN_NOT_DELETE_OTHER_USERS_POST);
        }
        post.delete();
        return post;
    }
}
