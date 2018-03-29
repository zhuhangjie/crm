package com.zhuhangjie.crm.service;

import javax.management.Query;

import com.zhuhangjie.common.utils.Page;
import com.zhuhangjie.crm.pojo.Customer;
import com.zhuhangjie.crm.pojo.QueryVo;

public interface CustomerService {
	//通过4个条件查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	
	public Customer selectCustomerById(Integer id);
	
	public void update(Customer customer);
}
