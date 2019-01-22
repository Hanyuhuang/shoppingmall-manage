package com.hyh.shoppingmallmanage.service;

import com.hyh.shoppingmallmanage.entity.Product;
import com.hyh.shoppingmallmanage.entity.ProductImage;

import java.util.List;


public interface SpuService {

	void addSpu(Product spu);

	void addImages(List<ProductImage> images);

	void deleteSpu(Product spu);

	void updateSpu(Product spu);

	Product getSpu(Product spu);

	List<Product> listSpu(Product spu);

}
