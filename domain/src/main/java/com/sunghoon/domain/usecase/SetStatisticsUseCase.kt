package com.sunghoon.domain.usecase


import com.sunghoon.domain.repository.MainRepository
import javax.inject.Inject

class SetStatisticsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    fun execute(plusValue : Int) = mainRepository.setStatistics(plusValue)
}