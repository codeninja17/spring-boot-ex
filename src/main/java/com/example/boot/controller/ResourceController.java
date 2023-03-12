package com.example.boot.controller;

import com.example.boot.exception.handler.ExceptionModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class ResourceController {

    @Value(value = "${default.name}")
    private String name;

    @RequestMapping(method = RequestMethod.GET, path = "/name")
    public String getName(){
        return name;
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionModel> handleNoSuchElementException(NoSuchElementException n){
        ExceptionModel exceptionModel =
                new ExceptionModel(HttpStatus.NOT_FOUND.value(),"Name Not FOUND !!!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exceptionModel);
    }
}
