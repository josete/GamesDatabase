/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
        DataBaseManager manager = new DataBaseManager("databaseTest.db");
        assertNotNull(manager.conn);
    }
    
}
