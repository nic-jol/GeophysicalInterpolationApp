package com.example.violetfire.geophysicalinterpolationapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        /* Display saved units */
    // TODO: Get it to read from the file
        //====Get ids of EditTexts to display units in====//
        // Get EditView for displaying z units
        final EditText displayZ = (EditText) findViewById(R.id.z_input_units);
        // Get EditText for displaying x units
        final EditText displayX = (EditText) findViewById(R.id.x_input_units);
        // Get EditText for displaying y units
        final EditText displayY = (EditText) findViewById(R.id.y_input_units);

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

    public void saveUnits(View view) {
        Intent getUnitsScreenIntent = new Intent(this, FileImportSelect.class);

        /* Save to both variables and file */

        // Get z units entered by user
        EditText zEditText = (EditText) findViewById(R.id.z_input_units);
        // Convert entered data into a String
        String newZUnits = zEditText.getText().toString();
        // Save entered units to global z unit variable
        ((GlobalApplicationData) this.getApplication()).setZUnits(newZUnits);

        // Get x units entered by user
        EditText xEditText = (EditText) findViewById(R.id.x_input_units);
        // Convert entered data into a String
        String newXUnits = xEditText.getText().toString();
        // Save entered units to global x unit variable
        ((GlobalApplicationData) this.getApplication()).setXUnits(newXUnits);

        // Get y units entered by user
        EditText yEditText = (EditText) findViewById(R.id.y_input_units);
        // Convert entered data into a String
        String newYUnits = yEditText.getText().toString();
        // Save entered units to global y unit variable
        ((GlobalApplicationData) this.getApplication()).setYUnits(newYUnits);

        /* Create a file in the Internal Storage that saves the units */
        String filename = "units.txt";
        String content = newZUnits + "#" + newXUnits + "#" + newYUnits;
        FileOutputStream outputStream;

        try{
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        }
        catch (Exception exp){
            exp.printStackTrace();
        }

        // Indicate to user that their units have been saved
        Toast.makeText(this, "Units saved", Toast.LENGTH_SHORT).show();

        startActivity(getUnitsScreenIntent);
    }
}
