package com.quanglv.utils.error;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleException(Exception e){
        if(e instanceof CustomException){
            //exception service
            CustomRestException errorCustom = (CustomRestException) e;
            return ResponseEntity.badRequest().body(errorCustom.getExtensions());
        }
        JsonObject error = new JsonObject();
        JsonArray value = new JsonArray();
        value.add(e.getMessage());
        error.add("", value);
        return ResponseEntity.badRequest().body(error.toString());
    }
}