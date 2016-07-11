package com.example.lc_me.curriculoleticia;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {


    HashMap<String, List<String>> listasHashMap;
    List<String> listasHashMapKeys;
    ExpandableListView expandableListView;
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableList);
        listasHashMap = MyDataProvider.getDataHashMap();
        listasHashMapKeys = new ArrayList<String>(listasHashMap.keySet());

        adapter = new MyCustomAdapter(this, listasHashMap, listasHashMapKeys);
        expandableListView.setAdapter(adapter);

       expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View clickedView, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this, "Selected " + listasHashMap.get(listasHashMapKeys.get(groupPosition)).get(childPosition)
                        + " from " + listasHashMapKeys.get(groupPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
