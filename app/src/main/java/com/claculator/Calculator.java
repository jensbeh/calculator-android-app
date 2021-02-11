package com.claculator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Stack;

public class Calculator extends MainActivity {

    public static String evaluate(String input) {
        StringBuilder parsedinput = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i == 0 && input.charAt(i) == '-') {
                parsedinput.append("0-");
                System.out.println("A");

            }
            else if (i > 0 && input.charAt(i) == '-' && input.charAt(i-1) == '(') { // (-
                parsedinput.append("0-");
                System.out.println("B");

            }
            else if (input.charAt(i) == '-' && input.charAt(i+1) == '(') { // -( -> -1x(
                parsedinput.append("-1×");
                System.out.println("C");

            }
            else if (input.charAt(i) == '-' && (input.charAt(i-1) == '+' || input.charAt(i-1) == '-' || input.charAt(i-1) == '×' || input.charAt(i-1) == '÷')) { // -( -> -1x(
                parsedinput.append("-1×");
                System.out.println("C");

            }
            else if (input.length() > i+2 && MainActivity.contains(input.charAt(i), new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'}) && input.charAt(i+1) == '(') { // 3( -> 3x(
                parsedinput.append(input.charAt(i) + "×");
                System.out.println("TEST");

            } else {
                parsedinput.append(input.charAt(i));
                System.out.println("D");

            }
            System.out.println("step: " + parsedinput);
        }

        char[] expr = parsedinput.toString().toCharArray();

        System.out.print("Expression: ");
        for (int i = 0; i < expr.length; i++) {
            System.out.print(expr[i]);
        }
        System.out.println("");


        Stack<String> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expr.length; i++) {
            //System.out.println("0: " + expr[i]);

            // if Number
            if (expr[i] >= '0' && expr[i] <= '9') {
                StringBuilder temp = new StringBuilder();
                //System.out.println("1: " + expr[i]);

                // if Number.size >= 1 -> add
                while (i < expr.length && (expr[i] >= '0' && expr[i] <= '9' || expr[i] == '.')) {
                    //System.out.println("2: " + expr[i]);
                    temp.append(expr[i]);
                    i++;
                }
                //System.out.println("2: " + temp.toString());
                numbers.push(String.valueOf(temp));
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
            else if (expr[i] == '+' || expr[i] == '-' || expr[i] == '×' || expr[i] == '÷') {

                while (!operators.empty() && hasPrecedence(expr[i], operators.peek())) {
                    numbers.push(calculate(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(expr[i]); // push current operator
            }
        }

        // Entire expression has been
        // parsed at this point, apply remaining
        // operators to remaining values
        while (!operators.empty()) {
            numbers.push(calculate(operators.pop(), numbers.pop(), numbers.pop()));
        }
        // Top of 'values' contains
        // result, return it
        return numbers.pop();
    }

    // true if lastOperator >= operator1
    public static boolean hasPrecedence(char currentOperator, char lastOperator) {
        if (lastOperator == '(' || lastOperator == ')') { // operator after '(' or ')'
            return false;
        }
        if ((currentOperator == '×' || currentOperator == '÷') && (lastOperator == '+' || lastOperator == '-')) { //
            return false;
        } else {
            return true;
        }
    }

    public static String calculate(char operator, String y, String x) {
        String result = "";
        BigDecimal x1 = new BigDecimal(x);
        BigDecimal y1 = new BigDecimal(y);
        BigDecimal res = new BigDecimal(BigInteger.ZERO);

        //System.out.println("xStr: " + x);

        int index = 0;
        int lengthDigitsY = 0;
        int lengthDigitsX = 0;

        if (y.contains(".")) {
            index = y.indexOf(".");
            for (int i = 0; i < y.length(); i++) {
                lengthDigitsY = y.length() - (index + 1);
            }
        }

        if (x.contains(".")) {
            index = x.indexOf(".");
            for (int i = 0; i < x.length(); i++) {
                lengthDigitsX = x.length() - (index + 1);
            }
        }

        //System.out.println("YdigitsCount: " + lengthDigitsY);
        //System.out.println("XdigitsCount: " + lengthDigitsX);

        int scale = 0;
        switch (operator) {

            case '+':
                if (lengthDigitsX >= lengthDigitsY) {
                    scale = lengthDigitsX;
                } else {
                    scale = lengthDigitsY;
                }
                if (scale >= 16) {
                    scale = 16;
                }
                res = x1.add(y1);
                res = res.setScale(scale, BigDecimal.ROUND_HALF_UP);
                break;

            case '-':
                if (lengthDigitsX >= lengthDigitsY) {
                    scale = lengthDigitsX;
                } else {
                    scale = lengthDigitsY;
                }
                if (scale >= 16) {
                    scale = 16;
                }
                res = x1.subtract(y1);
                res = res.setScale(scale, BigDecimal.ROUND_HALF_UP);
                break;

            case '×':
                scale = lengthDigitsX + lengthDigitsY;
                res = x1.multiply(y1);
                res = res.setScale(scale, BigDecimal.ROUND_HALF_UP);
                break;

            case '÷':

                if (y.equals("0")) {
                    setNullDivisionError(true);
                } else {
                    res = x1.divide(y1, 8, BigDecimal.ROUND_HALF_UP);
                    System.out.println("res: " + res.toPlainString());
                    break;
                }
        }

        // if res % 1 == 0 then cut of digits -> 3.0 to 3
        if (res.remainder(new BigDecimal(1)).compareTo(BigDecimal.ZERO) == 0) {
            int newRes = res.intValue();
            result = String.valueOf(newRes);
        } else {
            result = res.toPlainString();
            // delete last 0's
            int resLength = result.length();
            for (int i = resLength - 1; i > 0; i--) {
                if (result.charAt(i) == '0') {
                    result = result.substring(0, i);
                } else {break;}
            }
        }

        System.out.println("result: " + result);
        return result;
    }
}