package com.example.vd.lab_intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int EXPLICIT_REQUEST_CODE = 1;
    static final int CHOOSE_IMAGE_CODE = 2;
    static final String IMPLICIT_ACTION = "com.example.vd.lab_intents.IMPLICIT_ACTION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startExplicitActivity(View view){
        Intent explicit = new Intent(this, ExplicitActivity.class);
        startActivityForResult(explicit,EXPLICIT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == EXPLICIT_REQUEST_CODE && resultCode == RESULT_OK){
            TextView view = (TextView) findViewById(R.id.textView);
            view.setText(data.getStringExtra("data"));
        }else if (requestCode == CHOOSE_IMAGE_CODE && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            Intent viewImageIntent = new Intent();
            viewImageIntent.setAction(Intent.ACTION_VIEW);
            viewImageIntent.setData(imageUri);
            startActivity(viewImageIntent);
        }
    }

    public void startImplicitActivity(View view){
        Intent implicit = new Intent();
        implicit.setAction(IMPLICIT_ACTION);
        startActivity(implicit);
    }

    public void sendEmail(View view) {
        Intent implicit = new Intent();
        implicit.setAction(Intent.ACTION_SEND);
        implicit.setType("text/plain");
        implicit.putExtra(Intent.EXTRA_SUBJECT, "MPiP Send Title");
        implicit.putExtra(Intent.EXTRA_TEXT, "Content send from MainActivity");
        startActivity(Intent.createChooser(implicit, "Send E-mail"));
    }

    public void chooseImage(View view) {
        Intent imageIntent = new Intent();
        imageIntent.setType("image/*");
        imageIntent.setAction(Intent.ACTION_PICK);
        startActivityForResult(imageIntent, CHOOSE_IMAGE_CODE);
    }
}
