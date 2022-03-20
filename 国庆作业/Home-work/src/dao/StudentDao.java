package dao;


import entity.Student;
import entity.User;
import uitl.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public User login(){
        String sql = "select * from user";
        Object object[] = {};
        ResultSet resultSet = JDBC.query(sql, object);
        User user = new User();
        while (true){
            try {
                if (!resultSet.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                user = new User(resultSet.getLong("id"),resultSet.getString("username"),resultSet.getString("password"));


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        JDBC.close();
        return user;
    }
    // 添加
    public int addStudent(Student student){
        String sql = "insert into student values(null,?,?,?,?,?,?)";
        Object object[] = { student.getName(),student.getSex(),student.getAge(),student.getAddress(),
                student.getQq(),student.getEmail()
        };
        return JDBC.update(sql,object);
    }
    // 查询
    public List<Student> selectAll(){
        String sql = "select * from student ";
        Object object[] = {};
        ResultSet query = JDBC.query(sql, object);
        List<Student> list = new ArrayList<>();
        try {
            while (query.next()){
                Student student = new Student( query.getLong(1), query.getString(2), query.getString(3), query.getLong(4), query.getString(5), query.getString(6), query.getString(7));
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.close();
        }
        return list;
    }
    public int delStudent(long id){
        String sql = "delete from student where id=?";
        Object object[] = {id};
        return JDBC.update(sql,object);
    }
    public Student selectById(long id){
        String sql = "select * from student where id=?";
        Object object[] = {id};
        ResultSet query = JDBC.query(sql, object);
        Student student = null;
        try {
            if(query.next()){
                student = new Student( query.getLong(1), query.getString(2), query.getString(3), query.getLong(4), query.getString(5), query.getString(6),
            query.getString(7));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBC.close();
        }
        return student;
    }

//根据id进行数据修改
    public int update(Student student){
        String sql = "update student set sex=?,age=?,address=?,qq=?,email=? where id=?";
        Object object[] = { student.getSex(), student.getAge(), student.getAddress(), student.getQq(),student.getEmail(),student.getId() };
        return JDBC.update(sql,object);
    }
}
