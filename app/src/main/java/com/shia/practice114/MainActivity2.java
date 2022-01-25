package com.shia.practice114;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity2 extends AppCompatActivity {

    CircleImageView circleImageView;
    TextView txtName;
    Button btnEditProfile;
    Button btnViewWebSite;
    CheckBox androidDeveloper;
    RadioGroup radioGroup;
    TextView txtSwitch;
    Switch btnSwitch;

    public static final String KEY_EDIT_PROFILE = "edit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        circleImageView = findViewById(R.id.circleImageView);

        Picasso.get().load(R.drawable.irancicleflag).into(circleImageView);

        txtName = findViewById(R.id.txt_name);
        btnEditProfile = findViewById(R.id.btn_editProfile);
        btnViewWebSite = findViewById(R.id.btn_viewWebSite);

        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity3.class);
                intent1.putExtra(KEY_EDIT_PROFILE, txtName.getText().toString().trim());
                startActivityForResult(intent1, 1000);
            }
        });
        btnViewWebSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent2);
            }
        });

        androidDeveloper = findViewById(R.id.androidDeveloper);
        androidDeveloper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Toast.makeText(getApplicationContext(), "androidDeveloper checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "androidDeveloper NOT checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.gilanRasht:
                        Toast.makeText(getApplicationContext(), "Gilan,Rasht checked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tehran:
                        Toast.makeText(getApplicationContext(), "Tehran checked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.alborzKaraj:
                        Toast.makeText(getApplicationContext(), "Alborz,Karaj checked", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        txtSwitch = findViewById(R.id.txt_switch);
        btnSwitch = findViewById(R.id.btn_switch);

        btnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    txtSwitch.setText("I am a GOOD boy");
                } else {
                    txtSwitch.setText("I am not a GOOD boy");
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == Activity.RESULT_OK && data != null){
            String resultName = data.getStringExtra(KEY_EDIT_PROFILE);
            txtName.setText(resultName);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        SubMenu information = menu.addSubMenu("first page");
        information.add("log in").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent3 = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent3);
                return false;
            }
        });
        menu.add("join us").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent4 = new Intent(getApplicationContext(), MainActivity6.class);
                startActivity(intent4);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}