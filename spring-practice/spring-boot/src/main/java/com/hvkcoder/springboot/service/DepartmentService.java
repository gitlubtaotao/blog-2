package com.hvkcoder.springboot.service;

import com.hvkcoder.springboot.domain.Department;

import java.util.List;

/**
 * @author h-vk
 * @date 2019-12-23
 * @since V1.0
 */
public interface DepartmentService {
	List<Department> findAllDepartment();
}
