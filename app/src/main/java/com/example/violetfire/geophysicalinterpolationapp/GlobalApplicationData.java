package com.example.violetfire.geophysicalinterpolationapp;

import android.app.Application;

/**
 * Created by Nicole on 2017-06-10.
 */

public class GlobalApplicationData extends Application {
    // Instance Variables
    private String zUnits;
    private String xUnits;
    private String yUnits;
    private boolean atLeastOneEntry = false;
    private double xInterpolation;
    private double yInterpolation;
    private double zInterpolation;
    private boolean regularData = false;


    // Set Methods
    public void setZUnits(String newUnits){
        // Could say no to empty string
        zUnits = newUnits;
    }
    public void setXUnits(String newUnits){
        // Could say no to empty string
        xUnits = newUnits;
    }
    public void setYUnits(String newUnits){
        // Could say no to empty string
        yUnits = newUnits;
    }
    public void setOneEntry(boolean newValue){
        atLeastOneEntry = newValue;
    }

    public void setxInterpolation (double newX){
        xInterpolation = newX;
    }

    public void setyInterpolation (double newY){
        yInterpolation = newY;
    }

    public void setzInterpolation (double newZ){
        zInterpolation = newZ;
    }

    public void setRegularData(boolean newValue){
        regularData = newValue;
    }

    // Get Methods
    public String getZUnits(){
        return zUnits;
    }

    public String getXUnits(){
        return xUnits;
    }

    public String getYUnits(){
        return yUnits;
    }

    public boolean getOneEntry(){
        return atLeastOneEntry;
    }

    public double getxInterpolation(){
        return xInterpolation;
    }

    public double getyInterpolation(){
        return yInterpolation;
    }

    public double getzInterpolation(){
        return zInterpolation;
    }

    public boolean getRegularData(){
        return regularData;
    }
}
