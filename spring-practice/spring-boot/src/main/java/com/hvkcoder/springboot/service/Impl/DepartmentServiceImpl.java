package com.hvkcoder.springboot.service.Impl;

import com.hvkcoder.springboot.domain.Department;
import com.hvkcoder.springboot.mapper.DepartmentMapper;
import com.hvkcoder.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author h-vk
 * @date 2019-12-23
 * @since V1.0
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public List<Department> findAllDepartment() {
		return departmentMapper.findAll();
	}
}
