package com.example.vishal_pc.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import data.DataBaseHandler;
import model.Notes;

public class EditNotes extends AppCompatActivity {

    private EditText content;
    private Button edit;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notes);


        title=(TextView)findViewById(R.id.t16);
        content=(EditText)findViewById(R.id.e6);
        edit=(Button)findViewById(R.id.b18);


        Bundle extras=getIntent().getExtras();

        if(extras!=null)
        {
            content.setText(extras.getString("content"));
            title.setText(extras.getString("title"));
        }

        final String s=extras.getString("title");
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHandler dba= new DataBaseHandler(getApplicationContext());
                Notes note=new Notes();
                note.setTitle(s);
                note.setContent(content.getText().toString().trim());

                int c=dba.editNotes(note);

                if(c!=-1)
                {
                    Toast.makeText(getApplicationContext(),"Successfully Updated",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Not Updated",Toast.LENGTH_LONG).show();
                }

                startActivity(new Intent(EditNotes.this,DisplayNotes.class));

            }
        });


    }
}
