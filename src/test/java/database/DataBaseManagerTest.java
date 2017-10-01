/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Familia
 */
public class DataBaseManagerTest {
    
    @Test
    public void connectionTest(){
        DataBaseManager manager = new DataBaseManager("test.s3db");
        assertNotNull(manager.conn);
        try {
            manager.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void insertDeveloper(){
        DataBaseManager manager = new DataBaseManager("test.s3db");
        int id = manager.insertDeveloper("EA");
        assertEquals("EA", manager.getDeveloperById(id));
        try {
            manager.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void insertFormat(){
        DataBaseManager manager = new DataBaseManager("test.s3db");
        int id = manager.insertFormat("CD");
        assertEquals("CD", manager.getFormatById(id));
        try {
            manager.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void insertPlatform(){
        DataBaseManager manager = new DataBaseManager("test.s3db");
        int id = manager.insertPlatform("PC");
        assertEquals("PC", manager.getPlatformById(id));
        try {
            manager.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void insertGenre(){
        DataBaseManager manager = new DataBaseManager("test.s3db");
        int id = manager.insertGenre("Shooter");
        assertEquals("Shooter", manager.getGenreById(id));
        try {
            manager.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void insertGame(){
        DataBaseManager manager = new DataBaseManager("test.s3db");
        int id = manager.insertGame("Skyrim","Bethesda","Rol","PC","Steam");
        assertEquals("Skyrim", manager.getGameNameById(id));
        try {
            manager.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass 
    public static void remove(){
        DataBaseManager manager = new DataBaseManager("test.s3db");
        manager.clearDatabase();
    }
    
}
