package com.example.vishal_pc.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import data.DataBaseHandler2;
import model.Subjects;

public class PeriodsDetail extends AppCompatActivity {

    private TextView sub;
    private Button edit,back,att,abs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periods_detail);

        sub=(TextView)findViewById(R.id.t18);
        edit=(Button)findViewById(R.id.b23);
        back=(Button)findViewById(R.id.b24);
        att=(Button)findViewById(R.id.b25);
        abs=(Button)findViewById(R.id.b26);

        Bundle extras=getIntent().getExtras();

        if(extras!=null)
        {
            sub.setText(extras.getString("subject"));
        }
        String s="";
        int i=0;
        final String sub=extras.getString("subject");
        while(sub.charAt(i)!='\n')
        {
            s=s+sub.charAt(i);
            i++;
        }
        DataBaseHandler2 dba=new DataBaseHandler2(getApplicationContext());
        final Subjects sub1=dba.getSubject(s);
        final String period=extras.getString("period");
        //Log.v("period1: ",period);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PeriodsDetail.this,EditPeriods.class);
                intent.putExtra("period",period);
                intent.putExtra("subject",sub);
                startActivity(intent);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PeriodsDetail.this,TimeTable.class);
                startActivity(intent);
            }
        });

        att.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHandler2 dba=new DataBaseHandler2(getApplicationContext());
                int c=dba.updateAttendance(sub1);

                if(c!=-1)
                {
                    Toast.makeText(getApplicationContext(),"Attendance recorded",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Attendance not recorded",Toast.LENGTH_LONG).show();
                }

                startActivity(new Intent(PeriodsDetail.this,TimeTable.class));

            }
        });

        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHandler2 dba=new DataBaseHandler2(getApplicationContext());
                int c=dba.updateAttendance2(sub1);

                if(c!=-1)
                {
                    Toast.makeText(getApplicationContext(),"Attendance recorded",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Attendance not recorded",Toast.LENGTH_LONG).show();
                }

                startActivity(new Intent(PeriodsDetail.this,TimeTable.class));

            }
        });

    }
}
