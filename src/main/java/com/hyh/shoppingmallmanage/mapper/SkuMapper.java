package com.hyh.shoppingmallmanage.mapper;

import java.util.List;
import java.util.Map;

import com.hyh.shoppingmallmanage.entity.Product;
import com.hyh.shoppingmallmanage.entity.Sku;
import com.hyh.shoppingmallmanage.entity.SkuAttrValue;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SkuMapper {

	void insertSku(Sku sku);

	void insertSkuAttrValue(Map<Object, Object> map);

	List<SkuAttrValue> listSku(Product spu);

    void deleteSku(int id);

    void deleteSkuAttrValue(int id);

    Sku getSku(Sku sku);

    void updateSku(Sku sku);
}
