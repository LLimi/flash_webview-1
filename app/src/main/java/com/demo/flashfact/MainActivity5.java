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

public class MainActivity5 extends AppCompatActivity {
    String TAG = "MainActivity5";
    private WebView myWebView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        myWebView5 = (WebView) findViewById(R.id.webView5);


        myWebView5.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {

                Log.e(TAG, "Loading...");
                Log.e(TAG, " : " + (progress * 100));

                if (progress == 100)
                    Log.e(TAG, "LOADING COMPLETE");
            }
        });

        myWebView5.setWebViewClient(new WebViewClient() {

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
        myWebView5.getSettings().setDomStorageEnabled(true);
        myWebView5.getSettings().setJavaScriptEnabled(true);
        myWebView5.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView5.getSettings().setLoadWithOverviewMode(true);
        myWebView5.getSettings().setUseWideViewPort(true);
        myWebView5.loadUrl("https://flash.visafacturacion.com/ecommerce/category/5");
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (myWebView5.canGoBack()) {
                        myWebView5.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

}