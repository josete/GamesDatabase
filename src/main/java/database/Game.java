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
public class Game {
    
    SimpleStringProperty title;
    SimpleStringProperty developer;
    SimpleStringProperty genre;
    SimpleStringProperty platform;
    SimpleStringProperty format;

    public Game(String title, String developer, String genre, String platform, String format) {
        this.title = new SimpleStringProperty(title);
        this.developer = new SimpleStringProperty(developer);
        this.genre = new SimpleStringProperty(genre);
        this.platform = new SimpleStringProperty(platform);
        this.format = new SimpleStringProperty(format);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getDeveloper() {
        return developer.get();
    }

    public void setDeveloper(String developer) {
        this.developer.set(developer);
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
