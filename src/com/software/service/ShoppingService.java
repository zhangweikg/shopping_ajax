package com.software.service;

import com.software.dao.ShoppingDao;

import java.util.ArrayList;

public class ShoppingService {
    ShoppingDao shoppingDao = new ShoppingDao();
    public ArrayList getGoodsList() {
        return shoppingDao.returnAllGoods();
    }

    public boolean buyTheGoods(String txt_name, String goods_name) {
        if (shoppingDao.isFindTheRow(txt_name, goods_name)){
            return shoppingDao.theGoods_countPlusOne(txt_name, goods_name);
        }else {
            return shoppingDao.addGoods(txt_name, goods_name);
        }
    }

    public boolean removeTheGoods(String txt_name, String goods_name) {
        if (shoppingDao.returnTheGoods_count(txt_name, goods_name) <= 1){
            return shoppingDao.deleteTheRow(txt_name, goods_name);
        }else {
            return shoppingDao.theGoods_countMinusOne(txt_name, goods_name);
        }
    }

    public boolean clearShopCar(String txt_name) {
        return shoppingDao.deleteAllRow(txt_name);
    }

    public ArrayList getBuyList(String txt_name) {
        return shoppingDao.returnBuyList(txt_name);
    }
}
