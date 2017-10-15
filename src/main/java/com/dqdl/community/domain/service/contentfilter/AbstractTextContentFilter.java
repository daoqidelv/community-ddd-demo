/**
 * 
 */
package com.dqdl.community.domain.service.contentfilter;


/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月17日
 * 文本过滤器抽象类
 */
public abstract class TextContentFilter extends ContentFilter {

	/* (non-Javadoc)
	 * @see com.dqdl.community.domain.model.post.ContentFilter#filtContent(com.dqdl.community.domain.model.post.Post)
	 */
	@Override
	public abstract boolean filtContent(Object content);

}
