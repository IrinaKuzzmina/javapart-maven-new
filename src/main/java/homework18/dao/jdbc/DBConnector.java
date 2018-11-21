package homework18.dao.jdbc;

import homework16.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public  class DBConnector {
    public static Connection connectToDB() {
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(PropertyReader.readProperty("jdbc.url"));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
