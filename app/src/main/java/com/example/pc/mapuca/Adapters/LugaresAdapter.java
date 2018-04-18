package com.example.pc.mapuca.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.mapuca.Models.PlacesModel;
import com.example.pc.mapuca.R;

import java.util.List;

public class LugaresAdapter extends ArrayAdapter<PlacesModel> implements Filterable {

    private LinearLayout.LayoutParams parametros;
    private List<PlacesModel> listadoLugares;
    private Context mContext;

    public LugaresAdapter(Context context, int layoutResourceId, List<PlacesModel> listPuntos) {
        super(context, layoutResourceId, listPuntos);
        this.listadoLugares = listPuntos;
        this.mContext = context;
    }
    @Override
    public int getCount() {
        return listadoLugares.size();
    }

    @Override
    public PlacesModel getItem(int position) {
        return listadoLugares.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.item_lugar, null);
            holder = new ViewHolder();
            //aca se carga el item lugar.xml por cada item del list view
            holder.tvNombre = (TextView) convertView.findViewById(R.id.tvNombre);
            holder.tvDescripcion = (TextView) convertView.findViewById(R.id.tvDescripcion);
            holder.btn1 = (Button) convertView.findViewById(R.id.btn1);
            holder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final PlacesModel punto = getItem(position);
        try {
            //aca son los eventos para los botones
            holder.tvNombre.setText(punto.getLugar());
            holder.tvDescripcion.setText(punto.getDescripcion());
            holder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //abrir actividad para mostrar ubicacion en mapa y enviar coordenadas
                    Toast.makeText(mContext, "mostrar ubicacion de: " + punto.getLugar(),Toast.LENGTH_LONG).show();
                }
            });
            //con punto.getUrlImagen() se obtiene la url de la imagen para ponersela al imageview
        }catch (Exception e){
            Log.d("----> excepcion ", e.toString());
        }
        return convertView;
    }
    //clase holder para instancias los elementos del item lugar.xml
    private class ViewHolder {
        ImageView imageview;
        TextView tvNombre, tvDescripcion;
        Button btn1;
    }





}
