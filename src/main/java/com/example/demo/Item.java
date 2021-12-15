package com.example.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Item {
    public Item(){
        info = new HashMap<String,String>();
    }
    public Item(Map<String,String> map){
        info = map;
    }
    private final Map<String,String> info;
    public void addInfo(String a,String b){
        info.put(a,b);
    }
    public Map<String,String> getInfo(){
        return info;
    }
    @Override
    public String toString(){
        StringBuilder returnContent = new StringBuilder("");
        for (String x:info.keySet()) {
            if(returnContent.length() > 0){
                returnContent.append("\n");
            }
            returnContent.append(x).append(":").append(info.get(x));
        }
        return returnContent.toString();
    }
}
