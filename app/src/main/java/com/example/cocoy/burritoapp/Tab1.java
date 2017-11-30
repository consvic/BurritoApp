package com.example.cocoy.burritoapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;


public class Tab1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
        final Button btn_activar = (Button)rootView.findViewById(R.id.btn_activar);
        final Switch s = (Switch) rootView.findViewById(R.id.SwitchID);

        btn_activar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getContext(), "valor  "+s.isChecked(), Toast.LENGTH_SHORT).show();
                return;
            }
        });

        return rootView;
    }
}
