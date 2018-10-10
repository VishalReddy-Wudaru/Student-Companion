package com.example.vishal_pc.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.DataBaseHandler3;
import model.Period;

public class EditPeriods extends AppCompatActivity {

    private EditText subj,room;
    private Button save,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_periods);

        subj=(EditText)findViewById(R.id.e9);
        room=(EditText)findViewById(R.id.e10);

        save=(Button)findViewById(R.id.b27);
        cancel=(Button)findViewById(R.id.b28);

        Bundle extras=getIntent().getExtras();

        if(extras!=null)
        {
            String sub=extras.getString("subject");
            String s="";
            int i=0;
            while(sub.charAt(i)!='\n')
            {
                s=s+sub.charAt(i);
                i++;
            }
            final String s1=s;
            i++;
            s="";
            while(i<sub.length())
            {
                s=s+sub.charAt(i);
                i++;
            }
            final String s2=s;
            subj.setText(s1);
            room.setText(s2);
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditPeriods.this,TimeTable.class);
                startActivity(intent);
            }
        });




        final String per=extras.getString("period");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Period period=new Period();
                period.setPeriodName(per);
                period.setSubjectName(subj.getText().toString().trim());
                period.setRoom(room.getText().toString().trim());
                Log.v("period1: ",per+" subject: "+subj.getText().toString().trim()+" room: "+room.getText().toString().trim());

                DataBaseHandler3 dba= new DataBaseHandler3(getApplicationContext());
                int c=dba.editPeriod(period);

                if(c!=-1)
                {
                    Toast.makeText(getApplicationContext(),"Successfully Updated",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Not Updated",Toast.LENGTH_LONG).show();
                }


                startActivity(new Intent(EditPeriods.this,TimeTable.class));


            }
        });

    }
}
