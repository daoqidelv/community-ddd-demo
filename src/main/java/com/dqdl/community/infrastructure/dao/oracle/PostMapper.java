package com.dqdl.community.infrastructure.dao.oracle;

import com.dqdl.community.infrastructure.dao.entity.oracle.PostEntity;

/**
 * Created by limengyuan664 on 2017-02-23.
 */
public interface PostMapper {
	
	/**
	 * 查询帖子
	 * @param postId
	 * @return
	 */
	
	PostEntity query(long postId);
    
    /**
     * 保存帖子
     */
    int save(PostEntity postEntity);
    
    /**
     * 更新帖子状态̬
     * @param paramMap
     * @return
     */
    int updatePostStatus(PostEntity postEntity);

}
