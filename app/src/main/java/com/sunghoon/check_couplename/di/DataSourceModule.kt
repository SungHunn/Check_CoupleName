package com.sunghoon.check_couplename.di

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.sunghoon.data.remote.api.LoveCalculatorApi
import com.sunghoon.data.repository.remote.datasource.MainDataSource
import com.sunghoon.data.repository.remote.datasource.SplashDataSource
import com.sunghoon.data.repository.remote.datasourceimpl.MainDataSourceimpl
import com.sunghoon.data.repository.remote.datasourceimpl.SplashDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule() {

    @Provides
    @Singleton
    fun provideMainDataSource(
        loveCalculatorApi: LoveCalculatorApi,
        firebaseRtdb: FirebaseDatabase,
        fireStore: FirebaseFirestore
    ) : MainDataSource {
        return MainDataSourceimpl(loveCalculatorApi , firebaseRtdb , fireStore)
    }


    @Provides
    @Singleton
    fun provideSplashDataSource(
        firebaseRtdb : FirebaseDatabase,
        fireStore : FirebaseFirestore
    ) : SplashDataSource {
        return SplashDataSourceImpl(firebaseRtdb,fireStore)
    }
}