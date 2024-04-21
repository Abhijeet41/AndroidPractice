package com.abhi41.demoproject.recylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.abhi41.demoproject.HomeScreen;
import com.abhi41.demoproject.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewScreen extends AppCompatActivity implements ItemClickListener {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Item> itemList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_screen);

        recyclerView = findViewById(R.id.recylerview);

        itemList = new ArrayList<>();
        Item item1 = new Item("https://i.ibb.co/4m5NM2J/fruit.png","Fruit","Fresh fruits from Garden");
        Item item2 = new Item("https://i.ibb.co/ZM4kmV0/vegitables.png", "Vegetables","Delicious Vegetables ");
        Item item3 = new Item("","Bakery","Bread, Wheat and Beans");
        Item item4 = new Item("", "Beverage","Juice, Tea, Coffee and Soda");
        Item item5 = new Item("https://i.ibb.co/9bpNT1D/milk.png", "Milk", "Milk, Shakes and Yogurt");
        Item item6 = new Item("https://i.ibb.co/LYmQx1q/popcorn.png","Snacks","Pop Corn, Donut and Drinks");


        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(itemList,this);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(getApplicationContext(), "You choose: "+itemList.get(position).itemName, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, HomeScreen.class);
        intent.putExtra("fruite_name",itemList.get(position).itemName);
        startActivity(intent);
    }
}