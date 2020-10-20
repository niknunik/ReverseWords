package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ui.main.MainFragment;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText words;
    TextView label;
    HashMap<Character, Integer> charCountMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        words = findViewById(R.id.etWords);
        label = findViewById(R.id.message);
        charCountMap = new HashMap<>();

        findViewById(R.id.btnReverse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!words.getText().toString().isEmpty()) {
                    StringBuffer c = new StringBuffer(words.getText().toString());
                    label.setText(c.reverse());
                    Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
                } else {
                    words.setError("Enter NAME");
                }
            }
        });

        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }


}
