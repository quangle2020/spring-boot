package com.quanglv.utils.error;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.quanglv.constant.Constants;

import java.util.*;

public class CustomException extends Exception {

    private String errorJson;

    public CustomException(String key , String message){
        super(message);
        JsonObject json = new JsonObject();
        JsonArray error = new JsonArray();
        error.add(message);
        json.add(key , error);
        this.errorJson = json.toString();
    }

    public CustomException(String key , Map<String , Object> mapError){
        super(new Gson().toJson(mapError));
        JsonObject json = new JsonObject();
        JsonArray error = new JsonArray();
        error.add(new Gson().toJson(mapError));
        json.add(key , error);
        this.errorJson = json.toString();
    }

    public String getErrorJson() {
        return errorJson;
    }

    public void setErrorJson(String errorJson) {
        this.errorJson = errorJson;
    }
}
