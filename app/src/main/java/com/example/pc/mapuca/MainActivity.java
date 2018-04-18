package com.example.pc.mapuca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Categorias;
    private Button Lugares;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        Categorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityCategories.class);
                startActivity(intent);
                finish();
            }
        });

        Lugares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityPlaces.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void initViews() {


        Categorias = findViewById(R.id.Categorias);
        Lugares = findViewById(R.id.Lugares);



    }



}
