package com.example.violetfire.geophysicalinterpolationapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import java.io.FileOutputStream;

/**
 * Created by Nicole on 2017-06-24.
 */

public class SaveInternal implements WriteWhere
{
    private String internalPathname;

    // METHDOS
    @Override
    public boolean writeFile(String toWrite)
    {
        // Set up output stream for writing
        FileOutputStream outputStream;

        try{
            outputStream = getApplicationContext().openFileOutput(internalPathname, getActivity().MODE_PRIVATE);

            // Get bytes for provided string
            outputStream.write(toWrite.getBytes());
            // Close file that was written to
            outputStream.close();
        }
        catch (Exception exp){
            return false;
        }

        return true;
    }

    @Override
    public void export(String location)
    {
        // Implement

        // Either Export or display error message

    }

    public void setInternalPathname(String newPathname)
    {
        internalPathname = newPathname;
    }

    public String getInternalPathname()
    {
        return internalPathname;
    }
}