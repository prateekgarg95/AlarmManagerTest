package com.prateekgarg95.alarmmanagertest;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class CustomAlarmManager {

    private static final String TAG = "CUSTOM_ALARM";

    private Intent intent;
    private PendingIntent pendingIntent;
    private AlarmManager alarmManager;
    private static final long INTERVAL = 2000;

    public CustomAlarmManager(Context context) {

        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        intent = new Intent(context, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(context, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public void setNextAlarm(){
        Log.d(TAG, "setting next alarm...");
        alarmManager.set(AlarmManager.RTC_WAKEUP, (System.currentTimeMillis() + INTERVAL), pendingIntent);
    }

    public void stopAlarms(){
        Log.d(TAG, "stopping Alarms");
        alarmManager.cancel(pendingIntent);
    }
}
