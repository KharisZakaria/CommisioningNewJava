package com.zak.commisioningnewjava.view.monitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.zak.commisioningnewjava.ListItem;
import com.zak.commisioningnewjava.R;
import java.util.List;
import java.util.Map;

public class MonitoringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring);
    }

    SimpleAdapter ad;
    public void GetList(View v){
        ListView lstv = (ListView) findViewById(R.id.listview1);

        List<Map<String,String>> MyDatalist = null;
        ListItem MyData = new ListItem();
        MyDatalist = MyData.getlist();

        String[] Fromw = {"tv_id", "tv_cn","tv_egi", "tv_dateexpired"};
        int[] Tow = {R.id.tv_id,R.id.tv_cn,R.id.tv_egi,R.id.tv_dateexpired};
        ad = new SimpleAdapter(MonitoringActivity.this,MyDatalist,R.layout.listlayout,Fromw,Tow);
        lstv.setAdapter(ad);
    }
}