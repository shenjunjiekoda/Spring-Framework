package cn.shenjunjie.spring.mvc;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.startup.Tomcat;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/4/6 14:43
 */
public class KodaWebApplication {


	public static void main(String[] args) throws Exception {
		TomcatServer.run();
	}

	static class TomcatServer{
		public static void run() throws Exception {
			Tomcat tomcat=new Tomcat();
			tomcat.setPort(8080);
			//告诉Tomcat执行web规范
			tomcat.addWebapp("/",
				"d:\\tomcattemp");
//			context.addLifecycleListener((LifecycleListener)Class.forName(tomcat.getHost().getConfigClass()).newInstance());
			tomcat.start();
			System.out.println("=====tomcat start=====");
			tomcat.getServer().await();
		}
	}


}
