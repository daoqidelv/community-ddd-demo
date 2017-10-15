/**
 * 
 */
package com.dqdl.community.domain.service.contentfilter;


/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月17日
 * 图片过滤器
 */
public class ImageContentFilter extends AbstractContentFilter {

	/* (non-Javadoc)
	 * @see com.dqdl.community.domain.model.post.ContentFilter#filtContent(com.dqdl.community.domain.model.post.Post)
	 */
	@Override
	public boolean filtContent(Object content) {
		// TODO 调用第三方的图片过滤服务实现，已经超过了domain的范畴，此处略去。后续单列文章讲解如何和第三方服务交互。
		return true;
	}
}
