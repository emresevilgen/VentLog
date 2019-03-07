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
import java.util.ArrayList;

public class VentLog implements Serializable {

    // Properties
    private Settings settings;
    private ArrayList<Log> logList;

    // Constructor
    public VentLog() {
        logList = new ArrayList<Log>();
    }

    // Methods
    // Getters & Setters
    public Settings getSettings() {
        return settings;
    }
    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public ArrayList<Log> getLogList() {
        return logList;
    }
    public void setLogList(ArrayList<Log> logList) {
        this.logList = logList;
    }


    public void showCollage() {

    }

    public void fixMood() {}

    public void addLog(Log log) {
        logList.add(log);
    }

    public void removeLog(Log log) {
        logList.remove(log);
    }

    public void reset() {
        logList = new ArrayList<Log>();
    }

}
