package com.service.Impl;

import com.dao.BuMenDao;
import com.dao.impl.BuMenDaoImpl;
import com.pojo.BuMen;
import com.service.BuMenService;

import java.util.List;

public class BuMenServiceImpl implements BuMenService {
    private BuMenDao buMenDao=new BuMenDaoImpl();
    @Override
    public boolean saven(BuMen buMen) {
        return buMenDao.saven(buMen);
    }

    @Override
    public boolean update(BuMen buMen) {
        return buMenDao.update(buMen);
    }

    @Override
    public boolean delete(int id) {
        return buMenDao.delete(id);
    }

    @Override
    public List<BuMen> queryAll() {
        return buMenDao.queryAll();
    }

    @Override
    public List<BuMen> query(String name) {
        return buMenDao.query(name);
    }

    @Override
    public BuMen queryid(int id) {
        return buMenDao.queryid(id);
    }
}
