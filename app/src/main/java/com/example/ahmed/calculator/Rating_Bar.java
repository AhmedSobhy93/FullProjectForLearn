package com.example.ahmed.calculator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class Rating_Bar extends Activity {


    private RatingBar ratingBar;
    private TextView resultTxtV;
    private Button showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating__bar);

        addlisteneronRatingBar();
        addListenerOnButton();
    }

    //if rating value is changed,
    //display the current rating value in the result (textview) automatically
    public void addlisteneronRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.RatingBar_Rating_ProgBar);
        resultTxtV = (TextView) findViewById(R.id.RatinBar_Result1_TextView);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                resultTxtV.setText(String.valueOf(rating));
            }
        });
    }

    public void addListenerOnButton() {
        ratingBar = (RatingBar) findViewById(R.id.RatingBar_Rating_ProgBar);
        showBtn = (Button) findViewById(R.id.RatingBar_ShowRating_Button);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Rating_Bar.this, String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
