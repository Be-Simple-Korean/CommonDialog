package com.example.myapplication.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import com.example.myapplication.databinding.DialogCommonBinding

class CommonDialog(context: Context) : Dialog(context) {

    interface CommonDialogClickListener {
        fun onPositiveClickListener()
    }

    private lateinit var mBinding: DialogCommonBinding
    private var mOnPositiveClickListener: CommonDialogClickListener? = null

    private val mOnClickListener = View.OnClickListener {
        when (it.id) {
            mBinding.llBackground.id, mBinding.tvCancel.id -> {
                dismiss()
            }
            mBinding.llDialog.id -> {
            }
            mBinding.tvAnswer.id, mBinding.tvConfirm.id -> {
                if (mOnPositiveClickListener == null) {
                    dismiss()
                } else {
                    mOnPositiveClickListener?.let { it.onPositiveClickListener() }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DialogCommonBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initWindow()

        setClickEvent()
    }

    private fun setClickEvent() {
        mBinding.llBackground.setOnClickListener(mOnClickListener)
        mBinding.llDialog.setOnClickListener(mOnClickListener)
        mBinding.tvAnswer.setOnClickListener(mOnClickListener)
        mBinding.tvConfirm.setOnClickListener(mOnClickListener)
    }

    private fun initWindow() {
        window?.let {
            it.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    fun setDialog(
        dialogFlag: Int,
        title: String?,
        msg: String,
        negativeText: String?,
        positiveText: String?,
        onPositiveClickListener: CommonDialogClickListener?
    ) {
        Log.e("data3", "$title , $msg , $positiveText")
        when (dialogFlag) {
            1 -> { // 일반 얼럿형
                mBinding.tvAnswer.visibility = View.VISIBLE
                mBinding.llConfirm.visibility = View.GONE
                mBinding.tvAnswer.text = positiveText

            }
            else -> { //컨펌형
                mBinding.tvAnswer.visibility = View.GONE
                mBinding.llConfirm.visibility = View.VISIBLE
                mBinding.tvCancel.text = negativeText ?: "취소"
                mBinding.tvConfirm.text = positiveText ?: "확인"

            }
        }
        if (title == null) {
            mBinding.tvTitle.visibility = View.GONE
        } else {
            mBinding.tvTitle.text = title
        }

        onPositiveClickListener?.let {
            mOnPositiveClickListener = it
        }
        mBinding.tvMsg.text = msg

    }


}