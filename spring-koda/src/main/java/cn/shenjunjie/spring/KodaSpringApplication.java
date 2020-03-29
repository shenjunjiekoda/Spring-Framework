package cn.shenjunjie.spring;

import cn.shenjunjie.spring.config.AppConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/3/28 18:35
 */
public class KodaSpringApplication {
	private static final Log logger = LogFactory.getLog(KodaSpringApplication.class);

	public static void main(String[] args) {
		logger.debug("==========================================");
		logger.debug("==========================================");
		logger.debug("=====KodaSpringApplication main start=====");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		AppConfig appConfig = context.getBean(AppConfig.class);
//		System.out.println(appConfig);

		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			logger.debug("=====context中bean定义的name:" + name +"=====");
		}
	}
}
