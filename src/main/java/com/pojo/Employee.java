package com.pojo;

/**
 * 员工实体类
 * @author zeng
 */
public class Employee {

    private int id;
    private String yName;
    private String ySex;
    private int bId;
    private int yAge;
    private String yTelephone;
    private String yZhanghao;
    private String yPassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getyName() {
        return yName;
    }

    public void setyName(String yName) {
        this.yName = yName;
    }

    public String getySex() {
        return ySex;
    }

    public void setySex(String ySex) {
        this.ySex = ySex;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public int getyAge() {
        return yAge;
    }

    public void setyAge(int yAge) {
        this.yAge = yAge;
    }

    public String getyTelephone() {
        return yTelephone;
    }

    public void setyTelephone(String yTelephone) {
        this.yTelephone = yTelephone;
    }

    public String getyZhanghao() {
        return yZhanghao;
    }

    public void setyZhanghao(String yZhanghao) {
        this.yZhanghao = yZhanghao;
    }

    public String getyPassword() {
        return yPassword;
    }

    public void setyPassword(String yPassword) {
        this.yPassword = yPassword;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", yName='" + yName + '\'' +
                ", ySex='" + ySex + '\'' +
                ", bId=" + bId +
                ", yAge=" + yAge +
                ", yTelephone='" + yTelephone + '\'' +
                ", yZhanghao='" + yZhanghao + '\'' +
                ", yPassword='" + yPassword + '\'' +
                '}';
    }
}
