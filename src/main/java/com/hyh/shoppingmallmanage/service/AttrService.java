package com.hyh.shoppingmallmanage.service;

import com.hyh.shoppingmallmanage.entity.AttrVO;

import java.util.List;


public interface AttrService {

	void addAttr(AttrVO attrVO);
	
	List<AttrVO> listAttr(int class2);

    void deleteValue(int id);

	void deleteAttr(int id);

	AttrVO getAttr(int id);

	void updateAttr(AttrVO attrVO);
}
