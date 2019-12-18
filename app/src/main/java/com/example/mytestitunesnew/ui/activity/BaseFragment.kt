package com.example.mytestitunesnew.ui.activity

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.core.extension.isNetworkAvailable
import org.jetbrains.anko.support.v4.longToast
import org.koin.android.ext.android.inject

open class BaseFragment: Fragment() {

    protected val connectionManager: ConnectivityManager by inject()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            if (context is Activity) {
              //  navBarrConfigurationInterface = context as NavBarrConfigurationInterface
            }
        } catch (e: ClassCastException) {
            // throw ClassCastException(context!!.toString() + " must implement ToolBarConfigurationInterface")
        }
    }

    protected fun onLoading() {} //TODO: Show loading screen
    protected fun onCancel() {} //TODO: Show cancel message
    protected fun onError(tag: String = "BaseActivity", message: String = "onError") {
        if (connectionManager.isNetworkAvailable()) {
           // longToast(getString(R.string.toast_connection_error))
        } else {
           // longToast(getString(R.string.toast_are_you_connected))
        }
        Log.d(tag, message)
    }
    protected fun onUnexpectedError() {
       // longToast(getString(R.string.toast_unexpected_failure))
    }



}