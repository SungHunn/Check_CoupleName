package com.sunghoon.check_couplename.di

import com.sunghoon.domain.repository.MainRepository
import com.sunghoon.domain.repository.SplashRepository
import com.sunghoon.domain.usecase.CheckAppVersionUseCase
import com.sunghoon.domain.usecase.CheckLoveCalculatorUseCase
import com.sunghoon.domain.usecase.GetScoreUseCase
import com.sunghoon.domain.usecase.GetStatisticsUseCase
import com.sunghoon.domain.usecase.SetScoreUseCase
import com.sunghoon.domain.usecase.SetStatisticsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideCheckLoveCalculatorUseCase(repository: MainRepository) = CheckLoveCalculatorUseCase(repository)


    @Provides
    @Singleton
    fun provideCheckAppVersionUseCase(repository: SplashRepository) = CheckAppVersionUseCase(repository)

    @Provides
    @Singleton
    fun provideGetStatisticsUseCase(repository: MainRepository) = GetStatisticsUseCase(repository)

    @Provides
    @Singleton
    fun provideSetStatisticsUseCase(repository: MainRepository) = SetStatisticsUseCase(repository)

    @Provides
    @Singleton
    fun provideGetScoreUseCase(repository: MainRepository) = GetScoreUseCase(repository)

    @Provides
    @Singleton
    fun provideSetScoreUseCase(repository: MainRepository) = SetScoreUseCase(repository)
}