package com.zhuhangjie.crm.mapper;

import java.util.List;

import com.zhuhangjie.crm.pojo.BaseDict;
import com.zhuhangjie.crm.pojo.Customer;
import com.zhuhangjie.crm.pojo.QueryVo;

public interface CustomerMapper {
	//总条数
	public Integer customerCount(QueryVo vo);
	//分页结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	
	//根据id查找
	public Customer selectCustomerById(Integer id);
	//保存用户
	public void updateCustomer(Customer customer);
}
