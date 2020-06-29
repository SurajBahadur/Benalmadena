package com.benalmadena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.benalmadena.base.BaseActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        addFragment(MainActivity(),false,R.id.container_full)
    }
}