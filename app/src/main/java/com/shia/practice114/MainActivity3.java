package com.shia.practice114;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    EditText editText;
    Button doneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editText = findViewById(R.id.editText);
        doneButton = findViewById(R.id.doneButton);

        String name = getIntent().getStringExtra(MainActivity2.KEY_EDIT_PROFILE);
        editText.setText(name);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String extraName = editText.getText().toString().trim();
                Intent intent1 = new Intent();
                intent1.putExtra(MainActivity2.KEY_EDIT_PROFILE, extraName);
                setResult(Activity.RESULT_OK, intent1);
                finish();
            }
        });
    }
}