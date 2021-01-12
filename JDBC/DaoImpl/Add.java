package JDBC.DaoImpl;

import JDBC.Mysql_Connection;
import JDBC.POJO.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Random;
import java.util.UUID;

/*
* 增加用户
* */
public class Add implements JDBC.Dao.Add {
/*
* 增加一个用户
* */
    @Override
    public User AddOne() {
        User user = new User();
        user.setUUID(UUID.randomUUID().toString().trim().replace("-", ""));
        user.setName("Default");
        user.setPassword(new Random().nextInt(100001));
        Connection connection=null; //数据库连接对象
        java.sql.Statement statement=null; //操作数据库的Statement
        ResultSet resultSet=null;          //结果集
        try {
            connection = new Mysql_Connection("JDBC_Connection_Property.properties").getConnection();
            statement=connection.createStatement();
            String sql="insert into jdbc(UUID,Name,Password) values('"+user.getUUID()+"','"+user.getName()+"',"+user.getPassword()+")";
            //执行查询语句
            int executeUpdate = statement.executeUpdate(sql);
            System.out.println(executeUpdate==1?"插入成功":"插入失败");
           /* while (resultSet.next()){
                System.out.println("姓名:"+resultSet.getString(1)+"  编号："+resultSet.getString(2)+
                        "  专业："+resultSet.getString(3));
            }*/

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
                connection.close();
            }catch (Exception e){
                System.out.println("资源未关闭");
            }



        }
        return user;
    }
/*
* 增加多个用户
* */
    @Override
    public User AddALL() {
        return null;
    }
}
