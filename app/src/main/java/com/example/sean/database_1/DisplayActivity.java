package com.example.sean.database_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    //private List<Staff> staffList = new ArrayList<>();
    public String[] data_2 = null;
    public String[] data_3 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //取出第二个activity传送过来的数据
        Intent intent = getIntent();

        String i ;
        i = intent.getStringExtra("int");
        /* data_2 = intent.getStringArrayExtra("extra_data");*/
        //接收数组长度，从String转化为int
        int c = Integer.parseInt(i);
        data_2 = new String[c];
        data_3 = new String[c];
        Bundle bundle_2 = intent.getExtras();
        data_2 = bundle_2.getStringArray("extra_data");  //获取数据
        data_3 = bundle_2.getStringArray("extra_data2");
        //list列表显示数据
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (
                this,android.R.layout.simple_list_item_1,data_3);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Staff staff = staffList.get(position);
                Toast.makeText(DisplayActivity.this,data_2[position],Toast.LENGTH_SHORT).show();
            }
        });

    }
}
