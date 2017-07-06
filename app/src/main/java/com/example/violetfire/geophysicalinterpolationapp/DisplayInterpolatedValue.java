package com.example.violetfire.geophysicalinterpolationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Nicole on 2017-06-18.
 */

public class DisplayInterpolatedValue extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_interpolated_value);

        // Get TextView for displaying z units
        final TextView displayZ = (TextView) findViewById(R.id.z_units);
        // Get TextView for displaying x units
        final TextView displayX = (TextView) findViewById(R.id.x_units);
        // Get TextView for displaying y units
        final TextView displayY = (TextView) findViewById(R.id.y_units);

        //====Get Strings stored in GlobalApplicationData====//
        // Get String containing z units from GlobalApplicationData class
        String checkZ = ((GlobalApplicationData) this.getApplication()).getZUnits();
        // Get String containing x units from GlobalApplicationData class
        String checkX = ((GlobalApplicationData) this.getApplication()).getXUnits();
        // Get String containing y units from GlobalApplicationData class
        String checkY = ((GlobalApplicationData) this.getApplication()).getYUnits();

        //====Display Units====//
        // Change EditText so it displays stored z units
        displayZ.setText(checkZ);
        // Change EditText so it displays stored x units
        displayX.setText(checkX);
        // Change EditText so it displays stored y units
        displayY.setText(checkY);

        //====Display Interpolated Values ====//
        // TODO: Actually Calculate Interpolation and Load it Here
        double fake = 70.6;
        ((GlobalApplicationData) this.getApplication()).setzInterpolation(fake);

        // Get TextView for displaying interpolated z value
        final TextView displayZvalue = (TextView) findViewById(R.id.actual_value);
        // Get TextView for displaying x coordinate
        final TextView displayXvalue = (TextView) findViewById(R.id.x_value);
        // Get TextView for displaying y coordinate
        final TextView displayYvalue = (TextView) findViewById(R.id.y_value);

        //====Get Strings stored in GlobalApplicationData====//
        // Get double containing interpolated z value from GlobalApplicationData class and convert to String
        String interpolatedZ = ((GlobalApplicationData) this.getApplication()).getzInterpolation() + "";
        // Get double containing x-coordinate from GlobalApplicationData class and convert to String
        String interpolatedX = ((GlobalApplicationData) this.getApplication()).getxInterpolation() + "";
        // Get double containing y-coordinate from GlobalApplicationData class and convert to String
        String interpolatedY = ((GlobalApplicationData) this.getApplication()).getyInterpolation() + "";

        //====Display Interpolated Values====//
        // Change TextView so it displays stored interpolated z value
        displayZvalue.setText(interpolatedZ);
        // Change TextView so it displays stored x-coordinate
        displayXvalue.setText(interpolatedX);
        // Change TextView so it displays stored y-coordinate
        displayYvalue.setText(interpolatedY);
    }

    public void useDifferentPoint(View view) {
        Intent newInterpolationPoint = new Intent(this, EnterInterpolationPoint.class);
        startActivity(newInterpolationPoint);
    }

    public void startOver(View view) {
        // TODO: Add warning so you don't accidentally start over
        // TODO: Erase Everything?
        Intent goToBeginning = new Intent(this, StartPage.class);
        startActivity(goToBeginning);
    }
}
