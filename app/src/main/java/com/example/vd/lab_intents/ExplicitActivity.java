package com.example.vd.lab_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ExplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
    }

    public void okeyClick(View view){
        Intent intent = new Intent();
        EditText et = (EditText) findViewById(R.id.editText);
        intent.putExtra("data",et.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancelClick(View view){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
