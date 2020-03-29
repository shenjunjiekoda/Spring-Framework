package cn.shenjunjie.spring.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/3/29 10:37
 */
public class BService {
	private final Log logger = LogFactory.getLog(getClass());

	public BService(){
		logger.debug("=====BService()空参call=====");
	}

}
