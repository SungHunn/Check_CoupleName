package com.sunghoon.data.repository


import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.sunghoon.data.repository.remote.datasource.SplashDataSource
import com.sunghoon.domain.repository.SplashRepository
import javax.inject.Inject

class SplashRepositoryImpl @Inject constructor(
    private val splashDataSource: SplashDataSource

) : SplashRepository {
    override fun checkAppVersion(): Task<DataSnapshot> {
        return splashDataSource.checkAppVersion()
    }


}