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
    String inputValue	 = "";
    String operator = "";
    int num1 = 0;
    boolean isNewOp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        textView.setText("0");

    }

    public void funcButtonClick(View view) {

        Button button = (Button) view;
        String number = button.getText().toString();

        if (isNewOp) {
            inputValue	 = number;
            isNewOp = false;
        } else {
            inputValue	+= number;
        }

        textView.setText(inputValue	);

    }

    public void funcOperatorClick(View view) {
        num1=Integer.parseInt(inputValue);
        Button button = (Button) view;
        operator = button.getText().toString();
        textView.setText(inputValue	 + " " + operator);
        inputValue	 = "";
    }

    public void funcEqualClick(View view) {

      int num2 = Integer.parseInt(inputValue);
      int result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2; break;

            case "/":
                if(num2 !=0) {
                    result = num1 / num2;
                }
                else {
              textView.setText("Error");
              return;
                }
                break;
        }

       textView .setText(String.valueOf(result));
    }
   public  void funcSquareRootClick(View view){
       num1 = Integer.parseInt(inputValue);
       if (num1 < 0) return;

       double result = Math.sqrt(num1);

       if (result == (int) result) {
           textView.setText(String.valueOf((int) result));
           inputValue	 = String.valueOf((int) result);
       } else {
           textView.setText(String.valueOf(result));
           inputValue	 = String.valueOf(result);
       }


   }

    public void funcOnClick(View view) {
        textView.setVisibility(View.VISIBLE);
        textView.setText("0");
        inputValue	 = "";
        num1 = 0;
        operator="";

    }


    public void funcOffClick(View view) {
        textView.setVisibility(View.INVISIBLE);
        inputValue	 = "";
        num1 = 0;
        operator = "";

    }


    public void funcDeleteClick(View view) {

        inputValue	 = inputValue	.substring(0, inputValue	.length() - 1);
        textView.setText(inputValue	.isEmpty() ? "0" : inputValue	);


    }

    public void funcDotClick(View view) {
        if (!inputValue	.contains(".")) {
            inputValue	 += ".";
            textView.setText(inputValue	);
        }
    }




    public void funcClearClick(View view) {

        textView.setText("0");
        inputValue	 = "";
        num1 = 0;
        operator = "";

    }



    }