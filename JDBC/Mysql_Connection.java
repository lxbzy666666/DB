package JDBC;
import JDBC.Connection.JDBC_init;

import java.sql.Connection;
public class Mysql_Connection extends JDBC_init {
    public  Mysql_Connection(String p){
        super(p);
    }
    public Connection getConnection() {
        return connection;
    }
}
