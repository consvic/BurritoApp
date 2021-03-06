package com.example.cocoy.burritoapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cocoy.burritoapp.Notifications;
import com.example.cocoy.burritoapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pacod on 29/11/2017.
 */
public class NotificationAdapter
        extends BaseAdapter {
    ArrayList<String> result;
    ArrayList<String> result1;
    Context context;
    List<Integer> imageId;
    private static LayoutInflater inflater=null;

    public NotificationAdapter(Notifications notificacion1, ArrayList<String> compra, ArrayList<String> elementos) {
// TODO Auto-generated constructor stub
        result=compra;
        result1=elementos;
        context=notificacion1.getContext();
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }



    @Override
    public int getCount() {
// TODO Auto-generated method stub
        return result.size();
    }

    @Override
    public Object getItem(int position) {
// TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
// TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {

        TextView fecha;
        TextView elemento;
        ImageView im_language;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
// TODO Auto-generated method stub
        Holder holder=new Holder();
        View view;
        view = inflater.inflate(R.layout.layout_notification_item, null);

        holder.fecha=(TextView) view.findViewById(R.id.txt_fecha);
        holder.elemento=(TextView) view.findViewById(R.id.txt_elementos);


        holder.fecha.setText(result.get(position));
        holder.elemento.setText(result1.get(position));

        ;


        //double total= getTotal(result1);
        //TextView txt_total=(TextView) view.findViewById(R.id.cart_total);
        //txt_total.setText("$ 9,000.00");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + result1.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }

}