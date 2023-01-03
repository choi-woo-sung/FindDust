package com.ddd.pollpoll.network.remotesource

import com.ddd.pollpoll.network.api.DustAPI
import com.ddd.pollpoll.network.model.NetworkDust
import com.example.core_network.BuildConfig
import javax.inject.Inject


interface DustRemoteSource {
    suspend fun fetchDustList(numOfRows: Int, pageNo: Int, sidoName: String): NetworkDust
}

internal class DustRemoteSourceImp @Inject constructor(
    private val api: DustAPI
) : DustRemoteSource {

    override suspend fun fetchDustList(numOfRows: Int, pageNo: Int, sidoName: String): NetworkDust {
        return api.fetchDustList(
            serviceKey = BuildConfig.API_KEY,
            returnType = RETURN_TYPE,
            numOfRows = 1000,
            pageNo = 1,
            sidoName = "전체"
        )
    }

    companion object {
        const val RETURN_TYPE = "json"
    }
}
