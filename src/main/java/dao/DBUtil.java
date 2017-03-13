package dao;

import common.ShopException;
import rowParser.RowParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库操作工具类
 */
public class DBUtil {
    private static final String            jdbcUrl     = "jdbc:mysql://localhost:3306/bookstore";
    private static final String            user        = "root";
    private static final String            passwd      = "root";
    private static Map<Thread, Connection> connections = new HashMap<Thread, Connection>();
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = connections.get(Thread.currentThread());
        if (conn == null) {
            conn = DriverManager.getConnection(jdbcUrl, user, passwd);
            System.out.println("open connection:" + conn.hashCode());
            conn.setAutoCommit(false);
            connections.put(Thread.currentThread(), conn);
        }
        return conn;
    }

    public static void closeConnection() {
        Connection conn = connections.get(Thread.currentThread());
        if (conn != null) {
            try {
                conn.close();
                connections.remove(Thread.currentThread());
                System.out.println("close connection: " + conn.hashCode());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void update(String sql, Object... param) {
        try {
            PreparedStatement stmt = createStatement(sql, param);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ShopException("更新数据出错");
        }
    }

    public static List query(String sql, RowParser parser, Object... param) {
        List list = new ArrayList();
        try {
            PreparedStatement stmt = createStatement(sql, param);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object obj = parser.parseRow(rs);
                list.add(obj);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ShopException("查询数据出错");
        }
        return list;
    }

    public static Object unique(String sql, RowParser parser, Object... param) {
        Object obj = null;
        try {
            PreparedStatement stmt = createStatement(sql, param);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                obj = parser.parseRow(rs);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ShopException("查询数据出错");
        }
        return obj;
    }

    public static int updateWithAutoGen(String sql, Object... param) {
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < param.length; i++) {
                stmt.setObject(i + 1, param[i]);
            }
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            rs.close();
            stmt.close();
            return key;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ShopException("更新数据出错");
        }
    }

    private static PreparedStatement createStatement(String sql, Object... param) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        for (int i = 0; i < param.length; i++) {
            stmt.setObject(i + 1, param[i]);
        }
        return stmt;
    }

    public static void commit() {
        Connection conn = connections.get(Thread.currentThread());
        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ShopException("提交失败");
            }
        }
    }

    public static void rollback() {
        Connection conn = connections.get(Thread.currentThread());
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
            }
        }
    }
}
