/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.user.ventlog.ventlog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Munib Emre Sevilgen
 */
public class Event implements Serializable{
    private boolean isPinned;
    private String title;
    private String date;
    private String location;
    private String withPeople;
    private ArrayList<String> tags;
    private int likeRate;
    private int rememberRate;
    private String text;
    private Template template;
    private ArrayList<String> mediaList;
    private Log previousLog;
    private Log currentLog;
    
    public Event( String title, String date, String location, String withPeople, ArrayList<String> tags, int likeRate, int rememberRate, String text, Template template, ArrayList<String> mediaList){
        this.title = title;
        this.date = date;
        this.location = location;
        this.withPeople = withPeople;
        this.tags = tags;
        this.likeRate = likeRate;
        this.rememberRate = rememberRate;
        this.text = text;
        this.template = template;
        this.mediaList = mediaList;
        isPinned = false;
    }
    
    public Event() {
        title = "";
        date = "";
        location = "";
        withPeople = "";
        tags = new ArrayList<String>();
        likeRate = -1;
        rememberRate = -1;
        text = "";
        mediaList = new ArrayList<String>();
        isPinned = false;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDate( String date) {
        this.date = date;
    }
    
    public void setLocation( String location) {
        this.location = location;
    }
    
    public void setWithPeople( String withPeople) {
        this.withPeople = withPeople;
    }
    
    public void setLikeRate( int likeRate) {
        this.likeRate = likeRate;
    }
    
    public void setRememberRate( int rememberRate) {
        this.rememberRate = rememberRate;
    }
    
    public void setText( String text) {
        this.text = text;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getWithPeople() {
        return withPeople;
    }
    
    public int getLikeRate() {
        return likeRate;
    }
    
    public int getRememberRate() {
        return rememberRate;
    }
    
    public String getText() {
        return text;
    }
    
    public ArrayList<String> getTags() {
        return tags;
    }
    
    public ArrayList<String> getMediaList() {
        return mediaList;
    }
    
    public void addMedia( String media) {
        mediaList.add( media);
    }
    
    public void addTag( String tag) {
        tags.add( tag);
    }
    
    public void removeTag( String tag) {
        for( int i = 0; i < tags.size(); i++ ) {
            if ( tags.get(i).equals( tag)) {
                tags.remove(i);
                i = tags.size();
            }
        }
    }
    
    public void removeMedia( String media) {
        for( int i = 0; i < mediaList.size(); i++ ) {
            if ( mediaList.get(i).equals( media)) {
                mediaList.remove(i);
                i = mediaList.size();
            }
        }
    }
    
    public void addTemplate( Template template) {
        this.template = template;
    }
    
    public void removeTemplate() {
        template = null;
    }
    
    public void setPreviousLog( Log previousLog) {
        this.previousLog = previousLog; 
    }
    
    public void restoreEvent() {
        previousLog.addEvent( this);
        currentLog.removeEvent( this);
        currentLog = previousLog;
    }
    
    public void setCurrentLog( Log currentLog) {
       this.currentLog = currentLog;
    }

    public void setIsPinned( boolean isPinned) {
        this.isPinned = isPinned;
    }

    public boolean getIsPinned() {
        return isPinned;
    }

    public String toString() {
        return ("name = " + title +
                "\ndate = " + date +
                "\nlocation = " + location +
                "\nwithPeople = " + withPeople +
                "\ntags = " + tags +
                "\nlikeRate = " + likeRate +
                "\nrememberRate = " + rememberRate +
                "\ntext = " + text +
                "\ntemplate = " + template +
                "\nmediaList = " + mediaList +
                "\nisPinned = " + isPinned);
    }
    
}

