package com.example.mynews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import static com.example.mynews.NewAdapter.EXTRA_URL;

public class NewViewPage extends AppCompatActivity {

    ProgressBar progressBar;
    Context context;
    int position;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_view_page);

        progressBar=(ProgressBar) findViewById(R.id.progress_bar);
        webView=(WebView) findViewById(R.id.webViewNews);

        Intent intent=getIntent();
        String url=intent.getStringExtra(EXTRA_URL);
        progressBar.setVisibility(View.VISIBLE);

        webView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                setTitle("loading New Please Wait...");
                setProgress(newProgress* 100);

                if (newProgress==100){
                    setTitle(R.string.app_name);
                }

                super.onProgressChanged(view, newProgress);
            }
        });
        webView.getSettings().getJavaScriptEnabled();
        webView.loadUrl(url);

    }


}