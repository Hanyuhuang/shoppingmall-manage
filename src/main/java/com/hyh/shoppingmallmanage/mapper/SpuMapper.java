package com.hyh.shoppingmallmanage.mapper;

import java.util.List;
import com.hyh.shoppingmallmanage.entity.Product;
import com.hyh.shoppingmallmanage.entity.ProductImage;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SpuMapper {

	void addSpu(Product spu);

	void addImages(List<ProductImage> images);

	void deleteSpu(Product spu);

	void deleteImages(Product spu);

	void updateSpu(Product spu);

	Product getSpu(Product spu);

	List<Product> listSpu(Product spu);
}
