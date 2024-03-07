package com.sunghoon.domain.usecase


import com.sunghoon.domain.repository.MainRepository
import javax.inject.Inject

class GetStatisticsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun execute() = mainRepository.getStatistics()
}