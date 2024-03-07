package com.sunghoon.data.mapper

import com.sunghoon.data.remote.model.DataLoveResponse
import com.sunghoon.data.remote.model.DataScore
import com.sunghoon.domain.model.DomainLoveResponse
import com.sunghoon.domain.model.DomainScore

object MainMapper {

    fun loveMapper(
        dataResponse: DataLoveResponse?
    ): DomainLoveResponse? {
        return if (dataResponse != null) {
            DomainLoveResponse(
                fname = dataResponse.fname,
                percentage = dataResponse.percentage,
                result = dataResponse.result,
                sname = dataResponse.sname
            )
        } else dataResponse
    }

    fun scoreMapper(
        domainResponse : DomainScore
    ) : DataScore {
        return DataScore(
            man = domainResponse.man,
            woman = domainResponse.woman,
            percentage = domainResponse.percentage,
            date = domainResponse.date
        )
    }


}