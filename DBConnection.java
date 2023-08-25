package com.example.ecommerce;
import java.sql.*;

public class DBConnection {
    private static final String dburl ="jdbc:mysql://localhost:3306/ecommerce";
    private static final String username = "root";
    private static final String password ="admin123";

    private Statement getStatement(){
        try{
            Connection connection = DriverManager.getConnection(dburl,username,password);
            return connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet getQueryTable(String query){
        try{
            Statement statement = getStatement();
            return statement.executeQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DBConnection conn = new DBConnection();
        ResultSet rs = conn.getQueryTable("SELECT * From customer");
        if(rs!=null){
            System.out.println("Connection Successful");
        }
        else{
            System.out.println("Connection failed.");
        }
    }
}
