package cn.shenjunjie.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Junjie.Shen
 * @version 1.0
 * @date 2020/4/6 17:13
 */
@Controller
public class HelloController {

	@ResponseBody
	@GetMapping("/hello")
	public String sayHello(){
		System.out.println("HelloController sayHello()...");
		return "hello";
	}

}
