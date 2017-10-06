/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import org.json.simple.JSONObject;
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
public class ReadSteamFolderTest {
    
    @Test
    public void getFileTest(){
        ReadSteamFolder steam = new ReadSteamFolder("E:\\Steam");
        steam.getConfigFile();
        assertEquals("sharedconfig.vdf", steam.configFile.getName());
    }
    
    @Test
    public void getVdfTest(){
        ReadSteamFolder steam = new ReadSteamFolder("E:\\Steam");
        steam.getConfigFile();
        assertNotNull(steam.getVdfText());
    }
    
    @Test
    public void getJsonTest(){
        ReadSteamFolder steam = new ReadSteamFolder("E:\\Steam");
        steam.getConfigFile();
        VdfAndJsonUtils v = new VdfAndJsonUtils();
        assertNotNull(v.getJson(steam.getVdfText()));
    }
    
    @Test
    public void convertToJsonTest(){
        ReadSteamFolder steam = new ReadSteamFolder("E:\\Steam");
        steam.getConfigFile();
        VdfAndJsonUtils v = new VdfAndJsonUtils();
        assertNotNull(v.convertToJson(v.getJson(steam.getVdfText())));
    }
    
    @Test
    public void getAppsTest(){
        ReadSteamFolder steam = new ReadSteamFolder("E:\\Steam");
        steam.getConfigFile();
        VdfAndJsonUtils v = new VdfAndJsonUtils();
        assertNotNull(steam.getApps(v.convertToJson(v.getJson(steam.getVdfText()))));
    }
    
    @Test
    public void getAppsId(){
        ReadSteamFolder steam = new ReadSteamFolder("E:\\Steam");
        steam.getConfigFile();
        VdfAndJsonUtils v = new VdfAndJsonUtils();
        JSONObject apps = steam.getApps(v.convertToJson(v.getJson(steam.getVdfText())));
        assertNotNull(v.getAppsIds(apps));
    }
    
    @Test
    public void getNamesTest(){
        ReadSteamFolder steam = new ReadSteamFolder("E:\\Steam");
        steam.getConfigFile();
        VdfAndJsonUtils v = new VdfAndJsonUtils();
        JSONObject apps = steam.getApps(v.convertToJson(v.getJson(steam.getVdfText())));
        assertNotNull(v.getGames(v.getAppsIds(apps)));
    }
    
}
