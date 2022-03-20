package servlet;

import dao.StudentDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
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
        String username = req.getParameter("user");
        String pwd = req.getParameter("password");
        //连接数据库
        StudentDao studentDao = new StudentDao();
        User login = studentDao.login();
        System.out.println(login.getPassword());
        //给出响应
        if(login==null){
            req.setAttribute("mess","用户不存在！");
            req.getRequestDispatcher("login.html").forward(req,resp);

        }else{
            if (login.getPassword().equals(pwd)){
                System.out.println("登录成功！");
                //把登录的信息保存道session中
                req.getSession().setAttribute("user",login);
                //响应重定位道另一个查询所有的servlet中
                resp.sendRedirect("selectAll");
            }else {
                req.setAttribute("mess","密码有误！");
                req.getRequestDispatcher("login.html").forward(req,resp);
            }
        }


    }
}
