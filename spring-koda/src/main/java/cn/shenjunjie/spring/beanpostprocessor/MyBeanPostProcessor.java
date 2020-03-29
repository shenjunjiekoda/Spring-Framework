package cn.shenjunjie.spring.beanpostprocessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/3/29 19:02
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	private Log logger = LogFactory.getLog(getClass());

	public MyBeanPostProcessor(){
		logger.debug("===== MyBeanPostProcessor()空参call =====");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.debug("===== MyBeanPostProcessor postProcessBeforeInitialization() =====");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		logger.debug("===== MyBeanPostProcessor postProcessAfterInitialization() =====");
		return bean;
	}

}
