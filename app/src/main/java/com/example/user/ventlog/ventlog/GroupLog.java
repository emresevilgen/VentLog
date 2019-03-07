/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.user.ventlog.ventlog;

import java.util.ArrayList;

/**
 *
 * @author Munib Emre Sevilgen
 */
public class GroupLog extends Log{
    private String name;
    private String picture;
    private ArrayList<User> participants;
    
    public GroupLog( String name, String picture) {
        super();
        this.name = name;
        this.picture = picture;
        participants = new ArrayList<User>();
    }
    
    public GroupLog() {
        super();
        name = "";
        picture = "";
        participants = new ArrayList<User>();
    }
    
    public void setName( String name) {
        this.name = name;
    }
    
    public void setPicture( String picture) {
        this.picture = picture;
    }
     
    public String getName() {
        return name;
    }
    
    public String getPicture() {
        return picture;
    }
    
    public void addParticipant( User participant) {
        participants.add( participant);
    }
    
    public void removeParticipant( User participant) {
        for( int i = 0; i < participants.size(); i++ ) {
            if ( participants.get(i).equals( participant)) {
                participants.remove(i);
                i = participants.size();
            }
        }
    }
    
}
