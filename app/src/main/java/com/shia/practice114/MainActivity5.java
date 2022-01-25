package com.shia.practice114;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    TextView name;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

        Bundle bundle = getIntent().getExtras();

        if (bundle == null)
            return;

        String getName = bundle.getString(String.valueOf(MainActivity4.KEY_LOGIN_NAME));
        String getPass = bundle.getString(String.valueOf(MainActivity4.KEY_LOGIN_PASS));

        name.setText("your name : "+ getName);
        password.setText("your Password : "+getPass);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}