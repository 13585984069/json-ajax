package json.homework1.Service;

import json.homework1.Bean.User;
import json.homework1.DAO.UserDAO;

/**
 * @author JJChen
 * @version 1.0
 */
public class GetInfo {
    public static User getInfo(String username){
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getSingle("select * from user where username=?", User.class, username);
        return user;
    }
}
