package com.shia.practice114;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity4 extends AppCompatActivity {

    TextInputLayout nameLayout, passLayout;
    EditText nameEditText, passEdittext;
    Button enter;
    TextView textJoin;

    public static final int KEY_LOGIN_NAME = 1;
    public static final int KEY_LOGIN_PASS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        nameLayout = findViewById(R.id.nameLayout);
        passLayout = findViewById(R.id.passLayout);

        nameEditText = findViewById(R.id.nameEditText);
        passEdittext = findViewById(R.id.passEdittext);

        enter = findViewById(R.id.enter);
        textJoin = findViewById(R.id.textJoin);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity5.class);

                String nameInfo = nameEditText.getText().toString().trim();
                String passInfo = passEdittext.getText().toString().trim();

                intent1.putExtra(String.valueOf(KEY_LOGIN_NAME), nameInfo);
                intent1.putExtra(String.valueOf(KEY_LOGIN_PASS), passInfo);

                startActivity(intent1);
            }
        });

        textJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), MainActivity6.class);
                startActivity(intent2);
            }
        });
    }
}