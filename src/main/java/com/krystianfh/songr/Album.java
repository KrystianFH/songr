package com.krystianfh.songr;

import com.fasterxml.jackson.annotation.JsonTypeId;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;



    private String title;
    private String artist;
    private int songCount;
    private int length;
    private String imageUrl;
    @OneToMany(mappedBy = "album")
    private List<Song> songList;

    public Album(long id, String title, String artist, int songCount, int length, String imageUrl) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public Album(){}

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

}
