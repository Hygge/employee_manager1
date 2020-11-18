package com.pojo;

import java.util.List;

public class EmployeeBuMen<T> {

    private List<T> list;
    private String bumen;

    public EmployeeBuMen(List<T> list, String bumen) {
        this.list = list;
        this.bumen = bumen;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getBumen() {
        return bumen;
    }

    public void setBumen(String bumen) {
        this.bumen = bumen;
    }
}
