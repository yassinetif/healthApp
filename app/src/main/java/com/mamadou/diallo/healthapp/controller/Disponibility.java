package com.mamadou.diallo.healthapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;

import com.mamadou.diallo.healthapp.R;

import java.util.Calendar;

public class Disponibility extends AppCompatActivity {

    private CalendarView simpleCalendarView;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disponibility);

        calendar = Calendar.getInstance();
        simpleCalendarView = (CalendarView) findViewById(R.id.activity_make_an_appointment_calendar_btn); // get the reference of CalendarView

        Long min = calendar.getTime().getTime();
        simpleCalendarView.setMinDate(min);

        calendar.add(Calendar.MONTH, 2);

        int today = calendar.getActualMaximum(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DAY_OF_MONTH, today);
        Long max = calendar.getTime().getTime();
        simpleCalendarView.setMaxDate(max);
    }

    private void language_setting(){
        Intent intent = new Intent(getApplicationContext(),SettingLanguageActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_language:
                language_setting();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
