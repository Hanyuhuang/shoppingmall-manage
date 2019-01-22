package com.hyh.shoppingmallmanage.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AttrVO extends Attr {

	private List<Value> valueList;

}
