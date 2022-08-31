package json.homework1.DAO;

import json.homework1.Bean.User;
import json.homework1.Utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author JJChen
 * @version 1.0
 */
public class BasicDAO<T> {
    private QueryRunner qr;

    public BasicDAO() {
        qr = new QueryRunner();
    }
    public T getSingle(String sql,  Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = DruidUtils.getConnection();
            return qr.query(connection, sql, new BeanHandler<>(clazz), parameters);
        } catch (SQLException e) {
            System.out.println("cuole");
            throw new RuntimeException(e);
        } finally {
            DruidUtils.close(null, null, connection);
        }

    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getSingle("select * from user where id=?", User.class, "1");
        System.out.println(user);
    }
}
