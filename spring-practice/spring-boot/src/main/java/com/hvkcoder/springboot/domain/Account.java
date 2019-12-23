package com.hvkcoder.springboot.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author h-vk
 * @date 2019-12-23
 * @since V1.0
 */
@Data
public class Account implements Serializable {
	/**
	 * 用户ID
	 */
	private String accountId;

	/**
	 * 登录邮箱
	 */
	private String email;

	/**
	 * 用户名称
	 */
	private String userName;

	/**
	 * 登录密码
	 */
	private String password;

	/**
	 * 用户角色，user 普通用户，admin 管理员
	 */
	private String role;

	/**
	 * 部门ID
	 */
	private String departmentId;
}
