package com.hyh.shoppingmallmanage.mapper;



import com.hyh.shoppingmallmanage.entity.Attr;
import com.hyh.shoppingmallmanage.entity.AttrVO;
import com.hyh.shoppingmallmanage.entity.Value;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttrMapper {

	void insertAttr(AttrVO attr);

	List<AttrVO> listAttr(int class2);

    void deleteValue(@Param("id")int id,@Param("column")String column);

    void deleteSkuAttrValue(@Param("id")int id,@Param("column")String column);

	void deleteAttr(@Param("id")int id,@Param("column")String column);

	AttrVO getAttr(int id);

	void updateAttr(Attr attr);

	void updateValue(Value value);

	void addValue(Value value);
}
