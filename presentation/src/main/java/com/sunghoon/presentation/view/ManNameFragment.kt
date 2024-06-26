package com.sunghoon.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.sunghoon.domain.utils.ErrorType
import com.sunghoon.domain.utils.ScreenState
import com.sunghoon.presentation.R
import com.sunghoon.presentation.base.BaseFragment
import com.sunghoon.presentation.databinding.FragmentManNameBinding
import com.sunghoon.presentation.viewmodel.MainViewModel

class ManNameFragment : BaseFragment<FragmentManNameBinding>(R.layout.fragment_man_name) {

    private val mainViewModel by activityViewModels<MainViewModel>()
    override fun init() {
        binding.fragment = this
        observeViewModel()
    }

    fun nextBtnClick(view : View){
        binding.progressBar.visibility =View.VISIBLE
        mainViewModel.manNameResult = binding.editTxt.text.toString()
        mainViewModel.checkLoveCalculator(
            "love-calculator.p.rapidapi.com",
            "b4aef4724fmsh424644b7ba41f70p14d86cjsn212dff71de8f",
            mainViewModel.manNameResult ,
            mainViewModel.womanNameResult
        )

    }

    private fun observeViewModel(){
        mainViewModel.apiCallEvent.observe(this){
            binding.progressBar.visibility =View.GONE
            when(it){
                ScreenState.LOADING ->  this.findNavController().navigate(R.id.action_manNameFragment_to_resultFragment)
                ScreenState.ERROR -> toastErrorMsg()
                else -> shortShowToast("알수없는 오류가 발생")
            }
        }
    }

    private fun toastErrorMsg(){
        when(mainViewModel.apiErrorType){
            ErrorType.NETWORK ->longShowToast("네트워크 오류가 발생했습니다")
            ErrorType.SESSION_EXPIRED ->longShowToast("세션이 만료되었습니다")
            ErrorType.TIMEOUT ->longShowToast("서버 호출 시간이 초과되었습니다")
            ErrorType.UNKNOWN ->longShowToast("예기치 못한 오류가 발생했습니다")
        }
    }
}