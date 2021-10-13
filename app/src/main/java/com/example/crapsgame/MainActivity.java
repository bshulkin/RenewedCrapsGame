package com.example.crapsgame;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public TextView results;
    public TextView winner;
    public Button rollsNumber;
    public TextView textView;
    public ImageView image1, image2;
    public int wins;
    public int losses;
    public int point = 0;
    int over = 20;
    public int first_number = 0;
    public int second_number = 0;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollsNumber = findViewById(R.id.roll_button);
        winner = findViewById(R.id.Winner);
        results = findViewById(R.id.winsLossView);
        image1 = findViewById(R.id.dice1);
        image2 = findViewById(R.id.dice2);

        rollsNumber.setOnClickListener(view -> {

            final int[] die = {R.drawable.die1, R.drawable.die2, R.drawable.die3, R.drawable.die4, R.drawable.die5, R.drawable.die6};


            Random first_die = new Random();
            int first_number = first_die.nextInt(6) + 1;
            Random second_die = new Random();
            int second_number = second_die.nextInt(6) + 1;
            int sum_round = first_number + second_number;

            textView.setText("You rolled: " + first_number + "+" + second_number + "=" + sum_round );

            if (over == 30) {
                over = 40;
            }
            if (over == 20) {

                switch (sum_round) {
                    case 7:
                    case 11:
                        textView.setText("You won");
                        rollsNumber.setEnabled(false);
                        wins++;
                        displayWinNumber();
                        break;
                    case 2:
                    case 3:
                    case 12:
                        textView.setText("You lost");
                        rollsNumber.setEnabled(false);
                        losses++;
                        displayWinNumber();
                        break;
                    default:
                        point = sum_round;
                        textView.setText("You rolled " + point + ".\n" + "You must roll " + point
                                + " to win." + "\n" + "If you roll a 7 you lose." + "\n" + "Roll Again!");
                        displayWinNumber();
                        break;
                }
            }

            if (over == 40) {
                if (point == sum_round){
                    textView.setText("You have won");
                    rollsNumber.setEnabled(false);
                    over = 20;
                    wins++;
                    displayWinNumber();
            }
                if(sum_round == 7){
                    textView.setText("You Lose");
                    rollsNumber.setEnabled(false);
                    over = 20;
                    losses ++;
                    displayWinNumber();

                }
                if (sum_round != point && sum_round != 7){
                    textView.setText("You rolled " + point + ".\n" + "You must roll " + point
                            + " to win." + "\n" + "If you roll a 7 you lose." + "\n" + "Roll Again!");
                }



                image1.setImageResource(die[first_number]);
                image2.setImageResource(die[second_number]);

            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void displayWinNumber() {
        textView.setText("Player Wins: " + wins + "   House Wins: " + losses);
    }
    @SuppressLint("SetTextI18n")
    public void newGame(View view){
        rollsNumber.setEnabled(true);

        results.setText("Roll again");
        point = 0;
        first_number = 0;
        second_number = 0;

    }
}