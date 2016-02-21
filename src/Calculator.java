import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.Calculator.R;

/**
 * Created by Ozan on 20.2.2016.
 */
public class Calculator extends Activity implements View.OnClickListener{

    //written respectively due to layout style
    EditText display, entry;
    String op;
    Button one, two, three, four, five, six, seven, eight, nine, zero, div, mul, minus, plus, clear, equal, dot;
    int op1;
    int op2;

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
        Editable str =  display.getText();

        //clear room for new number
        if(entry.getText().toString().equals("/")||entry.getText().toString().equals("*")){
            entry.setText("");
        }

        //get element by id
        switch(v.getId()){
            case R.id.one:
                str = str.append(one.getText());
                entry.setText(str);
                break;
            case R.id.two:
                str = str.append(two.getText());
                entry.setText(str);
                break;
            case R.id.three:
                str = str.append(three.getText());
                entry.setText(str);
                break;
            case R.id.four:
                str = str.append(four.getText());
                entry.setText(str);
                break;
            case R.id.five:
                str = str.append(five.getText());
                entry.setText(str);
                break;
            case R.id.six:
                str = str.append(six.getText());
                entry.setText(str);
                break;
            case R.id.seven:
                str = str.append(seven.getText());
                entry.setText(str);
                break;
            case R.id.eight:
                str = str.append(eight.getText());
                entry.setText(str);
                break;
            case R.id.nine:
                str = str.append(nine.getText());
                entry.setText(str);
                break;
            case R.id.zero:
                if(!str.toString().equals("0")){
                    str = str.append(zero.getText());
                }
                entry.setText(str);
                break;
            case R.id.dot:
                if(!str.toString().contains(".")){
                    str = str.append(dot.getText());
                }
                entry.setText(str);
                break;
            case R.id.clear:
                str.clear();
                entry.setText(str);
                break;
            case R.id.div:
                op="/";
                display.setText(str);
                str.clear();
                str = str.append(div.getText());
                entry.setText(str);
                break;
            case R.id.mul:
                op="*";
                display.setText(str);
                str.clear();
                str = str.append(mul.getText());
                entry.setText(str);
                break;
            case R.id.minus:
                op="-";
                display.setText(str);
                str.clear();
                str = str.append(minus.getText());
                entry.setText(str);
                break;
            case R.id.plus:
                op="+";
                display.setText(str);
                str.clear();
                str = str.append(plus.getText());
                entry.setText(str);
                break;
            case R.id.equal:
                if(!op.equals(null)){
                    operation();
                }
                break;
        }
    }

    //this method handles the print message to display
    public void operation(){
        if(op.equals("+")){
            op1 = Integer.parseInt(display.getText().toString());
            if(display.getText().toString().equals("")){
                op1=0;
            }
            op2 = Integer.parseInt(entry.getText().toString());
            op1 = op1 + op2;
            display.setText(Integer.toString(op1));
            entry.setText("");
        }
        else if(op.equals("-")){
            op1 = Integer.parseInt(display.getText().toString());
            if(display.getText().toString().equals("")){
                op1=0;
            }
            op2 = Integer.parseInt(entry.getText().toString());
            op1 = op1 - op2;
            display.setText(Integer.toString(op1));
            entry.setText("");
        }
        else if(op.equals("*")){
            op1 = Integer.parseInt(display.getText().toString());
            if(display.getText().toString().equals("")){
                op1=0;
            }
            op2 = Integer.parseInt(entry.getText().toString());
            op1 = op1 * op2;
            display.setText(Integer.toString(op1));
            entry.setText("");
        }
        else if(op.equals("/")){
            op1 = Integer.parseInt(display.getText().toString());
            if(display.getText().toString().equals("")){
                op1=0;
            }
            op2 = Integer.parseInt(entry.getText().toString());
            if(op2==0){
                display.setText("error");
                entry.setText("");
            }else{
                op1 = op1 / op2;
                display.setText(Integer.toString(op1));
                entry.setText("");
            }
        }
    }
}
