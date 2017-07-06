package com.example.violetfire.geophysicalinterpolationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Nicole on 2017-06-18.
 */

public class EnterInterpolationPoint extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_interpolation_point);

        // Get TextView for displaying x units
        final TextView displayX = (TextView) findViewById(R.id.x_units);
        // Get TextView for displaying y units
        final TextView displayY = (TextView) findViewById(R.id.y_units);

        //====Get Strings stored in GlobalApplicationData====//
        // Get String containing x units from GlobalApplicationData class
        String checkX = ((GlobalApplicationData) this.getApplication()).getXUnits();
        // Get String containing y units from GlobalApplicationData class
        String checkY = ((GlobalApplicationData) this.getApplication()).getYUnits();

        //====Display Units====//
        // Change EditText so it displays stored x units
        displayX.setText(checkX);
        // Change EditText so it displays stored y units
        displayY.setText(checkY);
    }

    public void performInterpolation(View view) {
        Intent displayInterpolation = new Intent(this, DisplayInterpolatedValue.class);

        //==== Save Interpolation Point ====//
        // TODO: Error handling when point is not a floating point number
        // Get x-coordinate entered by user
        EditText xCoor = (EditText) findViewById(R.id.x_interpolation);
        // Convert entered data into a String
        String xCoorStr = xCoor.getText().toString();
        // Convert String into a double
        Double xCoorNum = new Double(xCoorStr);
        // Save entered x-coordinate to global x coordinate variable
        ((GlobalApplicationData) this.getApplication()).setxInterpolation(xCoorNum);

        // TODO: Error handling when point is not a floating point number
        // Get y-coordinate entered by user
        EditText yCoor = (EditText) findViewById(R.id.y_interpolation);
        // Convert entered data into a String
        String yCoorStr = yCoor.getText().toString();
        // Convert String into a double
        Double yCoorNum = new Double(yCoorStr);
        // Save entered y-coordinate to global y coordinate variable
        ((GlobalApplicationData) this.getApplication()).setyInterpolation(yCoorNum);

        // Check if CheckBox is checked
        CheckBox regularCheckBox = (CheckBox) findViewById(R.id.regular_data);

        boolean checked = regularCheckBox.isChecked();

        // If yes, remember that data is regular
        if (checked){
            ((GlobalApplicationData) this.getApplication()).setRegularData(true);
        }
        // If no, remember that data is irregular
        else{
            ((GlobalApplicationData) this.getApplication()).setRegularData(false);
        }

        // TODO: Actually calculate an Interpolated Value

        // Move on to displaying value
        startActivity(displayInterpolation);

    }

    public void enterMorePoints(View view) {
        Intent backToImport = new Intent(this, FileImportSelect.class);
        startActivity(backToImport);
    }
}
