package json.homework1.Servlet;
/**
 * @author JJChen
 * @version 1.0
 */

import com.google.gson.Gson;

import json.homework1.Bean.User;
import json.homework1.DAO.UserDAO;
import json.homework1.Service.GetInfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "checkdb", value = "/checkdb")
public class checkdb extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        User user = GetInfo.getInfo(username);
        System.out.println("1111");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(user == null){
            writer.write("");
        }else{
            Gson gson = new Gson();
            String s = gson.toJson(user);
            writer.write(s);
        }
        writer.flush();
        writer.close();
    }

}
