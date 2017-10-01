package gamesdatabase;

import database.DataBaseManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    
    DataBaseManager manager;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manager = new DataBaseManager("database.s3db");
    }
    
    @FXML
    private void createNewGame(){
        String title = this.title.getText();
        String developer = this.developer.getValue().toString();
        String genre = this.genre.getValue().toString();
        String platform = this.platform.getValue().toString();
        String format = this.format.getValue().toString();
        manager.insertGame(title, developer, genre, platform, format);
    }
}
