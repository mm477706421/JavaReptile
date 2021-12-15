package com.example.demo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDItem extends Item {
    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public String getHref() {
        return href.get();
    }

    public SimpleStringProperty hrefProperty() {
        return href;
    }

    public void setHref(String href) {
        this.href.set(href);
    }

    private SimpleStringProperty title;
    private SimpleDoubleProperty price;
    private SimpleStringProperty href;

    public String getImgUrl() {
        return imgUrl.get();
    }

    public SimpleStringProperty imgUrlProperty() {
        return imgUrl;
    }


    private SimpleStringProperty imgUrl;

    public JDItem() {
        super();
        this.title = new SimpleStringProperty();
        this.price = new SimpleDoubleProperty();
        this.href = new SimpleStringProperty();
        this.imgUrl = new SimpleStringProperty();
    }

    public JDItem(Map<String, String> info) {
        super(info);
        this.title = new SimpleStringProperty();
        this.price = new SimpleDoubleProperty();
        this.href = new SimpleStringProperty();
        this.imgUrl = new SimpleStringProperty();
        this.title.set(info.get("title"));
        this.price.set(Double.parseDouble(info.get("price")));
        this.href.set(info.get("href"));
    }

    public JDItem(String title, Double price, String href) {
        super();
        try {
            assert false;
            this.title = new SimpleStringProperty();
            this.price = new SimpleDoubleProperty();
            this.href = new SimpleStringProperty();
            this.imgUrl = new SimpleStringProperty();
            this.title.set(title);
            this.price.set(price);
            this.href.set(href);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static List<JDItem> convert(List<Item> li) {
        List<JDItem> ret = new ArrayList<>();
        for (Item x : li) {
            JDItem jdt = new JDItem(x.getInfo().get("title"), Double.parseDouble(x.getInfo().get("price")), x.getInfo().get("href"));
            jdt.imgUrl.set(x.getInfo().get("imgUrl"));
            ret.add(jdt);
        }
        return ret;
    }

    @Override
    public String toString() {
        return this.title.get() + ',' + this.price.get() + ',' + this.href.get();
    }
}
