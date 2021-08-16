package com.example.myapplication.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.dialog.CommonDialog

open class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    public fun showSimpleDialog(title: String?, msg: String, positiveText: String){
        showDialog(1,title,msg,null,positiveText)
    }

    public fun showConfirmDialog(title: String,msg: String,negativeText: String?,positiveText: String){
        showDialog(2,title,msg,negativeText,positiveText)
    }

    private fun showDialog(dialogFlag: Int,title: String?,msg: String,negativeText: String?,positiveText: String?){
        val commonDialog = CommonDialog(this)
        commonDialog.setDialog(dialogFlag,title,msg,negativeText,positiveText)
        commonDialog.show()
    }
}