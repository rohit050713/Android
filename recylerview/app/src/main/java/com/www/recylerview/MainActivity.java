package com.www.recylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.www.recylerview.adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView recyclerView1;
    ArrayList<model> values = new ArrayList<>();
    int images[]={R.drawable.bulb,R.drawable.fan,R.drawable.ac,R.drawable.refrigerator};
    String title1[], title2[],expandable_tv[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);




       //for horizontal recycler view
        recyclerView1=findViewById(R.id.recycler_view1);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        recyclerView1.setLayoutManager(layoutManager);
        //for normal recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        title1=getResources().getStringArray(R.array.title);
        title2=getResources().getStringArray(R.array.title_2);
        expandable_tv=getResources().getStringArray(R.array.expandable_text);


        for(int i=0;i<images.length;i++){
            model m=new model(title1[i],title2[i],images[i],expandable_tv[i]);
            values.add(m);


        }

        adapter a=new adapter(this,values);

        recyclerView.setAdapter(a);


        recyclerView1.setAdapter(a);


    }





}
