package com.JaveReptile;

public class Item {
    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public String getUrl(){
        return url;
    }
    private String url;
    private String title;
    private String info;
    public Item(){
        this.url = "";
        this.title = "";
        this.info = "";
    }
    public Item(String url, String title, String info) {
        this.url = url;
        this.title = title;
        this.info = info;
    }
    @Override
    public String toString(){
        return title+","+info+","+url;
    }
}
