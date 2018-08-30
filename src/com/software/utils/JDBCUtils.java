package com.software.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;


public class JDBCUtils {
    public static Connection getConnnection() throws Exception {
        ComboPooledDataSource source = new ComboPooledDataSource();
        Connection conn = source.getConnection();
        return conn;
    }
    public static void release(Statement stmt, Connection conn){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                stmt = null;
            }
        }
        if (conn!= null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                conn= null;
            }
        }
    }
    public static void release(PreparedStatement pstm, Connection conn){
        if (pstm != null){
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                pstm = null;
            }
        }
        if (conn!= null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                conn= null;
            }
        }
    }
    public static void release(ResultSet rs, Statement stmt, Connection conn){
        if (rs!= null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                rs= null;
            }
        }
        release(stmt, conn);
    }
    public static void release(ResultSet rs, PreparedStatement pstm, Connection conn){
        if (rs!= null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                rs= null;
            }
        }
        release(pstm, conn);
    }
    public static void release(ResultSet rs,Statement stmt, PreparedStatement pstm, Connection conn){
        if (stmt!= null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                stmt= null;
            }
        }
        release(rs, pstm, conn);
    }
}

