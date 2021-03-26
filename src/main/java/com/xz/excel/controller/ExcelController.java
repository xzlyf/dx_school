package com.xz.excel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: xz
 * @Date: 2021/3/26
 */
@Controller
public class ExcelController {
    @GetMapping("/")
    public String index() {
        return "maintain";
    }

    @GetMapping("/student")
    public String formPage() {
        return "xgym";
    }

    @GetMapping("/find")
    public String showPage() {
        return "tech";
    }
}
