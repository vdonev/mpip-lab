package com.example.vd.lab_intents;

/**
 * Created by VD on 01.11.2017.
 */


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ActivityAdapter extends ArrayAdapter<ResolveInfo> implements View.OnClickListener {
    private List<ResolveInfo> activities;
    private Context context;
    private LayoutInflater layoutInflater;

    public ActivityAdapter(List<ResolveInfo> inputActivities, Context context) {
        super(context, R.layout.activity_sample, inputActivities);
        this.activities = inputActivities;
        this.context = context;
        this.layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ResolveInfo info = this.activities.get(position);
        ActivityInfoHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ActivityInfoHolder();
            convertView = this.layoutInflater.inflate(R.layout.activity_sample, parent, false);
            viewHolder.packageN = (TextView) convertView.findViewById(R.id.packageName);
            viewHolder.activityN = (TextView) convertView.findViewById(R.id.targetActivity);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ActivityInfoHolder) convertView.getTag();
        }

        viewHolder.packageN.setText(info.activityInfo.packageName);
        viewHolder.activityN.setText(info.activityInfo.name);
        viewHolder.activityN.setOnClickListener(this);
        viewHolder.activityN.setTag(position);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        ResolveInfo info = getItem(position);

        Intent intent = new Intent();
        intent.setComponent(
                new ComponentName(
                        info.activityInfo.packageName,
                        info.activityInfo.name)
        );
        this.context.startActivity(intent);
    }
}
