package com.hyh.shoppingmallmanage.controller;

import java.util.List;

import com.hyh.shoppingmallmanage.entity.AttrVO;
import com.hyh.shoppingmallmanage.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AttrController {

	@Autowired
    AttrService attrService;
	
	@RequestMapping("gotoAddAttr")
	public String gotoAddAttr(int class2,ModelMap map) {
		map.put("class2", class2);
		return "attrAdd";
	}
	
	@RequestMapping("addAttr")
	public String addAttr(AttrVO attrVO,RedirectAttributes attributes) {
		attrService.addAttr(attrVO);
		attributes.addAttribute("msg","添加成功!");
		return "redirect:/success";
	}
	@RequestMapping("gotoUpdateAttr")
	public String gotoUpdateAttr(int id,ModelMap map) {
        AttrVO attrVO = attrService.getAttr(id);
        map.put("attrVO",attrVO);
		return "attrUpdate";
	}
	@RequestMapping("updateAttr")
	public String updateAttr(AttrVO attrVO,RedirectAttributes attributes) {
		attrService.updateAttr(attrVO);
		attributes.addAttribute("msg","修改成功!");
		return "redirect:/success";
	}
	@RequestMapping("deleteValue")
	public String deleteValue(int id,int class2,RedirectAttributes redirectAttributes) {
		attrService.deleteValue(id);
		redirectAttributes.addAttribute("class2",class2);
		return "redirect:/listAttr";
	}
	@RequestMapping("deleteAttr")
	public String deleteAttr(int id,int class2,RedirectAttributes redirectAttributes) {
		attrService.deleteAttr(id);
		redirectAttributes.addAttribute("class2",class2);
		return "redirect:/listAttr";
	}
	@RequestMapping("listAttr")
	public String listAttr(int class2, ModelMap map) {
		List<AttrVO> attrList = attrService.listAttr(class2);
		map.put("class2", class2);
		map.put("attrList", attrList);
		return "attrList";
	}
}
