package com.hvkcoder.springboot.mapper;

import com.hvkcoder.springboot.domain.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author h-vk
 * @date 2019-12-23
 * @since V1.0
 */
@Mapper
public interface DepartmentMapper extends MybatisBaseMapper<Department> {

}
