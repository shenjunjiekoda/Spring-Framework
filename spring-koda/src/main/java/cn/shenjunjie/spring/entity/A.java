package cn.shenjunjie.spring.entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/3/29 11:19
 */
public class A {
	private final Log logger = LogFactory.getLog(getClass());
	public A(){
		logger.debug("=====A()空参call=====");
	}
}
