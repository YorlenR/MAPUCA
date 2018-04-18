package com.example.pc.mapuca.Models;

import android.database.Cursor;

import org.json.JSONException;
import org.json.JSONObject;

import io.realm.RealmObject;



public class PlacesModel extends RealmObject // los objetos que yo quiero que se han realm , les hago herencia de la clase
 {

    private int id;
    private String lugar, descripcion, urlImagen;

    public PlacesModel(){

    }

    public PlacesModel(Cursor cursor) {
        this.id = cursor.getInt(0);
        this.lugar = cursor.getString(1);
        this.descripcion = cursor.getString(2);
        this.urlImagen = cursor.getString(3);
    }

    public PlacesModel(JSONObject jsonObject)throws JSONException {
        this.id = jsonObject.getInt("decId");
        this.lugar = jsonObject.getString("lugar");
        this.descripcion = jsonObject.getString("descripcion");
        this.urlImagen = jsonObject.getString("urlImagen");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }



}
