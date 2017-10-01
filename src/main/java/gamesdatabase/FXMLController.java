package gamesdatabase;

import database.DataBaseManager;
import database.Game;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController implements Initializable {
    
    @FXML
    private TextField title;
    @FXML
    private ComboBox developer;
    @FXML
    private ComboBox genre;
    @FXML
    private ComboBox platform;
    @FXML
    private ComboBox format;
    @FXML
    private TableView<Game> table;
    @FXML
    private TableColumn titleColumn;
    @FXML
    private TableColumn developerColumn;
    @FXML
    private TableColumn genreColumn;
    @FXML
    private TableColumn platformColumn;
    @FXML
    private TableColumn formatColumn;
    
    DataBaseManager manager;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manager = new DataBaseManager("database.s3db");
        refreshCombos();
        populateTable();
    }
    
    @FXML
    private void createNewGame(){
        String title = this.title.getText();
        String developer = this.developer.getValue().toString();
        String genre = this.genre.getValue().toString();
        String platform = this.platform.getValue().toString();
        String format = this.format.getValue().toString();
        manager.insertGame(title, developer, genre, platform, format);
        manager.insertDeveloper(developer);
        manager.insertGenre(genre);
        manager.insertPlatform(platform);
        manager.insertFormat(format);
        refreshCombos();
        clearData();
    }
    
    private void refreshCombos(){
        developer.setItems(FXCollections.observableList(manager.getAllDevelopers()));
        genre.setItems(FXCollections.observableList(manager.getAllGenres()));
        platform.setItems(FXCollections.observableList(manager.getAllPlatforms()));
        format.setItems(FXCollections.observableList(manager.getAllFormats()));
    }
    
    private void clearData(){
        title.setText("");
        developer.getSelectionModel().clearSelection();
        genre.getSelectionModel().clearSelection();
        platform.getSelectionModel().clearSelection();
        format.getSelectionModel().clearSelection();
    }
    
    private void populateTable(){
        titleColumn.setCellValueFactory(new PropertyValueFactory<Game,String>("title"));
        developerColumn.setCellValueFactory(new PropertyValueFactory<Game,String>("developer"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Game,String>("genre"));
        platformColumn.setCellValueFactory(new PropertyValueFactory<Game,String>("platform"));
        formatColumn.setCellValueFactory(new PropertyValueFactory<Game,String>("format"));
        table.setItems(FXCollections.observableArrayList(manager.getAllGames()));
    }
}
