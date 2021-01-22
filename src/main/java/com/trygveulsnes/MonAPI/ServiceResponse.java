package com.trygveulsnes.MonAPI;

public class ServiceResponse {
    
    private final long id;
    private final String content;

    public ServiceResponse(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}