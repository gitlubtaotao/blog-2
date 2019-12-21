package com.hvkcoder.springboot.controller;

import com.hvkcoder.springboot.domain.Account;
import com.hvkcoder.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author h-vk
 * @date 2019-12-19
 * @since V1.0
 */
@RestController
public class IndexController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/")
    public List<Account> index() {
        return accountService.findAll();
    }
}
