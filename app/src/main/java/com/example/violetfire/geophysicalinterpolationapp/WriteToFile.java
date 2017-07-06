package com.example.violetfire.geophysicalinterpolationapp;

/**
 * Created by Nicole on 2017-06-24.
 */

public class WriteToFile {
    // ATTRIBUTES
    private WriteWhere saveLocation;

    // METHODS

    public void setWriteLocation(WriteWhere newLocation)
    {
        saveLocation = newLocation;
    }

    public WriteWhere getWriteLocation()
    {
        return saveLocation;
    }

    public boolean writeToFile(String toWrite)
    {
        return saveLocation.writeFile("Hello");
    }
}
