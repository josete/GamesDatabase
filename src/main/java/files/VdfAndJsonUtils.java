package files;

import database.SteamGame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Familia
 */
public class VdfAndJsonUtils {

    ScriptEngine engine;

    public VdfAndJsonUtils() {
        engine = new ScriptEngineManager(null).getEngineByName("nashorn");
    }

    public String getJson(String vdfText) {
        String jsonText = null;
        try {
            final Compilable compilable = (Compilable) engine;
            final Invocable invocable = (Invocable) engine;
            String a = "load('./vdf.js'); function convert(vdf_text){data = VDF.parse(vdf_text);json = JSON.stringify(data);return json;}";
            final CompiledScript compiled = compilable.compile(a);
            compiled.eval();
            jsonText = invocable.invokeFunction("convert", vdfText).toString();
        } catch (ScriptException | NoSuchMethodException ex) {
            Logger.getLogger(VdfAndJsonUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonText;
    }

    public JSONObject convertToJson(String jsonText) {
        JSONParser parser = new JSONParser();
        JSONObject json = null;
        try {
            json = (JSONObject) parser.parse(jsonText);
        } catch (ParseException ex) {
            Logger.getLogger(VdfAndJsonUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public Set<String> getAppsIds(JSONObject apps) {
        return apps.keySet();
    }

    public ArrayList<SteamGame> getGames(Set keys) {
        ArrayList<SteamGame> games = new ArrayList<>();
        try {
            URL url = new URL("http://api.steampowered.com/ISteamApps/GetAppList/v0002/?format=json");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                out.append(line);
            }
            in.close();
            JSONObject json = convertToJson(out.toString());
            Iterator iter = keys.iterator();
            JSONObject applist = (JSONObject) json.get("applist");
            JSONArray apps = (JSONArray) applist.get("apps");

            while (iter.hasNext()) {
                long idIterator = Long.valueOf(iter.next().toString());
                for (int i = 0; i < apps.size(); i++) {
                    JSONObject j = (JSONObject) apps.get(i);
                    long id = (long) j.get("appid");
                    if (id == idIterator) {
                        games.add(new SteamGame((String) j.get("name"), idIterator));
                    }
                }
            }
            Comparator<SteamGame> comparator = new Comparator<SteamGame>() {
                @Override
                public int compare(SteamGame o1, SteamGame o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            };
            Collections.sort(games,comparator);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return games;
    }

}
