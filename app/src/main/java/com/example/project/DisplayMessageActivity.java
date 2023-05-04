package com.example.project;

import static com.example.project.R.id.prefButton;
import static com.example.project.R.id.prefText;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    private SharedPreferences sharedPref;
    private TextView text;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        text = findViewById(R.id.prefText);
        sharedPref = getSharedPreferences("preferences", MODE_PRIVATE);
        String name = sharedPref.getString("MyAppPreferenceString", "null");
        text.setText(name);
        Log.d("==>", name);

    }
}

