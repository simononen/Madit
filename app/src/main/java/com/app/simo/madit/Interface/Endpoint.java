package com.app.simo.madit.Interface;


import com.app.simo.madit.Categories.Category;
import com.app.simo.madit.Produces.Produce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoint {
    @GET("categories")
    Call<List<Category>> listCategories();

    @GET("produces")
    Call<Produce> listProduces();
}
