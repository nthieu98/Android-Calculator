package com.example.calculator;

import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    EditText editText;

    int state;
    int op1, op2;
    int op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txtSolution);

        Typeface tf = Typeface.createFromAsset(getAssets(), "font/digital.ttf");
        textView.setTypeface(tf);
        state = 1;
        op1 = 0;
        op2 = 0;
        op = 0;

        textView.setText(String.valueOf(op1));

        findViewById(R.id.btnZero).setOnClickListener(this);
        findViewById(R.id.btnOne).setOnClickListener(this);
        findViewById(R.id.btnTwo).setOnClickListener(this);
        findViewById(R.id.btnThree).setOnClickListener(this);
        findViewById(R.id.btnFour).setOnClickListener(this);
        findViewById(R.id.btnFive).setOnClickListener(this);
        findViewById(R.id.btnSix).setOnClickListener(this);
        findViewById(R.id.btnSeven).setOnClickListener(this);
        findViewById(R.id.btnEight).setOnClickListener(this);
        findViewById(R.id.btnNine).setOnClickListener(this);

        findViewById(R.id.btnPlus).setOnClickListener(this);
        findViewById(R.id.btnMinus).setOnClickListener(this);
        findViewById(R.id.btnMultiply).setOnClickListener(this);
        findViewById(R.id.btnDivide).setOnClickListener(this);
        findViewById(R.id.btnEqual).setOnClickListener(this);

        findViewById(R.id.btnCE).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnDel).setOnClickListener(this);
        findViewById(R.id.btnSign).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnZero) {
            addValue(0);
        } else if (id == R.id.btnOne) {
            addValue(1);
        } else if (id == R.id.btnTwo) {
            addValue(2);
        } else if (id == R.id.btnThree) {
            addValue(3);
        } else if (id == R.id.btnFour) {
            addValue(4);
        } else if (id == R.id.btnFive) {
            addValue(5);
        } else if (id == R.id.btnSix) {
            addValue(6);
        } else if (id == R.id.btnSeven) {
            addValue(7);
        } else if (id == R.id.btnEight) {
            addValue(8);
        } else if (id == R.id.btnNine) {
            addValue(9);
        } else if (id == R.id.btnPlus) {
            changeState(1);
        }  else if (id == R.id.btnMinus) {
            changeState(2);
        } else if (id == R.id.btnMultiply) {
            changeState(3);
        }  else if (id == R.id.btnDivide) {
            changeState(4);
        } else if (id == R.id.btnEqual) {
            calculateResult();
        } else if (id == R.id.btnCE) {
            // Xoa toan hang hien tai
            clearOperand();
        }  else if (id == R.id.btnClear) {
            // Xoa phep tinh
            clearOperator();
        } else if (id == R.id.btnDel) {
            // Xoa chu so hang don vi
            removeDigit();
        } else if (id == R.id.btnSign) {
            inverseOperand();
        }
    }

    private void inverseOperand() {
        if (state == 1) {
            op1 = -op1;
            textView.setText(String.valueOf(op1));
        } else {
            op2 = -op2;
            textView.setText(String.valueOf(op2));
        }
    }

    private void removeDigit() {
        if (state == 1) {
            op1 = op1 / 10;
            textView.setText(String.valueOf(op1));
        } else {
            op2 = op2 / 10;
            textView.setText(String.valueOf(op2));
        }
    }

    private void clearOperand() {
        if (state == 1)
            op1 = 0;
        else
            op2 = 0;

        textView.setText("0");
    }

    private void clearOperator() {
        state = 1;
        op1 = 0;
        op2 = 0;
        textView.setText("0");
    }

    private void calculateResult() {
        int result;
        if (op == 1)
            result = op1 + op2;
        else if (op == 2)
            result = op1 - op2;
        else if (op == 3)
            result = op1 * op2;
        else
            result = op1 / op2;

        textView.setText(String.valueOf(result));

        state = 1;
        op1 = result;
        op2 = 0;
    }

    private void changeState(int selectedOP) {
        if(op2 != 0) {
            calculateResult();
        }
        op = selectedOP;
        state = 2;

        //textView.setText(String.valueOf(op2));
    }

    private void addValue(int value) {
        if (state == 1) {
            op1 = op1 * 10 + value;
            textView.setText(String.valueOf(op1));
        } else {
            op2 = op2 * 10 + value;
            textView.setText(String.valueOf(op2));
        }
    }


}

