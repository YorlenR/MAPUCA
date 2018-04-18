package com.example.pc.mapuca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.pc.mapuca.Adapters.LugaresAdapter;
import com.example.pc.mapuca.Models.PlacesModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPlaces extends AppCompatActivity {

    private ListView listViewLugares;
    private LugaresAdapter customAdapter;
    private List<PlacesModel> listadoLugares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //cargamos la vista del listview a la variable listview lugares
        listViewLugares = (ListView) findViewById(R.id.listViewLugares);

        fnRefrescarAdaptador();

    }

    //este metodo refresca el listado del listview
    private void fnRefrescarAdaptador(){
        //esta linea debe ser reemplazada por el llamado de su base de datos que
        //esten utilizando
        listadoLugares = METODO_EJEMPLO();

        customAdapter = new LugaresAdapter(this, R.layout.item_lugar, listadoLugares);
        listViewLugares.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
    }

    private ArrayList<PlacesModel> METODO_EJEMPLO(){
        ArrayList<PlacesModel> listadoEjemplo = new ArrayList<>();

        for (int i=1;i<=20;i++){
            PlacesModel lugar = new PlacesModel();
            lugar.setId(i);
            lugar.setLugar("Lugar No. " + i);
            lugar.setDescripcion("Descripcion..." + i);
            listadoEjemplo.add(lugar);
        }

        return listadoEjemplo;
    }
}
