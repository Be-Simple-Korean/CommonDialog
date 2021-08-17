package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.dialog.CommonDialog

class MainActivity : BaseActivity() {
    private lateinit var mBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnST.setOnClickListener{
            showSimpleDialog("타이틀","메시지","응답",onPositiveClickListener)
        }
        mBinding.btnSNT.setOnClickListener{
            showSimpleDialog(null,"메시지","응답",null)
        }
        mBinding.btnCT.setOnClickListener{
            showConfirmDialog("타이틀2","메시지\n메시지","부정형","응답형",onPositiveClickListener)
        }
        mBinding.btnCNT.setOnClickListener{
            showConfirmDialog("타이틀2","메시지\n메시지",null,null,null)
        }

    }

    private val onPositiveClickListener=object:CommonDialog.CommonDialogClickListener{
        override fun onPositiveClickListener() {
            Toast.makeText(baseContext,"토스트 먹고싶다",Toast.LENGTH_SHORT).show()
        }

    }
}