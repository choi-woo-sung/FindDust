package com.ddd.pollpoll.network.remotesource

import com.ddd.pollpoll.network.api.DustAPI
import com.ddd.pollpoll.network.model.NetworkDust
import javax.inject.Inject

interface DustRemoteSource {
    suspend fun fetchDustList(numOfRows: Int, pageNo: Int, sidoName: String): NetworkDust
}

class DustRemoteSourceImp @Inject constructor(
    private val api: DustAPI
) : DustRemoteSource {

    override suspend fun fetchDustList(numOfRows: Int, pageNo: Int, sidoName: String): NetworkDust {
        return api.fetchDustList(
            serviceKey = API_KEY,
            returnType = RETURN_TYPE,
            numOfRows = 1000,
            pageNo = 1,
            sidoName = "전체"
        )
    }

    companion object {
        const val API_KEY = "LL0SSOpdVJrjj/OgFhTFxrEKFzVyJxrCKUyNncefeNLGGocos9LR2BNrSRB5RlWI1F0yqEfIrGMOY26ccNZ7fA=="
        const val RETURN_TYPE = "json"
    }
}
