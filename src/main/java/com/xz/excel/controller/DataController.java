package com.xz.excel.controller;

import com.xz.excel.bean.ApiResult;
import com.xz.excel.bean.Student;
import com.xz.excel.constant.StatusEnum;
import org.springframework.web.bind.annotation.*;

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

    }

    @PostMapping(value = "/saveV2", produces = "application/json;charset=UTF-8")
    public Object saveV2(@RequestBody(required = false) Student student) {
        if (student == null) {
            System.out.println("未传入数据");
            return new ApiResult(StatusEnum.STATUS_2);
        }


        return new ApiResult(StatusEnum.SUCCESS);
    }

}
