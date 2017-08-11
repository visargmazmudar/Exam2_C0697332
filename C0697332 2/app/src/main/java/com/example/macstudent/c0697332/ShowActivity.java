package com.example.macstudent.c0697332;

/**
 * Created by macstudent on 2017-08-10.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class ShowActivity extends AppCompatActivity {
    Realm realm;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        lv= (ListView) findViewById(R.id.listView);
        Realm.init(this);
        realm=Realm.getDefaultInstance();
        RealmResults<EmpData> test = realm.where(EmpData.class).findAll();
        String[] eid=new String[test.size()];
        String[] name=new String[test.size()];
        String[] date=new String[test.size()];
        String[] salary=new String[test.size()];
        for(int i=0;i<test.size();i++)
        {
            eid[i]=test.get(i).id;
            name[i]=test.get(i).name;
            date[i]=test.get(i).birthdate;
            salary[i]=test.get(i).salary;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, name);
        lv.setAdapter(adapter);
    }
}