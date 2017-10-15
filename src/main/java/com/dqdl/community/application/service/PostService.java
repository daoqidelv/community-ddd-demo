package com.dqdl.community.application.service;

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
public interface PostService {
	/**
	 * 删除指定帖子
	 * @param requestDto 
	 * @return DeletePostRespBody
	 * @throws BusinessException
	 */
	DeletePostRespBody delete( RequestDto<DeletePostReqBody> requestDto ) throws BusinessException ;
	/**
	 * 发帖
	 * @param requestDto
	 * @return PostingRespBody
	 * @throws BusinessException
	 */
	PostingRespBody posting( RequestDto<PostingReqBody> requestDto ) throws BusinessException ;
	/**
	 * 查询帖子详情
	 * @param requestDto
	 * @return QueryPostDetailRespBody
	 * @throws BusinessException
	 */
	QueryPostDetailRespBody queryPostDetail( RequestDto<QueryPostDetailReqBody> requestDto ) throws BusinessException ;

}
