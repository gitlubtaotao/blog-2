package com.hvkcoder.springboot.mapper;

import com.hvkcoder.springboot.domain.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author h-vk
 * @date 2019-12-20
 * @since V1.0
 */
@Mapper
public interface AccountMapper {
    List<Account> findAll();
}
