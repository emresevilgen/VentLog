/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.user.ventlog.ventlog;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Munib Emre Sevilgen
 */
public class EventContainer implements Serializable{
    private ArrayList<Event> list;
    private int sort;
    
    public EventContainer( ArrayList<Event> list, int sort) {
        this.list = list;
        this.sort = sort;
    }
    
    public EventContainer() {
        list = new ArrayList<Event>();
        sort = 0;
    }
    
    public void setSort( int sort) {
        this.sort = sort;
    }
    
    public int getSort() {
        return sort;
    }
    
    public void addEvent( Event event) {
        list.add( event);
    }
    
    public void removeEvent( Event event) {
        for( int i = 0; i < list.size(); i++ ) {
            if ( list.get(i).equals( event)) {
                list.remove(i);
                i = list.size();
            }
        }
    }
    
    public ArrayList<Event> getList() {
        return list;
    }
}
