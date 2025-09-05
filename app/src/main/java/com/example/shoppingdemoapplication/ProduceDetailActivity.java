package com.example.shoppingdemoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.shoppingdemoapplication.model.Produce;

import java.io.Serializable;

public class ProduceDetailActivity extends AppCompatActivity {

    private String TAG="toolbarback";

    private ImageView produce_img;
    private TextView produce_title;

    private TextView produce_price;

    private TextView produce_detail;

    private TextView produce_content;

    private Produce produce;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produce_detail);

        //获取传递的数据
        produce=(Produce)getIntent().getSerializableExtra("produce");
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //返回
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // finish();
                Log.d(TAG, "点击事件触发");
            }
        });



        //初始化控件
        produce_img=findViewById(R.id.mm);
        produce_content=findViewById(R.id.p_content);
        produce_price=findViewById(R.id.p_price);
        produce_detail=findViewById(R.id.p_detail);

        //设置数据
        if(produce!=null) {
            produce_img.setImageResource(produce.getImageUrl());
            produce_price.setText(String.valueOf(produce.getPrice()));
            produce_content.setText(produce.getContent());
            produce_detail.setText(produce.getDetail());

        }

    }


}