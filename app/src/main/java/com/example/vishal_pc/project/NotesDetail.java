package com.example.vishal_pc.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import data.DataBaseHandler;

public class NotesDetail extends AppCompatActivity {

    private TextView title,content,date;
    private Button deleteButton,editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_detail);

        title=(TextView)findViewById(R.id.t3);
        content=(TextView)findViewById(R.id.t4);
        date=(TextView)findViewById(R.id.t5);
        deleteButton=(Button)findViewById(R.id.b3);
        editButton=(Button)findViewById(R.id.b17);

        Bundle extras=getIntent().getExtras();

        if(extras!=null)
        {
            title.setText(extras.getString("title"));
            content.setText("\""+extras.getString("content")+"\"");
            date.setText("Created: "+extras.getString("date"));

            final int id =extras.getInt("id");
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataBaseHandler dba= new DataBaseHandler(getApplicationContext());
                    dba.delete(id);

                    Toast.makeText(getApplicationContext(),"Note Deleted",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(NotesDetail.this,DisplayNotes.class));
                }
            });

            final String ti=extras.getString("title");
            final String co=extras.getString("content");
            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (NotesDetail.this,EditNotes.class);
                    intent.putExtra("content",co);
                    intent.putExtra("title",ti);
                    startActivity(intent);
                }
            });


        }


    }


    public void backToDisplay(View view)
    {
        Intent intent= new Intent (this,DisplayNotes.class);
        startActivity(intent);
    }
}
