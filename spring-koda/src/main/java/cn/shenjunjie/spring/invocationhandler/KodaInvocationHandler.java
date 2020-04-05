package cn.shenjunjie.spring.invocationhandler;

import org.apache.ibatis.annotations.Select;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/4/4 10:55
 */
public class KodaInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("获取jdbc连接");
		Select select = method.getAnnotation(Select.class);
		String value = select.value()[0];
		if(value!=null && value.length()>0){
			System.out.println("执行sql："+value);
		}
		return null;
	}
}
