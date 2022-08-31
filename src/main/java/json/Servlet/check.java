package json.Servlet; /**
 * @author JJChen
 * @version 1.0
 */

import com.google.gson.Gson;
import json.Bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class check extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Gson gson = new Gson();
        response.setContentType("text/html;charset=utf-8");
        if(username.equals("king")){
            User king = new User(100, "king", "666", "king@sohu.com");
            String s = gson.toJson(king);
            PrintWriter writer = response.getWriter();
            writer.write(s);
        }else{
            response.getWriter().write("");
        }
    }
}
