package com.example.vishal_pc.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import data.DataBaseHandler;
import model.Notes;

public class NotesInput extends AppCompatActivity {

    private EditText title,notes;
    private Button saveButton;
    private DataBaseHandler dba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_input);
    }

    public void saveNotes(View view)
    {
        dba=new DataBaseHandler(getApplicationContext());

        title=(EditText)findViewById(R.id.e1);
        notes=(EditText)findViewById(R.id.e2);

        saveToDB();
    }


    public void cancel(View view)
    {
        Intent intent= new Intent (this,DisplayNotes.class);
        startActivity(intent);
    }


    public void saveToDB()
    {
        Notes note= new Notes();
        note.setTitle(title.getText().toString().trim());
        note.setContent(notes.getText().toString().trim());

        dba.addNotes(note);
        dba.close();

        title.setText("");
        notes.setText("");

        Intent intent= new Intent(this,DisplayNotes.class);
        startActivity(intent);

    }

}
