/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Familia
 */
public class SteamGame {
    SimpleStringProperty name;
    long id;
    SimpleStringProperty genre;
    SimpleStringProperty platform;
    SimpleStringProperty format;

    public SteamGame(String name, long id) {
        this.name = new SimpleStringProperty(name);
        this.id = id;
        platform = new SimpleStringProperty("PC");
        format = new SimpleStringProperty("Steam");
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public String getPlatform() {
        return platform.get();
    }

    public void setPlatform(String platform) {
        this.platform.set(platform);
    }

    public String getFormat() {
        return format.get();
    }

    public void setFormat(String format) {
        this.format.set(format);
    }
    
    
    
    
}
