package com.example.violetfire.geophysicalinterpolationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Nicole on 2017-06-24.
 */

public class SaveExternal implements WriteWhere
{
    // ATTRIBUTES
    private String externalPathname;

    // METHODS
    @Override
    public boolean writeFile(String toWrite)
    {
        // Check if a file can be written to external storage
        if (!isExternalStorageWritable())
        {
            return false;
        }

        File file;
        FileOutputStream outputStream;

        try
        {
            file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

            outputStream = new FileOutputStream(file);
            outputStream.write(toWrite.getBytes());
            outputStream.close();
        }
        catch (IOException e)
        {
            return false;
        }

        return true;
    }

    @Override
    public void export(String location)
    {
        // Implement
        // Save elsewhere
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

      //  if (!file.mkdirs())
      //  {
            //Log.e(LOG_TAG, "Directory not created");
      //  }

        return file;
    }
}