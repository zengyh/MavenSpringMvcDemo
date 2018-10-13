package edu.mvcdemo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.mvcdemo.model.User;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-9-16 上午11:52:55
 * @文件描述: 通过SecurityRiskRequestWrapper对象，修改页面请求参数Demo
 */
@Controller
@RequestMapping(value="/SecurityRiskTest")
public class ModifyParamsDemoController {

	@RequestMapping(value="/modiyParams",produces = "text/html; charset=utf-8")
	@ResponseBody
    private String modiyParams(User user, HttpServletResponse response){
    	return user.toString();
    }
}
