package com.example.apppi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button click;
    public static TextView data;
//    EditText et;
//    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.fetchddata);
//        et = (EditText) findViewById(R.id.editTextUrl);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i=new Intent(MainActivity.this,fetchData.class);
//                st=et.getText().toString();
//                i.putExtra("Value",st);
//                startActivity(i);
//                finish();
                fetchData process = new fetchData();
                process.execute();

            }
        });
    }
}
