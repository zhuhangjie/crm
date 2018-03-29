package com.zhuhangjie.crm.service;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhuhangjie.common.utils.Page;
import com.zhuhangjie.crm.mapper.CustomerMapper;
import com.zhuhangjie.crm.pojo.Customer;
import com.zhuhangjie.crm.pojo.QueryVo;
/**
 * 客户管理
 * <p>Title: CustomerServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerMapper customerMapper;
	
	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
		Page<Customer> page = new Page<Customer>();
		//判断当前页
		page.setSize(5);
		if(vo != null ) {
			if(vo.getPage() != null) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			if(vo.getCustName() != null && !"".equals(vo.getCustName().trim())) {
				vo.setCustName(vo.getCustName().trim());
			}
			if(vo.getCustSource() != null && !"".equals(vo.getCustSource().trim())) {
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(vo.getCustIndustry() != null && !"".equals(vo.getCustIndustry().trim())) {
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(vo.getCustLevel() != null && !"".equals(vo.getCustLevel().trim())) {
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			//
			Integer count = customerMapper.customerCount(vo);
			page.setTotal(count);
			List<Customer> list = customerMapper.selectCustomerListByQueryVo(vo);
			page.setRows(list);
		}
		
		return page;
		
	}

	public Customer selectCustomerById(Integer id) {
		
		return customerMapper.selectCustomerById(id);
	}

	public void update(Customer customer) {
		customerMapper.updateCustomer(customer);
	}

	//通过4个条件查询分页对象
}
