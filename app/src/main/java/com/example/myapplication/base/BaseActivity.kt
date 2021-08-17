package com.example.myapplication.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.dialog.CommonDialog

open class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showSimpleDialog(
        title: String?,
        msg: String,
        positiveText: String,
        onPositiveClickListener: CommonDialog.CommonDialogClickListener?
    ) {
        Log.e("수행", "1")
        Log.e("data", "$title , $msg , $positiveText")
        showDialog(1, title, msg, null, positiveText, onPositiveClickListener)
    }

    fun showConfirmDialog(
        title: String,
        msg: String,
        negativeText: String?,
        positiveText: String?,
        onPositiveClickListener: CommonDialog.CommonDialogClickListener?
    ) {
        showDialog(2, title, msg, negativeText, positiveText, onPositiveClickListener)
    }

    private fun showDialog(
        dialogFlag: Int,
        title: String?,
        msg: String,
        negativeText: String?,
        positiveText: String?,
        onPositiveClickListener: CommonDialog.CommonDialogClickListener?
    ) {
        Log.e("data2", "$title , $msg , $positiveText")
        val commonDialog = CommonDialog(this)
        commonDialog.show()
        commonDialog.setDialog(
            dialogFlag,
            title,
            msg,
            negativeText,
            positiveText,
            onPositiveClickListener
        )
    }
}