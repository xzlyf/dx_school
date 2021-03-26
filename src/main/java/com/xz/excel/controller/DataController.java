package com.xz.excel.controller;

import com.xz.excel.bean.ApiResult;
import com.xz.excel.bean.Student;
import com.xz.excel.constant.StatusEnum;
import com.xz.excel.service.impl.StudentServiceImpl;
import com.xz.excel.table.TableStudent;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

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

    @GetMapping(value = "/find")
    public Object findAll() {
        List<TableStudent> list = null;
        try {
            list = studentService.findAll();
        } catch (Exception e) {
            return new ApiResult(StatusEnum.ERROR);
        }

        return new ApiResult(StatusEnum.SUCCESS, list);
    }

    @GetMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<TableStudent> list = null;
        list = studentService.findAll();

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet1");
        HSSFRow row = null;

        //row = sheet.createRow(0);//创建第一个单元格
        //row.setHeight((short) (26.25 * 20));
        //row.createCell(0).setCellValue("用户信息列表");//为第一行单元格设值
        //
        ///*为标题设计空间
        // * firstRow从第1行开始
        // * lastRow从第0行结束
        // *
        // *从第1个单元格开始
        // * 从第7个单元格结束
        // */
        //CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 7);
        //sheet.addMergedRegion(rowRegion);

      /*CellRangeAddress columnRegion = new CellRangeAddress(1,4,0,0);
      sheet.addMergedRegion(columnRegion);*/

        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("姓名");//为第一个单元格设值
        row.createCell(1).setCellValue("性别");//为第一个单元格设值
        row.createCell(2).setCellValue("年龄");//为第一个单元格设值
        row.createCell(3).setCellValue("岗位/职务");//为第一个单元格设值
        row.createCell(4).setCellValue("身份证号");//为第一个单元格设值
        row.createCell(5).setCellValue("联系电话");//为第一个单元格设值
        row.createCell(6).setCellValue("是否愿意");//为第一个单元格设值
        row.createCell(7).setCellValue("备注");//为第一个单元格设值
        //遍历所获取的数据
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 2);
            TableStudent ts = list.get(i);
            row.createCell(0).setCellValue(ts.getName());
            row.createCell(1).setCellValue(ts.getSex());
            row.createCell(2).setCellValue(ts.getAge());
            row.createCell(3).setCellValue(ts.getDuty());
            row.createCell(4).setCellValue(ts.getIdcard());
            row.createCell(5).setCellValue(ts.getPhone());
            row.createCell(6).setCellValue(ts.getWill());
            row.createCell(7).setCellValue(ts.getRemark());
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=test.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }
}
