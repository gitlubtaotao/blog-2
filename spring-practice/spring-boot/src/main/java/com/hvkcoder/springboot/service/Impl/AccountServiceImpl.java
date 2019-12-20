package com.hvkcoder.springboot.service.Impl;

import com.hvkcoder.springboot.domain.Account;
import com.hvkcoder.springboot.mapper.AccountMapper;
import com.hvkcoder.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author h-vk
 * @date 2019-12-20
 * @since V1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }
}
