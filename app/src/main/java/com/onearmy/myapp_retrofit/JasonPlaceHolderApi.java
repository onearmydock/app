package com.onearmy.myapp_retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JasonPlaceHolderApi {

    @GET("posts")
    Call<List<JasonPlaceHolder>> getplaceHolder();
}
