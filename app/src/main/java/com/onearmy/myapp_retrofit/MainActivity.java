package com.onearmy.myapp_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    List<JasonPlaceHolder> data;
    RecycleAdapater adapater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycleview);
        RecyclerView.LayoutManager layoutmanager =new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutmanager);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JasonPlaceHolderApi api = retrofit.create(JasonPlaceHolderApi.class);

        Call<List<JasonPlaceHolder>> call = api.getplaceHolder();
        call.enqueue(new Callback<List<JasonPlaceHolder>>() {
            @Override
            public void onResponse(Call<List<JasonPlaceHolder>> call, Response<List<JasonPlaceHolder>> response) {
                if(!response.isSuccess()){
                    Log.d("myerror", "errorcode: "+response.code());
                    return;
                }
                Toast.makeText(MainActivity.this, "got to data feaching", Toast.LENGTH_SHORT).show();
                List<JasonPlaceHolder> result = response.body();
                Log.d("myerror", "onResponse: "+result);
                adapater = new RecycleAdapater(result);
                recyclerView.setAdapter(adapater);



            }

            @Override
            public void onFailure(Call<List<JasonPlaceHolder>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}