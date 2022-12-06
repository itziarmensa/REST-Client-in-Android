package com.itziar.restclient.models;



public class Track {

    String id;
    String title;
    String singer;
    static int lastId;

    public Track() {

    }

    public Track(String id, String title, String singer) {
        this();
        this.setId(id);
        this.setSinger(singer);
        this.setTitle(title);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Track [title=" + title + ", singer=" + singer +"]";
    }

}