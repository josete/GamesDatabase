/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author Familia
 */
public class ReadSteamFolder {

    String steamLocation;
    public File configFile;

    public ReadSteamFolder(String steamLocation) {
        this.steamLocation = steamLocation;
    }

    public void getConfigFile() {
        //Take the first user in steam folder
        File folder = new File(steamLocation + "/userdata");
        String[] directories = folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
            }
        });
        folder = new File(steamLocation + "\\userdata" + "\\" + directories[directories.length - 1] + "\\7\\remote");
        File[] files = folder.listFiles();
        configFile = files[1];
    }

    public String getVdfText() {
        String text = null;
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(configFile.getAbsolutePath()));
            text = new String(encoded, Charset.defaultCharset());
            
        } catch (IOException ex) {
            Logger.getLogger(ReadSteamFolder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return text;
    }

    public JSONObject getApps(JSONObject json) {
        JSONObject apps = null;
        JSONObject UserLocalConfigStore = (JSONObject) json.get("UserLocalConfigStore");
        JSONObject Software = (JSONObject) UserLocalConfigStore.get("Software");
        JSONObject Valve = (JSONObject) Software.get("Valve");
        JSONObject Steam = (JSONObject) Valve.get("Steam");
        apps = (JSONObject) Steam.get("apps");
        return apps;
    }

}
