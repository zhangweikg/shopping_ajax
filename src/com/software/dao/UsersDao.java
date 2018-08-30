package com.software.dao;

import com.software.utils.JDBCUtils;
import com.software.domain.UserLogInfo;
import com.software.domain.UserRegisterInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class UsersDao {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	Statement stmt = null;

    /**
     * @function 在 user_info 表中查找满足 txt_name 与 pwd 的行，若存在返回 true，否则返回 false。
     *     实现上层的登录功能。
     * @param user 存储用户账号密码。
     * @return 存在返回 true，否则返回 false。
     */
	public boolean findByNameAndPwd(UserLogInfo user) {
		try {
			conn = JDBCUtils.getConnnection();
			String sql = "select * from user_info where txt_name=? and pwd=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getTxt_name());
			pstm.setString(2, user.getPwd());
			rs = pstm.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(rs, pstm, conn);
		}
		return false;
	}


    public boolean findByName(String txt_name) {
        try {
            conn = JDBCUtils.getConnnection();
            String sql = "select * from user_info where txt_name=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, txt_name);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstm, conn);
        }
        return false;
    }
    /**
     * @function 添加一行 user_info 表属性来存储用户的个人信息，同时添加一行 habby 属性来存储用户的多个爱好。
     *     实现上层的注册功能。
     * @param userRegisterInfo 存储用户个人信息。
     * @return 成功写入两个表后返回 true，否则返回 false。
     */
	public boolean add(UserRegisterInfo userRegisterInfo) {
	    int flag1 = 0;
        try {
            conn = JDBCUtils.getConnnection();
            String sql1 = "insert into user_info(txt_name, pwd, email, tel, sex, age, xueli, jianli, ID) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstm = conn.prepareStatement(sql1);
			pstm.setString(1, userRegisterInfo.getTxt_name());
			pstm.setString(2, userRegisterInfo.getPwd());
			pstm.setString(3, userRegisterInfo.getEmail());
			pstm.setString(4, userRegisterInfo.getTel());
			pstm.setString(5, userRegisterInfo.getSex());
			pstm.setString(6, userRegisterInfo.getAge());
			pstm.setString(7, userRegisterInfo.getXueli());
			pstm.setString(8, userRegisterInfo.getJianli());
			pstm.setString(9, userRegisterInfo.getID());
			flag1 = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstm, conn);
        }
        int flag2 = 1, flag = 0;
        for (int i = 0; i<userRegisterInfo.getHabby().length; i++){
            try {
                conn = JDBCUtils.getConnnection();
                String sql2 = "insert into habby(txt_name, habby)values(?, ?)";
                pstm = conn.prepareStatement(sql2);
                pstm.setString(1, userRegisterInfo.getTxt_name());
                pstm.setString(2, userRegisterInfo.getHabby()[i]);
                flag = pstm.executeUpdate();
                if (flag == 0){
                    flag1 = 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.release(pstm, conn);
            }
        }
        return flag1 != 0 && flag2 != 0;
	}

    public UserRegisterInfo returnUserInfo(String txt_name) {
	    UserRegisterInfo userRegisterInfo = new UserRegisterInfo();
        try {
            conn = JDBCUtils.getConnnection();
            String sql1 = "select * from user_info where txt_name=?";
            PreparedStatement pstm = conn.prepareStatement(sql1);
            pstm.setString(1, txt_name);
            rs = pstm.executeQuery();
            if (rs.next()) {
                userRegisterInfo.setTxt_name(rs.getString("txt_name"));
                userRegisterInfo.setPwd(rs.getString("pwd"));
                userRegisterInfo.setEmail(rs.getString("email"));
                userRegisterInfo.setTel(rs.getString("tel"));
                userRegisterInfo.setSex(rs.getString("sex"));
                userRegisterInfo.setAge(rs.getString("age"));
                userRegisterInfo.setXueli(rs.getString("xueli"));
                userRegisterInfo.setJianli(rs.getString("jianli"));
                userRegisterInfo.setID(rs.getString("ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstm, conn);
        }

        try {
            ArrayList<String> ha = new ArrayList<>();
            conn = JDBCUtils.getConnnection();
            String sql1 = "select * from habby where txt_name=?";
            PreparedStatement pstm = conn.prepareStatement(sql1);
            pstm.setString(1, txt_name);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ha.add(rs.getString("habby"));
            }
            String[] habby = new String[ha.size()];
            for (int i=0;i<ha.size();i++){
                habby[i] = ha.get(i);
            }
            userRegisterInfo.setHabby(habby);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pstm, conn);
        }
        return userRegisterInfo;

    }
}
