package com.hyh.shoppingmallmanage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hyh.shoppingmallmanage.entity.Product;
import com.hyh.shoppingmallmanage.entity.ProductImage;
import com.hyh.shoppingmallmanage.service.SpuService;
import com.hyh.shoppingmallmanage.util.MyFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class SpuController {
	
	@Autowired
	SpuService spuService;

	@RequestMapping("gotoAddSpu")
	public String gotoAddSpu(ModelMap map, Product spu) {
		map.put("spu", spu);
		return "spuAdd";
	}
	
	@RequestMapping("listSpu")
	@ResponseBody
	public List<Product> listSpu(Product spu) {
		List<Product> spuList = spuService.listSpu(spu);
		return spuList;
	}

	@RequestMapping("getSpu")
	public String getSpu(Product spu,ModelMap map) {
		List<Product> spuList = spuService.listSpu(spu);
		map.put("spuList",spuList);
		return "spuList";
	}

    @RequestMapping("deleteSpu")
		public String deleteSpu(Product spu,RedirectAttributes redirectAttributes) {
			spuService.deleteSpu(spu);
			redirectAttributes.addAttribute("class2",spu.getClass2());
		    redirectAttributes.addAttribute("brandId",spu.getBrandId());
			return "redirect:/getSpu";
    }

    @RequestMapping("gotoUpdateSpu")
    public String gotoUpdateSpu(Product spu,ModelMap map) {
	    spu = spuService.getSpu(spu);
        map.put("spu",spu);
        return "spuUpdate";
    }

    @RequestMapping("updateSpu")
    public String updateSpu(Product spu,MultipartFile file,RedirectAttributes attributes) {
	    if(!file.isEmpty()){
            String fileName = MyFileUpload.newFileName(file);
            MyFileUpload.upload(file,fileName);
            spu.setPic(fileName);
        }
        spuService.updateSpu(spu);
		attributes.addAttribute("msg","修改成功!");
		return "redirect:/success";
    }

	@RequestMapping("addSpu")
	public String addSpu(Product spu, @RequestParam MultipartFile[] files,RedirectAttributes attributes) {
		List<String> fileNames = null;
		// 是否上传图片
		if(files.length>1) {
			// 修改图片名称
			fileNames = MyFileUpload.newFileName(files);
			// 上传图片
			MyFileUpload.upload(files,fileNames);	
			// 添加spu信息
			spu.setPic(fileNames.get(0));
			spuService.addSpu(spu);	
			// 创建图片对象并添加图片到数据库
			List<ProductImage> images = new ArrayList<ProductImage>();
			for(String url:fileNames) {
				ProductImage image = new ProductImage();
				image.setProductId(spu.getId());
				image.setUrl(url);
				images.add(image);
			}
	        spuService.addImages(images);
		}else if(spu!=null){
			spuService.addSpu(spu);	
		}
		attributes.addAttribute("msg","添加成功!");
		return "redirect:/success";
	}
}
