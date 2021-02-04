package com.claculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.Stack;

public class CalculatorActivity extends AppCompatActivity {

    private StringBuilder calc = new StringBuilder();
    char[] operation = {'+', '-', '×', '/'};
    char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.'};
    private boolean equalsWasPressed;
    private boolean clearWhenNextIsNumber;

    private TextView calcText;
    private TextView resultText;
    private ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        calcText = findViewById(R.id.tf_calc);
        resultText = findViewById(R.id.tf_result);
        vf = findViewById(R.id.vf_button);

        calcText.setText("");
        resultText.setText("");

        Button one = findViewById(R.id.button_One);
        Button two = findViewById(R.id.button_Two);
        Button three = findViewById(R.id.button_Three);
        Button four = findViewById(R.id.button_Four);
        Button five = findViewById(R.id.button_Five);
        Button six = findViewById(R.id.button_Six);
        Button seven = findViewById(R.id.button_Seven);
        Button eight = findViewById(R.id.button_Eight);
        Button nine = findViewById(R.id.button_Nine);
        Button zero = findViewById(R.id.button_Zero);
        Button plus = findViewById(R.id.button_Plus);
        Button minus = findViewById(R.id.button_Minus);
        Button multiply = findViewById(R.id.button_Multiply);
        Button divide = findViewById(R.id.button_Divide);
        Button percentage = findViewById(R.id.button_Percentage);
        Button equal = findViewById(R.id.button_Equal);
        Button dot = findViewById(R.id.button_Dot);
        Button clear = findViewById(R.id.button_Clear);
        Button delete = findViewById(R.id.button_Delete);
        Button change = findViewById(R.id.button_Change);

        Button one2 = findViewById(R.id.button_One2);
        Button two2 = findViewById(R.id.button_Two2);
        Button three2 = findViewById(R.id.button_Three2);
        Button four2 = findViewById(R.id.button_Four2);
        Button five2 = findViewById(R.id.button_Five2);
        Button six2 = findViewById(R.id.button_Six2);
        Button seven2 = findViewById(R.id.button_Seven2);
        Button eight2 = findViewById(R.id.button_Eight2);
        Button nine2 = findViewById(R.id.button_Nine2);
        Button zero2 = findViewById(R.id.button_Zero2);
        Button plus2 = findViewById(R.id.button_Plus2);
        Button minus2 = findViewById(R.id.button_Minus2);
        Button multiply2 = findViewById(R.id.button_Multiply2);
        Button divide2 = findViewById(R.id.button_Divide2);
        Button percentage2 = findViewById(R.id.button_Percentage2);
        Button equal2 = findViewById(R.id.button_Equal2);
        Button dot2 = findViewById(R.id.button_Dot2);
        Button clear2 = findViewById(R.id.button_Clear2);
        Button delete2 = findViewById(R.id.button_Delete2);
        Button change2 = findViewById(R.id.button_Change2);


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

        dot.setOnClickListener(this::onDotClick);
        dot2.setOnClickListener(this::onDotClick);

        clear.setOnClickListener(this::onClearClick);
        clear2.setOnClickListener(this::onClearClick);

        delete.setOnClickListener(this::onDeleteClick);
        delete2.setOnClickListener(this::onDeleteClick);

        change.setOnClickListener(this::changeView);
        change2.setOnClickListener(this::changeView);
    }

    private void onOneClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            if (clearWhenNextIsNumber) {
                calc.setLength(0);
                clearWhenNextIsNumber = false;
            }

            calc.append("1");
            updateCalcText();
            updateResult();
        }
    }

    private void onTwoClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            if (clearWhenNextIsNumber) {
                calc.setLength(0);
                clearWhenNextIsNumber = false;
            }

            calc.append("2");
            updateCalcText();
            updateResult();
        }
    }

    private void onThreeClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            if (clearWhenNextIsNumber) {
                calc.setLength(0);
                clearWhenNextIsNumber = false;
            }

            calc.append("3");
            updateCalcText();
            updateResult();
        }
    }

    private void onFourClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            if (clearWhenNextIsNumber) {
                calc.setLength(0);
                clearWhenNextIsNumber = false;
            }

            calc.append("4");
            updateCalcText();
            updateResult();
        }
    }

    private void onFiveClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            if (clearWhenNextIsNumber) {
                calc.setLength(0);
                clearWhenNextIsNumber = false;
            }

            calc.append("5");
            updateCalcText();
            updateResult();
        }
    }

    private void onSixClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            if (clearWhenNextIsNumber) {
                calc.setLength(0);
                clearWhenNextIsNumber = false;
            }

            calc.append("6");
            updateCalcText();
            updateResult();
        }
    }

    private void onSevenClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            if (clearWhenNextIsNumber) {
                calc.setLength(0);
                clearWhenNextIsNumber = false;
            }

            calc.append("7");
            updateCalcText();
            updateResult();
        }
    }

    private void onEightClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            if (clearWhenNextIsNumber) {
                calc.setLength(0);
                clearWhenNextIsNumber = false;
            }

            calc.append("8");
            updateCalcText();
            updateResult();
        }
    }

    private void onNineClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            if (clearWhenNextIsNumber) {
                calc.setLength(0);
                clearWhenNextIsNumber = false;
            }

            calc.append("9");
            updateCalcText();
            updateResult();
        }
    }

    private void onZeroClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            if (clearWhenNextIsNumber) {
                calc.setLength(0);
                clearWhenNextIsNumber = false;
            }

            calc.append("0");
            updateCalcText();
            updateResult();
        }
    }

    private void onPlusClick(View view) {
        if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
            calc.append("+");
            clearWhenNextIsNumber = false;
            updateCalcText();
        }
    }

    private void onMinusClick(View view) {
        if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
            calc.append("-");
            clearWhenNextIsNumber = false;
            updateCalcText();
        }
    }

    private void onMultiplyClick(View view) {
        if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
            calc.append("×");
            clearWhenNextIsNumber = false;
            updateCalcText();
        }
    }

    private void onDivideClick(View view) {
        if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
            calc.append("/");
            clearWhenNextIsNumber = false;
            updateCalcText();
        }
    }

    private void onPercentageClick(View view) {
        //if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
        //calc.append("%");
        //updateCalcText();
        //}
    }

    private void onEqualClick(View view) {
        if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
            equalsWasPressed = true;
            updateResult();
        }
    }

    private void onDotClick(View view) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            calc.append(".");
            updateCalcText();
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
        if (calc.length() > 0) {
            calc.deleteCharAt(calc.length() - 1);
            updateCalcText();
        }
    }

    public void changeView(View view) {
        System.out.println("VIEW CHANGED");
        switch (vf.getDisplayedChild()) {
            case 0:
                vf.setDisplayedChild(1);
                break;
            case 1:
                vf.setDisplayedChild(0);
                break;
        }
    }



    public void updateCalcText() {
        calcText.setText(calc);
    }

    public void updateResult() {
        String expr = calc.toString();

        System.out.println("Expression: ");

        double result = evaluate(expr);
        // To set no X.0 on Screen
        if (result % 1 == 0) {
            int newResult = (int) result;
            resultText.setText("= " + newResult);

            if (equalsWasPressed) {
                calc.setLength(0);
                calc.append(newResult).toString();
                clearWhenNextIsNumber = true;
                equalsWasPressed = false;
            }
        } else {
            System.out.println("result: " + result);
            resultText.setText("= " + result);

            if (equalsWasPressed) {
                calc.setLength(0);
                calc.append(result).toString();
                clearWhenNextIsNumber = true;
                equalsWasPressed = false;
            }
        }

        //System.out.println(EvaluateString.evaluate("10 + 2 × 6"));
        //System.out.println(EvaluateString.evaluate("100 × 2 + 12"));
        //System.out.println(EvaluateString.evaluate("100 × ( 2 + 12 )"));
        //System.out.println(EvaluateString.evaluate("100 × ( 2 + 12 ) / 14"));
    }

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
                while (i < expr.length && expr[i] >= '0' && expr[i] <= '9' || i < expr.length && expr[i] == '.') {
                    //System.out.println("2: " + expr[i]);
                    temp.append(expr[i]);
                    i++;
                }
                System.out.println("2: " + temp.toString());
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
        BigDecimal x1 = new BigDecimal(x);
        BigDecimal y1 = new BigDecimal(y);
        BigDecimal res;

        switch (operator) {
            case '+':
                res = x1.add(y1);
                res = res.setScale(5, BigDecimal.ROUND_HALF_UP);
                result = res.doubleValue();
                break;
            case '-':
                res = x1.subtract(y1);
                res = res.setScale(5, BigDecimal.ROUND_HALF_UP);
                result = res.doubleValue();
                break;
            case '×':
                res = x1.multiply(y1);
                res = res.setScale(5, BigDecimal.ROUND_HALF_UP);
                result = res.doubleValue();
                break;
            case '/':
                if (y == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                } else {
                    res = x1.divide(y1, 6, BigDecimal.ROUND_HALF_UP);
                    result = res.doubleValue();
                    break;
                }
        }
        return result;
    }

    static boolean contains(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }
}
