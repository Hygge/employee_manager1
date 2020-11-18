package com.pojo;

/**
 * 部门实体类
 * @author  zeng
 */
public class BuMen {

    /**
     * 部门id
     */
    private int id;
    /**
     * 部门名称
     */
    private String bName;
    /**
     * 部门描述
     */
    private String bMiaoShu;

 /*   public BuMen(int id, String bName, String bMiaoShu) {
        this.id = id;
        this.bName = bName;
        this.bMiaoShu = bMiaoShu;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbMiaoShu() {
        return bMiaoShu;
    }

    public void setbMiaoShu(String bMiaoShu) {
        this.bMiaoShu = bMiaoShu;
    }

    @Override
    public String toString() {
        return "BuMen{" +
                "id=" + id +
                ", bName='" + bName + '\'' +
                ", bMiaoShu='" + bMiaoShu + '\'' +
                '}';
    }
}
