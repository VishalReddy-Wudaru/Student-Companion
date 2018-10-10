package com.example.vishal_pc.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;

import data.DataBaseHandler3;
import model.Period;

public class TimeTable extends AppCompatActivity {

    private DataBaseHandler3 dba;
    //private ArrayList<Period> dbperiods= new ArrayList<>();
    private TextView mo[]=new TextView[9];
    private TextView tu[]=new TextView[9];
    private TextView we[]=new TextView[9];
    private TextView th[]=new TextView[9];
    private TextView fr[]=new TextView[9];
    private Button back;
    private int c=1,j=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);


        back=(Button)findViewById(R.id.b29);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimeTable.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mo[0]=(TextView)findViewById(R.id.tmo1);
        mo[1]=(TextView)findViewById(R.id.tmo2);
        mo[2]=(TextView)findViewById(R.id.tmo3);
        mo[3]=(TextView)findViewById(R.id.tmo4);
        mo[4]=(TextView)findViewById(R.id.tmo5);
        mo[5]=(TextView)findViewById(R.id.tmo6);
        mo[6]=(TextView)findViewById(R.id.tmo7);
        mo[7]=(TextView)findViewById(R.id.tmo8);
        mo[8]=(TextView)findViewById(R.id.tmo9);


        tu[0]=(TextView)findViewById(R.id.ttu1);
        tu[1]=(TextView)findViewById(R.id.ttu2);
        tu[2]=(TextView)findViewById(R.id.ttu3);
        tu[3]=(TextView)findViewById(R.id.ttu4);
        tu[4]=(TextView)findViewById(R.id.ttu5);
        tu[5]=(TextView)findViewById(R.id.ttu6);
        tu[6]=(TextView)findViewById(R.id.ttu7);
        tu[7]=(TextView)findViewById(R.id.ttu8);
        tu[8]=(TextView)findViewById(R.id.ttu9);

        we[0]=(TextView)findViewById(R.id.twe1);
        we[1]=(TextView)findViewById(R.id.twe2);
        we[2]=(TextView)findViewById(R.id.twe3);
        we[3]=(TextView)findViewById(R.id.twe4);
        we[4]=(TextView)findViewById(R.id.twe5);
        we[5]=(TextView)findViewById(R.id.twe6);
        we[6]=(TextView)findViewById(R.id.twe7);
        we[7]=(TextView)findViewById(R.id.twe8);
        we[8]=(TextView)findViewById(R.id.twe9);


        th[0]=(TextView)findViewById(R.id.tth1);
        th[1]=(TextView)findViewById(R.id.tth2);
        th[2]=(TextView)findViewById(R.id.tth3);
        th[3]=(TextView)findViewById(R.id.tth4);
        th[4]=(TextView)findViewById(R.id.tth5);
        th[5]=(TextView)findViewById(R.id.tth6);
        th[6]=(TextView)findViewById(R.id.tth7);
        th[7]=(TextView)findViewById(R.id.tth8);
        th[8]=(TextView)findViewById(R.id.tth9);

        fr[0]=(TextView)findViewById(R.id.tfr1);
        fr[1]=(TextView)findViewById(R.id.tfr2);
        fr[2]=(TextView)findViewById(R.id.tfr3);
        fr[3]=(TextView)findViewById(R.id.tfr4);
        fr[4]=(TextView)findViewById(R.id.tfr5);
        fr[5]=(TextView)findViewById(R.id.tfr6);
        fr[6]=(TextView)findViewById(R.id.tfr7);
        fr[7]=(TextView)findViewById(R.id.tfr8);
        fr[8]=(TextView)findViewById(R.id.tfr9);

        refeshData();

        mo[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tmo1");
                intent.putExtra("subject",mo[0].getText());
                startActivity(intent);
            }
        });

        mo[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tmo2");
                intent.putExtra("subject",mo[1].getText());
                startActivity(intent);
            }
        });

        mo[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tmo3");
                intent.putExtra("subject",mo[2].getText());
                startActivity(intent);
            }
        });

        mo[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tmo4");
                intent.putExtra("subject",mo[3].getText());
                startActivity(intent);
            }
        });

        mo[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tmo5");
                intent.putExtra("subject",mo[4].getText());
                startActivity(intent);
            }
        });

        mo[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tmo6");
                intent.putExtra("subject",mo[5].getText());
                startActivity(intent);
            }
        });

        mo[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tmo7");
                intent.putExtra("subject",mo[6].getText());
                startActivity(intent);
            }
        });


        mo[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tmo8");
                intent.putExtra("subject",mo[7].getText());
                startActivity(intent);
            }
        });

        mo[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tmo9");
                intent.putExtra("subject",mo[8].getText());
                startActivity(intent);
            }
        });






        tu[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","ttu1");
                intent.putExtra("subject",tu[0].getText());
                startActivity(intent);
            }
        });


        tu[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","ttu2");
                intent.putExtra("subject",tu[1].getText());
                startActivity(intent);
            }
        });

        tu[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","ttu3");
                intent.putExtra("subject",tu[2].getText());
                startActivity(intent);
            }
        });

        tu[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","ttu4");
                intent.putExtra("subject",tu[3].getText());
                startActivity(intent);
            }
        });

        tu[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","ttu5");
                intent.putExtra("subject",tu[4].getText());
                startActivity(intent);
            }
        });

        tu[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","ttu6");
                intent.putExtra("subject",tu[5].getText());
                startActivity(intent);
            }
        });

        tu[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","ttu7");
                intent.putExtra("subject",tu[6].getText());
                startActivity(intent);
            }
        });

        tu[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","ttu8");
                intent.putExtra("subject",tu[7].getText());
                startActivity(intent);
            }
        });

        tu[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","ttu9");
                intent.putExtra("subject",tu[8].getText());
                startActivity(intent);
            }
        });






        we[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","twe1");
                intent.putExtra("subject",we[0].getText());
                startActivity(intent);
            }
        });

        we[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","twe2");
                intent.putExtra("subject",we[1].getText());
                startActivity(intent);
            }
        });

        we[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","twe3");
                intent.putExtra("subject",we[2].getText());
                startActivity(intent);
            }
        });

        we[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","twe4");
                intent.putExtra("subject",we[3].getText());
                startActivity(intent);
            }
        });

        we[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","twe5");
                intent.putExtra("subject",we[4].getText());
                startActivity(intent);
            }
        });

        we[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","twe6");
                intent.putExtra("subject",we[5].getText());
                startActivity(intent);
            }
        });

        we[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","twe7");
                intent.putExtra("subject",we[6].getText());
                startActivity(intent);
            }
        });

        we[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","twe8");
                intent.putExtra("subject",we[7].getText());
                startActivity(intent);
            }
        });

        we[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","twe9");
                intent.putExtra("subject",we[8].getText());
                startActivity(intent);
            }
        });





        th[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tth1");
                intent.putExtra("subject",th[0].getText());
                startActivity(intent);
            }
        });

        th[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tth2");
                intent.putExtra("subject",th[1].getText());
                startActivity(intent);
            }
        });

        th[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tth3");
                intent.putExtra("subject",th[2].getText());
                startActivity(intent);
            }
        });

        th[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tth4");
                intent.putExtra("subject",th[3].getText());
                startActivity(intent);
            }
        });

        th[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tth5");
                intent.putExtra("subject",th[4].getText());
                startActivity(intent);
            }
        });

        th[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tth6");
                intent.putExtra("subject",th[5].getText());
                startActivity(intent);
            }
        });

        th[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tth7");
                intent.putExtra("subject",th[6].getText());
                startActivity(intent);
            }
        });

        th[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tth8");
                intent.putExtra("subject",th[7].getText());
                startActivity(intent);
            }
        });

        th[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tth9");
                intent.putExtra("subject",th[8].getText());
                startActivity(intent);
            }
        });




        fr[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tfr1");
                intent.putExtra("subject",fr[0].getText());
                startActivity(intent);
            }
        });

        fr[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tfr2");
                intent.putExtra("subject",fr[1].getText());
                startActivity(intent);
            }
        });

        fr[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tfr3");
                intent.putExtra("subject",fr[2].getText());
                startActivity(intent);
            }
        });

        fr[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tfr4");
                intent.putExtra("subject",fr[3].getText());
                startActivity(intent);
            }
        });

        fr[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tfr5");
                intent.putExtra("subject",fr[4].getText());
                startActivity(intent);
            }
        });

        fr[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tfr6");
                intent.putExtra("subject",fr[5].getText());
                startActivity(intent);
            }
        });

        fr[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tfr7");
                intent.putExtra("subject",fr[6].getText());
                startActivity(intent);
            }
        });

        fr[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tfr8");
                intent.putExtra("subject",fr[7].getText());
                startActivity(intent);
            }
        });

        fr[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tfr9");
                intent.putExtra("subject",fr[8].getText());
                startActivity(intent);
            }
        });

        fr[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeTable.this,PeriodsDetail.class);
                intent.putExtra("period","tfr1");
                intent.putExtra("subject",fr[0].getText());
                startActivity(intent);
            }
        });



    }

    public void refeshData()
    {
        //dbperiods.clear();
        dba= new DataBaseHandler3(getApplicationContext());

        dba.addPeriod();

        ArrayList<Period> periodFromDB=dba.getPeriods();
        for(int i=0;i<periodFromDB.size();i++)
        {
            String periodName= periodFromDB.get(i).getPeriodName();
            String subject=periodFromDB.get(i).getSubjectName();
            String room=periodFromDB.get(i).getRoom();


            /*Period period=new Period();
            period.setPeriodName(periodName);
            period.setSubjectName(subject);
            period.setRoom(room);

            dbperiods.add(period);*/

            if(c==1)
            {
                mo[j].setText(subject+"\n"+room);
                j++;
                if(j==9)
                {
                    c++;
                    j=0;
                }
            }
            else if(c==2)
            {
                tu[j].setText(subject+"\n"+room);
                j++;
                if(j==9)
                {
                    c++;
                    j=0;
                }
            }
            else if(c==3)
            {
                we[j].setText(subject+"\n"+room);
                j++;
                if(j==9)
                {
                    c++;
                    j=0;
                }
            }
            else if(c==4)
            {
                th[j].setText(subject+"\n"+room);
                j++;
                if(j==9)
                {
                    c++;
                    j=0;
                }
            }
            else
            {
                fr[j].setText(subject+"\n"+room);
                j++;
                if(j==9)
                {
                    c++;
                    j=0;
                }
            }

            //Log.v("Period:","PName "+periodName+" SName "+subject+" Room "+room);

        }



        dba.close();

    }


}
