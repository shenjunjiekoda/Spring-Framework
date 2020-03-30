package cn.shenjunjie.spring.entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/3/30 8:31
 */
@Service
public class CService {
	private final Log logger = LogFactory.getLog(getClass());

	public CService(){
		logger.debug("=====CService()空参call=====");
	}

}
