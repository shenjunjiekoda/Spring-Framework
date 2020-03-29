package cn.shenjunjie.spring.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/3/29 10:36
 */
@Service
public class AService {
	private final Log logger = LogFactory.getLog(getClass());

	public AService(){
		logger.debug("=====AService()空参call=====");
	}
}
