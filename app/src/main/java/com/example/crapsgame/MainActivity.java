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
    public Button rollsNumber;
    public Button rollAgain;
    public ImageView image1, image2;

    final int[] die = {R.drawable.die1, R.drawable.die2, R.drawable.die3, R.drawable.die4, R.drawable.die5, R.drawable.die6};


    Random first_die = new Random();
    int first_number = first_die.nextInt(6) + 1;
    Random second_die = new Random();
    int second_number = second_die.nextInt(6) + 1;
    int sum_round = first_number + second_number;

    int sumPointRound = 0;
    int die3;
    int die4;




    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollsNumber = findViewById(R.id.roll_button);
        rollAgain = findViewById(R.id.roll_button2);
        results = findViewById(R.id.winsLossView);
        image1 = findViewById(R.id.dice1);
        image2 = findViewById(R.id.dice2);

        rollsNumber.setOnClickListener(view -> {


            if(sum_round == 7 || sum_round == 11)
            {
                results.setText("Congratulations! You won.");
            }
            else {
                if (sum_round == 2 || sum_round == 3 || sum_round == 12) {
                    results.setText("Sorry, you have lost.");
                } else {
                    results.setText("You rolled " + sum_round + ". This is your point value.");
                }
            }


        rollAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                while (sumPointRound != 7 && sumPointRound != sum_round) {
                    die3 = first_die.nextInt(5) + 1;
                    die4 = second_die.nextInt(5) + 1;
                    sumPointRound = die3 + die4;
                    results.setText("You rolled: " + die3 + " + " + die4 + " = " + sumPointRound);
                }
                //sumPointRound = 8;
                if (sumPointRound == 7) {
                    results.setText("You Lost");
                }
                else if (sumPointRound == sum_round){
                    results.setText("You Won!");
                }

                image1.setImageResource(die[first_number]);
                image2.setImageResource(die[second_number]);


            }
        });
});
    
}}
