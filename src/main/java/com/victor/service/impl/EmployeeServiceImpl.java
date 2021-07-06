package com.victor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.victor.bean.Employee;
import com.victor.mapper.EmployeeMapper;
import com.victor.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @Author 麦 M·Victor
 * @Date 2021-07-03 13:16
 **/
@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
