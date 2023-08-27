package com.example.domain.repository


import com.example.domain.model.DomainLoveResponse
import com.example.domain.model.DomainScore
import com.example.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot

interface MainRepository {

    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ) : DomainLoveResponse?

    fun getStatistics() : Task<DataSnapshot>

    fun setStatistics(plusValue : Int) : Task<Void>

    fun getScore() : Task<QuerySnapshot>

    fun setScore(score: DomainScore) : Task<Void>

}