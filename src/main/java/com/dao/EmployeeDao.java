package com.dao;

import com.pojo.Employee;


import java.util.List;

/**
 * 员工操作接口
 * @author zeng
 */
public interface EmployeeDao {

    /**
     * 登录方法
     * @param yZhanghao 登录名
     * @param yPassword 密码
     * @return
     */
    public Employee login(String yZhanghao,String yPassword);

    /**
     * 员工添加操作
     * @param employee 员工实体类封装
     * @return  判断员工添加是否成功
     */
    public boolean saven(Employee employee);

    /**
     * 员工修改操作
     * @param employee 员工实体类封装
     * @return 判断员工修改是否成功
     */
    public boolean updateEmployee(Employee employee);

    /**
     * 删除员工操作
     * @param id  员工id
     * @return  删除是否成功
     */
    public boolean deleteEmployee(int id);

    /**
     *  查询所有员工的信息
     * @return 员工信息集合
     */
    public List<Employee> queryAll();

    public List<Employee> queryName(String name);

    public List<Employee> queryId(int id);

    public List<Employee> queryZhanghao(String zhanghao);

}
