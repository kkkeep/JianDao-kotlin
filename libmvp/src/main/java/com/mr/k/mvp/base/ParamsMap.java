package com.mr.k.mvp.base;

import java.util.HashMap;

public class ParamsMap extends HashMap<String,String> {

    private String url;


    public ParamsMap(String url) {
        this.url = url;
    }

    public String getUrl(){
        return url;
    }
}
