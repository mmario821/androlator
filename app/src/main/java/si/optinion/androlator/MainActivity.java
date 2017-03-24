package si.optinion.androlator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txt1 = (EditText)findViewById(R.id.editText);
        txt1.setText("0");
        final EditText txt2 = (EditText)findViewById(R.id.editText2);
        txt2.setText("0");
        final TextView lbl1 = (TextView)findViewById(R.id.textView);
        lbl1.setText("0");

        final Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Integer num1 = Integer.parseInt(txt1.getText().toString());
                Integer num2 = Integer.parseInt(txt2.getText().toString());
                Integer sum = num1+num2;
                // Perform onclick
                lbl1.setText(sum.toString());
            }
        });
    }
}
