package com.dev.app.bookstorerestapi.conroller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractRestController {

    public static String asJsonString(final Object object){
        try {
            return new ObjectMapper().writeValueAsString(object);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
