package cn.shenjunjie.spring.annotations;

import cn.shenjunjie.spring.factorybean.KodaFactoryBean;
import cn.shenjunjie.spring.importselector.KodaMapperRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/4/4 10:44
 */

@Import(KodaMapperRegistrar.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface KodaScan {
	@AliasFor("packages")
	String[] value() default {};
	/**
	 * mapper接口扫包路径
	 */
	@AliasFor("value")
	String[] packages() default {};

	Class<? extends KodaFactoryBean> factoryBeanClass() default KodaFactoryBean.class;
}
