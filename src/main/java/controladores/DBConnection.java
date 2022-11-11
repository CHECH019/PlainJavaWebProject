package controladores;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DBConnection {
    private static Connection myDBConnection;
    
    private DBConnection(){}

    public static Connection getConnection(){
        if(myDBConnection == null){
            try {
                
                MysqlDataSource ds = new MysqlDataSource();
                ds.setServerName("localhost");
                ds.setPortNumber(3306);
                ds.setDatabaseName("banco");
                ds.setUser("root");
                ds.setPassword("root");
                ds.setUseSSL(false);
                ds.setAllowPublicKeyRetrieval(true);
                ds.setAutoReconnect(true);
                myDBConnection = ds.getConnection();
                System.out.println("Conexión exitosa");
            } catch (SQLException e) {
                System.out.println("Conexión fallida");
                e.printStackTrace();
            }

        }
        return myDBConnection;
    }
}
