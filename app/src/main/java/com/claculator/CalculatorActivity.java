package com.claculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class CalculatorActivity extends AppCompatActivity {

    private StringBuilder calc = new StringBuilder();
    char[] operation = {'+', '-', '×', '/'};
    char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    private TextView calcText;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        calcText = findViewById(R.id.tf_calc);
        resultText = findViewById(R.id.tf_result);

        calcText.setText("");
        resultText.setText("");

        final Button one = findViewById(R.id.button_One);
        final Button two = findViewById(R.id.button_Two);
        final Button three = findViewById(R.id.button_Three);
        final Button four = findViewById(R.id.button_Four);
        final Button five = findViewById(R.id.button_Five);
        final Button six = findViewById(R.id.button_Six);
        final Button seven = findViewById(R.id.button_Seven);
        final Button eight = findViewById(R.id.button_Eight);
        final Button nine = findViewById(R.id.button_Nine);
        final Button zero = findViewById(R.id.button_Zero);
        final Button doubleZero = findViewById(R.id.button_DoubleZero);
        final Button plus = findViewById(R.id.button_Plus);
        final Button minus = findViewById(R.id.button_Minus);
        final Button multiply = findViewById(R.id.button_Multiply);
        final Button divide = findViewById(R.id.button_Divide);
        final Button clear = findViewById(R.id.button_Clear);
        final Button equal = findViewById(R.id.button_Equal);

        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
                    calc.append("1");
                    updateCalc();
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
                    calc.append("2");
                    updateCalc();
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
                    calc.append("3");
                    updateCalc();
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
                    calc.append("4");
                    updateCalc();
                }
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
                    calc.append("5");
                    updateCalc();
                }
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
                    calc.append("6");
                    updateCalc();
                }
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
                    calc.append("7");
                    updateCalc();
                }
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
                    calc.append("8");
                    updateCalc();
                }
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
                    calc.append("9");
                    updateCalc();
                }
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
                    calc.append("0");
                    updateCalc();
                }
            }
        });
        doubleZero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
                    calc.append("00");
                    updateCalc();
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
                    calc.append("+");
                    updateCalc();
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
                    calc.append("-");
                    updateCalc();
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
                    calc.append("×");
                    updateCalc();
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
                    calc.append("/");
                    updateCalc();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() != 0) {
                    calc.setLength(0);
                    resultText.setText("");
                    updateCalc();
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
                    evaluate();
                }
            }
        });
    }

    static boolean contains(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }

    public void updateCalc() {
        System.out.println("Calculation: " + calc);
        calcText.setText(calc);
    }

    public void evaluate() {
        //String[] exp = calc.toString().split("(?<=[-+×/])|(?=[-+×/])");

        String expr = calc.toString();

        System.out.println("To evaluate: ");

        double result = EvaluateString.evaluate(expr);
        // To set no X.0 on Screen
        if (result % 1 == 0) {
            int newResult = (int) result;
            resultText.setText(String.valueOf(newResult));
        } else {
            resultText.setText(String.valueOf(result));
        }

        System.out.println(EvaluateString.evaluate("10 + 2 × 6"));
        System.out.println(EvaluateString.evaluate("100 × 2 + 12"));
        System.out.println(EvaluateString.evaluate("100 × ( 2 + 12 )"));
        System.out.println(EvaluateString.evaluate("100 × ( 2 + 12 ) / 14"));
    }
}

class EvaluateString {
    public static double evaluate(String input) {
        char[] expr = input.toCharArray();

        System.out.print("Expression in evaluate: ");
        for (int i = 0; i < expr.length; i++) {
            System.out.print(expr[i]);
        }
        System.out.println("");

        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expr.length; i++) {
            //System.out.println("0: " + expr[i]);

            // if Number
            if (expr[i] >= '0' && expr[i] <= '9') {
                StringBuilder temp = new StringBuilder();
                //System.out.println("1: " + expr[i]);

                // if Number.size >= 1 -> add
                while (i < expr.length && expr[i] >= '0' && expr[i] <= '9') {
                    //System.out.println("2: " + expr[i]);
                    temp.append(expr[i]);
                    i++;
                }
                numbers.push(Double.parseDouble(temp.toString()));
                i--; // to correct the offset again
            }

            // Opening brace
            else if (expr[i] == '(') {
                operators.push(expr[i]);
            }

            // Closing brace
            else if (expr[i] == ')') {
                while (operators.peek() != '(') {
                    numbers.push(calculate(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.pop();
            }

            // Current token is an operator.
            else if (expr[i] == '+' || expr[i] == '-' || expr[i] == '×' || expr[i] == '/') {

                while (!operators.empty() && hasPrecedence(expr[i], operators.peek())) {
                    numbers.push(calculate(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(expr[i]); // push current operator
            }
        }

        // Entire expression has been
        // parsed at this point, apply remaining
        // operators to remaining values
        while (!operators.empty())
            numbers.push(calculate(operators.pop(),
                    numbers.pop(),
                    numbers.pop()));

        // Top of 'values' contains
        // result, return it
        return numbers.pop();
    }

    // true if lastOperator >= operator1
    public static boolean hasPrecedence(char currentOperator, char lastOperator) {
        if (lastOperator == '(' || lastOperator == ')') { // operator after '(' or ')'
            return false;
        }
        if ((currentOperator == '×' || currentOperator == '/') && (lastOperator == '+' || lastOperator == '-')) { //
            return false;
        } else {
            return true;
        }
    }

    public static double calculate(char operator, double y, double x) {
        double result = 0;
        switch (operator) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '×':
                result = x * y;
                break;
            case '/':
                if (y == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                } else {
                    result = x / y;
                    break;
                }
        }
        return result;
    }
}