package com.hvkcoder.springboot.controller;

import com.hvkcoder.springboot.domain.Department;
import com.hvkcoder.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author h-vk
 * @date 2019-12-19
 * @since V1.0
 *
 * @RestController 相当于 @Controller + @ResponseBody
 * @Controller 单独是使用，返回指定的视图
 */
@Controller
public class IndexController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping(path = "/getDepartmentAll")
    @ResponseBody
    public List<Department> getDepartmentAll() {
        return departmentService.findAllDepartment();
    }
}
