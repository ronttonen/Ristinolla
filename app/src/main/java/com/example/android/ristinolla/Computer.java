package com.example.android.ristinolla;
import android.view.animation.Animation.AnimationListener;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import static android.view.View.X;
import static com.example.android.ristinolla.R.id.center;

/**
 * Created by Roni on 27.3.2017.
 */

public class Computer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.computer);
        findViewById(R.id.computer).setBackgroundColor(color);

    }

    Random rnd = new Random();
    int board[] = {0, 0, 0, 0, 0, 0, 0, 0, 0}; // 0 = empty , 1 = player1, 2 = bot / player2, 3 = locked

    // pick random background
    int color = Color.argb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    int turn = 0; // set X to start




    public void markSquare(View v) {
        // get target
        TextView tv = (TextView) findViewById(v.getId());

        // check if box is empty (ischecked = 0 = empty)
        if (turn == 0 && isChecked(v.getId()) == 0) {
            tv.setText("X");
            checkSquare(v.getId());
            switchTurn();
            checkWin();
            ai();
            if (!win){
                switchTurn();
                checkWin();
            }



        }
    }

    // check if box is checked, return board[value] or 0
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

    public void checkSquare(int x) {
        if (x == R.id.center) {
            switch (turn) {
                case 0:
                    board[0] = 1;
                    break;

            }
        } else if (x == R.id.left) {
            switch (turn) {
                case 0:
                    board[1] = 1;
                    break;

            }
        } else if (x == R.id.right) {
            switch (turn) {
                case 0:
                    board[2] = 1;
                    break;

            }
        } else if (x == R.id.topLeft) {
            switch (turn) {
                case 0:
                    board[3] = 1;
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

            }
        } else if (x == R.id.bottomLeft) {
            switch (turn) {
                case 0:
                    board[6] = 1;
                    break;

            }
        } else if (x == R.id.bottomRight) {
            switch (turn) {
                case 0:
                    board[7] = 1;
                    break;

            }
        } else if (x == R.id.bottom) {
            switch (turn) {
                case 0:
                    board[8] = 1;
                    break;

            }

        }
    }
    // lock boxes
    public void checkAll() {
        for (int i = 0; i < board.length; i++) {
            board[i] = 3;
        }

    }

    public void ai() {
        int target;

        if (!win) {
            do {
                target = rnd.nextInt(9); // get random number 0-9 WOW SO WISE AI
            }
            while (board[target] != 0);
            if (target == 0) {
                TextView ff = (TextView) findViewById(R.id.center);
                if (turn == 1) {
                    ff.setText("O");
                    board[0] = 2;
                } else if (turn == 0) {
                    ff.setText("X");
                    board[0] = 1;
                }

            } else if (target == 1) {
                TextView ff = (TextView) findViewById(R.id.left);
                if (turn == 1) {
                    ff.setText("O");
                    board[1] = 2;
                } else if (turn == 0) {
                    ff.setText("X");
                    board[1] = 1;
                }

            } else if (target == 2) {
                TextView ff = (TextView) findViewById(R.id.right);
                if (turn == 1) {
                    ff.setText("O");
                    board[2] = 2;
                } else if (turn == 0) {
                    ff.setText("X");
                    board[2] = 1;
                }

            } else if (target == 3) {
                TextView ff = (TextView) findViewById(R.id.topLeft);
                if (turn == 1) {
                    ff.setText("O");
                    board[3] = 2;
                } else if (turn == 0) {
                    ff.setText("X");
                    board[3] = 1;
                }

            } else if (target == 4) {
                TextView ff = (TextView) findViewById(R.id.topRight);
                if (turn == 1) {
                    ff.setText("O");
                    board[4] = 2;
                } else if (turn == 0) {
                    ff.setText("X");
                    board[4] = 1;
                }

            } else if (target == 5) {
                TextView ff = (TextView) findViewById(R.id.top);
                if (turn == 1) {
                    ff.setText("O");
                    board[5] = 2;
                } else if (turn == 0) {
                    ff.setText("X");
                    board[5] = 1;
                }

            } else if (target == 6) {
                TextView ff = (TextView) findViewById(R.id.bottomLeft);
                if (turn == 1) {
                    ff.setText("O");
                    board[6] = 2;
                } else if (turn == 0) {
                    ff.setText("X");
                    board[6] = 1;
                }

            } else if (target == 7) {
                TextView ff = (TextView) findViewById(R.id.bottomRight);
                if (turn == 1) {
                    ff.setText("O");
                    board[7] = 2;
                } else if (turn == 0) {
                    ff.setText("X");
                    board[7] = 1;
                }

            } else if (target == 8) {
                TextView ff = (TextView) findViewById(R.id.bottom);
                if (turn == 1) {
                    ff.setText("O");
                    board[8] = 2;
                } else if (turn == 0) {
                    ff.setText("X");
                    board[8] = 1;
                }


            }
        }
    }

    boolean win = false;



    public boolean checkWin() {

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
            win = true;
            return win;

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
            win = true;
            return win;
        } else if (board[0] != 0 && board[1] != 0 && board[2] != 0 && board[3] != 0 && board[4] != 0
                && board[5] != 0 && board[6] != 0 && board[7] != 0 && board[8] != 0) {
            TextView vv = (TextView) findViewById(R.id.turn);
            vv.setText("It's a draw!");
            win = true;

            return win;
        } else {
            return win;
        }
    }


    public void goToMainMenu(View v) {
        startActivity(new Intent(Computer.this, menu.class));
    }

    public void newGame(View v) {
        startActivity(new Intent(Computer.this, Computer.class));
    }
}

