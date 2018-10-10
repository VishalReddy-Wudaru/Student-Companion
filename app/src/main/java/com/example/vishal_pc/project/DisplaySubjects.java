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

import org.w3c.dom.Text;

import java.util.ArrayList;



import data.DataBaseHandler2;
import model.Subjects;

public class DisplaySubjects extends AppCompatActivity {


    private DataBaseHandler2 dba;
    private ArrayList<Subjects> dbsubjects = new ArrayList<>();
    private SubjectAdapter subjectAdapter;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_subjects);
        refreshData();
    }



    public void addSubjects(View view)
    {
        Intent intent = new Intent (this,SubjectInput.class);
        startActivity(intent);
    }

    public void backToMain(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    public void refreshData()
    {

        dbsubjects.clear();
        dba =new DataBaseHandler2(getApplicationContext());

        ArrayList<Subjects> subjectsFromDB= dba.getSubjects();

        for(int i=0;i<subjectsFromDB.size();i++)
        {
            String subject= subjectsFromDB.get(i).getSubject();
            String  faculty= subjectsFromDB.get(i).getFaculty();
            String relatedNote= subjectsFromDB.get(i).getRelated();
            int mid=subjectsFromDB.get(i).getSubjectId();
            int attended=subjectsFromDB.get(i).getAttended();
            int total=subjectsFromDB.get(i).getTotal();


            Subjects subjects=new Subjects();

            subjects.setSubject(subject);
            subjects.setFaculty(faculty);
            subjects.setRelated(relatedNote);
            subjects.setSubjectId(mid);
            subjects.setAttended(attended);
            subjects.setTotal(total);

            dbsubjects.add(subjects);


        }

        dba.close();
        listview = (ListView) findViewById(R.id.list2);
        subjectAdapter=new SubjectAdapter(DisplaySubjects.this,R.layout.subject_row,dbsubjects);
        listview.setAdapter(subjectAdapter);
        subjectAdapter.notifyDataSetChanged();

    }

    public class SubjectAdapter extends ArrayAdapter<Subjects>
    {
        Activity activity;
        int layoutResource;
        Subjects subject;
        ArrayList<Subjects> mData = new ArrayList<>();

        @Override
        public int getCount() {
            return mData.size();
        }

        @Nullable
        @Override
        public Subjects getItem(int position) {
            return mData.get(position);
        }

        @Override
        public int getPosition(Subjects item) {
            return super.getPosition(item);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            View row= convertView;
            ViewHolder holder=null;

            if(row==null || (row.getTag())==null )
            {
                LayoutInflater inflater=LayoutInflater.from(activity);

                row=inflater.inflate(layoutResource,null);
                holder= new ViewHolder();

                holder.mSubject=(TextView) row.findViewById(R.id.t14);
                holder.mFaculty= (TextView) row.findViewById(R.id.t15);

                row.setTag(holder);
            }
            else
            {
                holder=(ViewHolder) row.getTag();
            }

            holder.subject=getItem(position);

            holder.mSubject.setText(holder.subject.getSubject());
            holder.mFaculty.setText(holder.subject.getFaculty());
            //holder.mSubject.setText("Hi");
            //holder.mFaculty.setText("Hello");
            final ViewHolder finalHolder= holder;


            holder.mSubject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sub=finalHolder.subject.getSubject().toString();
                    String fac=finalHolder.subject.getFaculty().toString();
                    String rel=finalHolder.subject.getRelated().toString();
                    int att=finalHolder.subject.getAttended();
                    int tot=finalHolder.subject.getTotal();
                    int mId=finalHolder.subject.getSubjectId();


                    Intent intent=new Intent(DisplaySubjects.this,SubjectDetail.class);
                    intent.putExtra("subject",sub);
                    intent.putExtra("faculty",fac);
                    intent.putExtra("related",rel);
                    intent.putExtra("id",mId);
                    intent.putExtra("total",tot);
                    intent.putExtra("attended",att);
                    startActivity(intent);
                }
            });




            return row;
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        public SubjectAdapter(Activity act, int resource, ArrayList<Subjects> data) {
            super(act, resource,data);
            activity=act;
            layoutResource=resource;
            mData=data;
            notifyDataSetChanged();
        }

        class ViewHolder
        {
            Subjects subject;
            TextView mSubject,mFaculty,mRelated,mTotal,mAttended;
            int mId;
        }
    }


}
