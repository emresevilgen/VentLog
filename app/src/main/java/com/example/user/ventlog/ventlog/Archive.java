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
public class Archive extends Log{
    
    public Archive() {
        super();
    }
    
    public void restoreAll() {
        ArrayList<Event> list = this.getContainer().getList();
        Event event;
        for (int i = 0; i < list.size(); i++) {
            event = list.get(i);
            event.restoreEvent();
        }
    }
}
