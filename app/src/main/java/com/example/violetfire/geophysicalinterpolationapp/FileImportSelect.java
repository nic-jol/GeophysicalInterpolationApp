package com.example.violetfire.geophysicalinterpolationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lamerman.*;


/**
 * Created by Nicole on 2017-06-10.
 */

public class FileImportSelect extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.importing_data);

        // Get interpolation button
        final Button moveToInterpolation = (Button) findViewById(R.id.BeginInterpolation);

        boolean oneEntry = ((GlobalApplicationData) this.getApplication()).getOneEntry();

        final TextView loadResult = (TextView) findViewById(R.id.load_result);

        // TODO: Actual result message
        // Set TextView to Transparent
        loadResult.setAlpha(0);

        if (!oneEntry)
        {
            // Make "Begin Interpolation Button" transparent
            moveToInterpolation.setAlpha(0);
        }
        else
        {
            // Make "Begin Interpolation Button" opaque
            moveToInterpolation.setAlpha(1);
        }
    }

    /**
     * When user presses "Go back" button, they are brought back to the enter units screen.
     * @param view "Go back" button that is pressed.
     */
    public void reenterUnits(View view)
    {
        Intent goBackIntent = new Intent(this, MainMenu.class);
        startActivity(goBackIntent);
    }

    /**
     * When appropriate button is pressed, the user is able to load a text file (extension .txt)
     * @param view "Load Data from Text File" button pressed by the user
     */
    public void importTextFile(View view)
    {
        // Get SD card directory
        String state = Environment.getExternalStorageState();

        // If there is not one, display an error message
        if (!(state.equals(Environment.MEDIA_MOUNTED)))
        {
            Toast.makeText(this, "There is no sd card", Toast.LENGTH_SHORT).show();

            System.exit(1);
        }
        else
        {
            Toast.makeText(this, "Sd card available", Toast.LENGTH_SHORT).show();

            // Open file choosing option
            String pathname = showFileChooserText();

            // TODO: What if file is empty?
            // Indicate that there was an entry
            ((GlobalApplicationData) this.getApplication()).setOneEntry(true);

            // TODO: remove this timer
            new CountDownTimer(3000, 1000)
            {
                public void onTick(long millisUntilFinished)
                {


                }

                public void onFinish()
                {
                    // Make "Begin Interpolation Button" opaque
                    final Button moveToInterpolation = (Button) findViewById(R.id.BeginInterpolation);
                    moveToInterpolation.setAlpha(1);

                    final TextView loadResult = (TextView) findViewById(R.id.load_result);

                    // TODO: Actual result message
                    // Set TextView to Opaque
                    loadResult.setAlpha(1);
                }
            }.start();


        }
    }

    /**
     *  When appropriate button is pressed, the user is able to load a shapefile (extension .shp)
     * @param view "Load Data from Shape File" button pressed by the user
     */
    public void importShapeFile(View view) {
        // Get SD card directory
        String state = Environment.getExternalStorageState();

        // If there is not one, display an error message
        if (!(state.equals(Environment.MEDIA_MOUNTED))) {
            Toast.makeText(this, "There is no sd card", Toast.LENGTH_SHORT).show();

            System.exit(1);
        } else {
            Toast.makeText(this, "Sd card available", Toast.LENGTH_SHORT).show();

            // Open file choosing option
            String pathname = showFileChooserShp();

            // TODO: What if file is empty?
            // Indicate that there was an entry
            ((GlobalApplicationData) this.getApplication()).setOneEntry(true);

            // Make "Begin Interpolation Button" opaque
            final Button moveToInterpolation = (Button) findViewById(R.id.BeginInterpolation);
            moveToInterpolation.setAlpha(1);
        }
    }

    /*
     * Opens a text file and returns a pathname in the form of a String
     */
    private String showFileChooserText()
    {
        String importedFile = "";

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        //intent.setType("*/*");      //all files
        intent.setType("text/*");   //XML file only
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try
        {
            int FILE_SELECT_CODE = 1;

            startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), FILE_SELECT_CODE);

            // TODO: Get pathname
            // TODO: Process Text File
            // TODO: Save pathname to GlobalApplicationData
            Intent fromFileDialog = getIntent();

            importedFile = fromFileDialog.getStringExtra(FileDialog.RESULT_PATH);

            // Indicate file was loaded
        //    Toast.makeText(this, "File loaded", Toast.LENGTH_SHORT).show();
        }
        catch (android.content.ActivityNotFoundException ex)
        {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show();

            System.exit(1);
        }

        return importedFile;
    }

    /*
     * Opens a shapefile and returns a pathname in the form of a string
     */
    private String showFileChooserShp()
    {
        String importedFile = "";

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        //intent.setType("*/*");      //all files
        intent.setType("*/shp");      //Shp file only
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try
        {
            int FILE_SELECT_CODE = 1;

            startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), FILE_SELECT_CODE);

            // TODO: Get pathname
            // TODO: Save pathname to GlobalApplicationData
            Intent fromFileDialog = getIntent();

            importedFile = fromFileDialog.getStringExtra(FileDialog.RESULT_PATH);

            // Indicate file was loaded
            Toast.makeText(this, "File loaded", Toast.LENGTH_SHORT).show();
        }
        catch (android.content.ActivityNotFoundException ex)
        {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show();

            System.exit(1);
        }

        return importedFile;
    }

    /**
     * When appropriate button is clicked, go to activity that allows user to enter a single entry
     * @param view "Enter Individual Entry" button pressed by the user
     */
    public void enterIndividualEntry(View view) {
        Intent goEnterIndividual = new Intent(this, IndividualEntry.class);
        startActivity(goEnterIndividual);
    }

    /**
     * When appropriate button is clicked, go to activity that allows user to enter a point
     * for interpolation
     * @param view "Begin Interpolation" button pressed by the user
     */
    public void setUpInterpolation(View view) {
        Intent goEnterInterpolation = new Intent(this, EnterInterpolationPoint.class);
        startActivity(goEnterInterpolation);
    }
}