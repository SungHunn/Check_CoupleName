package com.example.check_couplename.di

import com.example.domain.repository.MainRepository
import com.example.domain.repository.SplashRepository
import com.example.domain.usecase.CheckAppVersionUseCase
import com.example.domain.usecase.CheckLoveCalculatorUseCase
import com.example.domain.usecase.GetScoreUseCase
import com.example.domain.usecase.GetStatisticsUseCase
import com.example.domain.usecase.SetScoreUseCase
import com.example.domain.usecase.SetStatisticsUseCase
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