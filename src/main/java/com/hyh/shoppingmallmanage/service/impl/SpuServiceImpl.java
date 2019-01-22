package com.hyh.shoppingmallmanage.service.impl;

import java.util.List;

import com.hyh.shoppingmallmanage.entity.Product;
import com.hyh.shoppingmallmanage.entity.ProductImage;
import com.hyh.shoppingmallmanage.mapper.SpuMapper;
import com.hyh.shoppingmallmanage.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SpuServiceImpl implements SpuService {

	@Autowired
	SpuMapper spuMapper;
	
	public void addSpu(Product spu) {
		spuMapper.addSpu(spu);
	}

	public void addImages(List<ProductImage> images) {
		spuMapper.addImages(images);
	}

	public void deleteSpu(Product spu){
		spuMapper.deleteSpu(spu);
		spuMapper.deleteImages(spu);
	}
	public void updateSpu(Product spu){
		spuMapper.updateSpu(spu);
	}
    public Product getSpu(Product spu){
		return spuMapper.getSpu(spu);
	}
	public List<Product> listSpu(Product spu) {
		return spuMapper.listSpu(spu);
	}

}
