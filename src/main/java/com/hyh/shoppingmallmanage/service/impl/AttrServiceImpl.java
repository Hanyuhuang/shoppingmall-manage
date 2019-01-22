package com.hyh.shoppingmallmanage.service.impl;

import java.util.List;

import com.hyh.shoppingmallmanage.entity.AttrVO;
import com.hyh.shoppingmallmanage.entity.Value;
import com.hyh.shoppingmallmanage.mapper.AttrMapper;
import com.hyh.shoppingmallmanage.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AttrServiceImpl implements AttrService {

	@Autowired
	 AttrMapper attrMapper;

	public void addAttr(AttrVO attrVO) {
		attrMapper.insertAttr(attrVO);
		for (Value value:attrVO.getValueList()){
			// 过滤掉最后一个属性框的空值
			if(!"".equals(value.getValue())&&!"".equals(value.getName())){
				value.setAttrId(attrVO.getId());
				attrMapper.addValue(value);
			}
		}
	}

	public List<AttrVO> listAttr(int class2) {
		return attrMapper.listAttr(class2);
	}

	public void deleteValue(int id) {
		attrMapper.deleteValue(id,"id");
		attrMapper.deleteSkuAttrValue(id,"value_id");
	}

	public void deleteAttr(int id) {
		attrMapper.deleteAttr(id,"id");
		attrMapper.deleteValue(id,"attr_id");
		attrMapper.deleteSkuAttrValue(id,"attr_id");
	}

	public AttrVO getAttr(int id) {
		return attrMapper.getAttr(id);
	}

	public void updateAttr(AttrVO attrVO) {
		attrMapper.updateAttr(attrVO);
		for(Value value:attrVO.getValueList()){
			// 过滤掉最后一个空属性
			if(!"".equals(value.getValue())&&!"".equals(value.getName())){
				// 新添加的属性值
				if(value.getStatus()==null&&value.getCreateTime()==null){
					value.setAttrId(attrVO.getId());
					attrMapper.addValue(value);
				}
				attrMapper.updateValue(value);
			}
		}
	}

}
