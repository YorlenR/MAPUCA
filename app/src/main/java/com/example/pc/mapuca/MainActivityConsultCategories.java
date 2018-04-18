package com.example.pc.mapuca;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.pc.mapuca.Adapters.CategoryAdapter;
import com.example.pc.mapuca.Api.Api;
import com.example.pc.mapuca.Models.CategoriesModelTwo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityConsultCategories extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_consult_categories);

        initViews();
        configureRecyclerView();
        fetchHttpRequest();


        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityConsultCategories.this, MainActivityCategories.class );
                startActivity(intent);
                finish();
            }
        });
    }



    private void initViews() {

        recyclerView = findViewById(R.id.recycler_view);
        regresar = findViewById(R.id.regresar);
    }

    private void configureRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    private void fetchHttpRequest() {
        Call<List<CategoriesModelTwo>> call = Api.instance().getcategory();
        call.enqueue(new Callback<List<CategoriesModelTwo>>() {
            @Override
            public void onResponse(@NonNull Call<List<CategoriesModelTwo>> call, Response<List<CategoriesModelTwo>> response) {
                if (response.body() != null) {
                    CategoryAdapter categoryAdapter = new CategoryAdapter(response.body());
                    recyclerView.setAdapter(categoryAdapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<CategoriesModelTwo>> call, @NonNull Throwable t) {
                Log.i("Debug: ", t.getMessage());
            }
        });
    }

}
