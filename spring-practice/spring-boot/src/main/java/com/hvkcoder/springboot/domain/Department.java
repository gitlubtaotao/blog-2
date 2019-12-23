package com.hvkcoder.springboot.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author h-vk
 * @date 2019-12-23
 * @since V1.0
 */
@Data
public class Department implements Serializable {
	/**
	 * 部门ID
	 */
	private String departmentId;

	/**
	 * 部门名称
	 */
	private String departmentName;
}
