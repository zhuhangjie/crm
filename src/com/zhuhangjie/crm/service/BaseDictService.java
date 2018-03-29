package com.zhuhangjie.crm.service;

import java.util.List;

import com.zhuhangjie.crm.pojo.BaseDict;

public interface BaseDictService {
	public List<BaseDict> findByCode(String code);
}
