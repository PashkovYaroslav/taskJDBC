package com.epam.pashkov;

/**
 * Created by Yaroslav_Pashkov on 5/8/2015.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ConnectorDB {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        ResourceBundle resource= ResourceBundle.getBundle("database");
        String url= resource.getString("db.url");
        String user=resource.getString("db.user");
        String pass=resource.getString("db.password");
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url,user,pass);
    }

}
