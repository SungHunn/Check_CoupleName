package com.sunghoon.data.repository.remote.datasourceimpl


import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.sunghoon.data.repository.remote.datasource.SplashDataSource
import javax.inject.Inject

class SplashDataSourceImpl @Inject constructor(
    private val firebaseRtdb : FirebaseDatabase,
    private val firestore: FirebaseFirestore
) : SplashDataSource {

    override fun checkAppVersion(): Task<DataSnapshot> {
        return firebaseRtdb.reference.child("version").get()
    }
}