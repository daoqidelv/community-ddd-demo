package com.dqdl.community.application.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dqdl.community.domain.model.post.Post;
import com.dqdl.community.infrastructure.util.ApplicationUtil;
import com.dqdl.community.ui.dto.post.PostingRespBody;
import com.dqdl.community.ui.dto.post.QueryPostDetailRespBody;

/**
 * Post模块的组装器，完成domain model对象到dto的转换，组装职责包括：
 * 		1、完成类型转换、数据格式化；如日志格式化，状态enum装换为前端认识的string；
 * 		2、将多个model组合成一个dto，一并返回。
 * TODO: 不太好的地方每个assemble方法都需要先判断入参对象是否为空。
 * @author daoqidelv
 * @createdate 2017年9月24日
 */
@Component
public class PostAssembler {
	
	private final static String POSTING_TIME_STRING_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
	
	@Autowired
	private ApplicationUtil applicationUtil;
	
	public PostingRespBody assemblePostingRespBody(Post post) {
		if(post == null) {
			return null;
		}
		PostingRespBody postingRespBody = new PostingRespBody();
		postingRespBody.setPostId(String.valueOf(post.getId()));
		return postingRespBody;
	}
	
	public QueryPostDetailRespBody assembleQueryPostDetailRespBody(Post post) {
		/**
		 * NOTE: 判定入参post是否为null
		 */
		if(post == null) {
			return null;
		}
		QueryPostDetailRespBody queryPostDetailRespBody = new QueryPostDetailRespBody();
		//完成类型转换
		queryPostDetailRespBody.setAuthorId(String.valueOf(post.getAuthorId())); 
		//完成类型转换
		queryPostDetailRespBody.setPostId(String.valueOf(post.getId()));
		//完成日期格式化
		queryPostDetailRespBody.setPostingTime(
				applicationUtil.convertTimestampToString(post.getPostingTime(), POSTING_TIME_STRING_DATE_FORMAT));
		queryPostDetailRespBody.setSourceContent(post.getSourceContent());
		queryPostDetailRespBody.setTitle(post.getTitle());
		return queryPostDetailRespBody;
	}

}
