package com.hvkcoder.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author h-vk
 * @date 2019-12-02
 * @since V1.0
 */
@Controller // 添加到 Spring 容器中管理
public class IndexController {
  @RequestMapping("/index")
  public String index(ModelMap modelMap) {
    modelMap.addAttribute("msg", "你好，这是使用 Thymeleaf 模板引擎渲染的消息");
    return "index";
  }
}
