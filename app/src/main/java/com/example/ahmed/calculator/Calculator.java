package com.example.ahmed.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Calculator extends Activity implements View.OnClickListener {

    EditText firstNumEdt, secondNumEdt;
    Button addBtn, subBtn, mulBtn, divBtn, goBtn;
    TextView resulttv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //Receive message
        Intent i = getIntent();
        String m = i.getStringExtra("k1");

        Toast.makeText(this, m, Toast.LENGTH_SHORT).show();

        firstNumEdt = (EditText) findViewById(R.id.Main_FirstNum_Text);
        secondNumEdt = (EditText) findViewById(R.id.Main_SecondNum_Text);

        addBtn = (Button) findViewById(R.id.Main_Sum_Button);
        subBtn = (Button) findViewById(R.id.Main_Sub_Button);
        mulBtn = (Button) findViewById(R.id.Main_Multi_Button);
        divBtn = (Button) findViewById(R.id.Main_Div_Button);


        resulttv = (TextView) findViewById(R.id.Main_Result_TextView);

        addBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        mulBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == addBtn) {
            String firstNum1=firstNumEdt.getText().toString();
            String secondNum1=secondNumEdt.getText().toString();
            if (firstNum1.equals("")) {
                resulttv.setText("Please Enter First Number");
                //Toast.makeText(this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
            } else if (secondNum1.equals(""))
                resulttv.setText("Please Enter Second Number");
                //Toast.makeText(this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
            else {

                double firstNum = Double.parseDouble(firstNum1);

                double secondNum = Double.parseDouble(secondNum1);

                double result = firstNum + secondNum;
                String res = String.valueOf(result);
                resulttv.setText(res);

            }
        } else if (v == subBtn) {
            String firstNum1=firstNumEdt.getText().toString();
            String secondNum1=secondNumEdt.getText().toString();
            if (firstNum1.equals("")) {
                resulttv.setText("Please Enter First Number");
                //Toast.makeText(this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
            } else if (secondNum1.equals(""))
                resulttv.setText("Please Enter Second Number");
            //Toast.makeText(this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
            else {
                String firstNumberStr = firstNumEdt.getText().toString();
                double firstNum = Double.parseDouble(firstNumberStr);

                String secondNumberStr = secondNumEdt.getText().toString();
                double secondNum = Double.parseDouble(secondNumberStr);

                double result = firstNum - secondNum;
                String res = String.valueOf(result);
                resulttv.setText(res);

            }
        } else if (v == mulBtn) {


            String firstNum1=firstNumEdt.getText().toString();
            String secondNum1=secondNumEdt.getText().toString();
            if (firstNum1.equals("")) {
                resulttv.setText("Please Enter First Number");
                //Toast.makeText(this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
            } else if (secondNum1.equals(""))
                resulttv.setText("Please Enter Second Number");
                //Toast.makeText(this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
            else {
                double firstNum = Double.parseDouble(firstNum1);


                double secondNum = Double.parseDouble(secondNum1);

                double result = firstNum * secondNum;
                String res = String.valueOf(result);
                resulttv.setText(res);
            }

        } else if (v == divBtn) {

            String firstNum1 = firstNumEdt.getText().toString();
            String secondNum1 = secondNumEdt.getText().toString();
            if (firstNum1.equals("")) {
                resulttv.setText("Please Enter First Number");
                //Toast.makeText(this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
            } else if (secondNum1.equals(""))
                resulttv.setText("Please Enter Second Number");
                //Toast.makeText(this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();

            else {
                double firstNum = Double.parseDouble(firstNum1);

                double secondNum = Double.parseDouble(secondNum1);

                double result = firstNum / secondNum;
                String res = String.valueOf(result);
                resulttv.setText(res);
            }
        }

    }


}
