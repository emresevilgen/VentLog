/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.user.ventlog.ventlog;

/**
 *
 * @author Munib Emre Sevilgen
 */
public class Cinema extends Template {
    private String name;
    private String director;
    private String actors;
    private final String NAME = "Name: ";
    private final String DIRECTOR = "Director: ";
    private final String ACTORS = "Actors: ";
    
    public Cinema( String name, String director, String actors) {
        this.name = name;
        this.director = director;
        this.actors = actors;
    }
    
    public Cinema () {
        name = "";
        director = "";
        actors = "";
    }
    
    public void setName( String name) {
        this.name = name;
    }       
    
    public void setDirector( String director) {
        this.director = director;
    }   
    
    public void setActors( String actors) {
        this.actors = actors;
    }   
    
    public String getName() {
        return name;
    }
    
    public String getDirector() {
        return director;
    }
    
    public String getActors() {
        return actors;
    } 
    
    public String getNAME() {
        return NAME;
    } 
    
    public String getDIRECTOR() {
        return DIRECTOR;
    } 
    
    public String getACTORS() {
        return ACTORS;
    } 
}   

