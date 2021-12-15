package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import java.awt.Desktop;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URI;
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
    private ImageView imageView;

    @FXML
    void ImageClick(MouseEvent event) {
        try{
            String url = tableView.getSelectionModel().getSelectedItem().getHref();
            Desktop dp = Desktop.getDesktop();
            if(dp.isSupported(Desktop.Action.BROWSE)){
                dp.browse(URI.create("https:"+url));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void tableSelected(MouseEvent event) {
        String url = tableView.getSelectionModel().getSelectedItem().getImgUrl();
        imageView.setImage(new Image(url));
        Hyperlink link = new Hyperlink();
        link.setGraphic(imageView);
    }

    @FXML
    void SearchBtnClick(ActionEvent event) {

        tableViewTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableViewPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableViewHref.setCellValueFactory(new PropertyValueFactory<>("href"));
        String content = Content.getText();
        System.out.println(content);
        try {
            int cnt = 0;
            List<Item> result = Reptile.getItem(content, Boolean.FALSE);
            List<JDItem> resultJD = JDItem.convert(result);
            ObservableList<JDItem> data = FXCollections.observableList(resultJD);
            tableView.setItems(data);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}