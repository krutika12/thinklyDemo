package com.example.thinklydemo.helper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface fpNetworkHelper {

    @GET("api/user/getProductsCategories/{productId}")
    public Call<QuestionsResponse> getproductsubcategory(@Path("productId") String id);

}
