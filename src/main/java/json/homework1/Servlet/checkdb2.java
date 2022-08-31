package json.homework1.Servlet;
/**
 * @author JJChen
 * @version 1.0
 */

import com.google.gson.Gson;
import json.homework1.Bean.User;
import json.homework1.Service.GetInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "checkdb2", value = "/checkdb2")
public class checkdb2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        User user = GetInfo.getInfo(username);
        // 注意改这里的json
        response.setContentType("text/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(user == null){
            User user1 = new User(-1, "", "", "");
            Gson gson = new Gson();
            String s = gson.toJson(user1);
            writer.write(s);
        }else{
            Gson gson = new Gson();
            String s = gson.toJson(user);
            writer.write(s);
        }
        writer.flush();
        writer.close();
    }

}
