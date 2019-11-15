package com.example.cgpacalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
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

        webView.loadData("<iframe src=\"https://www.google.com/maps/embed?pb=!4v1573310444744!6m8!1m7!1s7Fo4OZfjIDQKvncUvTLw-A!2m2!1d31.25602209993804!2d75.70599918724794!3f347.72106379168514!4f-2.5479348524138032!5f0.7820865974627469\" width=\"102%\" height=\"101%\" margin=\"0\" frameborder=\"0\" style=\"border:0;\" allowfullscreen=\"\"></iframe>", "text/html",
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
