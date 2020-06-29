package com.benalmadena.base

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import com.benalmadena.activity.discover_benalmadena.ActivityDayOutThings

/**
 * Created by Suraj Bahadur on 29-Jun-20.
 */
open class BaseFragment: Fragment() {



    private var mActivity: androidx.fragment.app.FragmentActivity? = null
    protected var mContent: View? = null// For showing snackbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContent = view
    }

    fun addFragment(fragment: Fragment, addToBackStack: Boolean, id: Int) {
        val tag = fragment.javaClass.simpleName
        val fragmentManager = mActivity?.supportFragmentManager
        val fragmentOldObject = fragmentManager?.findFragmentByTag(tag)
        val transaction = fragmentManager?.beginTransaction()
        transaction?.setCustomAnimations(R.anim.anim_in, R.anim.anim_out, R.anim.anim_in_reverse, R.anim.anim_out_reverse)
        if (fragmentOldObject != null) {
            fragmentManager.popBackStackImmediate(tag, 0)
        } else {
            if (addToBackStack) {
                transaction?.addToBackStack(tag)
            }
            transaction?.add(id, fragment, tag)
                ?.commitAllowingStateLoss()
        }
    }

     fun goToWebViewScreen(title: String, url: String
    ) {
        val fragment = ActivityWebView()
        fragment.arguments = Bundle().apply {
            putString("title", title)
            putString("url", url)
        }
        addFragment(fragment, true, R.id.container_full)
    }
}