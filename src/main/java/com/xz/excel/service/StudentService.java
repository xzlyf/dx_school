package com.xz.excel.service;

import com.xz.excel.table.TableStudent;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/3/26
 */
public interface StudentService {
    long save(TableStudent student);

    List<TableStudent> findAll();
}
