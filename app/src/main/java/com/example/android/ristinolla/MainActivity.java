package com.example.android.ristinolla;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.activity_main).setBackgroundColor(color);
        switchTurn();
    }


    Random rnd = new Random();
    int board[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int color = Color.argb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    int turn = rnd.nextInt(2);


    public void markSquare(View v) {
        TextView tv = (TextView) findViewById(v.getId());


        if (turn == 0 && isChecked(v.getId()) == 0) {
            tv.setText("X");
            checkSquare(v.getId());
            switchTurn();
            checkWin();


        } else if (turn == 1 && isChecked(v.getId()) == 0) {
            tv.setText("O");
            checkSquare(v.getId());
            switchTurn();
            checkWin();


        }


    }

    public void checkSquare(int x) {
        if (x == R.id.center) {
            switch (turn) {
                case 0:
                    board[0] = 1;
                    break;
                case 1:
                    board[0] = 2;
            }
        } else if (x == R.id.left) {
            switch (turn) {
                case 0:
                    board[1] = 1;
                    break;
                case 1:
                    board[1] = 2;
                    break;
            }
        } else if (x == R.id.right) {
            switch (turn) {
                case 0:
                    board[2] = 1;
                    break;
                case 1:
                    board[2] = 2;
                    break;
            }
        } else if (x == R.id.topLeft) {
            switch (turn) {
                case 0:
                    board[3] = 1;
                    break;
                case 1:
                    board[3] = 2;
                    break;
            }
        } else if (x == R.id.topRight) {
            switch (turn) {
                case 0:
                    board[4] = 1;
                    break;
                case 1:
                    board[4] = 2;
                    break;
            }
        } else if (x == R.id.top) {
            switch (turn) {
                case 0:
                    board[5] = 1;
                    break;
                case 1:
                    board[5] = 2;
                    break;
            }
        } else if (x == R.id.bottomLeft) {
            switch (turn) {
                case 0:
                    board[6] = 1;
                    break;
                case 1:
                    board[6] = 2;
                    break;
            }
        } else if (x == R.id.bottomRight) {
            switch (turn) {
                case 0:
                    board[7] = 1;
                    break;
                case 1:
                    board[7] = 2;
                    break;
            }
        } else if (x == R.id.bottom) {
            switch (turn) {
                case 0:
                    board[8] = 1;
                    break;
                case 1:
                    board[8] = 2;
                    break;
            }

        }


    }

    public int isChecked(int x) {
        if (x == R.id.center) {
            return board[0];
        } else if (x == R.id.left) {
            return board[1];
        } else if (x == R.id.right) {
            return board[2];
        } else if (x == R.id.topLeft) {
            return board[3];
        } else if (x == R.id.topRight) {
            return board[4];
        } else if (x == R.id.top) {
            return board[5];
        } else if (x == R.id.bottomLeft) {
            return board[6];
        } else if (x == R.id.bottomRight) {
            return board[7];
        } else if (x == R.id.bottom) {
            return board[8];
        } else {
            return 0;
        }
    }

    public void switchTurn() {
        TextView vv = (TextView) findViewById(R.id.turn);
        if (turn == 1) {
            turn = 0;
            vv.setText("Turn X");

        } else {
            turn = 1;
            vv.setText("Turn O");

        }
    }

    public void checkAll() {
        for (int i = 0; i < board.length; i++) {
            board[i] = 3;
        }

    }

    public void checkWin() {

        if ((board[0] == 1 && board[1] == 1 &&
                board[2] == 1) || (board[0] == 1 && board[5] == 1 &&
                board[8] == 1) || (board[0] == 1 && board[3] == 1 &&
                board[7] == 1) || (board[0] == 1 && board[4] == 1 &&
                board[6] == 1) || (board[1] == 1 && board[3] == 1 &&
                board[6] == 1) || (board[2] == 1 && board[4] == 1 &&
                board[7] == 1) || (board[3] == 1 && board[5] == 1 &&
                board[4] == 1) || (board[6] == 1 && board[8] == 1 &&
                board[7] == 1)) {
            checkAll();
            TextView vv = (TextView) findViewById(R.id.turn);
            vv.setText("X WINS!");


        } else if ((board[0] == 2 && board[1] == 2 &&
                board[2] == 2) || (board[0] == 2 && board[5] == 2 &&
                board[8] == 2) || (board[0] == 2 && board[3] == 2 &&
                board[7] == 2) || (board[0] == 2 && board[4] == 2 &&
                board[6] == 2) || (board[1] == 2 && board[3] == 2 &&
                board[6] == 2) || (board[2] == 2 && board[4] == 2 &&
                board[7] == 2) || (board[3] == 2 && board[5] == 2 &&
                board[4] == 2) || (board[6] == 2 && board[8] == 2 &&
                board[7] == 2)) {
            checkAll();
            TextView vv = (TextView) findViewById(R.id.turn);
            vv.setText("O WINS!");

        } else if (board[0] != 0 && board[1] != 0 && board[2] != 0 && board[3] != 0 && board[4] != 0
                && board[5] != 0 && board[6] != 0 && board[7] != 0 && board[8] != 0) {
            TextView vv = (TextView) findViewById(R.id.turn);
            vv.setText("It's a draw!");

        }


    }


    public void goToMainMenu(View v) {
        startActivity(new Intent(MainActivity.this, menu.class));
    }

    public void newGame(View v) {
        startActivity(new Intent(MainActivity.this, MainActivity.class));
    }
}



