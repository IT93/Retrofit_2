package com.example.it24.ujicoba;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by it24 on 12/21/17.
 */

public interface Api {
    @GET("getsakila.php")
    Call<Example>getItem();
}
