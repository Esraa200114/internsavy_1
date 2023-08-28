package com.example.simplecalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText operand_1_et, operand_2_et;
    private TextView result_tv;
    private double number_1, number_2;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        initializeComponents();

    }

    private void initializeComponents() {

        operand_1_et = findViewById(R.id.operand_1_et);
        operand_2_et = findViewById(R.id.operand_2_et);

        result_tv = findViewById(R.id.result_tv);
    }

    public void onOperatorClickEvent(View view) {

        if(operand_1_et.getText().toString().equals("") || operand_2_et.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Please fill the required fields!", Toast.LENGTH_SHORT).show();
        }else{
            number_1 = Double.parseDouble(operand_1_et.getText().toString());
            number_2 = Double.parseDouble(operand_2_et.getText().toString());
        }

        switch (view.getId()){

            case R.id.add_btn:
                result_tv.setText("Result: " + String.valueOf(number_1 + number_2));
                break;

            case R.id.subtract_btn:
                result_tv.setText("Result: " + String.valueOf(number_1 - number_2));
                break;

            case R.id.multiply_btn:
                result_tv.setText("Result: " + String.valueOf(number_1 * number_2));
                break;

            case R.id.divide_btn:
                if(number_2 == 0){
                    Toast.makeText(getApplicationContext(), "Can't divide by 0", Toast.LENGTH_SHORT).show();
                }else{
                    result_tv.setText("Result: " + String.valueOf(number_1 / number_2));
                }
                break;
        }
    }
}