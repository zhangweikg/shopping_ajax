package com.software.domain;

public class UserRegisterInfo {
    private String txt_name;
    private String pwd;
    private String email;
    private String tel;
    private String sex;
    private String age;
    private String xueli;
    private String jianli;
    private String[] habby;
    private String ID;

    public void setHabby(String[] habby) {
        this.habby = habby;
    }

    public String[] getHabby() {

        return habby;
    }

    public String getTxt_name() {
        return txt_name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

    public String getXueli() {
        return xueli;
    }

    public String getJianli() {
        return jianli;
    }

    public String getID() {
        return ID;
    }

    public void setTxt_name(String txt_name) {
        this.txt_name = txt_name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    public void setJianli(String jianli) {
        this.jianli = jianli;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "UserRegisterInfo{" +
                "txt_name='" + txt_name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", xueli='" + xueli + '\'' +
                ", jianli='" + jianli + '\'' +
                ", habby='" + habby + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }

}
