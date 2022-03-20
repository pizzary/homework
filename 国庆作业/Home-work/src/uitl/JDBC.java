package uitl;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDBC {
    // 1，定义静态的私有的属性来保存全局的变量
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/shiyi?serverTimezone=UTC&useSSL=false";
    private static String username = "root";
    private static String password = "root";
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    // 2,编写一个静态的代码块来实现加载驱动
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 3,编写一个静态的方法来实现统一的链接数据库
    public static void getConnection(){
        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // 4,编写一个静态的方法来实现释放资源
    public static void close(){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // 5,编写一个方法来实现增加 删除 修改  功能
    public static int update(String sql,Object object[]){
        getConnection();
        int num = 0;  // 影响的行数
        try {
            statement = connection.prepareStatement(sql);
            // 数据注入
            if(object!=null){
                for(int i=0;i<object.length;i++){
                    statement.setObject(i+1,object[i]);
                }
            }
            //执行sql语句
            num = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return num;
    }

    // 6,编写一个专门用来实现查询的功能方法 [不能释放资源]
    public static ResultSet query(String sql, Object object[]){
        getConnection();
        try {
            statement = connection.prepareStatement(sql);
            // 数据注入
            if(object!=null){
                for(int i=0;i<object.length;i++){
                    statement.setObject(i+1,object[i]);
                }
            }
            // 执行sql
            resultSet = statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
    //日期格式
    public static Date toDate(String str){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    // 传入一个日期，把日期格式化返回一个字符串
    public static String toString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = sdf.format(date);
        return str;
    }



}
