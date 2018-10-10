package com.example.vishal_pc.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Bunk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunk);
    }

    public void calculation(View view) {
        EditText a = (EditText) findViewById(R.id.et1);
        EditText b = (EditText) findViewById(R.id.et2);
        EditText c = (EditText) findViewById(R.id.et3);
        TextView Result1 = (TextView) findViewById(R.id.tv1);
        TextView Result2 = (TextView) findViewById(R.id.tv2);
        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        String txt1 = a.getText().toString();
        String txt2 = b.getText().toString();
        String txt3 = c.getText().toString();
        if(txt1.length()>0 && txt2.length()>0 && txt3.length()>0)
        {
            int aa = Integer.parseInt(txt1);
            int bb = Integer.parseInt(txt2);
            int cc = Integer.parseInt(txt3);
            Log.v("a,b,c", aa + " " + " " + bb + " " + cc);
            double dd = ((bb * 100) / aa);
            Log.v("d", dd + "");
            String Res1 = String.valueOf(dd);
            int da = aa;
            int db = bb;
            int ddd = (int) dd;
            Log.v("d", ddd + "");
            if (ddd > cc) {
                dd = ((db * 100) / da);
                ddd = (int) dd;
                Log.v("d1", ddd + "");
                while (cc <= ddd) {
                    da++;
                    Log.v("d", ddd + "");
                    dd = ((db * 100) / da);
                    ddd = (int) dd;
                }
                Result1.setText("Attendance:" + Res1);
                aa = (da - aa - 1);
                String Res2 = String.valueOf(aa);
                Result2.setText("You can bunk next " + Res2 + " Classes");

            } else if (ddd < cc) {
                dd = ((db * 100) / da);
                ddd = (int) dd;
                Log.v("d1", ddd + "");
                while (cc > ddd) {
                    da++;
                    db++;
                    dd = ((db * 100) / da);
                    ddd = (int) dd;
                    Log.v("d1", ddd + "");
                }
                Result1.setText("Attendance:" + Res1);
                aa = (da - aa + 1);
                String Res2 = String.valueOf(aa);
                Result2.setText("You must attend next " + Res2 + " Classes");

            } else {
                Result1.setText("Attendance:" + Res1);
                Result2.setText("You ");
                Result2.setText("You dont have any safe Bunks");
            }
        }
        else
        {
            Result2.setText("Enter Correct Details");
        }
    }
    public void reset(View view) {
        EditText a=(EditText)findViewById(R.id.et1);
        EditText b=(EditText)findViewById(R.id.et2);
        EditText c = (EditText)findViewById(R.id.et3);
        TextView Result1 = (TextView) findViewById(R.id.tv1);
        TextView Result2 = (TextView) findViewById(R.id.tv2);
        a.setText("");
        b.setText("");
        c.setText("");
        Result1.setText("");
        Result2.setText("");
    }
    public void back(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
