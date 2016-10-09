package com.example.iheart;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 21403766 on 16/11/2015.
 */
public class History extends Activity {

    private static DBManager dbm = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_history);
        dbm = new DBManager(this);

        List<String> data = new ArrayList<>();
        data = getData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, data);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        List<HeartRate> result = new ArrayList<HeartRate>();
        result = dbm.query();
        Iterator it = result.iterator();
        while (it.hasNext()){
            data.add(it.next().toString());
        }
        return data;
    }
}
