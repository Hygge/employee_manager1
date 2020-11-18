package com.dao.impl;

import com.dao.EmployeeDao;

import com.pojo.Employee;
import com.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * 员工操作实现类
 * @author zeng
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public Employee login(String yZhanghao, String yPassword) {
        String sql="select*from yuangong where yzhanghao=? and ypassword=?";
        Employee employee=null;
        try{

           employee=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Employee.class),yZhanghao,yPassword);
        }catch (Exception e){

        }
        return employee;
    }

    @Override
    public boolean saven(Employee employee) {
        String sql= "insert into yuangong (yname, ysex, bid, yage, ytelephone, yzhanghao," +
                " ypassword) values(?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            jdbcTemplate.update(sql,employee.getbId(),employee.getyName(),employee.getySex(),
                    employee.getbId(),employee.getyAge(),employee.getyTelephone(),employee.getyZhanghao(),
                    employee.getyPassword());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        String sql =" update yuangong set yname=?, ysex=?, bid=?, yage=?, ytelephone=?, yzhanghao=?," +
                "ypassword=? where id=?";
        try{
            jdbcTemplate.update(sql,employee.getyName(),employee.getySex(),employee.getbId(),
                    employee.getyAge(),employee.getyTelephone(),employee.getyZhanghao(),employee.getyPassword(),employee.getId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteEmployee(int id) {
        String sql="delete from yuangong where id=?";

        int update = jdbcTemplate.update(sql, id);
        if (update>0){
            return false;
        }
        return true;
    }

    @Override
    public List<Employee> queryAll() {
        String sql = "select*from yuangong";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public List<Employee> queryName(String name) {
        String sql = "select*from yuangong where yname=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Employee.class),name);
    }

    @Override
    public List<Employee> queryId(int id) {
        String sql="select * from yuangong where id=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Employee.class),id);
    }

    @Override
    public List<Employee> queryZhanghao(String zhanghao) {
        String sql="select * from yuangong where yzhanghao=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Employee.class),zhanghao);
    }

}
