package com.example.it24.ujicoba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        getItemList();
    }

    private void getItemList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:7777/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);

        Call<Example> call = api.getItem();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.d("berhasil", response.body().getItem().size()+"");
                List<Item> list = response.body().getItem();
                ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), list);
                listView.setAdapter(itemAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("loh", t.getMessage());
            }
        });
//        call.enqueue(new Callback<List<Item>>() {
//            @Override
//            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
//                ItemAdapter adapter = new ItemAdapter(getApplicationContext(), response.body());
//                listView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<Item>> call, Throwable t) {
//                Log.d("loh", t.getMessage());
//            }
//        });
    }
}

