package com.example.cwlt_charlesweirdlanguagetranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    Button b;
    TextView tv;
    EditText et;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.edit);
        tv = findViewById(R.id.text);
        b = findViewById(R.id.button);
        rg = findViewById(R.id.radiogroup);
        rb = findViewById(R.id.etc);
        rb.toggle();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to_convert = et.getText().toString();
                if(rg.getCheckedRadioButtonId()==R.id.cte) {
                    tv.setText("Translated to English:\n\n" + CharlesToEnglish(to_convert));
                } else {
                    tv.setText("Translated to Charles\' Weird Language:\n\n" + EnglishToCharles(to_convert));
                }
            }
        });

    }

    String EnglishToCharles(String to_convert) {
        String converted = "";
        char let;
        for(int i = 0; i<to_convert.length(); i++)
        {
            let = to_convert.charAt(i);
            converted = converted + let;
            if(let=='a' || let=='e' || let=='i' || let=='o' || let=='u' || let =='A' || let =='E'|| let =='I'|| let =='O'|| let =='U') {
                converted = converted + 'p' + Character.toLowerCase(let);
            }
        }
        return converted;
    }

    String CharlesToEnglish(String to_convert) {
        String converted = "";
        char let;
        for(int i = 0; i<to_convert.length(); i++) {
            let = to_convert.charAt(i);
            converted = converted + let;
            if(let=='a' || let=='e' || let=='i' || let=='o' || let=='u' || let =='A' || let =='E'|| let =='I'|| let =='O'|| let =='U') {
                i = i+2;
            }
        }
        return converted;
    }
}
