package com.sunghoon.check_couplename.di


import com.sunghoon.data.repository.MainRepositoryImpl
import com.sunghoon.data.repository.SplashRepositoryImpl
import com.sunghoon.data.repository.remote.datasource.MainDataSource
import com.sunghoon.data.repository.remote.datasource.SplashDataSource
import com.sunghoon.domain.repository.MainRepository
import com.sunghoon.domain.repository.SplashRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        mainDataSource: MainDataSource
    ) : MainRepository {
        return MainRepositoryImpl(
            mainDataSource
        )
    }

    @Provides
    @Singleton
    fun provideSplashRepository(
        splashDataSource: SplashDataSource
    ) : SplashRepository {
        return SplashRepositoryImpl(
            splashDataSource
        )
    }
}