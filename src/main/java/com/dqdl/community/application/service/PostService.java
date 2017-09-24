package com.dqdl.community.application.service;

import com.dqdl.community.infrastructure.exception.BusinessException;
import com.dqdl.community.ui.dto.base.RequestDto;
import com.dqdl.community.ui.dto.post.DeletePostReqBody;
import com.dqdl.community.ui.dto.post.DeletePostRespBody;
import com.dqdl.community.ui.dto.post.PostingReqBody;
import com.dqdl.community.ui.dto.post.PostingRespBody;
import com.dqdl.community.ui.dto.post.QueryPostDetailReqBody;
import com.dqdl.community.ui.dto.post.QueryPostDetailRespBody;

public interface PostService {
	
	DeletePostRespBody delete( RequestDto<DeletePostReqBody> requestDto ) throws BusinessException ;
	
	PostingRespBody posting( RequestDto<PostingReqBody> requestDto ) throws BusinessException ;
	
	QueryPostDetailRespBody queryPostDetail( RequestDto<QueryPostDetailReqBody> requestDto ) throws BusinessException ;

}
