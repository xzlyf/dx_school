package com.xz.excel.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Author: xz
 * @Date: 2021/3/26
 */
@Table(name = "student")
@DynamicUpdate
@Entity
@Data
public class TableStudent {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "system-uuid")
    @JsonIgnore//作用：在实体类向前台返回数据时用来忽略不想传递给前台的属性或接口。
    @Column(name = "uuid", length = 32)
    private String uuid;
    @Column
    private String name;
    @Column
    private String sex;
    @Column
    private String age;
    @Column
    private String duty;
    @Column
    private String idcard;
    @Column
    private String phone;
    @Column
    private String will;
    @Column
    private String remark;

}
