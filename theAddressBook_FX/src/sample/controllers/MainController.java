package sample.controllers;

import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;
import sample.model.Person;
import sample.storage.CollectionAddressBook;

//import java.awt.*; этого не должно быть
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private final CollectionAddressBook addressBook = new CollectionAddressBook();

    private Stage mainStage;

    @FXML
    public Button btnEdit;
    @FXML
    public Button btnAdd;
    @FXML
    public Button btnDelete;
    @FXML
    public CustomTextField searchText;
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

    private ResourceBundle resourceBundle;

    private ObservableList<Person> backupList;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        //указываем поля класса Person для заполнения таблицы на форме
        columnFullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        columnTelephone.setCellValueFactory(new PropertyValueFactory<>("telephoneNumber"));
        setupClearButtonField(searchText);
        initListener();
        addressBook.testData();
        backupList = FXCollections.observableArrayList();
        backupList.addAll(addressBook.getStorage());

        dataTable.setItems(addressBook.getStorage());//заполняем элемент на форме, таблиц
        initLoader();
    }

    private void setupClearButtonField(CustomTextField customTextField) {
        try {
            Method m = TextFields.class.getDeclaredMethod("setupClearButtonField", TextField.class, ObjectProperty.class);
            m.setAccessible(true);
            m.invoke(null, customTextField, customTextField.rightProperty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initListener() {
        //слушатель, на изменения хранилища
        addressBook.getStorage().addListener((ListChangeListener<Person>) change ->
                countLabel.setText(resourceBundle.getString("count") + ": " + addressBook.getSize()));

        dataTable.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getClickCount() == 2) {
                editDialogController.setPerson((Person) dataTable.getSelectionModel().getSelectedItem());
                showDialog();
            }
        });
    }

    private void initLoader() {
        try {
            fxmlLoader.setLocation(getClass().getResource("../fxml/edit.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("sample.bundles.Locale", new Locale("en")));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionButtonPressed(ActionEvent actionEvent) {
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

    public void actionSearch(ActionEvent actionEvent) {
        ObservableList<Person> persons = addressBook.getStorage();
        if (searchText.getText().isEmpty()) {
            if (persons.size() != backupList.size()) {
                persons.clear();
                persons.addAll(backupList);
            }
        }
        persons.removeIf(person ->
                (!person.getFullName().toLowerCase().contains(searchText.getText().toLowerCase()) &&
                        !person.getTelephoneNumber().contains(searchText.getText())));

    }

    private void showDialog() {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle(fxmlLoader.getResources().getString("title.edit"));
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
