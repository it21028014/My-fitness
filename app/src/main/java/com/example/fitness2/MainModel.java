package com.example.fitness2;

public class MainModel {

    String name,duration,sets,url;

    public MainModel(){

    }
    public MainModel(String name, String duration, String sets, String url) {
        this.name = name;
        this.duration = duration;
        this.sets = sets;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
