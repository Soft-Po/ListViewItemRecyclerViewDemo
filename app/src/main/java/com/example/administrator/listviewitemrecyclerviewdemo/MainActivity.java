package com.example.administrator.listviewitemrecyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.administrator.listviewitemrecyclerviewdemo.adapters.LvAdapter;
import com.example.administrator.listviewitemrecyclerviewdemo.utils.ImageUrl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    //修复Bug

    //clone下来进行修改
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();


    }

    private void initData() {

        List<String> list = new ArrayList<>();

        String[] imageurls = ImageUrl.imageurls;
        for (int i = 0; i < 10; i++) {
            list.add(imageurls[i]);
        }

        LvAdapter adapter = new LvAdapter(this,list);

        listView.setAdapter(adapter);
    }

    private void initView() {
        listView = ((ListView) findViewById(R.id.listView));
    }
}
