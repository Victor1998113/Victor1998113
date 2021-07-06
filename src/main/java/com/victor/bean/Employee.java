package com.victor.bean;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
/**
 * @Author 麦 M·Victor
 * @Date 2021-07-03 12:50
 **/
@Data
@TableName(value = "Employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = 9027625044619057410L;
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private int id;
    private String name;
    private int age;
    private String genders;
    private String address;
}
