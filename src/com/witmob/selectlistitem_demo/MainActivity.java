package com.witmob.selectlistitem_demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private ListView listVIew;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listVIew = (ListView) findViewById(R.id.myListView);

        SelectAdapter selectAdapter=new SelectAdapter(this,getListData());
        listVIew.setAdapter(selectAdapter);

    }

    private List<?> getListData() {
        List<Map<String, String>> listData = new ArrayList<Map<String, String>>();

        for (int i = 0;i<20;)
        {
            i++;
            Map<String, String> mapData = new HashMap<String, String>();
            mapData.put("name", "名字"+i);
            mapData.put("id", ""+i);
            listData.add(mapData);
        }
        return listData;
    }

}
