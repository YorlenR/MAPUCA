package com.example.pc.mapuca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.mapuca.Api.Api;
import com.example.pc.mapuca.Models.CategoriesModel;
import com.example.pc.mapuca.Models.CategoriesModelTwo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityCategories extends AppCompatActivity {

    private final String TAG= "MainActivity";

    private Button consultar;
    private Button eliminar;
    private Button enviar;
    private Button actualizar;
    private EditText namecategoria;
    private EditText id;
    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initViews();

       // volver.setOnClickListener(new View.OnClickListener() {
       //     @Override
        //    public void onClick(View view) {
         //       Intent intent = new Intent(MainActivityCategories.this, MainActivity.class );
         //        startActivity(intent);
         //       finish();
        //    }
      //  });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityCategories.this, MainActivityConsultCategories.class);
                startActivity(intent);
                finish();
            }
        });



        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendHttpRequest();
            }
        });


        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteData();
            }
        });


    }


    private void initViews() {


        eliminar = findViewById(R.id.eliminar);
        consultar = findViewById(R.id.consultar);
        enviar = findViewById(R.id.enviar);
        actualizar= findViewById(R.id.actualizar);
        namecategoria= findViewById(R.id.namecategoria);
        id = findViewById(R.id.id);
        //volver.findViewById(R.id.volver);


    }


    private void sendHttpRequest() {
        CategoriesModel categoriesModel = new CategoriesModel();
        categoriesModel.setName(namecategoria.getText().toString());


        Call<CategoriesModel> call = Api.instance().postcategory(categoriesModel);
        call.enqueue(new Callback<CategoriesModel>() {
            @Override
            public void onResponse(Call<CategoriesModel> call, Response<CategoriesModel> response) {
                // Log.i(TAG, response.body().getName());

            }

            @Override
            public void onFailure(Call<CategoriesModel> call, Throwable throwable) {
                Log.e(TAG, throwable.getMessage());

            }
        });
    }


    private void updateData(){
        CategoriesModelTwo categoriesModelTwo = new CategoriesModelTwo();
        categoriesModelTwo.setId(Integer.valueOf(id.getText().toString()));
        categoriesModelTwo.setName(namecategoria.getText().toString());

        Call<CategoriesModelTwo> call = Api.instance().updatecategory(categoriesModelTwo.getId(),categoriesModelTwo);
        call.enqueue(new Callback<CategoriesModelTwo>() {
            @Override
            public void onResponse(Call<CategoriesModelTwo> call, Response<CategoriesModelTwo> response) {
                //  if(response != null){ Log.i(TAG, response.body().getName());}

            }

            @Override
            public void onFailure(Call<CategoriesModelTwo> call, Throwable throwable) {
                Log.e(TAG, throwable.getMessage());
            }
        });
    }


    private void deleteData(){
        CategoriesModelTwo categoriesModelTwo = new CategoriesModelTwo();
        categoriesModelTwo.setId(Integer.valueOf(id.getText().toString()));
        categoriesModelTwo.setName(namecategoria.getText().toString());

        Call<CategoriesModelTwo> call = Api.instance().deletecategory(categoriesModelTwo.getId());
        call.enqueue(new Callback<CategoriesModelTwo>() {
            @Override
            public void onResponse(Call<CategoriesModelTwo> call, Response<CategoriesModelTwo> response) {

                // if(response != null){ Log.i(TAG, response.body().getName());}


                Toast toast1 = Toast.makeText(getApplicationContext(), "prueba", Toast.LENGTH_SHORT);
                toast1.show();


            }

            @Override
            public void onFailure(Call<CategoriesModelTwo> call, Throwable throwable) {
                Log.e(TAG, throwable.getMessage());

                Toast toast1 = Toast.makeText(getApplicationContext(), "prueba", Toast.LENGTH_SHORT);
                toast1.show();

            }
        });

    }
}
