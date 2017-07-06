package com.example.violetfire.geophysicalinterpolationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nicole on 2017-06-18.
 */

public class IndividualEntry extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_entry);

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
    }

    /**
     * When appropriate button is pressed, entry is added to current collection of data points and
     * remains on this activity so user can add another data point.
     * @param view "Add Entry" button pressed by user
     */
    public void addErase(View view) {
        // TODO: Save entered data point

        // Get EditView where user entered measurement
        final EditText entryZ = (EditText) findViewById(R.id.z_measurement);
        // Erase contents of EditText
        entryZ.setText("");

        // Get EditView where user entered x coordinate value
        final EditText entryX = (EditText) findViewById(R.id.x_measurement);
        // Erase contents of EditText
        entryX.setText("");

        // Get EditView where user entered y coordinate value
        final EditText entryY = (EditText) findViewById(R.id.y_measurement);
        // Erase contents of EditText
        entryY.setText("");

        ((GlobalApplicationData) this.getApplication()).setOneEntry(true);
        Toast.makeText(this, "Data point added", Toast.LENGTH_SHORT).show();
   }

    public void addMoveOn(View view) {
        // TODO: Save entered data point
        Intent backToImport = new Intent(this, FileImportSelect.class);
        ((GlobalApplicationData) this.getApplication()).setOneEntry(true);
        Toast.makeText(this, "Data point added", Toast.LENGTH_SHORT).show();
        startActivity(backToImport);

    }
}