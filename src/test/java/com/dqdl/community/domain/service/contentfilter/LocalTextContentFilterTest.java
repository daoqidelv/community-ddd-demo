/**
 * 
 */
package com.dqdl.community.domain.service.contentfilter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.dqdl.community.domain.service.contentfilter.LocalTextContentFilter;

/**
 * @author DAOQIDELV
 * @CreateDate 2017年9月17日
 *
 */
public class LocalTextContentFilterTest {
	
	private LocalTextContentFilter localTextContentFilter;
	
	@Before
	public void setUp() {
		localTextContentFilter = new LocalTextContentFilter();		
	}
	
	@Test
	public void filtContentPassedWhenContentIsValid() {
		String content = "合法的内容";
		boolean ret = localTextContentFilter.filtContent(content);
		assertTrue(ret);
	}
	
	@Test
	public void filtContentNotPassedWhenContentIsInvalid() {
		String content = "NND";
		boolean ret = localTextContentFilter.filtContent(content);
		assertFalse(ret);
	}

}
