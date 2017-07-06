package com.example.violetfire.geophysicalinterpolationapp;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Nicole on 2017-06-24.
 */

public class SaveBoth implements WriteWhere
{
    // ATTRIBUTES
    private String internalPathname;
    private String externalPathname;

    // METHODS
    @Override
    public boolean writeFile(String toWrite)
    {
        boolean result = true;

        //=== STEP1: Write Internally ===//
        // QUESTION: OVERWRITING? ADDING?

        // Set up output stream for writing
        FileOutputStream outputStream;

        try{
            outputStream = getApplicationContext().openFileOutput(internalPathname, Context.MODE_PRIVATE);
            // Get bytes for provided string
            outputStream.write(toWrite.getBytes());
            // Close file that was written to
            outputStream.close();
        }
        catch (Exception exp){
            result = false;
        }

        //=== STEP2: Write Externally ===//
        // Check if a file can be written to external storage
        if (!isExternalStorageWritable())
        {
            result = false;
        }

        File file;

        try
        {
            file = new File(externalPathname);

            outputStream = new FileOutputStream(file);
            outputStream.write(toWrite.getBytes());
            outputStream.close();
        }
        catch (IOException e)
        {
            result = false;
        }

        return result;
    }

    @Override
    public void export(String location)
    {
        // Implement
        // Save elsewhere
    }

    public void setInternalPathname(String newPathname)
    {
        internalPathname = newPathname;
    }

    public String getInternalPathname()
    {
        return internalPathname;
    }

    public void setExternalPathname(String newPathname)
    {
        externalPathname = newPathname;
    }

    public String getExternalPathname()
    {
        return externalPathname;
    }

    /* Checks if external storage is available for read and write */
    private boolean isExternalStorageWritable()
    {
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state))
        {
            return true;
        }

        return false;
    }

    private File getAlbumStorageDir(String albumName)
    {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS), albumName);

     //   if (!file.mkdirs())
     //   {
            //Log.e(LOG_TAG, "Directory not created");
     //   }

        return file;
    }

}