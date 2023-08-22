package com.example.data.repository.remote.datasourceimpl

import com.example.data.remote.api.LoveCalculatorApi
import com.example.data.remote.model.DataLoveResponse
import com.example.data.repository.remote.datasource.MainDataSource
import com.example.data.utils.base.BaseDataSource
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class MainDataSourceimpl @Inject constructor(
    private val loveCalculatorApi: LoveCalculatorApi
) : BaseDataSource(), MainDataSource {

    override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ) : DataLoveResponse? {
        return safeApiCall(remoteErrorEmitter){
            loveCalculatorApi.getPercentage(host = host , key = key , fName = mName , sName = wName)
        }?.body()
    }
}