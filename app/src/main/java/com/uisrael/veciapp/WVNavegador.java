package com.uisrael.veciapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WVNavegador extends AppCompatActivity {

    WebView buscador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wvnavegador);

        // Definimos el webView
        buscador=(WebView)findViewById(R.id.wv_navegador);

        buscador.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        // Cargamos la web
        buscador.loadUrl("https://www.4imagine.com.ec");
    }
}
