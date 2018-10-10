package com.example.vishal_pc.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import data.DataBaseHandler2;
import model.Subjects;

public class EditSubjects extends AppCompatActivity {

    private TextView sub;
    private EditText fac,rel;
    private Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_subjects);

        sub=(TextView)findViewById(R.id.t17);
        fac=(EditText)findViewById(R.id.e7);
        rel=(EditText)findViewById(R.id.e8);
        edit=(Button)findViewById(R.id.b19);

        Bundle extras=getIntent().getExtras();


        if(extras!=null)
        {
            sub.setText(extras.getString("subject"));
            fac.setText(extras.getString("faculty"));
            rel.setText(extras.getString("related"));
        }

        final String s=extras.getString("subject");
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataBaseHandler2 dba= new DataBaseHandler2(getApplicationContext());
                Subjects subject= new Subjects();
                subject.setSubject(s);
                subject.setFaculty(fac.getText().toString().trim());
                subject.setRelated(rel.getText().toString().trim());

                int c=dba.editSubject(subject);

                if(c!=-1)
                {
                    Toast.makeText(getApplicationContext(),"Successfully Updated",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Not Updated",Toast.LENGTH_LONG).show();
                }


                startActivity(new Intent(EditSubjects.this,DisplaySubjects.class));

            }
        });

    }
}
