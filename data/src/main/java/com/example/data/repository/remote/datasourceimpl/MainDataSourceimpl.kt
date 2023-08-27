package com.example.data.repository.remote.datasourceimpl

import com.example.data.remote.api.LoveCalculatorApi
import com.example.data.remote.model.DataLoveResponse
import com.example.data.remote.model.DataScore
import com.example.data.repository.remote.datasource.MainDataSource
import com.example.data.utils.base.BaseDataSource
import com.example.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class MainDataSourceimpl @Inject constructor(
    private val loveCalculatorApi: LoveCalculatorApi,
    private val firebaseRtdb : FirebaseDatabase,
    private val firestore : FirebaseFirestore
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

    override fun getStatistics(): Task<DataSnapshot> {
        return  firebaseRtdb.reference.child("statistics").get()
    }

    override fun setStatistics(plusValue : Int): Task<Void> {
        return firebaseRtdb.reference.child("statistics").setValue(plusValue)
    }

    override fun getScore(): Task<QuerySnapshot> {
        return firestore.collection("score").orderBy("date",Query.Direction.DESCENDING).get()
    }

    override fun setScore(score: DataScore): Task<Void> {
        return firestore.collection("score").document().set(score)
    }
}