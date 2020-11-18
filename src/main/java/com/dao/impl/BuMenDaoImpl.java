package com.dao.impl;

import com.dao.BuMenDao;
import com.pojo.BuMen;
import com.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

public class BuMenDaoImpl implements BuMenDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtils.getDataSource());


    public boolean saven(BuMen buMen) {
        String sql="insert into bumen (id, bname, bmiaoshu)values (?, ?, ?)";
        Object[] parameter={buMen.getId(), buMen.getbName(), buMen.getbMiaoShu()};
        try{
            jdbcTemplate.update(sql, parameter);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(BuMen buMen) {
        String sql="update bumen set bname=?,bmiaoshu=? where id=?";

        int update = jdbcTemplate.update(sql, buMen.getbName(), buMen.getbMiaoShu(), buMen.getId());
        if (update>0){
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        String sql="delete from bumen where id=?";

        int update = jdbcTemplate.update(sql, id);
        if (update ==0){

            return false;
        }
        return true;
    }

    public List<BuMen> queryAll() {
        String  sql="select*from bumen";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<BuMen>(BuMen.class));
    }

    @Override
    public List<BuMen> query(String name) {
        String  sql="select*from bumen where bname=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(BuMen.class),name);
    }

    @Override
    public BuMen queryid(int id) {
        String sql="select * from bumen where id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<BuMen>(BuMen.class),id);

    }


}
