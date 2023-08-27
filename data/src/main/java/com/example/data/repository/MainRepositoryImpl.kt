package com.example.data.repository

import com.example.data.mapper.MainMapper
import com.example.data.repository.remote.datasource.MainDataSource
import com.example.data.remote.model.DataLoveResponse
import com.example.domain.model.DomainLoveResponse
import com.example.domain.model.DomainScore
import com.example.domain.repository.MainRepository
import com.example.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDataSource: MainDataSource
)  : MainRepository{

    override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ): DomainLoveResponse? {
        return MainMapper.loveMapper(mainDataSource.checkLoveCalculator(remoteErrorEmitter, host, key, mName, wName))
    }

    override fun getStatistics(): Task<DataSnapshot> {
        return mainDataSource.getStatistics()
    }

    override fun setStatistics(plusValue: Int): Task<Void> {
        return mainDataSource.setStatistics(plusValue)
    }

    override fun getScore(): Task<QuerySnapshot> {
        return mainDataSource.getScore()
    }

    override fun setScore(score: DomainScore): Task<Void> {
        return mainDataSource.setScore(MainMapper.scoreMapper(score))
    }

}