package com.claculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class CalculatorActivity extends AppCompatActivity {

    private StringBuilder calc = new StringBuilder();
    char[] operation = {'+', '-', '×', '/'};
    char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    private TextView calcText;
    private TextView resultText;
    private ViewFlipper vf;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button plus;
    private Button minus;
    private Button multiply;
    private Button divide;
    private Button clear;
    private Button delete;
    private Button equal;
    private Button percentage;
    private Button change;

    private Button one2;
    private Button two2;
    private Button three2;
    private Button four2;
    private Button five2;
    private Button six2;
    private Button seven2;
    private Button eight2;
    private Button nine2;
    private Button zero2;
    private Button plus2;
    private Button minus2;
    private Button multiply2;
    private Button divide2;
    private Button clear2;
    private Button delete2;
    private Button equal2;
    private Button percentage2;
    private Button change2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        calcText = findViewById(R.id.tf_calc);
        resultText = findViewById(R.id.tf_result);
        vf = (ViewFlipper) findViewById(R.id.vf_button);

        calcText.setText("");
        resultText.setText("");

        one = (Button) findViewById(R.id.button_One);
        two = (Button) findViewById(R.id.button_Two);
        three = (Button) findViewById(R.id.button_Three);
        four = (Button) findViewById(R.id.button_Four);
        five = (Button) findViewById(R.id.button_Five);
        six = (Button) findViewById(R.id.button_Six);
        seven = (Button) findViewById(R.id.button_Seven);
        eight = (Button) findViewById(R.id.button_Eight);
        nine = (Button) findViewById(R.id.button_Nine);
        zero = (Button) findViewById(R.id.button_Zero);
        plus = (Button) findViewById(R.id.button_Plus);
        minus = (Button) findViewById(R.id.button_Minus);
        multiply = (Button) findViewById(R.id.button_Multiply);
        divide = (Button) findViewById(R.id.button_Divide);
        percentage = (Button) findViewById(R.id.button_Percentage);
        equal = (Button) findViewById(R.id.button_Equal);
        clear = (Button) findViewById(R.id.button_Clear);
        delete = (Button) findViewById(R.id.button_Delete);
        change = (Button) findViewById(R.id.button_Change);

        one2 = (Button) findViewById(R.id.button_One2);
        two2 = (Button) findViewById(R.id.button_Two2);
        three2 = (Button) findViewById(R.id.button_Three2);
        four2 = (Button) findViewById(R.id.button_Four2);
        five2 = (Button) findViewById(R.id.button_Five2);
        six2 = (Button) findViewById(R.id.button_Six2);
        seven2 = (Button) findViewById(R.id.button_Seven2);
        eight2 = (Button) findViewById(R.id.button_Eight2);
        nine2 = (Button) findViewById(R.id.button_Nine2);
        zero2 = (Button) findViewById(R.id.button_Zero2);
        plus2 = (Button) findViewById(R.id.button_Plus2);
        minus2 = (Button) findViewById(R.id.button_Minus2);
        multiply2 = (Button) findViewById(R.id.button_Multiply2);
        divide2 = (Button) findViewById(R.id.button_Divide2);
        percentage2 = (Button) findViewById(R.id.button_Percentage2);
        equal2 = (Button) findViewById(R.id.button_Equal2);
        clear2 = (Button) findViewById(R.id.button_Clear2);
        delete2 = (Button) findViewById(R.id.button_Delete2);
        change2 = (Button) findViewById(R.id.button_Change2);


        one.setOnClickListener(this::onOneClick);
        one2.setOnClickListener(this::onOneClick);

        two.setOnClickListener(this::onTwoClick);
        two2.setOnClickListener(this::onTwoClick);

        three.setOnClickListener(this::onThreeClick);
        three2.setOnClickListener(this::onThreeClick);

        four.setOnClickListener(this::onFourClick);
        four2.setOnClickListener(this::onFourClick);

        five.setOnClickListener(this::onFiveClick);
        five2.setOnClickListener(this::onFiveClick);

        six.setOnClickListener(this::onSixClick);
        six2.setOnClickListener(this::onSixClick);

        seven.setOnClickListener(this::onSevenClick);
        seven2.setOnClickListener(this::onSevenClick);

        eight.setOnClickListener(this::onEightClick);
        eight2.setOnClickListener(this::onEightClick);

        nine.setOnClickListener(this::onNineClick);
        nine2.setOnClickListener(this::onNineClick);

        zero.setOnClickListener(this::onZeroClick);
        zero2.setOnClickListener(this::onZeroClick);

        plus.setOnClickListener(this::onPlusClick);
        plus2.setOnClickListener(this::onPlusClick);

        minus.setOnClickListener(this::onMinusClick);
        minus2.setOnClickListener(this::onMinusClick);

        multiply.setOnClickListener(this::onMultiplyClick);
        multiply2.setOnClickListener(this::onMultiplyClick);

        divide.setOnClickListener(this::onDivideClick);
        divide2.setOnClickListener(this::onDivideClick);

        percentage.setOnClickListener(this::onPercentageClick);
        percentage2.setOnClickListener(this::onPercentageClick);

        equal.setOnClickListener(this::onEqualClick);
        equal2.setOnClickListener(this::onEqualClick);

        clear.setOnClickListener(this::onClearClick);
        clear2.setOnClickListener(this::onClearClick);

        delete.setOnClickListener(this::onDeleteClick);
        delete2.setOnClickListener(this::onDeleteClick);

        change.setOnClickListener(this::changeView);
        change2.setOnClickListener(this::changeView);
    }

    private void onOneClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            calc.append("1");
            updateCalc();
        }
    }

    private void onTwoClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            calc.append("2");
            updateCalc();
        }
    }

    private void onThreeClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            calc.append("3");
            updateCalc();
        }
    }

    private void onFourClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            calc.append("4");
            updateCalc();
        }
    }

    private void onFiveClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            calc.append("5");
            updateCalc();
        }
    }

    private void onSixClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            calc.append("6");
            updateCalc();
        }
    }

    private void onSevenClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            calc.append("7");
            updateCalc();
        }
    }

    private void onEightClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            calc.append("8");
            updateCalc();
        }
    }

    private void onNineClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            calc.append("9");
            updateCalc();
        }
    }

    private void onZeroClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            calc.append("0");
            updateCalc();
        }
    }

    private void onPlusClick(View view) {
        if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
            calc.append("+");
            updateCalc();
        }
    }

    private void onMinusClick(View view) {
        if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
            calc.append("-");
            updateCalc();
        }
    }

    private void onMultiplyClick(View view) {
        if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
            calc.append("×");
            updateCalc();
        }
    }

    private void onDivideClick(View view) {
        if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
            calc.append("/");
            updateCalc();
        }
    }

    private void onPercentageClick(View view) {
        //if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
        //calc.append("%");
        //updateCalc();
        //}
    }

    private void onEqualClick(View view) {
        if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
            evaluate();
        }
    }

    private void onClearClick(View view) {
        if (calc.length() != 0) {
            calc.setLength(0);
            calcText.setText("");
            resultText.setText("");
        }
    }

    private void onDeleteClick(View view) {
        if(calc.length() > 0){
            calc.deleteCharAt(calc.length() - 1);
            updateCalc();
        }
    }

    public void changeView(View view) {
        System.out.println("HEY");
        switch (vf.getDisplayedChild()){
            case 0:
                vf.setDisplayedChild(1);
                break;
            case 1:
                vf.setDisplayedChild(0);
                break;
        }
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