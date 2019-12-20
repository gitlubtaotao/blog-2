package com.hvkcoder.springboot.service;

import com.hvkcoder.springboot.domain.Account;

import java.util.List;

/**
 * @author h-vk
 * @date 2019-12-20
 * @since V1.0
 */
public interface AccountService {
    List<Account> findAll();
}
