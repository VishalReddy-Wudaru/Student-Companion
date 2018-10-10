package com.example.vishal_pc.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import data.DataBaseHandler;
import data.DataBaseHandler2;
import model.Subjects;

public class SubjectDetail extends AppCompatActivity {

    private TextView sub1,fac1,rel1,att1,tot1,per;
    private Button deleteButton,attendedButton,notattendButton,editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);

        sub1=(TextView)findViewById(R.id.t9);
        fac1=(TextView)findViewById(R.id.t10);
        rel1=(TextView)findViewById(R.id.t13);
        att1=(TextView)findViewById(R.id.t11);
        tot1=(TextView) findViewById(R.id.t12);
        per=(TextView)findViewById(R.id.t19);
        deleteButton=(Button) findViewById(R.id.b12);
        attendedButton=(Button) findViewById(R.id.b15);
        notattendButton=(Button) findViewById(R.id.b16);
        editButton=(Button) findViewById(R.id.b20);


        Bundle extras=getIntent().getExtras();

        if(extras!=null)
        {
            sub1.setText("Subject: "+extras.getString("subject"));
            fac1.setText("Faculty: "+extras.getString("faculty"));
            rel1.setText("Related: "+extras.getString("related"));
            att1.setText("Classes Attended: "+extras.getInt("attended"));
            tot1.setText("Total Classes: "+extras.getInt("total"));
            if(extras.getInt("total")==0)
            {
                per.setText("Percentage: "+"0%");
            }
            else
            {
                per.setText("Percentage: " + ((extras.getInt("attended") * 100) / extras.getInt("total"))+"%");
            }

            final int id =extras.getInt("id");
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataBaseHandler2 dba= new DataBaseHandler2(getApplicationContext());
                    dba.delete(id);

                    Toast.makeText(getApplicationContext(),"Subject Deleted",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(SubjectDetail.this,DisplaySubjects.class));
                }
            });

            final int att=extras.getInt("attended");
            final int  tot=extras.getInt("total");
            final String sub=extras.getString("subject");
            final String fac=extras.getString("faculty");
            final String rel=extras.getString("related");
            attendedButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataBaseHandler2 dba= new DataBaseHandler2(getApplicationContext());
                    Subjects subject=new Subjects();

                    subject.setAttended(att);
                    subject.setTotal(tot);
                    subject.setSubject(sub);

                    int c=dba.updateAttendance(subject);

                    if(c!=-1)
                    {
                        Toast.makeText(getApplicationContext(),"Attendance recorded",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Attendance not recorded",Toast.LENGTH_LONG).show();
                    }

                    startActivity(new Intent(SubjectDetail.this,DisplaySubjects.class));

                }
            });


            notattendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DataBaseHandler2 dba= new DataBaseHandler2(getApplicationContext());
                    Subjects subject=new Subjects();

                    subject.setTotal(tot);
                    subject.setSubject(sub);

                    int c=dba.updateAttendance2(subject);

                    if(c!=-1)
                    {
                        Toast.makeText(getApplicationContext(),"Attendance recorded",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Attendance not recorded",Toast.LENGTH_LONG).show();
                    }


                    startActivity(new Intent(SubjectDetail.this,DisplaySubjects.class));

                }
            });



            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (SubjectDetail.this,EditSubjects.class);
                    intent.putExtra("subject",sub);
                    intent.putExtra("faculty",fac);
                    intent.putExtra("related",rel);
                    startActivity(intent);

                }
            });


        }






    }




    public void backToSubDisplay1(View view)
    {
        Intent intent= new Intent(this,DisplaySubjects.class);
        startActivity(intent);
    }


}
