package JDBC.Connection;

import JDBC.Connection.JDBC_getConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

public abstract  class JDBC_init implements JDBC_getConnection {
    protected   static  String  driver=null;
    protected static  String  url=null;
    protected static  String  name=null;
    protected static  String  password=null;
    protected static  java.sql.Connection connection=null;
    public   static  String path=null;
    protected JDBC_init(String path2){
        path=path2;
        if(path!=null)
        JDBC_Connection(path);
        else
            System.out.println("设置配置路径");
    }
    /*
    * 根据配置文件路径获取Connection连接
    * */
    protected   java.sql.Connection JDBC_Connection(String path){
         InputStream in=null;
         try {
             in=ClassLoader.getSystemResourceAsStream(path);
             java.util.Properties p = new Properties();
             p.load(in);
             driver= p.getProperty("JDBC.driver");
             url=p.getProperty("JDBC.url");
             name=p.getProperty("JDBC.name");
             password=p.getProperty("JDBC.password");
             //1.加载数据库驱动
             Class.forName(driver);
             //2.建立连接
             connection= DriverManager.getConnection(url, name, password);
         }catch (Exception e){
             System.out.println("找不到对应MySQL连接配置文件"+path);
         }finally {
             if(in!=null) {
                 try {
                     in.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
         return connection;
    }
}
