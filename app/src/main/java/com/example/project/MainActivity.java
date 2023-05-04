package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences myPrefRef;
    private SharedPreferences.Editor myPreferenceEditor;
    private EditText myEdit;
    private TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myPrefRef = getSharedPreferences("preferences", MODE_PRIVATE);
        myEdit = findViewById(R.id.settingseditview);

        Button button3 = findViewById(R.id.prefButton);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = myPrefRef.edit();
                editor.putString("MyAppPreferenceString", myEdit.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
                startActivity(intent);
                Log.d("TAG", "onClick: ");
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        myText = findViewById(R.id.prefText);
        myPrefRef = getSharedPreferences("preferences", MODE_PRIVATE);
        String name = myPrefRef.getString("MyAppPreferenceString", "null");
        myText.setText(name);
    }
}


