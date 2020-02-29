package com.mr.k.mvp.base

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.annotation.StringRes

import com.mr.k.mvp.statusbar.StatusBarUtils
import com.mr.k.mvp.widget.LoadingView
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/*
 * created by Cherry on 2019-12-20
 **/
open class BaseActivity : RxAppCompatActivity(),BaseLoading{



  /*  override fun getDefaultRootVieId(): Int = android.R.id.content*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.setStatusBarLightMode(this,Color.WHITE)
    }


    override fun <T : View> getViewById(id: Int): T {
       return findViewById<T>(id)
    }

    override var mLoadingView: LoadingView? = null

    protected fun showToast(@StringRes id: Int) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show()
    }

    protected fun showToast(content: String) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()

    }



}
