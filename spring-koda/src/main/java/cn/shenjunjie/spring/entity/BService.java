package cn.shenjunjie.spring.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/3/29 10:37
 */
@Service
public class BService {
	@Autowired
	private AService aService;

	private final Log logger = LogFactory.getLog(getClass());

	public BService(){
		logger.debug("=====BService()空参call=====");
	}

	public String hello(){
		return "BService Hello()";
	}

	public Boolean good(){
		System.out.println(aService.aaa());
		return true;
	}

}
