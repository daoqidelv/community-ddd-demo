package com.dqdl.community.infrastructure.repository.translator;

import org.springframework.stereotype.Component;

/**
 * 将不同repository返回的entity翻译层domain层认识的model对象
 * @author daoqidelv
 * @createdate 2017年9月23日
 */
@Component
public class PostRepositoryTranslator {

	/**
	 * NOTE：通常情况下，我们可以直接使用domain层的model对象写入存储，这样就不需要translator存在了，比如demo中使用memory repository完成model的存取；
	 * 		实际项目中，并不会这么理想，往往有很多遗留的系统，需要我们使用translator做翻译。
	 */
}
