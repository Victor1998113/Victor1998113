package com.victor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.victor.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 麦 M·Victor
 * @Date 2021-07-03 13:13
 **/
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
