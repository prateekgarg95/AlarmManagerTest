package com.prateekgarg95.alarmmanagertest;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button alarmBtnStart;
    private Button alarmBtnStop;
    private CustomAlarmManager customAlarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmBtnStart = (Button)findViewById(R.id.alarm_button_start);
        alarmBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlarm();
            }
        });

        alarmBtnStop = (Button)findViewById(R.id.alarm_button_stop);
        alarmBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAlarm();
            }
        });

        customAlarmManager = new CustomAlarmManager(getApplicationContext());
    }


    private void startAlarm(){
        customAlarmManager.setNextAlarm();
        alarmBtnStop.setVisibility(View.VISIBLE);
        alarmBtnStart.setVisibility(View.GONE);
    }

    private void stopAlarm(){
        customAlarmManager.stopAlarms();
        alarmBtnStart.setVisibility(View.VISIBLE);
        alarmBtnStop.setVisibility(View.GONE);
    }
}
