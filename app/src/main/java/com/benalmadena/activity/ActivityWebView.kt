package com.benalmadena.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import kotlinx.android.synthetic.main.activity_web_view.*

class ActivityWebView:AppCompatActivity() {
    companion object{
        fun start(context: Context, title:String, url:String){
            val intent= Intent(context,ActivityWebView::class.java)

            intent.putExtra("title",title)
            intent.putExtra("url",url)
            context.startActivity(intent)
        }

        lateinit var progressBar: ProgressBar
    }

    lateinit var WebUrl:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        tv_title_web_view.text=intent.getStringExtra("title")
        btn_back_web_view.setOnClickListener { finish() }
        WebUrl=intent.getStringExtra("url")

        progressBar=findViewById(R.id.progress_bar)
        progressBar.visibility= View.VISIBLE

        webview.settings.javaScriptEnabled = true
        webview.settings.domStorageEnabled=true
        webview.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        webview.webViewClient = MyWebViewClient(this,progress_bar)
        webview.loadUrl(WebUrl)
    }


    private class MyWebViewClient(val context: Context,val view:ProgressBar ) : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)

            progressBar.visibility= View.VISIBLE
            return true
        }


        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)

            progressBar.visibility= View.GONE

        }

        @RequiresApi(Build.VERSION_CODES.M)
        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            super.onReceivedError(view, request, error)
            progressBar.visibility= View.GONE
            Log.e("Error", "Error: " + error?.description);
            Toast.makeText(context, "Oh no! " + error?.description, Toast.LENGTH_SHORT).show();

        }
    }
}