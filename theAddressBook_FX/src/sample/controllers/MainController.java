package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

//import java.awt.*; этого не должно быть
import java.io.IOException;
import java.util.Objects;

import javafx.scene.control.Button;

public class MainController {
    @FXML
    private Button addButton;

    public void showDialog(javafx.event.ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxml/edit.fxml")));
            stage.setTitle("Редактирование записи");
            stage.setMinHeight(80);
            stage.setMinWidth(400);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());//родительское окно взять
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
