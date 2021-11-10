package com.mbugua.simpleconverter;

import android.os.Debug;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_foot, et_inches;
    Button btn_convert, btn_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_foot = (EditText)findViewById(R.id.et_foot);
        et_inches = (EditText)findViewById(R.id.et_inches);
        btn_convert = (Button)findViewById(R.id.btn_convert);
        btn_clear = (Button)findViewById(R.id.btn_clear);

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String strCentimeter = et_foot.getText().toString();
                    String strInches = et_inches.getText().toString();

                    if(!strCentimeter.equals("") && strInches.equals("")) {
                        double foot = Double.valueOf(et_foot.getText().toString());
                        double inches = foot * 12;
                        et_inches.setText(String.valueOf(inches));

                    }else if (!strInches.equals("") && strCentimeter.equals("")){
                        double inches = Double.valueOf(et_inches.getText().toString());
                        double foot = inches * 0.0833333;
                        et_foot.setText(String.valueOf(foot));

                    }else if(!strCentimeter.equals("") && !strInches.equals("")){
                        Toast.makeText(getApplicationContext(), "Please clear the text field first!", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_foot.setText("");
                et_inches.setText("");
            }
        });

    }
}
