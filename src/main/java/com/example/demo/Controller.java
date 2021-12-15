package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class Controller {

    @FXML
    private TextField Content;

    @FXML
    private TableView<JDItem> tableView;

    @FXML
    private TableColumn<JDItem, String> tableViewHref;

    @FXML
    private TableColumn<JDItem, Double> tableViewPrice;

    @FXML
    private TableColumn<JDItem, String> tableViewTitle;

    @FXML
    void SearchBtnClick(ActionEvent event) {

        tableViewTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableViewPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableViewHref.setCellValueFactory(new PropertyValueFactory<>("href"));
        String content = Content.getText();
        System.out.println(content);
        try{
            int cnt = 0;
            List<Item> result = Reptile.getItem(content,Boolean.FALSE);
            List<JDItem> resultJD = JDItem.convert(result);
            ObservableList<JDItem> data = FXCollections.observableList(resultJD);
            for(JDItem it : resultJD){
                System.out.println(it);
                //tableView.getItems().add();
            }
            tableView.setItems(data);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

}