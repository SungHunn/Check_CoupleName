package com.example.domain.repository


import com.example.domain.model.DomainLoveResponse
import com.example.domain.utils.RemoteErrorEmitter

interface MainRepository {

    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ) : DomainLoveResponse?

}