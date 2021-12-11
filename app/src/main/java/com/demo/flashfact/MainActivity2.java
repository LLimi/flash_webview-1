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

public class MainActivity2 extends AppCompatActivity {
    String TAG = "MainActivity2";
    private WebView myWebView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myWebView2 = (WebView) findViewById(R.id.webView2);


        myWebView2.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {

                Log.e(TAG, "Loading...");
                Log.e(TAG, " : " + (progress * 100));

                if (progress == 100)
                    Log.e(TAG, "LOADING COMPLETE");
            }
        });

        myWebView2.setWebViewClient(new WebViewClient() {

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
        myWebView2.getSettings().setDomStorageEnabled(true);
        myWebView2.getSettings().setJavaScriptEnabled(true);
        myWebView2.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView2.getSettings().setLoadWithOverviewMode(true);
        myWebView2.getSettings().setUseWideViewPort(true);
        myWebView2.loadUrl("https://flash.visafacturacion.com/ecommerce/category/4");

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (myWebView2.canGoBack()) {
                        myWebView2.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

}