package com.example.vd.lab_intents;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ImplicitActivity extends AppCompatActivity {

    private List<ResolveInfo> activities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        //intent.setType(Intent.CATEGORY_LAUNCHER);
        final PackageManager pm = getPackageManager();
        this.activities = pm.queryIntentActivities(intent, 0);

        ListView list = (ListView) findViewById(R.id.listViewActivity);
        ActivityAdapter adapter = new ActivityAdapter(activities, this);
        list.setAdapter(adapter);
    }
}
