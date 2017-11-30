package com.example.cocoy.burritoapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.cocoy.burritoapp.Adapters.NotificationAdapter;

import java.util.ArrayList;



public class Notifications extends Fragment {

    private ArrayList<String> fecha;
    private ArrayList<String> elemento;
    ListView lv_notifiaction;
    NotificationAdapter list_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.notifications, container, false);

        lv_notifiaction = (ListView) rootView.findViewById(R.id.lv_notification);


        fecha = new ArrayList<String>();
        fecha.add("NOMBRE: Allan Francisco");
        elemento= new ArrayList<String>();
        elemento.add("UBICACION: SALON MEDIAESCAPE");

        init();
        list_adapter = new NotificationAdapter(Notifications.this,fecha,elemento);
        lv_notifiaction.setAdapter(list_adapter);


        return rootView;
    }
    private void init() {





    }



}
