/**
 * 
 */
package com.dqdl.community.domain.service.contentfilter;


/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月17日
 * 内容过滤器抽象类
 */
public abstract class AbstractContentFilter {
	
	private AbstractContentFilter nextContentFilter;
	
	/**
	 * 过滤指定内容
	 * @param content
	 * @return boolean
	 * 	true —— 通过
	 *  false —— 不通过
	 */
	public abstract boolean filtContent(Object content);

	/**
	 * @return the nextContentFilter
	 */
	public AbstractContentFilter getNextContentFilter() {
		return nextContentFilter;
	}

	/**
	 * @param nextContentFilter the nextContentFilter to set
	 */
	public void setNextContentFilter(AbstractContentFilter nextContentFilter) {
		this.nextContentFilter = nextContentFilter;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof AbstractContentFilter)) {
			return false;
		} else {
			return this == obj;
		}
	}
}
