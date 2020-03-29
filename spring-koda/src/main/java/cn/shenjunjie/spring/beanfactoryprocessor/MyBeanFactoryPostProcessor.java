package cn.shenjunjie.spring.beanfactoryprocessor;

import cn.shenjunjie.spring.entity.BService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;


/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/3/29 18:15
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private Log logger = LogFactory.getLog(getClass());

	public MyBeanFactoryPostProcessor() {
		logger.debug("===== MyBeanFactoryPostProcessor()空参call =====");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		logger.debug("=====MyBeanFactoryPostProcessor postProcessBeanFactory()=====");
//		beanFactory.registerSingleton("bService", new BService());
	}
}
