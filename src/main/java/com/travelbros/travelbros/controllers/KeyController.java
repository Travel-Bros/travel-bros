package com.travelbros.travelbros.controllers;

import com.travelbros.travelbros.services.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KeyController {

    @Autowired
    private KeyService keys;

    @GetMapping("/key")
    public KeyService getKeys() {
        return keys;
    }
}
