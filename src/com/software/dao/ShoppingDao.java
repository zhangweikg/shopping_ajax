package com.software.dao;

import com.software.utils.JDBCUtils;
import com.software.domain.GoodsSingle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ShoppingDao {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    Statement stmt = null;

    public ArrayList returnAllGoods() {
        ArrayList<GoodsSingle> goodsList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnnection();
            String sql = "select * from goods_single";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                goodsList.add(new GoodsSingle(rs.getString("name"), rs.getFloat("price"), 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return goodsList;
    }

    public boolean addGoods(String txt_name, String goods_name) {
        int flag = 0;
        try {
            conn = JDBCUtils.getConnnection();
            String sql = "insert into shop_car(txt_name, goods_name, goods_count) values(?, ?, ?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, txt_name);
            pstm.setString(2, goods_name);
            pstm.setInt(3, 1);
            flag = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstm, conn);
        }
        return flag != 0;
    }

    public boolean isFindTheRow(String txt_name, String goods_name) {
        try {
            conn = JDBCUtils.getConnnection();
            String sql = "select * from shop_car where txt_name = ? and goods_name = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, txt_name);
            pstm.setString(2, goods_name);
            rs = pstm.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstm, conn);
        }
        return false;
    }

    public boolean theGoods_countPlusOne(String txt_name, String goods_name) {
        int flag = 0;
        try {
            conn = JDBCUtils.getConnnection();
            String sql = "update shop_car set goods_count=goods_count+1 where txt_name = ? and goods_name = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, txt_name);
            pstm.setString(2, goods_name);
            flag = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstm, conn);
        }
        return flag != 0;
    }

    public int returnTheGoods_count(String txt_name, String goods_name) {
        try {
            conn = JDBCUtils.getConnnection();
            String sql = "select goods_count from shop_car where txt_name ='" + txt_name + "' and goods_name = '" + goods_name + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("goods_count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return 0;
    }

    public boolean deleteTheRow(String txt_name, String goods_name) {
        int flag = 0;
        try {
            conn = JDBCUtils.getConnnection();
            String sql = "delete from shop_car where txt_name = ? and goods_name = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, txt_name);
            pstm.setString(2, goods_name);
            flag = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstm, conn);
        }
        return flag != 0;
    }

    public boolean theGoods_countMinusOne(String txt_name, String goods_name) {
        int flag = 0;
        try {
            conn = JDBCUtils.getConnnection();
            String sql = "update shop_car set goods_count=goods_count-1 where txt_name = ? and goods_name = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, txt_name);
            pstm.setString(2, goods_name);
            flag = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstm, conn);
        }
        return flag != 0;
    }

    public boolean deleteAllRow(String txt_name) {
        int flag = 0;
        try {
            conn = JDBCUtils.getConnnection();
            String sql = "delete from shop_car where txt_name = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, txt_name);
            flag = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstm, conn);
        }
        return flag != 0;
    }

    public ArrayList returnBuyList(String txt_name) {
        ArrayList<GoodsSingle> goodsList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnnection();
            String sql = "select goods_single.name, goods_single.price, shop_car.goods_count from shop_car, goods_single where shop_car.goods_name=goods_single.name and txt_name ='" + txt_name + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                goodsList.add(new GoodsSingle(rs.getString("name"), rs.getFloat("price"), rs.getInt("goods_count")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return goodsList;
    }
}
