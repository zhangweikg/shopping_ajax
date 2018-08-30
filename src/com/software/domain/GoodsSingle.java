package com.software.domain;

public class GoodsSingle {
    //封装商品信息
    private String name; //保存商品名称
    private float price; //保存商品价格
    private int num; //商品购买数量

    public GoodsSingle(){
        super();
    }
    public GoodsSingle(String name, float price, int num){
        this.name = name;
        this.price = price;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
