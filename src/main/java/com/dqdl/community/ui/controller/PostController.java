package com.dqdl.community.ui.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dqdl.community.application.service.PostService;
import com.dqdl.community.ui.dto.base.RequestDto;
import com.dqdl.community.ui.dto.base.ResponseDto;
import com.dqdl.community.ui.dto.post.DeletePostReqBody;
import com.dqdl.community.ui.dto.post.PostingReqBody;
import com.dqdl.community.ui.dto.post.PostingRespBody;
import com.dqdl.community.ui.dto.post.QueryPostDetailReqBody;
import com.dqdl.community.ui.dto.post.QueryPostDetailRespBody;

/**
 * 帖子 模块对应控制器
 * @author daoqidelv
 * @createdate 2017年10月15日
 */
@Controller
@RequestMapping("/post")
public class PostController extends BaseController {
	
	@Autowired
	private PostService postService;

	/**
	 *  发布帖子
	 * @param requestDto
	 * @return  ResponseDto
	 */
    @ResponseBody
    @RequestMapping(value = "/posting", method = RequestMethod.POST)
    public ResponseDto posting(@RequestBody @Valid RequestDto<PostingReqBody> requestDto) {
        try {
        	PostingRespBody postingRespBody = postService.posting (requestDto);
			return this.formatSuccessResponse(postingRespBody);
		} catch (Exception e) {
			return this.formatErrorResponse(e);
		}
    }
	
    /**
     * 删除帖子
     * 
     * @param requestDto
     * @param ResponseDto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseDto delete(@RequestBody @Valid RequestDto<DeletePostReqBody> requestDto) {
        try {
        	postService.delete ( requestDto );
			return this.formatSuccessResponse(null);
		} catch (Exception e) {
			return this.formatErrorResponse(e);
		}
    }
    
    /**
     * 查询帖子详情
     * 
     * @param requestDto
     * @param ResponseDto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPostDeatil", method = RequestMethod.POST)
    public ResponseDto queryPostDeatil(@RequestBody @Valid RequestDto<QueryPostDetailReqBody> requestDto) {
        try {
        	QueryPostDetailRespBody queryPostDetailRespBody =postService.queryPostDetail (requestDto);
			return this.formatSuccessResponse(queryPostDetailRespBody);
		} catch (Exception e) {
			return this.formatErrorResponse(e);
		}
    }

}
