package com.xz.excel.controller;

import com.xz.excel.bean.ApiResult;
import com.xz.excel.bean.Student;
import com.xz.excel.constant.StatusEnum;
import com.xz.excel.service.impl.StudentServiceImpl;
import com.xz.excel.table.TableStudent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: xz
 * @Date: 2021/3/26
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    StudentServiceImpl studentService;

    @PostMapping(value = "/save", produces = "application/json;charset=UTF-8")
    public Object save(@RequestBody(required = false) Student student) {
        if (student == null) {
            System.out.println("未传入数据");
            return new ApiResult(StatusEnum.STATUS_2);
        }

        TableStudent tableStudent = new TableStudent();
        BeanUtils.copyProperties(student, tableStudent);

        System.out.println(tableStudent.toString());

        long state = studentService.save(tableStudent);
        if (state == 1) {
            return new ApiResult(StatusEnum.SUCCESS);
        }
        return new ApiResult(StatusEnum.ERROR);
    }

}
