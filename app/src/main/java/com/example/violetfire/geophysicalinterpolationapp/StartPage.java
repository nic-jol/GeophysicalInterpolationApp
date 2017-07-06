package com.example.violetfire.geophysicalinterpolationapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Nicole on 2017-06-14.
 */

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        final Button start = (Button) findViewById(R.id.StartButton);
        final Button about = (Button) findViewById(R.id.AboutButton);

        new CountDownTimer(3000, 1000) { // 5000 = 5 sec

            public void onTick(long millisUntilFinished) {
                // Make start button transparent
                start.setAlpha(0);

                // Make about button transparent
                about.setAlpha(0);
            }

            public void onFinish() {
                // Erase team logo
             //   ImageView displayLogo = (ImageView) findViewById(R.id.logo);
            //    displayLogo.setImageResource(android.R.color.transparent);

                // Make start button opaque
                start.setAlpha(1);

                // Make about button opaque
                about.setAlpha(1);

            }
        }.start();
    }

    public void startApp(View view) {
        // Go to Main Menu
        Intent getUnitsScreenIntent = new Intent(this, MainMenu.class);

        startActivity(getUnitsScreenIntent);
    }

    public void aboutApp(View view) {
        // TODO: About page
    }
}
