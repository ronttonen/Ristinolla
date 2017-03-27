package com.example.android.ristinolla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.button;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    public void buttonClick(View v)
    {
        TextView tv = (TextView)findViewById(R.id.center);
        tv.setText("X");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToMainMenu(View v) {
        startActivity(new Intent(MainActivity.this, menu.class));
    }

}

