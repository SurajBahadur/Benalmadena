package com.benalmadena.base

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R

/**
 * Created by Suraj Bahadur on 29-Jun-20.
 */
open class BaseActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun addFragment(fragment: androidx.fragment.app.Fragment, addToBackStack: Boolean, container_id: Int) {
        val tag = fragment.javaClass.simpleName
        val fragmentManager = this.supportFragmentManager
        val fragmentOldObject = fragmentManager.findFragmentByTag(tag)
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.anim_in, R.anim.anim_out, R.anim.anim_in_reverse, R.anim.anim_out_reverse)
        if (fragmentOldObject != null) {
            fragmentManager.popBackStackImmediate(tag, 0)
        } else {
            if (addToBackStack) {
                transaction.addToBackStack(tag)
            }
            transaction.add(container_id, fragment, tag)
                .commit()
        }
    }
}