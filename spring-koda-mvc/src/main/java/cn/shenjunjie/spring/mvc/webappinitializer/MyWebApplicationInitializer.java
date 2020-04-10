package cn.shenjunjie.spring.mvc.webappinitializer;

import cn.shenjunjie.spring.mvc.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/4/6 12:45
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletCxt) {
		System.out.println("开始搭建web上下文");
		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(AppConfig.class);
//		ac.refresh();

		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/*");

//		System.out.println("注册完毕，现在容器中的组件");
//		for (String name : ac.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
	}
}