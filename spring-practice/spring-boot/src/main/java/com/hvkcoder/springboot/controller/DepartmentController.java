package com.hvkcoder.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hvkcoder.springboot.domain.Department;
import com.hvkcoder.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author h-vk
 * @date 2019-12-23
 * @since V1.0
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/getDepartmentByPage")
    public Object getDepartmentByPage(Integer pageIndex, Integer pageSize) {
        pageIndex = pageIndex == null ? 1 : pageIndex;
        pageSize = pageSize == null ? 10 : pageSize;

        PageHelper.startPage(pageIndex, pageSize);
        List<Department> allDepartment = departmentService.findAllDepartment();
        PageInfo<Department> departmentPageInfo = new PageInfo<>(allDepartment);

        return departmentPageInfo;
    }
}
