package com.prateekgarg95.alarmmanagertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    private CustomAlarmManager customAlarmManager;

    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"ALARM",Toast.LENGTH_SHORT).show();
        customAlarmManager = new CustomAlarmManager(context.getApplicationContext());
        customAlarmManager.setNextAlarm();
    }
}
