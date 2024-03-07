package com.sunghoon.data.repository.remote.datasource

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.sunghoon.data.remote.model.DataLoveResponse
import com.sunghoon.data.remote.model.DataScore
import com.sunghoon.domain.utils.RemoteErrorEmitter

interface MainDataSource {

    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName : String,
        wName : String
    ) : DataLoveResponse?

    fun getStatistics() : Task<DataSnapshot>

    fun setStatistics(plusValue : Int) : Task<Void>

    fun getScore() : Task<QuerySnapshot>

    fun setScore(score: DataScore) : Task<Void>
}