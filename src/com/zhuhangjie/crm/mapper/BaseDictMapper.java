package com.zhuhangjie.crm.mapper;

import java.util.List;

import com.zhuhangjie.crm.pojo.BaseDict;

public interface BaseDictMapper {
	
	public List<BaseDict> findByCode(String code);
}
