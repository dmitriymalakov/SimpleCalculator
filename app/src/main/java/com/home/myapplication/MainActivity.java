package com.home.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;


    private Button[] btns = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0};
    private int[] btnsId = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
                            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn0};

    private Button btn_plus;
    private Button multi;
    private Button minus;
    private Button divide;
    private Button percent;

    private Button[] signS = {btn_plus, minus, multi, divide, percent};
    private int[] signId = {R.id.btn_plus, R.id.btn_minus, R.id.btn_multi, R.id.divide, R.id.percent};

    private Button resultBtn;
    private Button ceBtn;
    private Button pixel;

    private EditText num1Et;
    private EditText num2Et;
    private TextView signTv;
    private TextView totalTv;

    private String num1Str = "";
    private String num2Str = "";
    private String sign = "";
    private double totall = 0;

    Operation oper = new Operation();


    private View.OnClickListener numBtnsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (num1Et.isFocused()) {
                num1Str += ((Button) v).getText().toString();
                num1Et.setText(num1Str);
            } else if(num2Et.isFocused()) {
                num2Str += ((Button) v).getText().toString();
                num2Et.setText(num2Str);
            }
        }
    };

    private View.OnClickListener signButtonsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sign = ((Button) v).getText().toString();
            signTv.setText(sign);
            print(sign);
        }
    };

    private View.OnClickListener buttonCeCLickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signTv.setText("");
            num1Et.setText("");
            num1Str = "";
            num2Et.setText("");
            num2Str = "";
            totalTv.setText("");

        }
    };

    private View.OnClickListener signTotallClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (sign.equals("")) {
                totalTv.setText("");

            } else if (sign.equals("/") && num2Str.equals("0")) {
                num2Et.setText("Can`t be = zero");
                totalTv.setText("Can't divide on zero");

            } else {

                totalTv.setText(resultOfSign() + "");

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button of view zone
        num1Et = (EditText) findViewById(R.id.num1);
        num2Et = (EditText) findViewById(R.id.num_2);
        signTv = (TextView) findViewById(R.id.znak);
        totalTv = (TextView) findViewById(R.id.total);

        // Button clear & aquals
        resultBtn = (Button) findViewById(R.id.result);
        ceBtn = (Button) findViewById(R.id.btn_Ce);
        resultBtn.setOnClickListener(signTotallClickListener);
        ceBtn.setOnClickListener(buttonCeCLickListener);

        // Disable keyboard
        num1Et.setKeyListener(null);
        num2Et.setKeyListener(null);

        setupNumButtons();
        setupSignButtons();
    }

    private void setupNumButtons() {
        for (int i = 0; i < btns.length; i++) {
            btns[i] = (Button) findViewById(btnsId[i]);
        }

        for (Button btn: btns) {
            btn.setOnClickListener(numBtnsClickListener);
        }
    }

    private void setupSignButtons() {
        for(int i = 0; i < signS.length; i++) {
            signS[i] = (Button) findViewById(signId[i]);
        }

        for (Button btn: signS) {
            btn.setOnClickListener(signButtonsClickListener);
        }
    }

    private double resultOfSign() {

        double result = 0;

        switch (signTv.getText().toString()) {
            case "+":
                result = oper.add(num1Str,num2Str);
                break;

            case "-":
                result = oper.subtract(num1Str,num2Str);
                break;

            case "*":
                result = oper.multi(num1Str,num2Str);
                break;

            case "/":
                if (num2Str.equals("0")){
                    num2Et.setText("Can't / on zero");
                    totalTv.setText("Can`t divide on 0");
                } else {
                    result = oper.divide(num1Str,num2Str);
                    break;
                }

            case "%":
                    result = oper.percent(num1Str,num2Str);
                    break;

        } return result;
    }

    private void print(String s) {
        Log.wtf("MainActivity", s);
    }

}



