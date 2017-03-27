package com.example.android.ristinolla;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Roni on 27.3.2017.
 */

public class menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void goToGame(View v) {
        startActivity(new Intent(menu.this, MainActivity.class));
    }
}
