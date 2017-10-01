/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
}
