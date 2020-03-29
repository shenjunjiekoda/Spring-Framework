package cn.shenjunjie.spring.config;

import cn.shenjunjie.spring.entity.A;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/3/28 18:35
 */
@ComponentScan("cn.shenjunjie.spring")
@Configuration
public class AppConfig {

	@Bean
	public A a(){
		return new A();
	}
}
