package com.xz.excel.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xz
 * @Date: 2021/3/26
 */
@RestController
@RequestMapping("/data")
public class DataController {
    @PostMapping("/save")
    public void save(@RequestParam(value = "name", required = false) String name,
                     @RequestParam(value = "sex", required = false) String sex,
                     @RequestParam(value = "age", required = false) String age,
                     @RequestParam(value = "duty", required = false) String duty,
                     @RequestParam(value = "idcard", required = false) String idcard,
                     @RequestParam(value = "phone", required = false) String phone,
                     @RequestParam(value = "will", required = false) String will,
                     @RequestParam(value = "remark", required = false) String remark) {

        System.out.println(name + "==================");
    }

}
