package com.example.demo;

import javafx.scene.image.Image;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reptile {
    public static List<Item> getItem(String name,Boolean isProxy) throws IOException {

        List<Item> ret = new ArrayList<Item>();
        String url = "https://search.jd.com/Search?keyword=" + name;
        Connection.Response rs = getResponse(url,isProxy);
        Document doc = Jsoup.parse(rs.body());
        for(Element x:doc.getElementsByClass("gl-i-wrap")){
            String imgUrl = x.getElementsByClass("p-img").select("a").select("img").attr("data-lazy-img");
            String price = x.getElementsByClass("p-price").select("strong").select("i").text();
            String titleClass = "p-name p-name-type-2";
            String title = x.getElementsByClass(titleClass).select("a").select("em").text();
            String href = x.getElementsByClass(titleClass).select("a").attr("href");
            Map<String,String> info = new HashMap<String,String>();
            info.put("imgUrl","https:"+imgUrl);
            info.put("price",price);
            info.put("title",title);
            info.put("href",href);
            Item it = new Item(info);
            ret.add(it);
        }
        return ret;
    }
    public static Connection.Response getResponse(String url, Boolean isProxy) throws IOException {
        List<Item> ret = new ArrayList<Item>();
        Connection con;
        if(isProxy){
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1",4781));
            con = Jsoup.connect(url).proxy(proxy);
        }
        else {
            con = Jsoup.connect(url);
        }
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Host","search.jd.com");
        headers.put("Referer","https://www.jd.com/");
        headers.put("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:95.0) Gecko/20100101 Firefox/95.0");
        con.headers(headers);
        Connection.Response rs = con.execute();
        return rs;
    }
    public static void main(String[] args) {
        try{
            for(Item x:getItem("iphone",Boolean.FALSE)){
                System.out.println(x);
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
