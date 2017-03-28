package si.optinion.androlator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private enum operation
    {
      operationNone, operationSum, operationDiff
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        operand1 = 0;
        operator = operation.operationNone;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // What happens when button '9' is clicked
        Button but9 = (Button)findViewById(R.id.but9);
        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumber("9");
            }
        });

        // What happens when button '8' is clicked
        Button but8 = (Button)findViewById(R.id.but8);
        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumber("8");
            }
        });

        // What happens when button '7' is clicked
        Button but7 = (Button)findViewById(R.id.but7);
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumber("7");
            }
        });

        // What happens when button '6' is clicked
        Button but6 = (Button)findViewById(R.id.but6);
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumber("6");
            }
        });

        // What happens when button '5' is clicked
        Button but5 = (Button)findViewById(R.id.but5);
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumber("5");
            }
        });

        // What happens when button '4' is clicked
        Button but4 = (Button)findViewById(R.id.but4);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumber("4");
            }
        });

        // What happens when button '3' is clicked
        Button but3 = (Button)findViewById(R.id.but3);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumber("3");
            }
        });

        // What happens when button '2' is clicked
        Button but2 = (Button)findViewById(R.id.but2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumber("2");
            }
        });

        // What happens when button '1' is clicked
        Button but1 = (Button)findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumber("1");
            }
        });

        // What happens when button '0' is clicked
        Button but0 = (Button)findViewById(R.id.but0);
        but0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumber("0");
            }
        });

        // What happens when 'CE' button is clicked
        Button butce = (Button)findViewById(R.id.butce);
        butce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset text view to 0
                resetToZero();
                // Clear operand1
                operand1 = 0;
                // Clear operator
                operator = operation.operationNone;
            }
        });

        // What happens when '+' button is clicked
        Button butplus = (Button)findViewById(R.id.butplus);
        butplus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Calculate sum of two numbers (if possible)
                // This is needed because we can click + instead of =
                // to continue the calculation.
                calculateSum();

                // Get number from textbox and save it as operand 1
                operand1 = getNumber();
                // Mark operator +
                operator = operation.operationSum;
                // Set textview to 0
                setNumber(0);
            }
        });

        // What happens when '-' button is clicked
        Button butminus = (Button)findViewById(R.id.butminus);
        butminus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Calculate difference of two numbers (if possible)
                // This is needed because we can click - instead of =
                // to continue the calculation.
                calculateDifference();

                // Get number from textbox and save it as operand 1
                operand1 = getNumber();
                // Mark operator +
                operator = operation.operationDiff;
                // Set textview to 0
                setNumber(0);
            }
        });

        // Whan happens when '=' button is clicked
        Button butcalculate = (Button)findViewById(R.id.butcalculate);
        butcalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                // Calculate sum if possible
                calculateSum();

                // Calculate diff is possible
                calculateDifference();
            }
        });

    }

    private boolean calculateDifference()
    {
        if (operator == operation.operationDiff)
        {
            // Get number from the textbox
            Integer num2 = getNumber();

            // Calculate two number difference
            Integer diff = operand1-num2;

            // Save number in the textivew
            setNumber(diff);

            // Reset operand1
            operand1 = 0;
            // Reset operator
            operator = operation.operationNone;

            return true;
        }

        return false;
    }

    private boolean calculateSum()
    {
        if (operator == operation.operationSum)
        {
            // Get number from the textbox
            Integer num2 = getNumber();

            // Sum two numbers
            Integer sum = operand1+num2;

            // Save number in the textivew
            setNumber(sum);

            // Reset operand1
            operand1 = 0;
            // Reset operator
            operator = operation.operationNone;

            return true;
        }

        return false;

    }

    /**
     * Return number from the textview,
     * return 0 if the number cannot be converted to valid integer.
     *
     * @return  Integer Number from the textview
     */
    private Integer getNumber()
    {
        TextView lbl1 = (TextView)findViewById(R.id.textView);

        try {
            return Integer.parseInt(lbl1.getText().toString());
        } catch(NumberFormatException nfe) {
            return 0;
        }
    }

    /**
     * Set TextView value to desired value
     *
     * @param Integer   num     Number to be set to TextView
     */
    private void setNumber(Integer num)
    {
        TextView lbl1 = (TextView)findViewById(R.id.textView);

        lbl1.setText(num.toString());
    }

    /**
     * Reset TextView value to 0
     */
    private void resetToZero()
    {
        setNumber(0);
    }

    /**
     * Append digit to a TextView
     *
     * @param String    num     Value to be appended
     */
    private void addNumber(String num)
    {
        TextView lbl1 = (TextView)findViewById(R.id.textView);

        // Get current number and append first character from num
        String new_number = getNumber().toString().concat(num.substring(0, 1));

        try {
            setNumber(Integer.parseInt(new_number));
        } catch(NumberFormatException nfe) {
            // Do nothing...
        }
    }

    /// This is one operand which is then used in mathematical operation
    private Integer operand1;

    /**
     * Operator 0 => No operator selected
     * Operator 1 => Plus (sum)
     */
    private operation operator;
}
