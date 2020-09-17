package com.example.androidlifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TEXT_TO_RECOVER_KEY = "keyToRetrive";
    private static final String TEXT_RECOVER_TEXTVIEW = "textViewRecover";
    private TextView textViewSave;
    private String textToBeSaved = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null)
        {
            textToBeSaved = savedInstanceState.getString(TEXT_TO_RECOVER_KEY);
        }
        setContentView(R.layout.activity_main);
        textViewSave = findViewById(R.id.textView_save);
        textViewSave.setText(textToBeSaved);
        Log.d("activity", "onCreate Activity is called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("activity", "onStart Activity is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("activity", "onRestart Activity is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("activity", "onResume Activity is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("activity", "onPause Activity is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("activity", "onStop Activity is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("activity", "onDestroy Activity is called");
    }

    //usable only when android is killing the app NOT WHEN CLOSE THE APP MANUALY!!!
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("activity", "onSavedInstanceState Activity is called");
        outState.putString(TEXT_TO_RECOVER_KEY,"This is a saved string");
        outState.putString(TEXT_RECOVER_TEXTVIEW,textViewSave.getText().toString());
        super.onSaveInstanceState(outState);
    }
    //usable only when android is killing the app NOT WHEN CLOSE THE APP MANUALY!!!
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        textViewSave.setText(savedInstanceState.getString(TEXT_TO_RECOVER_KEY));
        Log.d("activity", "onRestoreInstanceState Activity is called");
    }
}