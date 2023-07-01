package com.cupk;

import com.cupk.pojo.Userdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

/**
 * 名称:Database
 * 描述:
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-07-01 23:18
 */
@Service
public class Database {
    @Autowired(required = false)
    private Userdata userdata;

    Connection connection = null;
    public Database(@Value("root") String name, @Value("Cup123Cup123") String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://rm-cn-zxu3a3njq0001fco.rwlb.rds.aliyuncs.com:3306/zhongguocai?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai","root","Cup123Cup123");
    }
    public void showConnect(){
        System.out.println(this.connection);
    }
    public void insert(String userId,String userName,String userPwd) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("INSERT INTO root_user values (?, ?, ?)");
        prep.setString(1,userId);
        prep.setString(2,userName);
        prep.setString(3,userPwd);
        prep.executeUpdate();
    }
    public void delete(String userId) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("delete from root_user where id=?");
        prep.setString(1,userId);
        prep.executeUpdate();

    }
    public Userdata getUser(String userId) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("select * from root_user where id=?");
        prep.setString(1,userId);
        prep.executeQuery();
        ResultSet resultSet = prep.getResultSet();
        if(resultSet.next()){
            String name = resultSet.getString("name");
            String id = resultSet.getString("id");
            String password = resultSet.getString("password");
            return new Userdata(id,name,password);
        }
        else return null;
    }
    public ArrayList<Userdata> getAllUser() throws SQLException {
        ArrayList<Userdata> userList = new ArrayList<Userdata>();
        PreparedStatement prep = connection.prepareStatement("select * from root_user");
        prep.executeQuery();
        ResultSet resultSet = prep.getResultSet();
        while(resultSet.next()){
            String name = resultSet.getString("name");
            String id = resultSet.getString("id");
            String password = resultSet.getString("password");
            userList.add(new Userdata(id,name,password));
        }
        return userList;
    }
    public void close() throws SQLException {
        connection.close();
    }
    public Userdata check(String name,String password) throws SQLException {
        PreparedStatement prep = connection.prepareStatement("select * from root_user where name=?");
        prep.setString(1,name);
        prep.executeQuery();
        ResultSet resultSet = prep.getResultSet();
        if(resultSet.next()){
            String pwd = resultSet.getString("password");
            if(password.equals(pwd)){
                String id = resultSet.getString("id");
                return new Userdata(id, name, password);
            }else return null;
        }
        else return null;
    }

}
