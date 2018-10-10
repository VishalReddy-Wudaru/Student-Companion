package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import model.Period;

/**
 * Created by VISHAL-PC on 4/24/2017.
 */

public class DataBaseHandler3 extends SQLiteOpenHelper {


    private final ArrayList<Period> periodList= new ArrayList<>();


    public DataBaseHandler3(Context context) {
        super(context, Constants3.DATABASE_NAME, null, Constants3.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_PERIOD_TABLE="CREATE TABLE "+Constants3.TABLE_NAME+
                "("+Constants3.KEY_ID+" INT PRIMARY KEY, "+Constants3.PERIOD_NAME+
                " TEXT UNIQUE, "+Constants3.SUBJECT_NAME+" TEXT, "+Constants3.ROOM_NAME+" TEXT, "+
                Constants3.DAY_NAME+" TEXT);";
        db.execSQL(CREATE_PERIOD_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+Constants3.TABLE_NAME);

        //To create new one.
        onCreate(db);

    }

    public void addPeriod()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String selectQuery="SELECT * FROM "+Constants3.TABLE_NAME;
        Cursor cursor= db.query(Constants3.TABLE_NAME,new String[]{Constants3.KEY_ID,
                        Constants3.PERIOD_NAME,Constants3.SUBJECT_NAME,Constants3.ROOM_NAME,Constants3.DAY_NAME},
                null,null,null,null,null);
        if(cursor.moveToFirst())
        {

        }
        else
        {
            SQLiteDatabase dba=this.getWritableDatabase();
            for(int i=1;i<10;i++)
            {
                ContentValues values=new ContentValues();
                values.put(Constants3.PERIOD_NAME,"tmo"+i);
                values.put(Constants3.SUBJECT_NAME,"abc");
                values.put(Constants3.ROOM_NAME,"xyz");
                values.put(Constants3.DAY_NAME,"Monday");

                db.insert(Constants3.TABLE_NAME,null,values);
            }

            for(int i=1;i<10;i++)
            {
                ContentValues values=new ContentValues();
                values.put(Constants3.PERIOD_NAME,"ttu"+i);
                values.put(Constants3.SUBJECT_NAME,"def");
                values.put(Constants3.ROOM_NAME,"zxy");
                values.put(Constants3.DAY_NAME,"Tuesday");

                db.insert(Constants3.TABLE_NAME,null,values);
            }

            for(int i=1;i<10;i++)
            {
                ContentValues values=new ContentValues();
                values.put(Constants3.PERIOD_NAME,"twe"+i);
                values.put(Constants3.SUBJECT_NAME,"ghi");
                values.put(Constants3.ROOM_NAME,"yzx");
                values.put(Constants3.DAY_NAME,"Wednesday");

                db.insert(Constants3.TABLE_NAME,null,values);
            }

            for(int i=1;i<10;i++)
            {
                ContentValues values=new ContentValues();
                values.put(Constants3.PERIOD_NAME,"tth"+i);
                values.put(Constants3.SUBJECT_NAME,"jkl");
                values.put(Constants3.ROOM_NAME,"zyx");
                values.put(Constants3.DAY_NAME,"Thursday");

                db.insert(Constants3.TABLE_NAME,null,values);
            }

            for(int i=1;i<10;i++)
            {
                ContentValues values=new ContentValues();
                values.put(Constants3.PERIOD_NAME,"tfr"+i);
                values.put(Constants3.SUBJECT_NAME,"mno");
                values.put(Constants3.ROOM_NAME,"xzy");
                values.put(Constants3.DAY_NAME,"Friday");

                db.insert(Constants3.TABLE_NAME,null,values);
            }
            db.close();
        }
    }


    public int editPeriod(Period period)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put(Constants3.SUBJECT_NAME,period.getSubjectName());
        values.put(Constants3.ROOM_NAME,period.getRoom());


        int i=db.update(Constants3.TABLE_NAME, values, Constants3.PERIOD_NAME + " = ?", new String[]{String.valueOf(period.getPeriodName())});

        db.close();
        return i;
    }

    public ArrayList<Period> getPeriods()
    {

        String selectQuery="SELECT * FROM "+Constants3.TABLE_NAME;

        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor= db.query(Constants3.TABLE_NAME,new String[]{Constants3.KEY_ID,
                        Constants3.PERIOD_NAME,Constants3.SUBJECT_NAME,Constants3.ROOM_NAME,},
                null,null,null,null,null);

        if(cursor.moveToFirst())
        {
            do {
                Period period= new Period();
                period.setPeriodName(cursor.getString(cursor.getColumnIndex(Constants3.PERIOD_NAME)));
                period.setSubjectName(cursor.getString(cursor.getColumnIndex(Constants3.SUBJECT_NAME)));
                period.setRoom(cursor.getString(cursor.getColumnIndex(Constants3.ROOM_NAME)));


                periodList.add(period);

            }while(cursor.moveToNext());
        }


        return periodList;
    }

}
