package com.xz.excel.repository;

import com.xz.excel.table.TableStudent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: xz
 * @Date: 2021/3/9
 */
public interface StudentRepo extends JpaRepository<TableStudent, Long> {

}
