package cn.shenjunjie.spring.importselector;

import cn.shenjunjie.spring.annotations.KodaScan;
import cn.shenjunjie.spring.beanfactoryprocessor.KodaConfigurer;
import cn.shenjunjie.spring.dao.KodaMapper;
import cn.shenjunjie.spring.factorybean.KodaFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/4/4 10:45
 */
public class KodaMapperRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		AnnotationAttributes attrs = AnnotationAttributes
				.fromMap(importingClassMetadata.getAnnotationAttributes(KodaScan.class.getName()));
//		相当于Map<String, Object> value = importingClassMetadata.getAnnotationAttributes(KodaScan.class.getName(), true);

		//获得扫包路径
		List<String> packages = new ArrayList<>();
		packages.addAll(Arrays.stream(attrs.getStringArray("packages"))
				.filter(StringUtils::hasText)
				.collect(Collectors.toList()));
		if (CollectionUtils.isEmpty(packages)) {
			//没找到packages的话默认去当前配置类所在的包下找
			packages.add(ClassUtils.getPackageName(importingClassMetadata.getClassName()));
		}
		for (String scanPackage : packages) {
			System.out.println("当前扫包路径:" + scanPackage);
		}

		//获得factoryBean
		Class<? extends KodaFactoryBean> factoryBeanClass = attrs.getClass("factoryBeanClass");

		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(KodaConfigurer.class);
		//以逗号隔开
		builder.addPropertyValue("packages", StringUtils.collectionToCommaDelimitedString(packages));
		builder.addPropertyValue("factoryBeanClass", factoryBeanClass);
		//注册用于配置的bean
		registry.registerBeanDefinition(KodaConfigurer.class.getSimpleName(), builder.getBeanDefinition());
	}
}
