package com.hvkcoder.mybatis.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author h-vk
 * @date 2019-12-19
 * @since V1.0
 */
public interface DepartmentMapper {
	List<Map<String,Object>> selectDepartment();
}
