package com.example.fanto.calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button clearButton, delButton, dotButton, equalButton,
            plusButton, minusButton, multiplyButton, divideButton, modulusButton,
            zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton;

    String mainText = "", resultString = "", op = "";
    Float value1, value2, result;
    String[] values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);

        clearButton = (Button) findViewById(R.id.clear_button);
        delButton = (Button) findViewById(R.id.del_button);
        dotButton = (Button) findViewById(R.id.dot_button);
        equalButton = (Button) findViewById(R.id.equal_button);

        plusButton = (Button) findViewById(R.id.plus_button);
        minusButton = (Button) findViewById(R.id.minus_button);
        multiplyButton = (Button) findViewById(R.id.multiply_button);
        divideButton = (Button) findViewById(R.id.divide_button);
        modulusButton = (Button) findViewById(R.id.modulus_button);

        zeroButton = (Button) findViewById(R.id.zero_button);
        oneButton = (Button) findViewById(R.id.one_button);
        twoButton = (Button) findViewById(R.id.two_button);
        threeButton = (Button) findViewById(R.id.three_button);
        fourButton = (Button) findViewById(R.id.four_button);
        fiveButton = (Button) findViewById(R.id.five_button);
        sixButton = (Button) findViewById(R.id.six_button);
        sevenButton = (Button) findViewById(R.id.seven_button);
        eightButton = (Button) findViewById(R.id.eight_button);
        nineButton = (Button) findViewById(R.id.nine_button);


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAll();
            }
        });

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLastChar();
            }
        });

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equal();
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operators("+");
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operators("-");
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operators("*");
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operators("/");
            }
        });

        modulusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operators("%");
            }
        });

        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dotOperator(".");
            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypad("0");
            }
        });

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypad("1");
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypad("2");
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypad("3");
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypad("4");
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypad("5");
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypad("6");
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypad("7");
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypad("8");
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keypad("9");
            }
        });
    }

    private void dotOperator(String s) {
        textView.setTextColor(Color.parseColor("#000000"));
        textView.append(s);
    }

    private void equal() {
        mainText = textView.getText().toString();

        if (mainText.length() > 1) {
            if (!op.isEmpty()) {
                if (!mainText.substring(mainText.length() - 1).equals(op)) {
                    if (resultString.isEmpty()) {

                        calculation();

                        resultString = String.valueOf(result);
                        textView.append("\n=");
                        textView.append(resultString);
                        textView.setTextColor(Color.parseColor("#4CAF50"));
                    }
                }
            }
        }
    }

    private void calculation() {
        values = mainText.split(Pattern.quote(op));

        value1 = Float.parseFloat(values[0]);
        value2 = Float.parseFloat(values[1]);


        switch (op) {
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "*":
                result = value1 * value2;
                break;
            case "/":
                result = value1 / value2;
                break;
            case "%":
                result = value1 % value2;
                break;
        }
    }


    private void operators(String s) {
        mainText = textView.getText().toString();
        textView.setTextColor(Color.parseColor("#000000"));
        if (!op.isEmpty()) {
            if (!resultString.isEmpty()) {
                textView.setText(resultString);
                resultString = "";
                textView.append(s);
                op = s;
            } else {
                if (mainText.substring(mainText.length() - 1).equals(op)) {
                    mainText = mainText.substring(0, mainText.length() - 1);
                    textView.setText(mainText);
                    textView.append(s);
                    op = s;
                } else {
                    calculation();
                    resultString = String.valueOf(result);
                    textView.setText(resultString);
                    textView.append(s);
                    textView.setTextColor(Color.parseColor("#4CAF50"));
                    resultString = "";
                    op = s;
                }
            }
        } else {
            textView.append(s);
            op = s;
        }
    }

    private void keypad(String s) {
        mainText = textView.getText().toString();
        textView.setTextColor(Color.parseColor("#000000"));
        if (mainText.equals("0")) {
            textView.setText(s);
        } else if (!resultString.isEmpty()) {
            textView.setText(s);
            resultString = "";
            op = "";
        } else {
            textView.append(s);
        }
    }

    private void deleteLastChar() {
        mainText = textView.getText().toString();
        textView.setTextColor(Color.parseColor("#000000"));
        if (mainText.length() > 1) {
            if (!resultString.isEmpty()) {
                textView.setText(resultString);
                resultString = "";
                op = "";
            } else {
                if (!op.isEmpty()) {
                    if (mainText.substring(mainText.length() - 1).equals(op)) {
                        mainText = mainText.substring(0, mainText.length() - 1);
                        textView.setText(mainText);
                        op = "";
                    } else {
                        mainText = mainText.substring(0, mainText.length() - 1);
                        textView.setText(mainText);
                    }
                } else {
                    mainText = mainText.substring(0, mainText.length() - 1);
                    textView.setText(mainText);
                }
            }
        } else {
            textView.setText("0");
        }
    }

    private void clearAll() {
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setText("0");
        mainText = resultString = op = "";
    }
}