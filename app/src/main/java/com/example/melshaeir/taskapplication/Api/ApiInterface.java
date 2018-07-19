package com.example.melshaeir.taskapplication.Api;

import com.example.melshaeir.taskapplication.Model.Product;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiInterface {
@GET("products")
    Call<List<Product>> getProducts(@QueryMap Map<String,String> map);
}
