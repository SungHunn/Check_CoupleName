package com.sunghoon.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil.setContentView
import com.sunghoon.presentation.R
import com.sunghoon.presentation.base.BaseActivity
import com.sunghoon.presentation.databinding.ActivityMainBinding
import com.sunghoon.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun init() {

    }


}