package com.example.pc.mapuca.Api;

import com.example.pc.mapuca.Models.CategoriesModel;
import com.example.pc.mapuca.Models.CategoriesModelTwo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("categories")
    Call<List<CategoriesModelTwo>> getcategory();

    @DELETE("categories/{id}")
    Call<CategoriesModelTwo> deletecategory (@Path("id")int id);

    @POST("categories")
    Call<CategoriesModel> postcategory(@Body CategoriesModel categoriesModel);

    @PUT("categories/{id}")
    Call<CategoriesModelTwo> updatecategory (@Path("id") int id, @Body CategoriesModelTwo categoriesModelTwo);
}
