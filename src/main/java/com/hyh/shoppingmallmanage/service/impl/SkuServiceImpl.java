package com.hyh.shoppingmallmanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hyh.shoppingmallmanage.entity.Product;
import com.hyh.shoppingmallmanage.entity.Sku;
import com.hyh.shoppingmallmanage.entity.SkuAttrValue;
import com.hyh.shoppingmallmanage.mapper.SkuMapper;
import com.hyh.shoppingmallmanage.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class SkuServiceImpl implements SkuService {

	@Autowired
	SkuMapper skuMapper;
	
	public void saveSku(SkuAttrValue skuAttrValue) {
		skuAttrValue.getSku().setProductId(skuAttrValue.getSpu().getId());
		skuMapper.insertSku(skuAttrValue.getSku());
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("productId", skuAttrValue.getSpu().getId());
		map.put("skuId", skuAttrValue.getSku().getId());
		map.put("attrValueList", skuAttrValue.getAttrValueList());
		skuMapper.insertSkuAttrValue(map);
	}

	public List<SkuAttrValue> listSku(Product spu) {
		return skuMapper.listSku(spu);
	}

    public void deleteSku(int id) {
        skuMapper.deleteSku(id);
        skuMapper.deleteSkuAttrValue(id);
    }

    public Sku getSku(Sku sku) {
        return skuMapper.getSku(sku);
    }

    public void updateSku(Sku sku) {
        skuMapper.updateSku(sku);
    }

}
