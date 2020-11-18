package com.service.Impl;

import com.dao.EmployeeDao;
import com.dao.impl.EmployeeDaoImpl;
import com.pojo.Employee;
import com.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao=new EmployeeDaoImpl();

    @Override
    public Employee login(String yZhanghao, String yPassword) {
        return employeeDao.login(yZhanghao,yPassword);
    }

    @Override
    public boolean saven(Employee employee) {

        return employeeDao.saven(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeDao.deleteEmployee(id);
    }

    @Override
    public List<Employee> queryAll() {
        return employeeDao.queryAll();
    }

    @Override
    public List<Employee> queryName(String name) {
        return employeeDao.queryName(name);
    }

    @Override
    public List<Employee> queryId(int id) {
        return employeeDao.queryId(id);
    }

    @Override
    public List<Employee> queryZhanghao(String zhanghao) {
        System.out.println("..");
        System.out.println(zhanghao);
        return employeeDao.queryZhanghao(zhanghao);
    }
}
