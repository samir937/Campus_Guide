package com.example.cgpacalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MapActivity extends AppCompatActivity {

    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        webView=findViewById(R.id.webView);


        WebSettings webViewSettings = webView.getSettings();
        webViewSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webViewSettings.setJavaScriptEnabled(true);
        webViewSettings.setBuiltInZoomControls(true);
        webViewSettings.setPluginState(WebSettings.PluginState.ON);
        webView.setBackgroundColor(Color.BLACK);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("Campus Tour");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));
        webView.loadData("<iframe src=\"https://www.google.com/maps/embed?pb=!4v1574445936599!6m8!1m7!1sPPeXkt5NPYNTeQijNbwYCg!2m2!1d31.2607325620669!2d75.70697036279117!3f230.91!4f-4.090000000000003!5f0.4000000000000002\" width=\"101%\" height=\"101%\" frameborder=\"0\" style=\"border:0;\" allowfullscreen=\"\"></iframe>", "text/html",
                "utf-8");



    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }






}
