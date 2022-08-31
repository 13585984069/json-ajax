package json.homework1.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Stack;

/**
 * @author JJChen
 * @version 1.0
 */
public class DruidUtils {
    private static DataSource ds;

    static {
        Properties properties = new Properties();
        try {
            // 因为是javaweb所以要用类加载器!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            properties.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.out.println("cuole");
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void close(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Connection connection = DruidUtils.getConnection();
        System.out.println(connection == null);
    }
}
