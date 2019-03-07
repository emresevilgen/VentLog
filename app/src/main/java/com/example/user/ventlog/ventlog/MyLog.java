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
public class MyLog extends Log {
    private String picture;
    
    public MyLog( String picture) {
        super();
        this.picture = picture;
    }
    
    public MyLog() {
        super();
        picture = "";
    }
}
