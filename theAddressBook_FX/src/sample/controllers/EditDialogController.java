package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Person;

import java.util.Objects;

public class EditDialogController {
    @FXML
    public TextField nameText;
    @FXML
    public TextField telephoneText;
    @FXML
    public Button okButton;
    @FXML
    public Button cancelButton;

    private Person person;

    public void setPerson(Person person) {
        Objects.requireNonNull(person, "IT IS NULL!!!");
        this.person = person;
        nameText.setText(person.getFullName());
        telephoneText.setText(person.getTelephoneNumber());
    }

    public Person getPerson() {
        return person;
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void actionSave(ActionEvent actionEvent) {
        person.setFullName(nameText.getText());
        person.setTelephoneNumber(telephoneText.getText());
        actionClose(actionEvent);
    }
}
