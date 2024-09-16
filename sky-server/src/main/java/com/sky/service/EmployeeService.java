package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO 登录信息
     * @return 员工信息
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 添加员工
     * @param employeeDTO 员工信息
     */
    void addEmployee(EmployeeDTO employeeDTO);

    /**
     * 分页查询员工
     * @param employeePageQueryDTO 分页查询条件
     * @return 分页查询结果
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 启用或禁用员工账号
     * @param status 状态
     * @param id 员工id
     */
    void enableOrDisableEmployee(Integer status, Long id);

    /**
     * 编辑员工信息
     * @param employeeDTO 员工信息
     */
    void updateEmployee(EmployeeDTO employeeDTO);

    /**
     * 根据id查询员工
     * @param id 员工id
     * @return 员工信息
     */
    Employee getEmployeeById(Long id);
}
