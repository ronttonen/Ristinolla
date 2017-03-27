package com.example.android.ristinolla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    boolean turn = true;



    Button center = (Button) findViewById(R.id.center);

    public void markSquare(View v)
    {
        switch (v.getId()){
            case R.id.center:
                center.setText("X");
        }

    }

    public void switchTurn(boolean turn) {
        if (turn) {
            turn = false;
        }

        else {
            turn = true;
        }
    }


    public void goToMainMenu(View v) {
        startActivity(new Intent(MainActivity.this, menu.class));
    }

}

