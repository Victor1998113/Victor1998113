package com.victor.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.victor.bean.Employee;
import com.victor.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * @Author 麦 M·Victor
 * @Date 2021-07-03 13:19
 **/
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * 增加新员工 addEmp
     *
     * @param employee
     * @return
     */
    @PostMapping("/addEmp")
    public String addEmp(@RequestBody Employee employee) {
        System.out.println("进入 addEmp 方法.........................!");
        boolean saveEmp = employeeService.save(employee);
        return saveEmp ? "ok" : "no";
    }

    /**
     * Checking All Emp Info查询所有员工信息
     *
     * @return
     */
    @GetMapping("/findAll")
    public List<Employee> findAll() {
        System.out.println("查询所有信息");
        System.out.println("进入 findAll 方法...........................!");
        return employeeService.list();
    }

    /**
     * 根据ID查询员工信息 findEmpById
     *
     * @param id
     * @return
     */
    @RequestMapping("/findEmpById")
    public Employee findEmpById(@RequestParam("id") Integer id) {
        System.out.println("进入 findEmpById 方法...........................!");
        return employeeService.getById(id);
    }

    /**
     * 修改员工信息 updateMmpInfo
     *
     * @param employee
     * @return
     */
    @RequestMapping("updateEmp")
    public String updateEmp(@RequestBody Employee employee) {
        boolean b = employeeService.updateById(employee);
        System.out.println("进入 updateEmp 方法...........................!");
        return b ? "ok" : "no";
    }

    /**
     * 删除员工信息 deleteEmp
     *
     * @param id
     * @return
     */
    @RequestMapping("deleteEmp")
    public String deleteEmp(@RequestParam("id") Integer id) {
        System.out.println("进入delete 方法...........................!");
        boolean b = employeeService.removeById(id);
        return b ? "ok" : "no";
    }

    /**
     * 分页以及按员工名称模糊分页查询@Test /allEmpByPage?pageIndex=1&pageSize=1&search=""
     * @param pageIndex
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("findAllEmpBypage")
    public IPage<Employee> findAllEmpBypage(
            @RequestParam(required = false, defaultValue = "1", value = "pageIndex") Integer pageIndex,//当前页
            @RequestParam(required = false, defaultValue = "5", value = "pageSize") Integer pageSize,// 页大小
            @RequestParam(required = false, defaultValue = "",value = "search")String search//搜索条件
    ){
        //Mybatis-plus Conditional select form 带条件查询
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();


        //这里是Mybatis-plus Conditional select form 多条件查询语句
         queryWrapper.like("name",search).or().like("address",search);

        Page<Employee> page = new Page<Employee>(pageIndex, pageSize);

        IPage<Employee> iPage = employeeService.page(page,queryWrapper);
        //select Results data查询出来的数据
        List<Employee> list = iPage.getRecords();
        // foreach print out data循环打印查询出来的数据
        list.forEach(System.out::println);
        System.out.println(iPage);
          //return data
        return iPage;

    }
}

















