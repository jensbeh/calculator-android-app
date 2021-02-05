package com.claculator;

import java.math.BigDecimal;
import java.util.Stack;

public class Calculator extends MainActivity{

    public static double evaluate(String input){
        char[] expr = input.toCharArray();

        System.out.print("Expression: ");
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
                //System.out.println("2: " + temp.toString());
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
                    setNullDivisionError(true);
                } else {
                    res = x1.divide(y1, 6, BigDecimal.ROUND_HALF_UP);
                    result = res.doubleValue();
                    break;
                }
        }
        return result;
    }

}
