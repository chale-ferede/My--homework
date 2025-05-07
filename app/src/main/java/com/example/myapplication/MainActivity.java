package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String inputNum = "";
    String operator = "";
    int num1 = 0;
    boolean isNewOp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText("CASIO");

    }

    public void funcButtonClick(View view) {

        Button button = (Button) view;
        String number = button.getText().toString();

        if (isNewOp) {
            inputNum = number;
            isNewOp = false;
        } else {
            inputNum += number;
        }

        textView.setText(inputNum);

    }

    public void funcOperatorClick(View view) {
        num1 = Integer.parseInt(inputNum);
        Button button = (Button) view;
        operator = button.getText().toString();
        textView.setText(inputNum + " " + operator);
        inputNum = "";
    }

    public void funcEqualClick(View view) {

        //int num2 = Integer.parseInt(inputNum);
        double num2=Double.parseDouble(inputNum);
        double res = 0;

        switch (operator) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;

            case "/":
                if (num2 != 0) {
                    res = num1 / num2;
                } else {
                    textView.setText("Error");
                    return;
                }
                break;
        }
        inputNum=(res==(int) res)?String.valueOf((int) res) : String.valueOf(res);
        textView.setText(inputNum);
    }

    public void funcSquareClick(View view) {
        if (inputNum.isEmpty() || inputNum==null) {
            textView.setText("0");
            return;
        }
        try {


            double num = Double.parseDouble(inputNum);

            if (num < 0) {
                textView.setText("Error");
                return;
            }
            double res = Math.sqrt(num);
            if(res==(int) res) {
                inputNum = String.valueOf((int)res);
            }
            else {
                inputNum=String.valueOf(res);
            }
            textView.setText(String.valueOf(inputNum));
        } catch (NumberFormatException e) {
            textView.setText("Error");
        }
    }

            public void funcOnClick (View view){
                textView.setVisibility(View.VISIBLE);
                textView.setText("CASIO");
                inputNum = "";
                num1 = 0;
                operator = "";

            }


            public void funcOffClick (View view){
                textView.setVisibility(View.INVISIBLE);
                inputNum = "";
                num1 = 0;
                operator = "";

            }


            public void funcDeleteClick (View view){

                inputNum = inputNum.substring(0, inputNum.length() - 1);
                textView.setText(inputNum.isEmpty() ? "0" : inputNum);


            }

            public void funcExponentClick (View view){
                if (!inputNum.contains(".")) {
                    inputNum += ".";
                    textView.setText(inputNum);
                }
            }



    }