package com.claculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private StringBuilder calc = new StringBuilder();
    char[] operation = {'+', '-', '×', '/', '.'};
    char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private static boolean nullDivisionError = false;
    private boolean equalsWasPressed;
    private boolean clearWhenNextIsNumber;

    private TextView calcText;
    private TextView resultText;
    private ViewFlipper vf;
    private Button clear;

    private String calcHistoryString;
    private String resultHistoryString;
    private boolean addToCalcHistoryList;


    private ArrayList<String> calcHistoryList = new ArrayList<>();
    private ArrayList<String> resultHistoryList = new ArrayList<>();
    private RecyclerView recycleViewCalcHistory;
    private calcHistoryAdapter calcHistoryAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        recycleViewCalcHistory = findViewById(R.id.rw_calcList);
        calcText = findViewById(R.id.tf_calc);
        resultText = findViewById(R.id.tf_result);
        vf = findViewById(R.id.vf_button);

        buildRecyclerView();

        calcText.setText("");
        resultText.setText("");

        Button one = findViewById(R.id.button_one);
        Button two = findViewById(R.id.button_two);
        Button three = findViewById(R.id.button_three);
        Button four = findViewById(R.id.button_four);
        Button five = findViewById(R.id.button_five);
        Button six = findViewById(R.id.button_six);
        Button seven = findViewById(R.id.button_seven);
        Button eight = findViewById(R.id.button_eight);
        Button nine = findViewById(R.id.button_nine);
        Button zero = findViewById(R.id.button_zero);
        Button plus = findViewById(R.id.button_plus);
        Button minus = findViewById(R.id.button_minus);
        Button multiply = findViewById(R.id.button_multiply);
        Button divide = findViewById(R.id.button_divide);
        Button percentage = findViewById(R.id.button_percent);
        Button equal = findViewById(R.id.button_equal);
        Button dot = findViewById(R.id.button_dot);
        clear = findViewById(R.id.button_clear);
        Button delete = findViewById(R.id.button_delete);
        Button change = findViewById(R.id.button_change);

        Button one2 = findViewById(R.id.button_one2);
        Button two2 = findViewById(R.id.button_two2);
        Button three2 = findViewById(R.id.button_three2);
        Button four2 = findViewById(R.id.button_four2);
        Button five2 = findViewById(R.id.button_five2);
        Button six2 = findViewById(R.id.button_six2);
        Button seven2 = findViewById(R.id.button_seven2);
        Button eight2 = findViewById(R.id.button_eight2);
        Button nine2 = findViewById(R.id.button_nine2);
        Button zero2 = findViewById(R.id.button_zero2);
        Button plus2 = findViewById(R.id.button_plus2);
        Button minus2 = findViewById(R.id.button_minus2);
        Button multiply2 = findViewById(R.id.button_multiply2);
        Button divide2 = findViewById(R.id.button_divide2);
        Button percentage2 = findViewById(R.id.button_percent2);
        Button equal2 = findViewById(R.id.button_equal2);
        Button dot2 = findViewById(R.id.button_dot2);
        Button clear2 = findViewById(R.id.button_clear2);
        Button delete2 = findViewById(R.id.button_delete2);
        Button change2 = findViewById(R.id.button_change2);


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

    // ===========================================================================================
    // Number
    // ===========================================================================================

    private void onOneClick(View view) {
        onNumberButtonClick("1");
    }

    private void onTwoClick(View view) {
        onNumberButtonClick("2");
    }

    private void onThreeClick(View view) {
        onNumberButtonClick("3");
    }

    private void onFourClick(View view) {
        onNumberButtonClick("4");
    }

    private void onFiveClick(View view) {
        onNumberButtonClick("5");
    }

    private void onSixClick(View view) {
        onNumberButtonClick("6");
    }

    private void onSevenClick(View view) {
        onNumberButtonClick("7");
    }

    private void onEightClick(View view) {
        onNumberButtonClick("8");
    }

    private void onNineClick(View view) {
        onNumberButtonClick("9");
    }

    private void onZeroClick(View view) {
        onNumberButtonClick("0");
    }

    // ===========================================================================================
    // Operator
    // ===========================================================================================

    private void onPlusClick(View view) {
        onOperatorButtonClick("+");
    }

    private void onMinusClick(View view) {
        onOperatorButtonClick("-");
    }

    private void onMultiplyClick(View view) {
        onOperatorButtonClick("×");
    }

    private void onDivideClick(View view) {
        onOperatorButtonClick("/");
    }

    private void onPercentageClick(View view) {
        //onOperatorButtonClick("%");
    }


    // ===========================================================================================
    // Special Button
    // ===========================================================================================

    private void onEqualClick(View view) {
        if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
            equalsWasPressed = true;
            updateResult();
        }
    }

    private void onDotClick(View view) {
        if (calc.length() != 0 && contains(calc.charAt(calc.length() - 1), numbers) && !contains(calc.charAt(calc.length() - 1), operation)) {
            int dotCounter = 0;
            for (int i = 0; i < calc.length(); i++) {
                if (calc.charAt(i) == '.') {
                    dotCounter++;
                }
                if (contains(calc.charAt(i), operation) && calc.charAt(i) != '.') {
                    dotCounter = 0;
                }
            }
            if (dotCounter == 0) {
                calc.append(".");
                updateCalcText();
            }
        }
    }

    private void onClearClick(View view) {
        if (calcText.getText() == "" && resultText.getText() == "") {
            calcHistoryAdapter.clearHistory();
            calcHistoryAdapter.notifyDataSetChanged();
        }
        if (calc.length() != 0) {
            clear.setText("AC");

            calc.setLength(0);
            calcText.setText("");
            resultText.setText("");
            calcHistoryString = "";
            resultHistoryString = "";
        }
    }

    private void onDeleteClick(View view) {
        if (calc.length() > 0) {
            calc.deleteCharAt(calc.length() - 1);
            updateCalcText();
            if ((calc.length() > 0) && !contains(calc.charAt(calc.length() - 1), operation)) {
                updateResult();
            }
            if (calc.length() == 0) {
                resultText.setText("");
            }
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

    // ===========================================================================================
    // Number Click
    // ===========================================================================================

    private void onNumberButtonClick(String number) {
        if (calc.length() == 0 || contains(calc.charAt(calc.length() - 1), operation) || contains(calc.charAt(calc.length() - 1), numbers)) {
            if (clearWhenNextIsNumber) {
                calc.setLength(0);
                clearWhenNextIsNumber = false;
            }

            calc.append(number);
            updateCalcText();
            updateResult();
            if (addToCalcHistoryList) {
                updateHistoryList();
                addToCalcHistoryList = false;
            }
        }
    }

    // ===========================================================================================
    // Operator Click
    // ===========================================================================================

    private void onOperatorButtonClick(String operator) {
        if (calc.length() != 0 && !contains(calc.charAt(calc.length() - 1), operation)) {
            calc.append(operator);
            clearWhenNextIsNumber = false;
            addToCalcHistoryList = false;
            updateCalcText();
        }
    }

    // ===========================================================================================
    // HistoryList and RecyclerView
    // ===========================================================================================

    private void buildRecyclerView() {
        recycleViewCalcHistory.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        calcHistoryAdapter = new calcHistoryAdapter(calcHistoryList, resultHistoryList);
        layoutManager.scrollToPosition(calcHistoryList.size() - 1);

        recycleViewCalcHistory.setLayoutManager(layoutManager);
        recycleViewCalcHistory.setAdapter(calcHistoryAdapter);

        calcHistoryAdapter.setOnItemCLickListener(new calcHistoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                System.out.println("HELLO ###################################");
                updateHistoryList();
                calc = new StringBuilder(calcHistoryList.get(position));

                calcHistoryString = calcHistoryList.get(position);
                resultHistoryString = resultHistoryList.get(position);

                updateCalcText();
                updateResult();
            }
        });
    }

    private void updateHistoryList() {
        if (!calcHistoryString.equals("") && !resultHistoryString.equals("")) {
            calcHistoryList.add(calcHistoryString);
            resultHistoryList.add(resultHistoryString);

            calcHistoryAdapter.notifyItemInserted(calcHistoryList.size() + 1);
            layoutManager.scrollToPosition(calcHistoryList.size() - 1);
        }
    }


    // ===========================================================================================
    // Update Text and calculate
    // ===========================================================================================

    public void updateCalcText() {
        calcText.setText(calc);
    }

    public void updateResult() {
        clear.setText("C");

        String expr = calc.toString();

        // Calculate result
        double result = Calculator.evaluate(expr);

        if (!nullDivisionError) {
            // to set 1.0 -> 1
            if (result % 1 == 0) {
                int newResult = (int) result;
                resultText.setText("= " + newResult);

                if (equalsWasPressed) {

                    calcHistoryString = calc.toString();
                    resultHistoryString = String.valueOf(newResult);

                    calc.setLength(0);
                    calc.append(newResult).toString();
                    clearWhenNextIsNumber = true;
                    addToCalcHistoryList = true;
                    equalsWasPressed = false;
                }
            } else {
                System.out.println("result: " + result);
                resultText.setText("= " + result);

                if (equalsWasPressed) {

                    calcHistoryString = calc.toString();
                    resultHistoryString = String.valueOf(result);

                    calc.setLength(0);
                    calc.append(result).toString();
                    clearWhenNextIsNumber = true;
                    addToCalcHistoryList = true;
                    equalsWasPressed = false;
                }
            }
        } else {
            resultText.setText("nicht Definiert!");
            nullDivisionError = false;
        }

        //System.out.println(EvaluateString.evaluate("10 + 2 × 6"));
        //System.out.println(EvaluateString.evaluate("100 × 2 + 12"));
        //System.out.println(EvaluateString.evaluate("100 × ( 2 + 12 )"));
        //System.out.println(EvaluateString.evaluate("100 × ( 2 + 12 ) / 14"));
    }


    // ===========================================================================================
    // Additional Methods
    // ===========================================================================================

    static boolean contains(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }

    public static void setNullDivisionError(boolean error) {
        nullDivisionError = error;
    }

}
