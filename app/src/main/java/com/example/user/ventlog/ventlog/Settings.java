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

public class Settings implements Serializable {

    // Properties
    private User user;
    private boolean isMoodFixerSelected;
    private boolean isCollageSelected;

    // Methods
    // Getters & Setters
    public boolean getIsMoodFixerSelected() {
        return isMoodFixerSelected;
    }
    public void setIsMoodFixerSelected(boolean isMoodFixerSelected) {
        this.isMoodFixerSelected = isMoodFixerSelected;
    }

    public boolean getIsCollageSelected() {
        return isCollageSelected;
    }
    public void setIsCollageSelected(boolean isCollageSelected) {
        this.isCollageSelected = isCollageSelected;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}

