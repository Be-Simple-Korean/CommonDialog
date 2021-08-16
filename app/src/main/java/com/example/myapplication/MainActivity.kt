package com.example.myapplication

import android.os.Bundle
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var mBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnST.setOnClickListener{
            showSimpleDialog("타이틀","메시지","응답")
        }
        mBinding.btnST.setOnClickListener{
            showSimpleDialog(null,"메시지","응답")
        }



    }
}