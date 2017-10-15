package com.dqdl.community.domain.repository;

import com.dqdl.community.domain.model.post.Post;

/**
 * 帖子仓库接口
 * @author daoqidelv
 * @createdate 2017年10月15日
 */
public interface IPostRepository {
	/**
	 * 查询指定帖子信息
	 * @param postId
	 * @return Post
	 */
	Post query(long postId);
	/**
	 * 保存指定帖子
	 * @param post
	 * @return int
	 */
	int save(Post post);
	/**
	 * 删除指定帖子
	 * @param post
	 * @return int
	 */
	int delete(Post post);

}
