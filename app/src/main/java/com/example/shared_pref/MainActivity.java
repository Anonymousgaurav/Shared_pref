package com.example.shared_pref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView tv;
    EditText et;
    Button btn;

    public static final String MY_PREFS = "com.example.shared_pref.Names";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        tv = findViewById(R.id.tv);
        et = findViewById(R.id.et);
        btn = findViewById(R.id.btn);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS,MODE_PRIVATE);
        String user =  prefs.getString("kumar","");
        tv.setText(user);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String name = et.getText().toString().trim();
                tv.setText(name);
                SharedPreferences.Editor sf = getSharedPreferences(MY_PREFS,MODE_PRIVATE).edit();
                sf.putString("kumar",name);
                sf.commit();

            }
        });
    }
}
