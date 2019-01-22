package com.hyh.shoppingmallmanage.controller;

import java.util.List;

import com.hyh.shoppingmallmanage.entity.*;
import com.hyh.shoppingmallmanage.service.AttrService;
import com.hyh.shoppingmallmanage.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class SkuController {

	@Autowired
	AttrService attrService;
	
	@Autowired
	SkuService skuService;
	
	@RequestMapping("gotoAddSku")
	public String gotoAddSku(Product spu,ModelMap map) {
		List<AttrVO> attrList = attrService.listAttr(spu.getClass2());
		map.put("spu", spu);
        map.put("attrList", attrList);
		return "skuAdd";
	}
	@RequestMapping("listSku")
	public String listSku(Product spu, ModelMap map) {
		List<SkuAttrValue> skuList=skuService.listSku(spu);
		map.put("skuList",skuList);
		return "skuList";
	}

    @RequestMapping("deleteSku")
    public String deleteSku(int skuId,Product spu,RedirectAttributes redirectAttributes) {
        skuService.deleteSku(skuId);
        redirectAttributes.addAttribute("id",spu.getId());
        redirectAttributes.addAttribute("class2",spu.getClass2());
        redirectAttributes.addAttribute("brandId",spu.getBrandId());
        return "redirect:/listSku";
    }
	
	@RequestMapping("addSku")
	public String addSku(SkuAttrValue skuAttrValue, RedirectAttributes attributes) {
		skuService.saveSku(skuAttrValue);
		attributes.addAttribute("msg", "添加成功！");
		return "redirect:/success";
	}

    @RequestMapping("gotoUpdateSku")
    public String gotoUpdateSku(Sku sku,ModelMap map) {
        sku = skuService.getSku(sku);
        map.put("sku", sku);
        return "skuUpdate";
    }

    @RequestMapping("updateSku")
    public String updateSku(Sku sku,RedirectAttributes attributes) {
	    skuService.updateSku(sku);
		attributes.addAttribute("msg", "修改成功！");
		return "redirect:/success";
    }
}
