package com.example.vishal_pc.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.view.View;

import data.DataBaseHandler;
import data.DataBaseHandler2;
import model.Subjects;

import static android.support.v7.appcompat.R.styleable.View;

public class SubjectInput extends AppCompatActivity {

    private EditText sub,fac,rel;
    private DataBaseHandler2 dba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_input);
    }

    public void backToSubDisplay(View view)
    {
        Intent intent = new Intent(this,DisplaySubjects.class);
        startActivity(intent);
    }


    public void saveSubject(View view)
    {
        dba=new DataBaseHandler2(getApplicationContext());

        sub=(EditText) findViewById(R.id.e3);
        fac=(EditText) findViewById(R.id.e4);
        rel=(EditText) findViewById(R.id.e5);
        //rel.setText(sub.getText()+" "+fac.getText());
        Log.v("Subj Sucessfully added","sveSubj");
        saveToDB2();

    }


    public void saveToDB2()
    {
        Subjects subject= new Subjects();
        subject.setSubject(sub.getText().toString().trim());
        subject.setFaculty(fac.getText().toString().trim());
        subject.setAttended(0);
        subject.setTotal(0);
        subject.setRelated(rel.getText().toString().trim());


        dba.addSubjects(subject);
        dba.close();

        sub.setText("");
        fac.setText("");
        rel.setText("");
        Log.v("Subj Sucessfully added","saveto2");

        Intent intent= new Intent(this,DisplaySubjects.class);
        startActivity(intent);
        Log.v("Subj Sucessfully added","intnet");
    }


}
