package com.example.vishal_pc.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import data.DataBaseHandler;
import model.Notes;

public class DisplayNotes extends AppCompatActivity {

    private DataBaseHandler dba;
    private ArrayList<Notes> dbnotes =new ArrayList<>();
    private NoteAdapter noteAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_notes);

        refershData();
    }


    public void addNotes(View view)
    {
        Intent intent = new Intent (this,NotesInput.class);
        startActivity(intent);
    }

    public void backToMain(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    public void refershData()
    {
        dbnotes.clear();
        dba = new DataBaseHandler(getApplicationContext());
        ArrayList<Notes> notesFromDB= dba.getNotes();

        for(int i=0;i<notesFromDB.size();i++)
        {
            String title= notesFromDB.get(i).getTitle();
            String content= notesFromDB.get(i).getContent();
            String date= notesFromDB.get(i).getRecordDate();
            int mid=notesFromDB.get(i).getItemId();

            Notes note=new Notes();
            note.setTitle(title);
            note.setContent(content);
            note.setRecordDate(date);
            note.setItemId(mid);

            dbnotes.add(note);

        }
        dba.close();
        listView= (ListView) findViewById(R.id.list1);
        noteAdapter= new NoteAdapter(DisplayNotes.this,R.layout.note_row,dbnotes);
        listView.setAdapter(noteAdapter);
        noteAdapter.notifyDataSetChanged();
    }



    public class NoteAdapter extends ArrayAdapter<Notes>
    {
        Activity activity;
        int layoutResource;
        Notes note;
        ArrayList<Notes> mData= new ArrayList<>();

        @Override
        public int getCount() {
            return mData.size();
        }

        @Nullable
        @Override
        public Notes getItem(int position) {
            return mData.get(position);
        }

        @Override
        public int getPosition(Notes item) {
            return super.getPosition(item);
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row= convertView;
            ViewHolder holder=null;

            if(row== null ||(row.getTag())==null)
            {
                LayoutInflater inflater= LayoutInflater.from(activity);

                row=inflater.inflate(layoutResource,null);
                holder=new ViewHolder();

                holder.mTitle=(TextView) row.findViewById(R.id.t6);
                holder.mDate=(TextView) row.findViewById(R.id.t7);

                row.setTag(holder);
            }
            else
            {
                holder=(ViewHolder) row.getTag();
            }

            holder.note=getItem(position);

            holder.mTitle.setText(holder.note.getTitle());
            holder.mDate.setText(holder.note.getRecordDate());
            final ViewHolder  finalHolder= holder;

            holder.mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text= finalHolder.note.getContent().toString();
                    String dateText=finalHolder.note.getRecordDate().toString();
                    String title= finalHolder.note.getTitle().toString();

                    int mId= finalHolder.note.getItemId();

                    Intent intent = new Intent (DisplayNotes.this,NotesDetail.class);
                    intent.putExtra("content",text);
                    intent.putExtra("date",dateText);
                    intent.putExtra("title",title);
                    intent.putExtra("id",mId);
                    startActivity(intent);
                }
            });


            return row;
        }

        public NoteAdapter(Activity act, int resource, ArrayList<Notes> data) {
            super(act, resource,data);
            activity=act;
            layoutResource=resource;
            mData=data;
            notifyDataSetChanged();
        }

        class ViewHolder
        {
            Notes note;
            TextView mTitle,mContent,mDate;
            int mId;
        }


    }



}
