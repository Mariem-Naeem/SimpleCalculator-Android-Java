package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    TextView txt_res;
    Button op_minus, op_plus, op_multiply, op_div, op_del, op_equal;

    private String num1 = "";
    private String num2 = "";
    private char op;
    private boolean isOpPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        txt_res = findViewById(R.id.txt_num);

        op_minus = findViewById(R.id.op_minus);
        op_del = findViewById(R.id.btn_del);
        op_div = findViewById(R.id.op_div);
        op_equal = findViewById(R.id.btn_equal);
        op_multiply = findViewById(R.id.op_multiply);
        op_plus = findViewById(R.id.op_plus);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberInput("0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberInput("1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberInput("2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberInput("3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberInput("4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberInput("5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberInput("6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberInput("7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberInput("8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberInput("9");
            }
        });


        op_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperation('+');
            }
        });
        op_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperation('*');
            }
        });
        op_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperation('/');
            }
        });
        op_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperation('-');
            }
        });


        op_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });

        op_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearCalculator();
            }
        });
    }

    private void handleNumberInput(String number) {
        if (isOpPressed) {
            num2 += number;
        } else {
            num1 += number;
        }
        txt_res.setText(num1 + " " + op + " " + num2);
    }

    private void handleOperation(char operation) {
        if (!num1.isEmpty()) {
            op = operation;
            isOpPressed = true;
            txt_res.setText(num1 + " " + op);
        }
    }

    private void calculateResult() {
        double result = 0;
        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);

        switch (op) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                if (n2 != 0) {
                    result = n1 / n2;
                } else {
                    txt_res.setText("Error: Division by zero");
                    return;
                }
                break;
        }
        txt_res.setText(String.valueOf(result));
    }

    private void clearCalculator() {
        num1 = "";
        num2 = "";
        op = '\0';
        isOpPressed = false;
        txt_res.setText("");
    }
}
