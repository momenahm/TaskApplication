package com.example.melshaeir.taskapplication.ui.MainActivity;

import android.content.Context;

import com.example.melshaeir.taskapplication.Api.ApiInterface;

import com.example.melshaeir.taskapplication.Model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.melshaeir.taskapplication.Utils.Common.BASE_URL;

public class ui_Presenter {
    Context context;
    ui_view view;

    public ui_Presenter(Context context, ui_view view) {
        this.context = context;
        this.view = view;
    }

    public Retrofit retrofitService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public void interfaceData(final int page) {
        Map<String, String> map = new HashMap<>();
        map.put("count","10");
        map.put("from", String.valueOf(page));
        ApiInterface apiInterface = retrofitService().create(ApiInterface.class);
        apiInterface.getProducts(map).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                view.getProducts(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });





    }
}