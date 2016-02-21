package com.example.Calculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Ozan on 20.2.2016.
 */
public class MyActivity extends Activity implements View.OnClickListener{

    //written respectively due to layout style
    EditText display, entry;
    String op;
    Button one, two, three, four, five, six, seven, eight, nine, zero, div, mul, minus, plus, clear, equal, dot;
    double op1;
    double op2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //connect buttons with variables to take actions
        display = (EditText) findViewById(R.id.display);
        entry = (EditText) findViewById(R.id.entry);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        div = (Button) findViewById(R.id.div);
        mul = (Button) findViewById(R.id.mul);
        minus = (Button) findViewById(R.id.minus);
        plus = (Button) findViewById(R.id.plus);
        clear = (Button) findViewById(R.id.clear);
        equal = (Button) findViewById(R.id.equal);
        dot = (Button) findViewById(R.id.dot);

        //set event listeners for those buttons
        try{
            one.setOnClickListener(this);
            two.setOnClickListener(this);
            three.setOnClickListener(this);
            four.setOnClickListener(this);
            five.setOnClickListener(this);
            six.setOnClickListener(this);
            seven.setOnClickListener(this);
            eight.setOnClickListener(this);
            nine.setOnClickListener(this);
            zero.setOnClickListener(this);
            div.setOnClickListener(this);
            mul.setOnClickListener(this);
            minus.setOnClickListener(this);
            plus.setOnClickListener(this);
            clear.setOnClickListener(this);
            equal.setOnClickListener(this);
            dot.setOnClickListener(this);
        }
        catch(Exception e){
            Log.e("YOUR_APP_LOG_TAG", "I got an error", e);
        }
    }

    @Override
    public void onClick(View v) {
        Editable dsp =  display.getText();
        Editable entri =  entry.getText();

        //clear room for new number
        if(entry.getText().toString().equals("/")||entry.getText().toString().equals("*")){
            entry.setText("");
        }

        //get element by id
        switch(v.getId()){
            case R.id.one:
                entri.append(one.getText());
                entry.setText(entri);
                break;
            case R.id.two:
                entri.append(two.getText());
                entry.setText(entri);
                break;
            case R.id.three:
                entri.append(three.getText());
                entry.setText(entri);
                break;
            case R.id.four:
                entri.append(four.getText());
                entry.setText(entri);
                break;
            case R.id.five:
                entri.append(five.getText());
                entry.setText(entri);
                break;
            case R.id.six:
                entri.append(six.getText());
                entry.setText(entri);
                break;
            case R.id.seven:
                entri.append(seven.getText());
                entry.setText(entri);
                break;
            case R.id.eight:
                entri.append(eight.getText());
                entry.setText(entri);
                break;
            case R.id.nine:
                entri.append(nine.getText());
                entry.setText(entri);
                break;
            case R.id.zero:
                if(!entri.toString().equals("0")){
                    entri.append(zero.getText());
                }
                entry.setText(entri);
                break;
            case R.id.dot:
                if(!entri.toString().contains(".")){
                    entri.append(dot.getText());
                }
                entry.setText(entri);
                break;
            case R.id.clear:
                entri.clear();
                entry.setText(entri);
                display.setText(entri);
                break;
            case R.id.div:
                op="/";
                if(dsp.toString().equals("")){  //empty, aka first argument
                    display.setText(entri);
                    entry.setText("");
                }else{
                    operation();
                }
                break;
            case R.id.mul:
                op="*";
                if(dsp.toString().equals("")){  //empty, aka first argument
                    display.setText(entri);
                    entry.setText("");
                }else{
                    operation();
                }
                break;
            case R.id.minus:
                op="-";
                if(dsp.toString().equals("")){  //empty, aka first argument
                    display.setText(entri);
                    entry.setText("");
                }else{
                    operation();
                }
                break;
            case R.id.plus:
                op="+";
                if(dsp.toString().equals("")){  //empty, aka first argument
                    display.setText(entri);
                    entry.setText("");
                }else{
                    operation();
                }
                break;
            case R.id.equal:
                operation();
                break;
        }
    }

    //this method handles the print message to display
    public void operation(){
        if(op.equals("+")){
            op1 = Double.parseDouble(display.getText().toString());
            if(display.getText().toString().equals("")){
                op1=0;
            }
            if(!entry.getText().toString().equals("")) {
                op2 = Double.parseDouble(entry.getText().toString());
                op1 = op1 + op2;
                if(op1%1.0!=0) {
                    display.setText(Double.toString(op1));
                }else{
                    display.setText(Integer.toString((int)op1));
                }
                entry.setText("");
            }
        }
        else if(op.equals("-")){
            op1 = Double.parseDouble(display.getText().toString());
            if(display.getText().toString().equals("")){
                op1=0;
            }
            if(!entry.getText().toString().equals("")) {
                op2 = Double.parseDouble(entry.getText().toString());
                op1 = op1 - op2;
                if(op1%1.0!=0) {
                    display.setText(Double.toString(op1));
                }else{
                    display.setText(Integer.toString((int)op1));
                }
                entry.setText("");
            }
        }
        else if(op.equals("*")){
            op1 = Double.parseDouble(display.getText().toString());
            if(display.getText().toString().equals("")){
                op1=0;
            }
            if(!entry.getText().toString().equals("")) {
                op2 = Double.parseDouble(entry.getText().toString());
                op1 = op1 * op2;
                if(op1%1.0!=0) {
                    display.setText(Double.toString(op1));
                }else{
                    display.setText(Integer.toString((int)op1));
                }
                entry.setText("");
            }
        }
        else if(op.equals("/")){
            op1 = Double.parseDouble(display.getText().toString());
            if(display.getText().toString().equals("")){
                op1=0;
            }
            if(!entry.getText().toString().equals("")) {
                op2 = Double.parseDouble(entry.getText().toString());
                if (op2 == 0) {
                    display.setText("error");
                    entry.setText("");
                } else {
                    op1 = op1 / op2;
                    if(op1%1.0!=0) {
                        display.setText(Double.toString(op1));
                    }else{
                        display.setText(Integer.toString((int)op1));
                    }
                    entry.setText("");
                }
            }
        }
    }
}
