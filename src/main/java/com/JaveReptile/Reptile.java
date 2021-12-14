package com.JaveReptile;

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
    public static List<Item> getInfo(String name) throws IOException {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
        String url = new String("https://learningportal.iiep.unesco.org/en/library/search?keys=") + name;
        String urlTotal = "https://learningportal.iiep.unesco.org";
        Connection con = Jsoup.connect(url).proxy(proxy);
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3880.400 QQBrowser/10.8.4554.400");
        headers.put("Host", "learningportal.iiep.unesco.org");
        con.headers(headers);
        Connection.Response rs = con.execute();
        Document doc = Jsoup.parse(rs.body());
        String className = new String("view-content");
        List<Item> ret = new ArrayList<Item>();
        for (Element x:doc.getElementsByClass(className)) {
            for(Element y:x.getElementsByClass(new String("views-row"))){
                Item it = new Item();
                it.setInfo(y.getElementsByClass("search-info").text());
                it.setUrl(urlTotal+y.attr("href").toString());
                it.setTitle(y.getElementsByTag("span").first().text());
                ret.add(it);
            }
        }
        return ret;
    }
}
