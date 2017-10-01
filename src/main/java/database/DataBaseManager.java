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
import java.util.ArrayList;
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
    
    public ArrayList<String> getAllDevelopers(){
        ArrayList<String> developers = new ArrayList<>();
        try {
            String sql = "select name from Developer";
            Statement consulta = conn.createStatement();
            ResultSet r = consulta.executeQuery(sql);
            while(r.next()){
                developers.add(r.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return developers;
    }
    
    public ArrayList<String> getAllGenres(){
        ArrayList<String> genres = new ArrayList<>();
        try {
            String sql = "select name from Genre";
            Statement consulta = conn.createStatement();
            ResultSet r = consulta.executeQuery(sql);
            while(r.next()){
                genres.add(r.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return genres;
    }
    
    public ArrayList<String> getAllPlatforms(){
        ArrayList<String> platforms = new ArrayList<>();
        try {
            String sql = "select name from Platform";
            Statement consulta = conn.createStatement();
            ResultSet r = consulta.executeQuery(sql);
            while(r.next()){
                platforms.add(r.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return platforms;
    }
    
    public ArrayList<String> getAllFormats(){
        ArrayList<String> formats = new ArrayList<>();
        try {
            String sql = "select name from Format";
            Statement consulta = conn.createStatement();
            ResultSet r = consulta.executeQuery(sql);
            while(r.next()){
                formats.add(r.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formats;
    }
    
    public ArrayList<Game> getAllGames(){
        ArrayList<Game> games = new ArrayList<>();
        try {
            String sql = "select * from Game";
            Statement consulta = conn.createStatement();
            ResultSet r = consulta.executeQuery(sql);
            while(r.next()){
                games.add(new Game(r.getString(2),r.getString(3), r.getString(4), r.getString(5), r.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return games;
    }

    public ArrayList<Game> getGamesByGenre(String genre) {
        ArrayList<Game> games = new ArrayList<>();
        try {
            String sql = "select * from Game where genre='"+genre+"'";
            Statement consulta = conn.createStatement();
            ResultSet r = consulta.executeQuery(sql);
            while(r.next()){
                games.add(new Game(r.getString(2),r.getString(3), r.getString(4), r.getString(5), r.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return games;
    }
    
    void clearDatabase() {
        try {
            String sql = "delete from Developer";
            Statement consulta = conn.createStatement();
            consulta.execute(sql);
            sql = "delete from Genre";
            consulta.execute(sql);
            sql = "delete from Platform";
            consulta.execute(sql);
            sql = "delete from Format";
            consulta.execute(sql);
            sql = "delete from Game";
            consulta.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
