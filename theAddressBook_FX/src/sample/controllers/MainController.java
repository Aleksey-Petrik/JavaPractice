package sample.controllers;

import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.model.Person;
import sample.storage.CollectionAddressBook;

//import java.awt.*; этого не должно быть
import java.io.IOException;

public class MainController {
    private final CollectionAddressBook addressBook = new CollectionAddressBook();

    private Stage mainStage;

    @FXML
    public Button btnEdit;
    @FXML
    public Button btnAdd;
    @FXML
    public Button btnDelete;
    @FXML
    public TextField searchText;
    @FXML
    public Button searchButton;
    @FXML
    public TableView dataTable;
    @FXML
    public TableColumn<Person, String> columnFullName;
    @FXML
    public TableColumn<Person, String> columnTelephone;
    @FXML
    public Label countLabel;

    private Parent fxmlEdit;
    private final FXMLLoader fxmlLoader = new FXMLLoader();
    private EditDialogController editDialogController;
    private Stage editDialogStage;

    @FXML
    private void initialize() {
        //указываем поля класса Person для заполнения таблицы на форме
        columnFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        columnTelephone.setCellValueFactory(new PropertyValueFactory<>("telephoneNumber"));
        //слушатель, на изменения хранилища
        addressBook.getStorage().addListener((ListChangeListener<Person>) change -> {
            // if (change.wasAdded() || change.wasRemoved()) {
            countLabel.setText("Количество записей: " + addressBook.getSize());
            // }
        });

        dataTable.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getClickCount() == 2) {
                editDialogController.setPerson((Person) dataTable.getSelectionModel().getSelectedItem());
            }
        });

        addressBook.testData();

        //заполняем таблицу
        dataTable.setItems(addressBook.getStorage());

        try {
            fxmlLoader.setLocation(getClass().getResource("../fxml/edit.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionButtonPressed(javafx.event.ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (!(source instanceof Button)) {
            return;
        }

        switch (((Button) source).getId()) {
            case "btnAdd" -> {
                editDialogController.setPerson(new Person());
                showDialog();
                addressBook.add(editDialogController.getPerson());
            }
            case "btnEdit" -> {
                editDialogController.setPerson((Person) dataTable.getSelectionModel().getSelectedItem());
                showDialog();
            }
            case "btnDelete" -> addressBook.delete((Person) dataTable.getSelectionModel().getSelectedItem());
        }
    }

    private void showDialog() {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Редактирование записи");
            editDialogStage.setMinHeight(80);
            editDialogStage.setMinWidth(400);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);//родительское окно взять
        }
        editDialogStage.showAndWait();
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
}
