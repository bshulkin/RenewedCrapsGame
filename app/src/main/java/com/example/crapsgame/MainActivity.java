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

    private static final int DICE_RANDOM_UPPER_BOUND = 5;
    public TextView resultsTv;
    public Button rollsNumberButton;
    public Button rollAgainButton;
    public ImageView diceOneIv, diceTwoIv;

    final int[] die = {R.drawable.die1, R.drawable.die2, R.drawable.die3,
            R.drawable.die4, R.drawable.die5, R.drawable.die6};

    Random dieOneRng = new Random();
    Random dieTwoRng = new Random();

    int sumOfInitialRoll = 0;
    int die3;
    int die4;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollsNumberButton = findViewById(R.id.roll_button);
        rollAgainButton = findViewById(R.id.roll_button2);
        resultsTv = findViewById(R.id.winsLossView);
        diceOneIv = findViewById(R.id.dice1);
        diceTwoIv = findViewById(R.id.dice2);

        rollsNumberButton.setOnClickListener(view -> {
            int sumOfInitialRoll = rollDice();
            if (sumOfInitialRoll == 7 || sumOfInitialRoll == 11) {
                resultsTv.setText("Congratulations! You won.");
            } else {
                if (sumOfInitialRoll == 2 || sumOfInitialRoll == 3 || sumOfInitialRoll == 12) {
                    resultsTv.setText("Sorry, you have lost.");
                } else {
                    resultsTv.setText("You rolled " + sumOfInitialRoll + ". This is your point value.");
                }
            }
        });

        rollAgainButton.setOnClickListener(view ->  {

                // Why is this here?
                double[] odds = new double[11]; //{2,1.5,1.2,1.2,1.5,2}
                odds[0] = 1; //odds on a 2
                odds[1] = 1; //odds on a 3
                odds[2] = 2; //odds on a 4
                odds[3] = 1.5; //odds on a 5
                odds[4] = 1.2; //odds on a 6
                odds[5] = 1; //odds on a 7
                odds[6] = 1.2; //odds on an 8
                odds[7] = 1.5; //odds on a 9
                odds[8] = 2; //odds on a 10
                odds[9] = 1; //odds on an 11
                odds[10] = 1; //odds on a 12

                int sumOfDice = rollDice();
//                if (sumOfInitialRoll != 7 && sumOfInitialRoll != sumOfDice) {
//                    resultsTv.setText("You rolled: " + die3 + " + " + die4 + " = " + sumOfDice);
//                }
//                if (sumOfInitialRoll == 7) {
//                    resultsTv.setText("You Lost");
//                } else if (sumOfInitialRoll == sumOfDice){
//                    resultsTv.setText("You Won!");
//                }
                if (sumOfDice == sumOfInitialRoll) {
                    resultsTv.setText("You Won!");
                } else {
                    resultsTv.setText("You Lost");
                }
            });
        }

    private int rollDice() {
        int dieOneValue = dieOneRng.nextInt(DICE_RANDOM_UPPER_BOUND) + 1;
        int dieTwoValue = dieTwoRng.nextInt(DICE_RANDOM_UPPER_BOUND) + 1;
        diceOneIv.setImageResource(die[dieOneValue]);
        diceTwoIv.setImageResource(die[dieTwoValue]);
        return dieOneValue + dieTwoValue;
    }
}
