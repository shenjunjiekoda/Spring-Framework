package cn.shenjunjie.spring.entity;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/3/29 10:36
 */
@Service
public class AService {
//	@Autowired
//	private BService bService;



	private final Log logger = LogFactory.getLog(getClass());

	public AService(){
		logger.debug("=====AService()空参call=====");
	}

	@PostConstruct
	public void test(){
		System.out.println("A test()");
		logger.debug("=====A @PostConstruct call=====");
	}

	public String aaa(){
		return "aaaaa";
	}

}
