package com.hvkcoder.springboot.mapper;

import java.util.List;

/**
 * @author h-vk
 * @date 2019-12-23
 * @since V1.0
 */
public interface MybatisBaseMapper<E> {
	List<E> findAll();
}
