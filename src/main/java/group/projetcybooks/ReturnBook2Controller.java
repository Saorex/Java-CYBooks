package group.projetcybooks;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ReturnBook2Controller {

    private Stage stage;
    private Scene scene;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void switchToReturnBook1(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("ReturnBook1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 1080, 720);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("MainScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 1080, 720);
        stage.setScene(scene);
        stage.show();
    }
}
