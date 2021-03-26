package com.xz.excel.service.impl;

import com.xz.excel.repository.StudentRepo;
import com.xz.excel.service.StudentService;
import com.xz.excel.table.TableStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xz
 * @Date: 2021/3/26
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public long save(TableStudent student) {
        try {
            studentRepo.save(student);
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }
}
