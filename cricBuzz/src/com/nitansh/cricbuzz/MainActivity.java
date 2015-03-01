package com.nitansh.cricbuzz;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	final Context myApp=this;
	private AdView adView;
	private WebView mainWebView;
	@Override
	public void onPause() {
	    super.onPause();
	}
	
	/** Called when the activity is first created. */
    @SuppressLint("SetJavaScriptEnabled") @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        setContentView(R.layout.activity_main);
        adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-5047333943084311/4181724580");
        
        
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.linear_layout);
        layout.addView(adView);
        
        AdRequest adRequest = new AdRequest.Builder()
        .build();

    // Start loading the ad in the background.
    adView.loadAd(adRequest);
    
        mainWebView = (WebView) findViewById(R.id.mainWebView);
        
        
        mainWebView.setWebViewClient(new WebViewClient());
        mainWebView.setWebChromeClient(new WebChromeClient(){

        	 // disable scroll on touch
        	

                });
        
        WebSettings webSettings = mainWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        //mainWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mainWebView.setWebViewClient(new MyCustomWebViewClient());
        mainWebView.loadUrl("file:///android_asset/html/index.html");
    }
    
    private class MyCustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
