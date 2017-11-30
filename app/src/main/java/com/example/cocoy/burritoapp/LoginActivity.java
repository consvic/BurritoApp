package com.example.cocoy.burritoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cocoy.burritoapp.Activities.MainActivity;
import com.example.cocoy.burritoapp.DB.Modelo.FoodCRUD;

import butterknife.BindView;
import butterknife.ButterKnife;
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";


    final FoodCRUD food = new FoodCRUD(LoginActivity.this);

    private static final int REQUEST_SIGNUP = 0;
    @BindView(R.id.input_email)
    EditText _emailText;
    @BindView(R.id.input_password)
    EditText _passwordText;
            @BindView(R.id.btn_login)
    Button _loginButton;
            @BindView(R.id.link_signup)
    TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Login");

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    public void login() {

        if (!validate()) {

            Toast.makeText(LoginActivity.this, "Error  ", Toast.LENGTH_SHORT).show();
            return;
        } else {
            String name = _emailText.getText().toString();
            String password = _passwordText.getText().toString();


            Boolean encontrado = food.login(name, password);

            //Toast.makeText(LoginActivity.this, "El valor es:  "+ encontrado, Toast.LENGTH_LONG).show();

            if (encontrado) {
                Toast.makeText(LoginActivity.this, "Bienvenido ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, MainFragment.class);
                startActivity(intent);

            } else {
                Toast.makeText(LoginActivity.this, "El usuario no existe ", Toast.LENGTH_LONG).show();
            }


            // Usuario u = food.selectUsuario(name);

            //Toast.makeText(LoginActivity.this, "El usuario es: "+u.getNombre(), Toast.LENGTH_LONG).show();
            /*if(u.getNombre().equals(name)){

                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
            else
            {

                Toast.makeText(LoginActivity.this, "El usuario no existe: ", Toast.LENGTH_LONG).show();
            }*/

        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty()) {
            _emailText.setError("Required");
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
