package com.fangrongjie.www.listviewtypedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Item> list;
    private SBTangListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);

        initData();
    }

    //初始化数据
    private void initData() {
        list = new ArrayList<>();
        //造假数据了
        //public Item(String name, String rank, String phone, String money, int type, String teamName) {
        Item item = null;
        for (int i = 0; i < 40; i++) {
            if (i % 10 == 0) {
                item = new Item("","","","",SBTangListViewAdapter.FIRST_TYPE,"Cretin"+(i+1));
            }else{
                item = new Item("Cretin"+(i+1),"高级","13227293721","100万",SBTangListViewAdapter.OTHERS_TYPE,"");
            }
            list.add(item);
        }
        adapter = new SBTangListViewAdapter(this,list);
        listView.setAdapter(adapter);
    }

}
