package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import model.Subjects;

/**
 * Created by VISHAL-PC on 4/22/2017.
 */

public class DataBaseHandler2 extends SQLiteOpenHelper {

    private final ArrayList<Subjects> subjectList= new ArrayList<>();



    public DataBaseHandler2(Context context) {
        super(context, Constants2.DATABASE_NAME, null, Constants2.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v("DB1 Sucessfully added","yeah");

        String CREATE_SUBJECTS_TABLE="CREATE TABLE "+Constants2.TABLE_NAME+
                "("+Constants2.KEY_ID+" INTEGER PRIMARY KEY, "+Constants2.SUBJECT_NAME+
                " TEXT, "+Constants2.FACULTY_NAME+" TEXT, "+Constants2.ATTENDED_NAME+" INTEGER, "+
                Constants2.TOTAL_NAME+" INTEGER, "+Constants2.RELATED_NAME+ " LONG);";
        db.execSQL(CREATE_SUBJECTS_TABLE);

        Log.v("DB1 Sucessfully added","yeah");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+Constants2.TABLE_NAME);

        //To create new one.
        onCreate(db);

    }


    public void addSubjects(Subjects subject)
    {

        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues values =new ContentValues();
        //values.put(Constants2.SUBJECT_NAME,"MAD");
        values.put(Constants2.SUBJECT_NAME,subject.getSubject());
        values.put(Constants2.FACULTY_NAME,subject.getFaculty());
        values.put(Constants2.ATTENDED_NAME,subject.getAttended());
        values.put(Constants2.TOTAL_NAME,subject.getTotal());
        values.put(Constants2.RELATED_NAME,subject.getRelated());

        db.insert(Constants2.TABLE_NAME,null,values);

        db.close();

        Log.v("Subj Sucessfully added","yeah");

    }

    public int updateAttendance(Subjects subject)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put(Constants2.ATTENDED_NAME,subject.getAttended()+1);
        values.put(Constants2.TOTAL_NAME,subject.getTotal()+1);


        int i=db.update(Constants2.TABLE_NAME, values, Constants2.SUBJECT_NAME + " = ?", new String[]{String.valueOf(subject.getSubject())});

        db.close();
        return i;
    }

    public int updateAttendance2(Subjects subject)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put(Constants2.TOTAL_NAME,subject.getTotal()+1);


        int i=db.update(Constants2.TABLE_NAME, values, Constants2.SUBJECT_NAME + " = ?", new String[]{String.valueOf(subject.getSubject())});

        db.close();
        return i;
    }

    public int editSubject(Subjects subject)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put(Constants2.FACULTY_NAME,subject.getFaculty());
        values.put(Constants2.RELATED_NAME,subject.getRelated());


        int i=db.update(Constants2.TABLE_NAME, values, Constants2.SUBJECT_NAME + " = ?", new String[]{String.valueOf(subject.getSubject())});

        db.close();
        return i;
    }

    public Subjects getSubject(String sub)
    {
        String selectQuery="SELECT * FROM "+Constants2.TABLE_NAME+" WHERE "+Constants2.SUBJECT_NAME+" = "+sub;
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.query(Constants2.TABLE_NAME,new String[]{Constants2.KEY_ID,
                        Constants2.SUBJECT_NAME,Constants2.FACULTY_NAME,Constants2.ATTENDED_NAME,
                        Constants2.TOTAL_NAME,Constants2.RELATED_NAME},
                null,null,null,null,null);
        Subjects subject= new Subjects();

        if(cursor.moveToFirst())
        {

                subject.setSubject(cursor.getString(cursor.getColumnIndex(Constants2.SUBJECT_NAME)));
                subject.setFaculty(cursor.getString(cursor.getColumnIndex(Constants2.FACULTY_NAME)));
                subject.setSubjectId(cursor.getInt(cursor.getColumnIndex(Constants2.KEY_ID)));
                subject.setAttended(cursor.getInt(cursor.getColumnIndex(Constants2.ATTENDED_NAME)));
                subject.setTotal(cursor.getInt(cursor.getColumnIndex(Constants2.TOTAL_NAME)));
                subject.setRelated(cursor.getString(cursor.getColumnIndex(Constants2.RELATED_NAME)));

        }
        Log.v("subject:",subject.getSubject()+" att "+subject.getAttended());
        return subject;

    }


    public ArrayList<Subjects> getSubjects()
    {
        String selectQuery="SELECT * FROM "+Constants2.TABLE_NAME;

        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor= db.query(Constants2.TABLE_NAME,new String[]{Constants2.KEY_ID,
                        Constants2.SUBJECT_NAME,Constants2.FACULTY_NAME,Constants2.ATTENDED_NAME,
                Constants2.TOTAL_NAME,Constants2.RELATED_NAME},
                null,null,null,null, Constants2.SUBJECT_NAME+" DESC");

        if(cursor.moveToFirst())
        {
            do {
                Subjects subject= new Subjects();
                subject.setSubject(cursor.getString(cursor.getColumnIndex(Constants2.SUBJECT_NAME)));
                subject.setFaculty(cursor.getString(cursor.getColumnIndex(Constants2.FACULTY_NAME)));
                subject.setSubjectId(cursor.getInt(cursor.getColumnIndex(Constants2.KEY_ID)));
                subject.setAttended(cursor.getInt(cursor.getColumnIndex(Constants2.ATTENDED_NAME)));
                subject.setTotal(cursor.getInt(cursor.getColumnIndex(Constants2.TOTAL_NAME)));
                subject.setRelated(cursor.getString(cursor.getColumnIndex(Constants2.RELATED_NAME)));

                subjectList.add(subject);

            }while(cursor.moveToNext());
        }


        return subjectList;
    }


    public void delete(int id)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(Constants2.TABLE_NAME,Constants.KEY_ID+" = ? ",
                new String[]{String.valueOf(id)});
    }


}
