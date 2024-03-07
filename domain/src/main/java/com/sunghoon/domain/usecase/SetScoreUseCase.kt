package com.sunghoon.domain.usecase


import com.sunghoon.domain.model.DomainScore
import com.sunghoon.domain.repository.MainRepository
import javax.inject.Inject

class SetScoreUseCase @Inject constructor(
    private val mainRepository: MainRepository
){

    fun execute(score : DomainScore) = mainRepository.setScore(score)
}