package com.dao;

import com.pojo.BuMen;


import java.util.List;

/**
 * 部门表操作接口
 * @author zeng
 */
public interface BuMenDao {

    /**
     * 添加部门操作
     * @param buMen 部门实体类
     * @return  受影响行数，用于判断是否成功
     */
    public boolean  saven(BuMen buMen);

    /**
     * 修改部门
     * @param buMen 部门实体类
     * @return  受影响行数，用于判断是否成功
     */
    public boolean update(BuMen buMen);

    /**
     * 删除部门
     * @param id    部门实体类
     * @return  受影响行数，用于判断是否成功
     */
    public boolean delete(int id);

    /**
     * 查询所以部门信息
     * @return  所有部门
     */
    public List<BuMen> queryAll();


    public List<BuMen> query(String name);
    public BuMen queryid(int id);



}
