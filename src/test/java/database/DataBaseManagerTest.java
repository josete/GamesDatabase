/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Familia
 */
public class DataBaseManagerTest {
    
    @Before
    public void before(){
        DataBaseManager manager = new DataBaseManager("test.s3db");
        manager.clearDatabase();
    }
    
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
        manager.clearDatabase();
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
        manager.clearDatabase();
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
        manager.clearDatabase();
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
        manager.clearDatabase();
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
        manager.clearDatabase();
        try {
            manager.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void checkOrderAlphabetical(){
        DataBaseManager manager = new DataBaseManager("test.s3db");
        manager.insertGame("Skyrim","Bethesda","Rol","PC","Steam");
        manager.insertGame("Akyrim","Bethesda","Accion","PC","Steam");
        manager.insertGame("Jkyrim","Bethesda","Aventuras","PC","Steam");
        manager.insertGame("Ckyrim","Bethesda","Rol","PC","Steam");
        ArrayList<Game> list = manager.getAllGames();
        assertEquals("Akyrim", list.get(0).getTitle());
        manager.clearDatabase();
        try {
            manager.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void sortGamesByGenre(){
        DataBaseManager manager = new DataBaseManager("test.s3db");
        manager.insertGame("Skyrim","Bethesda","Rol","PC","Steam");
        manager.insertGame("Skyrim1","Bethesda","Accion","PC","Steam");
        manager.insertGame("Skyrim2","Bethesda","Aventuras","PC","Steam");
        manager.insertGame("Skyrim3","Bethesda","Rol","PC","Steam");
        int gamesNumber = manager.getGamesByGenre("Rol").size();
        assertEquals(2, gamesNumber);
        manager.clearDatabase();
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
