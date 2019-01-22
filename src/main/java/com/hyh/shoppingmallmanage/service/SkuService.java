package com.hyh.shoppingmallmanage.service;

import com.hyh.shoppingmallmanage.entity.Product;
import com.hyh.shoppingmallmanage.entity.Sku;
import com.hyh.shoppingmallmanage.entity.SkuAttrValue;

import java.util.List;


public interface SkuService {

	void saveSku(SkuAttrValue skuAttrValue);

	List<SkuAttrValue> listSku(Product spu);

    void deleteSku(int id);

	Sku getSku(Sku sku);

	void updateSku(Sku sku);
}
