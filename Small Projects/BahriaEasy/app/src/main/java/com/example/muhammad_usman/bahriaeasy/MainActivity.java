package com.example.muhammad_usman.bahriaeasy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
    }
    public void LaunchWebView(View view) {
        WebView Middle = (WebView) findViewById(R.id.Middle);
        Middle.loadUrl("http://www.google.com");
    }

}



