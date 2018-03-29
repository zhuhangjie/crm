package com.zhuhangjie.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhuhangjie.common.utils.Page;
import com.zhuhangjie.crm.pojo.BaseDict;
import com.zhuhangjie.crm.pojo.Customer;
import com.zhuhangjie.crm.pojo.QueryVo;
import com.zhuhangjie.crm.service.BaseDictService;
import com.zhuhangjie.crm.service.CustomerService;

/**
 * 客户管理
 * <p>Title: CustomerController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class CustomerController {

	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService ;
	
	//配置文件注入成员变量
	@Value("${fromType_code}")
	private String fromTypeCode;
	
	//入口
	@RequestMapping("/customer/list")
	public String list(QueryVo vo,Model model) {
		List<BaseDict> fromType = baseDictService.findByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.findByCode("001");
		List<BaseDict> levelType = baseDictService.findByCode("006");
		model.addAttribute("fromType",fromType);
		model.addAttribute("industryType",industryType);
		model.addAttribute("levelType",levelType);
		
		//通过4个条件查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName",vo.getCustName());
		model.addAttribute("custSource",vo.getCustSource());
		model.addAttribute("custIndustry",vo.getCustIndustry());
		model.addAttribute("custLevel",vo.getCustLevel());
		return "customer";
		
		
	}
	
	//去修改页面
	@RequestMapping(value = "/customer/edit.action")
	@ResponseBody
	public Customer edit(Integer id) {
		//通过Id查询客户
		return customerService.selectCustomerById(id);
	}
	
	//去保存页面
	@RequestMapping(value = "/customer/update.action")
	@ResponseBody
	public String update(Customer customer) {
		//通过Id查询客户
		customerService.update(customer);
		return "OK";
	}
}
