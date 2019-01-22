package com.hyh.shoppingmallmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping("gotoSpu")
	public String gotoSpu() {
		return "spu";
	}
	
	@RequestMapping("gotoAttr")
	public String gotoAttribute() {
		return "attr";
	}
	
	@RequestMapping("gotoSku")
	public String gotoSku() {
		return "sku";
	}

	@RequestMapping("success")
	public String success(String msg, ModelMap map) {
		map.put("msg",msg);
		return "success";
	}
    @RequestMapping("login")
    public String login(String username, String password, ModelMap map,HttpSession session) {
        if(username.equals("admin")&&password.equals("123456")){
            session.setAttribute("User",username);
            return "index";
        }
        map.put("msg","用户名或密码错误!");
        return "login";
    }
}
