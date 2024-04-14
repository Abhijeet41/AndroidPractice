package com.abhi41.demoproject.recylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.abhi41.demoproject.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewScreen extends AppCompatActivity {
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
        Item item1 = new Item(R.drawable.fruit,"Fruit","Fresh fruits from Garden");
        Item item2 = new Item(R.drawable.vegitables, "Vegetables","Delicious Vegetables ");
        Item item3 = new Item(R.drawable.bread,"Bakery","Bread, Wheat and Beans");
        Item item4 = new Item(R.drawable.beverage, "Beverage","Juice, Tea, Coffee and Soda");
        Item item5 = new Item(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt");
        Item item6 = new Item(R.drawable.popcorn,"Snacks","Pop Corn, Donut and Drinks");
        Item item7 = new Item(R.drawable.popcorn,"Snacks","Pop Corn, Donut and Drinks");


        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);
        itemList.add(item7);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);

    }
}