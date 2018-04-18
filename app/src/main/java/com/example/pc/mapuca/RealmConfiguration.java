package com.example.pc.mapuca;

import android.app.Application;

import io.realm.Realm;

public class RealmConfiguration extends Application {


    public void Oncreate(){

        super.onCreate();
        Realm.init(this);
        io.realm.RealmConfiguration configuration = new io.realm.RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);

    }
}
