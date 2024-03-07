package com.sunghoon.presentation.view

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.sunghoon.presentation.R
import com.sunghoon.presentation.base.BaseFragment
import com.sunghoon.presentation.databinding.FragmentResultBinding
import com.sunghoon.presentation.viewmodel.MainViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        initResult()
        saveScore()
    }

    private fun initResult(){
        binding.manText.text = mainViewModel.manNameResult
        binding.womanText.text = mainViewModel.womanNameResult
        binding.score.text = mainViewModel.apiCallResult.percentage.toString()

        saveStatistics()

        when (mainViewModel.apiCallResult.percentage) {
            in 0..20 -> setLoveMsgTxt("조금 힘들어보여요")
            in 21..40 -> setLoveMsgTxt("노력해 보세요")
            in 41..70 -> setLoveMsgTxt("기대해도 좋겠는데요?")
            in 71..90 -> setLoveMsgTxt("일단 축하드려요")
            in 91..99 -> setLoveMsgTxt("와우.. 눈을 의심하고 있어요")
            100 -> {
                setLoveMsgTxt("완벽하네요, 축하드려요")
                //saveStatistics()
            }
            else -> setLoveMsgTxt("알수없는 힘!!")
        }
    }

    private fun saveScore() = with(mainViewModel.apiCallResult){
        mainViewModel.setScore(this.fname , this.sname , this.percentage , nowTime())
    }

    private fun nowTime() : String = SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분", Locale("ko", "KR")).format(
        Date(System.currentTimeMillis())
    )
    private fun saveStatistics(){
        mainViewModel.getStatistics()
            .addOnSuccessListener {
                if(it != null) mainViewModel.setStatistics(it.value.toString().toInt() + 1)
                    .addOnFailureListener {
                        error()
                    }
            }
            .addOnFailureListener {
                error()
            }
    }

    fun error() = shortShowToast("통계를 저장하는데 오류가 발생했습니다.")

    private fun setLoveMsgTxt(msg: String) = binding.message.setText(msg)

    fun backMainBtnClick(view : View){
        this.findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }
}