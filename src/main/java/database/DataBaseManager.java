/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Familia
 */
public class DataBaseManager {
    
    Connection conn;
    String databaseName;
    
    public DataBaseManager(String name) {
        this.databaseName = name;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + databaseName);
        } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int insertDeveloper(String name){
        int id = 0;
        try {
            String sql = "insert into Developer (name) values ('"+name+"')";
            Statement consulta = conn.createStatement();
            consulta.execute(sql);
            sql = "SELECT last_insert_rowid()";
            ResultSet r = consulta.executeQuery(sql);
            id = r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public String getDeveloperById(int id){
        String name = null;
        try {
            String sql = "select name from Developer where id = "+id;
            Statement consulta = conn.createStatement();
            ResultSet r = consulta.executeQuery(sql);
            name = r.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    
    public int insertFormat(String name){
        int id = 0;
        try {
            String sql = "insert into Format (name) values ('"+name+"')";
            Statement consulta = conn.createStatement();
            consulta.execute(sql);
            sql = "SELECT last_insert_rowid()";
            ResultSet r = consulta.executeQuery(sql);
            id = r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public String getFormatById(int id){
        String name = null;
        try {
            String sql = "select name from Format where id = "+id;
            Statement consulta = conn.createStatement();
            ResultSet r = consulta.executeQuery(sql);
            name = r.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    
    public int insertPlatform(String name){
        int id = 0;
        try {
            String sql = "insert into Platform (name) values ('"+name+"')";
            Statement consulta = conn.createStatement();
            consulta.execute(sql);
            sql = "SELECT last_insert_rowid()";
            ResultSet r = consulta.executeQuery(sql);
            id = r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public String getPlatformById(int id){
        String name = null;
        try {
            String sql = "select name from Platform where id = "+id;
            Statement consulta = conn.createStatement();
            ResultSet r = consulta.executeQuery(sql);
            name = r.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    
    public int insertGenre(String name){
        int id = 0;
        try {
            String sql = "insert into Genre (name) values ('"+name+"')";
            Statement consulta = conn.createStatement();
            consulta.execute(sql);
            sql = "SELECT last_insert_rowid()";
            ResultSet r = consulta.executeQuery(sql);
            id = r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public String getGenreById(int id){
        String name = null;
        try {
            String sql = "select name from Genre where id = "+id;
            Statement consulta = conn.createStatement();
            ResultSet r = consulta.executeQuery(sql);
            name = r.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

    public int insertGame(String title, String developer, String genre, String platform, String format) {
         int id = 0;
        try {
            String sql = "insert into Game (title,developer,genre,platform,format) values ('"+title+"','"+developer+"'"
                    + ",'"+genre+"','"+platform+"','"+format+"')";
            Statement consulta = conn.createStatement();
            consulta.execute(sql);
            sql = "SELECT last_insert_rowid()";
            ResultSet r = consulta.executeQuery(sql);
            id = r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public String getGameNameById(int id){
        String name = null;
        try {
            String sql = "select title from Game where id = "+id;
            Statement consulta = conn.createStatement();
            ResultSet r = consulta.executeQuery(sql);
            name = r.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    
}
