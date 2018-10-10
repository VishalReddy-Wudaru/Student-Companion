package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

import model.Notes;

/**
 * Created by VISHAL-PC on 4/20/2017.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    private final ArrayList<Notes> noteList= new ArrayList<>();

    public DataBaseHandler(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v("DB1 Sucessfully added","yeah");

        String CREATE_NOTES_TABLE="CREATE TABLE "+Constants.TABLE_NAME+
                "("+Constants.KEY_ID+" INTEGER PRIMARY KEY, "+Constants.TITLE_NAME+
                " TEXT, "+Constants.CONTENT_NAME+" TEXT, "+Constants.DATE_NAME+
                " LONG);";
        db.execSQL(CREATE_NOTES_TABLE);
        Log.v("DB2 Sucessfully added","yeah");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v("DB3 Sucessfully added","yeah");

        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLE_NAME);

        //To create new one.
        onCreate(db);

    }

    public void addNotes(Notes note)
    {

        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put(Constants.TITLE_NAME,note.getTitle());
        values.put(Constants.CONTENT_NAME,note.getContent());
        values.put(Constants.DATE_NAME, java.lang.System.currentTimeMillis());

        db.insert(Constants.TABLE_NAME,null,values);

        db.close();

        Log.v("Note Sucessfully added","yeah");

    }

    public int editNotes(Notes note)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put(Constants.TITLE_NAME,note.getTitle());
        values.put(Constants.CONTENT_NAME,note.getContent());

        int i=db.update(Constants.TABLE_NAME, values, Constants.TITLE_NAME + " = ?", new String[]{String.valueOf(note.getTitle())});
        db.close();
        return i;

    }

    public ArrayList<Notes> getNotes()
    {
        String selectQuery="SELECT * FROM "+Constants.TABLE_NAME;

        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor= db.query(Constants.TABLE_NAME,new String[]{Constants.KEY_ID,
        Constants.TITLE_NAME,Constants.CONTENT_NAME,Constants.DATE_NAME},
                null,null,null,null, Constants.DATE_NAME+" DESC");

        if(cursor.moveToFirst())
        {
            do {
                Notes note= new Notes();
                note.setTitle(cursor.getString(cursor.getColumnIndex(Constants.TITLE_NAME)));
                note.setContent(cursor.getString(cursor.getColumnIndex(Constants.CONTENT_NAME)));
                note.setItemId(cursor.getInt(cursor.getColumnIndex(Constants.KEY_ID)));

                java.text.DateFormat dateformat= java.text.DateFormat.getDateInstance();
                String dateData = dateformat.format(new Date(cursor.getLong(cursor.getColumnIndex(Constants.DATE_NAME))).getTime());

                note.setRecordDate(dateData);

                noteList.add(note);

            }while(cursor.moveToNext());
        }


        return noteList;
    }


    public void delete(int id)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(Constants.TABLE_NAME,Constants.KEY_ID+" = ? ",
                new String[]{String.valueOf(id)});
    }


}
