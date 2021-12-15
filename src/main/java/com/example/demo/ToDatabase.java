package com.example.demo;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToDatabase {
    public static void toDataBase(List<JDItem> jdItemList) throws SQLException {
        Driver dr = new Driver();
        DriverManager.registerDriver(dr);
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","12345678");
        if(con.isValid(30000)){
            System.out.println("Database connected successfully");
        }
        else{
            System.out.println("Database connection is failure.....");
        }
    }

    public static void main(String[] args) {
        List<JDItem> jd = new ArrayList<>();
        jd.add(new JDItem("1",1.0,"1"));
        try{
            ToDatabase.toDataBase(jd);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
