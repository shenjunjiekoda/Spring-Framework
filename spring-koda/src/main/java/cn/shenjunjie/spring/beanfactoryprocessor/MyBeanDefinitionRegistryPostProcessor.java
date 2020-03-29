package cn.shenjunjie.spring.beanfactoryprocessor;

import cn.shenjunjie.spring.entity.BService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/3/29 10:41
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	private Log logger = LogFactory.getLog(getClass());

	public MyBeanDefinitionRegistryPostProcessor() {
		logger.debug("===== MyBeanDefinitionRegistryPostProcessor()空参call =====");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		logger.debug("MyBeanDefinitionRegistryPostProcessor postProcessBeanDefinitionRegistry()");
		//注册BService
//		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(BService.class);
//		AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
//		registry.registerBeanDefinition("bService",beanDefinition);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		logger.debug("MyBeanDefinitionRegistryPostProcessor postProcessBeanFactory");
	}
}
