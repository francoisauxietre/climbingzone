package com.climbing.zone.domain;

public class Topic {
    Long Id;
    String name;
    String info;

    public Topic() {

    }

    public Topic(Long id, String name, String info) {
        Id = id;
        this.name = name;
        this.info = info;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
