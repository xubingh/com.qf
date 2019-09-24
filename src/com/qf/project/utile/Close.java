package com.qf.project.utile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Close {
    /**
     *Connection : 连接
     * Statement : 声明
     * Resultset : 结果集
     */
    public static void close(Connection conn, Statement sta, ResultSet rs){
        try {
            if (conn !=null){conn.close();}
            if (sta!=null){sta.close();}
            if (rs!=null){rs.close();}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
