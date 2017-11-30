package com.example.cocoy.burritoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cocoy.burritoapp.DB.Modelo.FoodCRUD;
import com.example.cocoy.burritoapp.DB.Modelo.Usuario;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";


    final FoodCRUD food = new FoodCRUD(SignupActivity.this);

    @BindView(R.id.input_name)
    EditText _nameText;
    @BindView(R.id.input_producto) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;


    @BindView(R.id.link_login)
    TextView _loginLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Signup");
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        /*
        *    Textview
        * */
        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity

                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Calientes");
        categories.add("Frios");
        categories.add("Postres");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


        Button btn_signup =(Button)findViewById(R.id.btn_signup);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validate()) {
                    Toast.makeText(SignupActivity.this, "Error  ", Toast.LENGTH_LONG).show();
                    return;
                }
                else {





                    String name = _nameText.getText().toString();
                    String password = _passwordText.getText().toString();
                    String producto = _emailText.getText().toString();
                    String text = spinner.getSelectedItem().toString();




                    Boolean encontrado = food.Sign(name);



                    if(encontrado){
                        Toast.makeText(SignupActivity.this, "El usuario ya existe ", Toast.LENGTH_LONG).show();
                    }
                    else{
                        int id= food.newUsuario(new Usuario(0,name,password,producto,text));
                        // Toast.makeText(SignupActivity.this, "Valores: "+id, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignupActivity.this,MainFragment.class);
                        startActivity(intent);
                        Toast.makeText(SignupActivity.this, "Bienvenido ", Toast.LENGTH_LONG).show();
                    }

                   /* if(u.getNombre().equals(name)){

                        Toast.makeText(SignupActivity.this, "El usuario ya Existe", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        int id= food.newUsuario(new Usuario(0,name,password,producto,text));
                        Toast.makeText(SignupActivity.this, "Valores: "+id, Toast.LENGTH_LONG).show();
                        /* Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                         startActivity(intent);
                    }*/


                }


            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }



    /*
    * Metodo para validar Los campos
    * */

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (name.isEmpty() || name.length() < 5) {
            _nameText.setError("at least 5 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty()) {
            _emailText.setError("You need this field");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}
