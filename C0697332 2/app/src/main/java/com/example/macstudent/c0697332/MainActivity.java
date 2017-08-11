package com.example.macstudent.c0697332;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    EditText eid;
    EditText name;
    EditText date;
    EditText salary;
    Button btn,btn2;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eid = (EditText)findViewById(R.id.eid);
        name = (EditText)findViewById(R.id.name);
        date = (EditText)findViewById(R.id.date);
        salary = (EditText)findViewById(R.id.salary);
        btn = (Button)findViewById(R.id.btn);
        btn2 = (Button)findViewById(R.id.btn2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm.init(getApplicationContext());
                realm=Realm.getDefaultInstance();
                EmpData obj=new EmpData();
                obj.id=eid.getText().toString();
                obj.name=name.getText().toString();
                obj.birthdate=date.getText().toString();
                obj.salary=salary.getText().toString();
                realm.beginTransaction();
                realm.copyToRealm(obj);
                realm.commitTransaction();
                Toast.makeText(MainActivity.this, "Saved To Realm", Toast.LENGTH_SHORT).show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(getApplicationContext(),ShowActivity.class);
                startActivity(myIntent);
            }
        });


    }
}
