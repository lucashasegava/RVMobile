package com.example.rvmobile.mvp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity(), Contract.View {
    private var mToast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
        onInitView()
    }


    abstract fun getLayoutResource(): Int

    abstract fun onInitView()

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun showShortToast(resId: Int) {
        showShortToast(getString(resId))
    }

    fun showShortToast(text: String?) {
        showToast(text, Toast.LENGTH_SHORT)    }

    fun showLongToast(resId: Int) {
        showShortToast(getString(resId))
    }

    fun showLongToast(text: String?) {
        showToast(text, Toast.LENGTH_LONG)
    }

    open fun showToast(text: String?, length: Int) {
        if (text != null) {
            cancel()
            mToast = Toast.makeText(this, text, length)
            mToast?.show()
        }
    }

    open fun cancel() {
        mToast?.cancel()
    }

    override fun onDestroy() {
        mToast?.cancel()
        super.onDestroy()
    }

}