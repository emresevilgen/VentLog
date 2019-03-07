/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.user.ventlog.ventlog;

import java.io.Serializable;

/**
 *
 * @author Munib Emre Sevilgen
 */
public class Log implements Serializable {
    private EventContainer container;
     
    public Log( EventContainer container) {
        this.container = container; 
    }
    
    public Log() {
        container = new EventContainer();
    }
    
    public void setContainer( EventContainer container) {
        this.container = container;
    }
    
    public EventContainer getContainer() {
        return container;
    }
    
    public void addEvent( Event event) {
        container.addEvent( event);
        event.setCurrentLog( this);
    } 
    
    public void removeEvent( Event event) {
        container.removeEvent( event);
        event.setPreviousLog( this);
    }
}
