package com.example.vishal_pc.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void notes(View view)
    {
        /*TextView t1= (TextView)findViewById(R.id.t1);
        Button b= (Button)findViewById(R.id.b1);
        TimePicker tp= (TimePicker)findViewById(R.id.time);
        int hour = tp.getCurrentHour();
        int min = tp.getCurrentMinute();
        t1.setText("hr "+hour+" min "+min);*/
        Intent intent= new Intent(this,DisplayNotes.class);
        startActivity(intent);
    }


    public void subjects(View view)
    {
        Intent intent=new Intent(this,DisplaySubjects.class);
        startActivity(intent);
    }

    public void bunk(View view)
    {
        Intent intent = new Intent(this,Bunk.class);
        startActivity(intent);
    }

    public void timetable(View view)
    {
        Intent intent = new Intent(this,TimeTable.class);
        startActivity(intent);
    }

}
