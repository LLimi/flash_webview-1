package com.demo.flashfact;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity6 extends AppCompatActivity {
    String TAG = "MainActivity6";
    private WebView myWebView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        myWebView6 = (WebView) findViewById(R.id.webView6);


        myWebView6.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {

                Log.e(TAG, "Loading...");
                Log.e(TAG, " : " + (progress * 100));

                if (progress == 100)
                    Log.e(TAG, "LOADING COMPLETE");
            }
        });

        myWebView6.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.d("Failure Url :", failingUrl);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                Log.d("Ssl Error:", handler.toString() + "error:" + error);
                handler.proceed();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        myWebView6.getSettings().setDomStorageEnabled(true);
        myWebView6.getSettings().setJavaScriptEnabled(true);
        myWebView6.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView6.getSettings().setLoadWithOverviewMode(true);
        myWebView6.getSettings().setUseWideViewPort(true);
        myWebView6.loadUrl("https://flash.visafacturacion.com/ecommerce/category/3");
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (myWebView6.canGoBack()) {
                        myWebView6.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}