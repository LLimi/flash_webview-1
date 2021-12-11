package com.demo.flashfact;

import android.app.Dialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.view.View;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

      String TAG = "MainActivity7";
    private WebView myWebView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    //Método el botón cafe
    public void Siguiete(View view){
        Intent siguiente = new Intent(this, MainActivity1.class);
        startActivity(siguiente);
    }

    //Método el botón licores
    public void Siguiete_Lico(View view){
        Intent siguiente2 = new Intent(this, MainActivity2.class);
        startActivity(siguiente2);
    }

    //Método el botón Supermercado
    public void Siguiete_Super(View view){
        Intent siguiente3 = new Intent(this, MainActivity3.class);
        startActivity(siguiente3);
    }
    //Método el botón restaurante
    public void Siguiete_Rest(View view){
        Intent siguiente4 = new Intent(this, MainActivity4.class);
        startActivity(siguiente4);
    }

    //Método el botón ferreteria
    public void Siguiete_Ferr(View view){
        Intent siguiente5 = new Intent(this, MainActivity5.class);
        startActivity(siguiente5);
    }

    //Método el botón farmacia
    public void Siguiete_Farm(View view){
        Intent siguiente6 = new Intent(this, MainActivity6.class);
        startActivity(siguiente6);
    }



}