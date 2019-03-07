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
public class Trash extends Log {
    public Trash() {
        super();
    }
    
    public void restoreAll() {
        ArrayList<Event> list = this.getContainer().getList();
        Event event;
        while ( list.size() > 0) {
            event = list.get(0);
            event.restoreEvent();
        }
    }
    
    public void removeAll() {
        ArrayList<Event> list = this.getContainer().getList();
        while ( list.size() > 0) {
            list.remove(0);
        }
    }
}
