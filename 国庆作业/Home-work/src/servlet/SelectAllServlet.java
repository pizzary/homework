package servlet;

import dao.StudentDao;
import entity.Student;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码方式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;Charset=UTF-8");
        //接收请求
        //连接数据库
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.selectAll();
        //给出响应
        req.setAttribute("list",students);
        req.getRequestDispatcher("list.jsp").forward(req,resp);


    }
}
