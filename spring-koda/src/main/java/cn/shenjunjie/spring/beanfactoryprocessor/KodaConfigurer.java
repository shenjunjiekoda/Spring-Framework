package cn.shenjunjie.spring.beanfactoryprocessor;

import cn.shenjunjie.spring.factorybean.KodaFactoryBean;
import cn.shenjunjie.spring.scanner.KodaScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/4/4 21:58
 */
public class KodaConfigurer implements BeanDefinitionRegistryPostProcessor {

	private String packages;

	private Class<? extends KodaFactoryBean> factoryBeanClass;

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public Class<? extends KodaFactoryBean> getFactoryBeanClass() {
		return factoryBeanClass;
	}

	public void setFactoryBeanClass(Class<? extends KodaFactoryBean> factoryBeanClass) {
		this.factoryBeanClass = factoryBeanClass;
	}

	//注册扫描器
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		KodaScanner scanner = new KodaScanner(registry);
		String[] packages = StringUtils.tokenizeToStringArray(this.packages, ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
		scanner.setFactoryBeanClass(this.factoryBeanClass);
		scanner.setPackages(packages);
		//让该包下的class都被扫到，在后续第二层校验重写方法，只让接口过
		scanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
		//扫描过程中真正注册代理bean
		scanner.scan(packages);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
