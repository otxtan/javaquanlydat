/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author otxtan
 */
public class connectsqlsv {
    static public Connection connectsql() throws SQLException
    {
        String url= "jdbc:sqlserver://OTXTAN\\SQLEXPRESS.database.windows.net:1433;"
                        + "database=QLBDS1;"
                        + "user=sa;"
                        + "password=sa;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
        Connection con=DriverManager.getConnection(url);
        return con;
    }
    public static void main(String[] args) {
        
        
    }
}