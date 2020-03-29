package cn.shenjunjie.spring;

import cn.shenjunjie.spring.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/3/28 18:35
 */
public class KodaSpringApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppConfig appConfig = context.getBean(AppConfig.class);
		System.out.println(appConfig);
	}
}
