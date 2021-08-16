package com.example.myapplication.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.DialogCommonBinding

class CommonDialog(context: Context) : Dialog(context) {

    private lateinit var mBinding: DialogCommonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DialogCommonBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    public fun setDialog(
        dialogFlag: Int,
        title: String?,
        msg: String,
        negativeText: String?,
        positiveText: String?
    ) {
        when (dialogFlag) {
            1 -> { // 일반 얼럿형
                mBinding.tvAnswer.visibility = View.VISIBLE
                mBinding.llConfirm.visibility=View.GONE
                mBinding.tvAnswer.text=positiveText
            }
            else -> { //컨펌형
                mBinding.tvAnswer.visibility = View.GONE
                mBinding.llConfirm.visibility=View.VISIBLE
                mBinding.tvCancel.text=negativeText
                mBinding.tvConfirm.text=positiveText

            }
        }
        if(title==null){
            mBinding.tvTitle.visibility=View.GONE
        }
        mBinding.tvMsg.text=msg


    }


}