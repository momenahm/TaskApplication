package com.example.melshaeir.taskapplication.ui.MainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.melshaeir.taskapplication.Adapter.ProductAdapter;
import com.example.melshaeir.taskapplication.Model.Product;
import com.example.melshaeir.taskapplication.R;
import com.example.melshaeir.taskapplication.Utils.EndlessRecyclerViewScrollListener;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ui_view {
    RecyclerView recyclerView;

     ui_Presenter presenter;
     ProductAdapter productAdapter;
     List<Product> productslist ;
      int userPage =1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productslist= new ArrayList<>();
        presenter = new ui_Presenter(getApplicationContext(),this);
        presenter.interfaceData(userPage);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerProduct);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager  layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        productAdapter = new ProductAdapter(getApplicationContext(),productslist);
        recyclerView.setAdapter(productAdapter);
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                userPage++;
                presenter.interfaceData(userPage);
            }
        });


    }


    @Override
    public void getProducts(List<Product> list) {
        productslist.addAll(list);
        productAdapter.notifyItemRangeInserted(productAdapter.getItemCount(),productslist.size());

    }

}
