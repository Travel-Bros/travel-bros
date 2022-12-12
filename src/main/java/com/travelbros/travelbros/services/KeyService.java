package com.travelbros.travelbros.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KeyService {

    @Value("${GOOGLE_MAPS_API}")
    private String GOOGLE_API;

    public KeyService() {}

    public KeyService(String GOOGLE_API) {
        this.GOOGLE_API = GOOGLE_API;
    }

    public String getGOOGLE_API() {
        return GOOGLE_API;
    }

    public void setGOOGLE_API(String GOOGLE_API) {
        this.GOOGLE_API = GOOGLE_API;
    }
}
