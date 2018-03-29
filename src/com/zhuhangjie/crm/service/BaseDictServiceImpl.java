package com.zhuhangjie.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhuhangjie.crm.mapper.BaseDictMapper;
import com.zhuhangjie.crm.pojo.BaseDict;

@Service
//@Transaction
public class BaseDictServiceImpl implements BaseDictService{
	@Autowired
	private BaseDictMapper baseDictMapper;

	public List<BaseDict> findByCode(String code) {
		
		return baseDictMapper.findByCode(code);
	}
	

}
