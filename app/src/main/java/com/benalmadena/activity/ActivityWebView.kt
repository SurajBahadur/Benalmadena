package com.benalmadena.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_web_view.*

class ActivityWebView:BaseFragment() {


    lateinit var WebUrl:String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_web_view,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title_web_view.text=arguments!!.getString("title")
        btn_back_web_view.setOnClickListener {
            activity!!.onBackPressed()
        }
        WebUrl= arguments!!.getString("url").toString()
        progressBar.visibility= View.VISIBLE

        webview.settings.javaScriptEnabled = true
        webview.settings.domStorageEnabled=true
        webview.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        webview.webViewClient = MyWebViewClient(activity!!,progressBar)
        webview.loadUrl(WebUrl)
    }



    private class MyWebViewClient(val context: Context,val progressBar:ProgressBar ) : WebViewClient() {

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