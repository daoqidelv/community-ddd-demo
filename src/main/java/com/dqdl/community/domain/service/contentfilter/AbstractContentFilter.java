/**
 * 
 */
package com.dqdl.community.domain.service.contentfilter;


/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月17日
 * 内容过滤器抽象类
 */
public abstract class ContentFilter {
	
	private ContentFilter nextContentFilter;
	
	public abstract boolean filtContent(Object content);

	/**
	 * @return the nextContentFilter
	 */
	public ContentFilter getNextContentFilter() {
		return nextContentFilter;
	}

	/**
	 * @param nextContentFilter the nextContentFilter to set
	 */
	public void setNextContentFilter(ContentFilter nextContentFilter) {
		this.nextContentFilter = nextContentFilter;
	}
}
