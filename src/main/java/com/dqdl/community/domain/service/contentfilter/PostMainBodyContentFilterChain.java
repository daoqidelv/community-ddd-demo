/**
 * 
 */
package com.dqdl.community.domain.service.contentfilter;

import java.util.Iterator;
import java.util.Set;

import com.dqdl.community.domain.model.post.Post;

/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月17日
 * 帖子正文内容过滤器 责任链。正文可能有图片，故包含图片过滤
 */
public class PostMainBodyContentFilterChain {
	
	private Set<AbstractContentFilter> contentFilters;
	
	public PostMainBodyContentFilterChain() {
		AbstractTextContentFilter localTextContentFilter = new LocalTextContentFilter();
		AbstractTextContentFilter remoteTextContentFilter = new RemoteTextContentFilter();
		ImageContentFilter imageContentFilter = new ImageContentFilter();
		//优先校验本地的敏感词
		contentFilters.add(localTextContentFilter); 
		contentFilters.add(remoteTextContentFilter);
		contentFilters.add(imageContentFilter);
	}
	
	/**
	 * 过滤标题
	 * @param post
	 * @return
	 *  true —— 通过
	 *  false —— 未通过
	 */
	public boolean filtMainBody(Post post) {
		for(Iterator<AbstractContentFilter> it = contentFilters.iterator(); it.hasNext();) {
			if(!it.next().filtContent(post.getSourceContent())) {
				return false;
			}
		}
		return true;
	}

}
