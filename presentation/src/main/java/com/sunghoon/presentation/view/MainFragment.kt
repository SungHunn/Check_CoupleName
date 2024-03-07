package com.sunghoon.presentation.view

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunghoon.presentation.R
import com.sunghoon.presentation.adapter.ScoreRecyclerViewAdapter
import com.sunghoon.presentation.base.BaseFragment
import com.sunghoon.presentation.databinding.FragmentMainBinding
import com.sunghoon.presentation.viewmodel.MainViewModel


class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val mainViewModel by activityViewModels<MainViewModel>()
    override fun init() {
        binding.fragment = this
        observeViewModel()
        mainViewModel.getStatisticsDisplay()
        mainViewModel.getScore()

    }

    fun startBtnClick(view: View) {
        this.findNavController().navigate(R.id.action_mainFragment_to_womanNameFragment)
    }

    private fun observeViewModel() {
        mainViewModel.getStatisticsEvent.observe(this) {
            binding.statistics.text = it.toString()
        }

        mainViewModel.getScoreEvent.observe(this) {
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        binding.scoreRecyclerView.adapter = ScoreRecyclerViewAdapter(mainViewModel)
        binding.scoreRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


}