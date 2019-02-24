/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author crisantru
 */
public class ConexionBD {
    
    private Connection conn;
    private String host;
    private String db;
    private String username;
    private String password;
    
    private static ConexionBD connect;
    
    public ConexionBD(String host, int port, String db, String username, String password) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://" + host + ":"+port+"/" + db;
        this.host = host;
        this.db = db;
        this.username = username;
        this.password = password;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connect = this;
    }
    
    public Connection connection() {
        try {
            return getConn();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public Statement query(String sQuery) throws SQLException {
        Statement s = getConn().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        s.executeQuery(sQuery);
        return s;
    }

    public Statement update(String sQuery) throws SQLException {
        Statement s = getConn().createStatement();
        s.executeUpdate(sQuery);
        return s;
    }

    public void close(Statement s) {
        try {
            s.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        }
    }

    public void close() {
        try {
            if(getConn()!=null){
                getConn().close();   
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
        }
    }

    public static ConexionBD getConnect() {
        return connect;
    }

    public static void setConnect(ConexionBD connect) {
        ConexionBD.connect = connect;
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the db
     */
    public String getDb() {
        return db;
    }

    /**
     * @param db the db to set
     */
    public void setDb(String db) {
        this.db = db;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}