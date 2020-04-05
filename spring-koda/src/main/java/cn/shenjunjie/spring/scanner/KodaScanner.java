package cn.shenjunjie.spring.scanner;

import cn.shenjunjie.spring.factorybean.KodaFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/4/4 22:16
 */
public class KodaScanner extends ClassPathBeanDefinitionScanner {

	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	private String[] packages;

	private Class<? extends KodaFactoryBean> factoryBeanClass;

	public String[] getPackages() {
		return packages;
	}

	public void setPackages(String[] packages) {
		this.packages = packages;
	}

	public Class<? extends KodaFactoryBean> getFactoryBeanClass() {
		return factoryBeanClass;
	}

	public void setFactoryBeanClass(Class<? extends KodaFactoryBean> factoryBeanClass) {
		this.factoryBeanClass = factoryBeanClass;
	}

	public KodaScanner(BeanDefinitionRegistry registry) {
		super(registry,false);
	}

	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
	}

	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		Set<BeanDefinitionHolder> holders = super.doScan(basePackages);
		for (BeanDefinitionHolder holder : holders) {
			GenericBeanDefinition beanDefinition = (GenericBeanDefinition) holder.getBeanDefinition();
			String mapperInterface = beanDefinition.getBeanClassName();
			//设置为factoryBean
			beanDefinition.setBeanClass(this.factoryBeanClass);
			//设置mapperInterface，即xxxMapper
			// spring会通过converter注入构造方法
			//交给FactoryBean生成jdk动态代理对象$Proxy
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapperInterface);
			//方便注入sqlSession
			beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		}
		return holders;
	}
}
